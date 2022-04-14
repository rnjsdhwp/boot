<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
    <head>
    <meta charset="UTF-8">
        <title>Spring Test</title>
    </head>

    <body>
        <h2>글작성</h2>
        </br>

        <c:forEach var="item" items="${list}">
            ${item.name} !!!
            <br/>
        </c:forEach>



    </body>
</html>