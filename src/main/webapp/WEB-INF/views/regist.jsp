<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
    <head>
    <meta charset="UTF-8">
        <title>Spring Test</title>
    </head>

    <body>
        <h2>회원가입</h2>
        </br>
        <form action="./home" method="get">
            <table style="width:300px; border:1px solid red; margin:2px;">
                <tr>
                    <td>이름</td>
                    <td><input type="text" name="username" placeholder="username" style="float:right;"></td>
                </tr>
                <tr>
                    <td>아이디</td>
                    <td><input type="text" name="userid" placeholder="ID" style="float:right;"></td>
                </tr>
                <tr>
                    <td>비밀번호</td>
                    <td><input type="password" name="userpw" placeholder="PW" style="float:right;"></td>
                </tr>
                <tr>
                    <td>비밀번호확인</td>
                    <td><input type="password" name="pwchk" placeholder="pwchk" style="float:right;"></td>
                </tr>
                <tr>
                    <td>이메일</td>
                    <td><input type="email" name="email" placeholder="email" style="float:right;"></td>
                </tr>
                <tr>
                    <td colspan="2"><input type="submit" value="회원가입" style="width:100%;"></td>
                </tr>
            </table>
        </form>
    </body>
</html>