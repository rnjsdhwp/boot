<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript">
    function goBack(){
        window.history.back();
    }
</script>

<html>
    <head>
    <meta charset="UTF-8">
        <title>Spring Test</title>
    </head>

    <body>
        <h2>질문보기</h2>
        </br>
        ${id}
        <div style="width:500px; height:500px; border:1px solid red; margin:2px;">
            <form action="/board/boardProc" method="get">
                <h3>질문</h3>
                <table style="width:100%; background-color:lightgray;">
                    <c:forEach var="board" items="${boardlst}">
                        <tr>
                            <td colspan="2"><h2>${board.title}</h2></td>
                        </tr>

                        <tr>
                            <td style="width:15%;">작성자</td>
                            <td>${board.id}(${board.name})</td>
                        </tr>

                        <tr>
                            <td>작성일</td>
                            <td>${board.wdate}</td>
                        </tr>
                    </c:forEach>
                </table>

                <table style="width:500px;">
                    <c:forEach var="board" items="${boardlst}">
                        <tr style="height:10px;"></tr>

                        <tr>
                            <td colspan="2" style="height:270px; vertical-align:top;">${board.contents}</td>
                        </tr>

                        <tr style="height:10px;"></tr>

                        <tr style="text-align:right;">
                            <td colspan="2">
                                <input type="button" onclick="location.href='/board/reply?wno=${board.wno}&rownum=${board.rownum}'" value="답글">
                                <input type="button" onclick="location.href='/board/boardProc'" value="목록" >
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </form>
        </div>

        <c:choose>
            <c:when test="${not empty replylst}">
                <div style="width:500px; height:200px; border:1px solid red; margin:2px;">
                    <h3>답글</h3>
                    <c:forEach var="reply" items="${replylst}">
                        <table style="width:500px; border:1px solid green;">
                            <tr>
                                <td style="width:100px;">${reply.name}(${reply.id})</td>
                                <td style="width:300px;">${reply.contents}</td>
                                <td style="width:100px;">${reply.rdate}</td>
                            </tr>
                        </table>
                    </c:forEach>
                </div>
            </c:when>
            <c:otherwise>
                댓글 없음
            </c:otherwise>
        </c:choose>
    </body>
</html>