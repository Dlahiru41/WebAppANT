package com.ajax;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.HashMap;
import java.util.Iterator;

/**
 *
 * @author nbuser
 */
public class AutoCompleteServlet extends HttpServlet {

    private ServletContext context;
    private final ComposerData compData = new ComposerData();
    private final HashMap composers = compData.getComposers();

    @Override
    public void init(ServletConfig config) throws ServletException {
        this.context = config.getServletContext();
    }

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        String action = request.getParameter("action");
        String targetId = request.getParameter("id");
        StringBuilder sb = new StringBuilder();

        if (targetId != null) {
            targetId = targetId.trim().toLowerCase();
        } else {
            context.getRequestDispatcher("/error.jsp").forward(request, response);
        }
        
        try {
            boolean namesAdded = false;

            if (action.equals("complete")) {

                // check if user sent empty string
                //if (!targetId.equals("")) 
                if (targetId != null){

                    Iterator it = composers.keySet().iterator();

                    while (it.hasNext()) {
                        String id = (String) it.next();
                        Composer composer = (Composer) composers.get(id);

                        if ( // targetId matches field1
                                composer.getTITLE().toLowerCase().startsWith(targetId)
                                || // targetId matches field2
                                composer.getPUBLISHERNAME().toLowerCase().startsWith(targetId)
                                || // targetId matches field1 & field2
                                composer.getTITLE().toLowerCase().concat(" ")
                                .concat(composer.getPUBLISHERNAME().toLowerCase()).startsWith(targetId)) {
                            sb.append("<dataRow>");
                            sb.append("<rowId>").append(composer.getISBN()).append("</rowId>");
                            sb.append("<field1>").append(composer.getTITLE()).append("</field1>");
                            sb.append("<field2>").append(composer.getPUBLISHERNAME()).append("</field2>");
                            sb.append("</dataRow>");
                            namesAdded = true;
                        }
                    }
                }

                if (namesAdded) {
                    response.setContentType("text/xml");
                    response.setHeader("Cache-Control", "no-cache");
                    response.getWriter().write("<composers>" + sb.toString() + "</composers>");
                } else {
                    //nothing to show
                    response.setStatus(HttpServletResponse.SC_NO_CONTENT);
                }
            }

            if (action.equals("lookup")) {

                // put the target composer in the request scope to display 
                if ((targetId != null) && composers.containsKey(targetId.trim())) {
                    request.setAttribute("composer", composers.get(targetId));
                    context.getRequestDispatcher("/composer.jsp").forward(request, response);
                }
            }
        } catch (Exception ex) {
            //context.getRequestDispatcher("/error.jsp").forward(request, response);
        }
    }
}
