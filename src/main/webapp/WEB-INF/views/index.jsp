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
            <c:choose>
                <c:when test="${not empty id}">
                    <button type="button" onclick="location.href='/board/boardProc'">글쓰기</button>
                </c:when>
                <c:otherwise>
                    <button type="button" onclick="location.href='/login'">로그인</button>
                    <button type="button" onclick="location.href='/regist'">회원가입</button>
                </c:otherwise>
            </c:choose>
        </div>
        ${id}님 환영
    </body>
</html>