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
        <h2>답글작성</h2>
        </br>
        ${id}
        <div style="width:500px; height:500px; border:1px solid red; margin:2px;">
            <form action="/board/boardProc" method="get">
                <input type="hidden" name="id" value="${id}">
                <h3>질문</h3>
                <table style="width:100%; background-color:lightgray;">
                    <c:forEach var="board" items="${lst}">
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
                    <c:forEach var="board" items="${lst}">
                        <tr style="height:10px;"></tr>

                        <tr>
                            <td colspan="2" style="height:270px; vertical-align:top;">${board.contents}</td>
                        </tr>
                    </c:forEach>
                </table>
            </form>
        </div>

        <div style="width:500px; height:200px; border:1px solid red; margin:2px;">
            <form action="/board/replyProc" method="get">
                <h3>답글</h3>
                <input type="hidden" name="rownum" value="${lst.get(0).rownum}"/>
                <input type="hidden" name="wno" value="${lst.get(0).wno}"/>
                <input type="hidden" name="id" value="${id}"/>
                <table style="width:100%;">
                    <tr>
                        <td>
                            <textarea name="contents" style="width:100%; resize:none;" rows="5"></textarea>
                        </td>
                    </tr>
                    <tr style="height:10px;"></tr>
                    <tr style="text-align:right;">
                        <td><input type="submit" value="등록"/>
                            <input type="button" value="취소" onclick="goBack();"/></td>
                    </tr>
                </table>
            </form>
        </div>
    </body>
</html>