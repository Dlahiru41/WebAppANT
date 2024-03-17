<%-- 
    Document   : index
    Created on : Aug 4, 2008, 10:33:51 PM
    Author     : nbuser
--%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Auto-Completion Database Search using Ajax</title>

        <script type="text/javascript" src="javascript.js"></script>
        <link rel="stylesheet" type="text/css" href="stylesheet.css">
    </head>
    <body onload="init()">
        <h1>Auto-Completion Search using Ajax</h1>

        <p>This example shows how you can do real time auto-completion using Asynchronous
            JavaScript and XML (Ajax) interactions.</p>

        <p>Enter a book title or its publisher name into the search box. Possible titles that will be auto-completed are displayed below
            the box. For example, try typing in the *first* few letters of a book title or of a publisher name, e.g. &quot;C,&quot &quot;Pea,&quot; or &quot;Android,&quot;
            then click on one of the selections to see the title's details.</p>

        <form name="autofillform" action="autocomplete">
            <table border="0" cellpadding="5"> 
                <tbody>
                    <tr>
                        <td><strong>Book title:</strong></td>
                        <td>
                            <input type="text"
                                   size="40" 
                                   id="complete-field"
                                   onkeyup="doCompletion()">
                        </td>
                    </tr>
                    <tr>
                        <td id="auto-row" colspan="2">
                            <table id="complete-table" class="popupBox" />
                        </td>
                    </tr>
                </tbody>
            </table>
        </form>
    </body>
</html>
