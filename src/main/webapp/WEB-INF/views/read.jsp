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
                                <input type="button" onclick="location.href='/board/reply?cPage=${cPage}&cBlock=${cBlock}&wno=${board.wno}'" value="답글">
                                <input type="button" onclick="location.href='/board/boardProc?cPage=${cPage}&cBlock=${cBlock}'" value="목록" >
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </form>
        </div>

        <c:choose>
            <c:when test="${not empty replylst}">
                <div style="width:500px; height:290px; border:1px solid red; margin:2px;">
                    <h3>답글</h3>
                    <table style="width:500px;">
                        <c:forEach var="reply" items="${replylst}">
                            <tr>
                                <td style="width:100px; border-top:1px solid red;">${reply.id}(${reply.name})</td>
                                <td style="width:300px; border-top:1px solid red;">${reply.contents}</td>
                                <td style="width:100px; border-top:1px solid red;">${reply.rdate}</td>
                            </tr>
                        </c:forEach>

                        <tr>
                            <td colspan="3" style="text-align:center; border-top:1px solid red;">
                                <c:choose>
                                    <c:when test="${cBlock_reply ne '1'}">
                                        <a href="/board/read?cPage=${cPage}&cBlock=${cBlock}&wno=${boardlst.get(0).wno}&cPage_reply=${(cBlock_reply-1)*3-2}&cBlock_reply=${cBlock_reply-1}"><이전</a>
                                    </c:when>
                                    <c:otherwise> </c:otherwise>
                                </c:choose>
                                <c:forEach var="i" begin="${start_block}" end="${end_block}">
                                    <a href="/board/read?cPage=${cPage}&cBlock=${cBlock}&wno=${boardlst.get(0).wno}&cPage_reply=${i}&cBlock_reply=${cBlock_reply}">${i}</a>
                                </c:forEach>
                                <c:choose>
                                    <c:when test="${cBlock_reply ne totalPageBlock}">
                                        <a href="/board/read?cPage=${cPage}&cBlock=${cBlock}&wno=${boardlst.get(0).wno}&cPage_reply=${(cBlock_reply+1)*3-2}&cBlock_reply=${cBlock_reply+1}">다음></a>
                                    </c:when>
                                    <c:otherwise> </c:otherwise>
                                </c:choose>
                            </td>
                        </tr>
                    </table>
                </div>
            </c:when>
            <c:otherwise>
                댓글 없음
            </c:otherwise>
        </c:choose>
    </body>
</html>