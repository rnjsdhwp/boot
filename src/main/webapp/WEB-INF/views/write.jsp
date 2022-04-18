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

        <form action="/board/writeProc" method="get">
            <input type="hidden" name="id" value="${id}">
            <table style="border:1px solid red; margin:2px;">
                <tr>
                    <td style="width:100px;">작성자</td>
                    <td><input type="text" value="${id}" readonly></td>
                </tr>

                <tr style="height:10px;"></tr>

                <tr>
                    <td style="width:100px;">제목</td>
                    <td><input type="text" name="title"></td>
                </tr>

                <tr style="height:10px;"></tr>

                <tr>
                    <td style="vertical-align:top;">내용</td>
                    <td><textarea name="contents" cols="80" rows="5" style="resize: none;"></textarea></td>
                </tr>

                <tr style="height:10px;"></tr>

                <tr>
                    <td colspan="2"><input type="submit" value="등록" style="float:right;"></td>
                </tr>
            </table>
        </form>
    </body>
</html>