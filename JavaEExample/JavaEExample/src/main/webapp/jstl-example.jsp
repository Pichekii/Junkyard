<%-- 
    Document   : jstl-example
    Author     : Scott Natelli
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:useBean id="arrayClass" scope="request" class="com.pichekiink.javaeexample.beans.ArrayClass" />
<jsp:useBean id="listClass" scope="request" class="com.pichekiink.javaeexample.beans.ListClass" />
<jsp:useBean id="mapClass" scope="request" class="com.pichekiink.javaeexample.beans.MapClass" />

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSTL Example</title>
    </head>
    
    <body>
        <h1>Array</h1>
        Displaying the contents of an <i>Array</i> containing strings:
        <c:set var="arrayOfStrings" value="${arrayClass.arrayOfStrings}" />
        <ul>
            <c:forEach var="element" items="${arrayOfStrings}">
                <li><c:out value="${element}" /></li>
            </c:forEach>
        </ul>
        
        <br>
            
        <h1>LinkedList</h1>
        Displaying the contents of a <i>LinkedList</i> containing integers:
        <c:set var="listOfInts" value="${listClass.listOfInts}" />
        <ul>
            <c:forEach var="element" items="${listOfInts}">
                <li><c:out value="${element}" /></li>
            </c:forEach>
        </ul>
        
        <h1>HashMap</h1>
        Displaying the contents of a <i>HashMap</i> containing strings:
        
        <br><br>
        <p>
            <a href="index">Return to the home page.</a>
        </p>
    </body>
</html>
