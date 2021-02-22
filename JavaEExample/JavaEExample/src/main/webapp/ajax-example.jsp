<%-- 
    Document   : ajax-example
    Author     : Scott Natelli
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<script src="scripts/jquery-2.1.3.min.js"></script>
<script src="scripts/ajax-example.js"></script>

<script type="text/javascript">
            function ajaxCall() {
                var ajaxOperation = new AjaxOperation();
                ajaxOperation.callServlet();
            }
</script>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ajax Example</title>
    </head>
    <body>
        <h1>Ajax Action</h1>
        
        <p>
            <input type="button" id="submit" value="Submit Ajax Call" onclick="ajaxCall()"/>
            <div id="messageOutput">This content will change after you press the <i>Submit Ajax Call</i> button.</div>
        </p>
        
        <br>
        <p>
            <a href="index">Return to the home page.</a>
        </p>
    </body>
</html>
