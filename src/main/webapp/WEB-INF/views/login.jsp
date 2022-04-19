<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
    <head>
    <meta charset="UTF-8">
        <title>Spring Test</title>
    </head>

    <body>
        <h2>로그인</h2>
        </br>
        <form action="/login/loginProc" method="post">
            <table style="width:300px; border:1px solid red; margin:2px;">
                <tr>
                    <td>아이디</td>
                    <td><input type="text" name="id" placeholder="id" style="float:right;"></td>
                </tr>
                <tr>
                    <td>비밀번호</td>
                    <td><input type="password" name="pw" placeholder="pw" style="float:right;"></td>
                </tr>
                <tr>
                    <td colspan="2"><input type="submit" value="로그인" style="width:100%;"></td>
                </tr>
            </table>
        </form>
    </body>
</html>