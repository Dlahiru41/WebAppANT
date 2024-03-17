<html>
    <head>
        <title>Title Details</title>

        <link rel="stylesheet" type="text/css" href="stylesheet.css">
    </head>
    <body>
        <table>
            <tr>
                <th align="left" colspan="2"><h2>Title Details</h2></th>
    </tr>
    <tr>
        <td>TITLE: </td>
        <td>${requestScope.composer.TITLE}</td>
    </tr>
    <tr>
        <td>EDITION No: </td>
        <td>${requestScope.composer.EDITIONNUMBER}</td>
    </tr>
    <tr>
        <td>ISBN: </td>
        <td>${requestScope.composer.ISBN}</td>
    </tr>
    <tr>
        <td>COPYRIGHT: </td>
        <td>${requestScope.composer.COPYRIGHT}</td>
    </tr>
    <tr>
        <td>PUBLISHER: </td>
        <td>${requestScope.composer.PUBLISHERNAME}</td>
    </tr> 
</table>

<p><a href="ajaxSearchBox.jsp" class="link"><b>Search for another title</b></a>.</p>
</body>
</html>

