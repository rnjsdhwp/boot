<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
    <head>
    <meta charset="UTF-8">
        <title>Spring Test</title>
    </head>

    <body>
        <h2>Spring Test</h2>
        </br>
        <div>
            <form method="post">
                <c:choose>
                    <c:when test="${not empty id}">
                        <input type="button" onclick="location.href='/board/boardProc?cPage=1&cBlock=1'" value="QnA"/>
                        <input type="button" onclick="location.href='/login/logout'" value="로그아웃"/>
                    </c:when>
                    <c:otherwise>
                        <input type="button" onclick="location.href='/login'" value="로그인"/>
                        <input type="button" onclick="location.href='/regist'" value="회원가입"/>
                    </c:otherwise>
                </c:choose>
            </form>
        </div>
    </body>
</html>