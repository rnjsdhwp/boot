<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
    <head>
    <meta charset="UTF-8">
        <title>Spring Test</title>
    </head>

    <body>
        <h2>Q&A</h2>
        </br>
        <input type="button" id="cancel" value="홈" style="width:50px;" onclick="location.href='/home'">
        <form action="/board/write" method="post">
            ${cPage} 페이지
            <table style="width:900px; border:1px solid red; margin:2px;">
                <th style="width:100px; text-align:center; border:1px solid red;">글번호</th>
                <th style="width:500px; text-align:center; border:1px solid red;">제목</th>
                <th style="width:100px; text-align:center; border:1px solid red;">작성자</th>
                <th style="width:100px; text-align:center; border:1px solid red;">등록일</th>
                <th style="width:100px; text-align:center; border:1px solid red;">조회수</th>

                <!--게시판-->
                <c:forEach var="board" items="${boardlst}">
                    <tr>
                        <td style="text-align:center;">${board.rownum}</td>
                        <td><a href="/board/read?cPage=${cPage}&cBlock=${cBlock}&wno=${board.wno}">${board.title}
                            <c:if test="${board.rcount > 0}">(${board.rcount})</c:if></a></td>
                        <td style="text-align:center;">${board.id}(${board.name})</td>
                        <td style="text-align:center;">${board.wdate}</td>
                        <td style="text-align:center;">${board.hits}</td>
                    </tr>
                </c:forEach>

                <!-- 페이징 -->
                <tr>
                    <td colspan="5" style="border-top:1px solid red; text-align:center;">
                        <c:choose>
                            <c:when test="${cBlock ne '1'}"> <a href="/board/boardProc?cPage=${(cBlock-1)*3-2}&cBlock=${cBlock-1}"><이전</a> </c:when>
                            <c:otherwise> </c:otherwise>
                        </c:choose>
                        <c:forEach var="i" begin="${start_block}" end="${end_block}">
                            <a href="/board/boardProc?cPage=${i}&cBlock=${cBlock}">${i}</a>
                        </c:forEach>
                        <c:choose>
                            <c:when test="${cBlock ne totalPageBlock}"> <a href="/board/boardProc?cPage=${(cBlock+1)*3-2}&cBlock=${cBlock+1}">다음></a> </c:when>
                            <c:otherwise> </c:otherwise>
                        </c:choose>
                    </td>
                </tr>

                <tr>
                    <td colspan="5">
                        <input type="submit" value="글쓰기" style="float:right; margin:4px 2px 2px;"></td>
                </tr>
            </table>
        </form>
    </body>
</html>