<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript">
    $(document).ready(function(){
        $("#loginbtn").on('click',function(){
            var id = $('#id').val();
            var pw = $('#pw').val();

            if(!id){
                alert("아이디를 입력하세요.");
                return;
            }else if(!pw){
                 alert("비밀번호를 입력하세요.");
                 return;
            }

            $.ajax({
                type:"POST",
                url: "/login/loginProc?id=" + id + "&pw=" + pw,
                success : function(data) {
                    if(data == "isLoginSuccess_true"){
                        alert("로그인 성공");
                        $('#loginForm').submit();
                    }else if(data == "isLoginSuccess_noID"){
                        alert("존재하지 않는 아이디입니다.");
                    }else if(data == "isLoginSuccess_noPW"){
                        alert("비밀번호가 틀립니다.");
                    }
                }
            });
        });
    });
</script>

<html>
    <head>
    <meta charset="UTF-8">
        <title>Spring Test</title>
    </head>

    <body>
        <h2>로그인</h2>
        </br>
        <input type="button" id="cancel" value="홈" style="width:50px;" onclick="location.href='/home'">
        <form action="/login/loginuser" method="post" id="loginForm">
            <table style="width:300px; border:1px solid red; margin:2px;">
                <tr>
                    <td>아이디</td>
                    <td><input type="text" id="id" name="id" placeholder="id" style="float:right;"></td>
                </tr>
                <tr>
                    <td>비밀번호</td>
                    <td><input type="password" id="pw" name="pw" placeholder="pw" style="float:right;"></td>
                </tr>
                <tr>
                    <td colspan="2"><input type="button" value="로그인" style="width:100%;" id="loginbtn"></td>
                </tr>
            </table>
        </form>
    </body>
</html>