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
        <h2>글작성</h2>
        </br>

        <form action="/board/writeProc" method="post">
            <table style="border:1px solid red; margin:2px;">
                <tr>
                    <td style="width:100px;">작성자</td>
                    <td><input type="text" value="${id}" name="id" readonly></td>
                </tr>

                <tr style="height:10px;"></tr>

                <tr>
                    <td style="width:100px;">제목</td>
                    <td><input type="text" name="title"></td>
                </tr>

                <tr style="height:10px;"></tr>

                <tr>
                    <td style="vertical-align:top;">내용</td>
                    <td><textarea name="contents" cols="80" rows="5" style="resize:none;"></textarea></td>
                </tr>

                <tr style="height:10px;"></tr>

                <tr>
                    <td colspan="2" style="text-align:right;">
                        <input type="submit" value="등록"/>
                        <!--<input type="button" value="취소" onclick="location.href='/board/boardProc?cPage='+${cPage}+'&cBlock='+${cBlock}"/>-->
                        <input type="button" value="취소" onclick="goBack();"/>
                    </td>
                </tr>
            </table>
        </form>
    </body>
</html>