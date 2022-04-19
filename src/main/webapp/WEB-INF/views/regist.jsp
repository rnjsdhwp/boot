<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript">
    $(document).ready(function(){
        var oldVal="";
        var idchk=0;
      /*
        $('#idchk').on('click', function(){
            var id = $('#id').val();
            var pw = $('#pw').val();
            var pwchk = $('#pwchk').val();
            var name = $('#name').val();
            var email = $('#email').val();
            location.href = '/regist/chkID?id='+id+'&pw='+pw+'&pwchk='+pwchk+'&name='+name+'&email='+email;
        });
      */

        $('#idchk').on('click', function(){
            idchk=1;
        });

        $("#id").on("propertychange change keyup paste input", function() {
            var currentVal = $(this).val();
            if(currentVal == oldVal) {
                return;
            }

            oldVal = currentVal;
            idchk=0;

            //$("#text").text(currentVal);
        });
    });
</script>

<html>
    <head>
    <meta charset="UTF-8">
        <title>Spring Test</title>
    </head>

    <body>
        <h2>회원가입</h2>
        </br>
        <form action="/regist/registuser" method="post">
            <table style="width:500px; border:1px solid red; margin:2px;">
                <tr>
                    <td>이름</td>
                    <td><input type="text" id="name" name="name" placeholder="username" style="width:100%;" value=${name}></td>
                </tr>
                <tr>
                    <td>아이디</td>
                    <td><input type="text" id="id" name="id" placeholder="ID" style="width:100%;" value=${id}></td>
                    <td><input type="button" id="idchk" value='중복확인'></td>
                    <!-- onkeyPress -->
                </tr>

<!-- 스크립트로 중복체크했는지 변수변경해서 넘기기?-->

<!-- 값이바뀌면 중복체크하라고 텍스트
    중복체크하면 db체크해서 중복or가능 텍스트
                <tr>
                    <td></td>
                    <td colspan="2"><p id="test"></p></td>
                </tr>
-->
                <c:set var="isExistID" value="${isExistID}"/>
                <c:choose>
                    <c:when test="${isExistID eq 'true'}">
                        <tr><td></td><td colspan="2">중복된 아이디입니다.</td></tr>
                    </c:when>
                    <c:when test="${isExistID eq 'false'}">
                        <tr><td></td><td colspan="2">사용할 수 있는 아이디입니다.</td></tr>
                    </c:when>
                </c:choose>


                <tr>
                    <td>비밀번호</td>
                    <td><input type="password" id="pw" name="pw" placeholder="PW" style="width:100%;" value=${pw}></td>
                </tr>
                <tr>
                    <td>비밀번호확인</td>
                    <td><input type="password" id="pwchk" name="pwchk" placeholder="pwchk" style="width:100%;" value=${pwchk}></td>
                </tr>
                <tr>
                    <td>이메일</td>
                    <td><input type="email" id="email" name="email" placeholder="email" style="width:100%;" value=${email}></td>
                </tr>
                <tr>
                    <td colspan="2"><input type="submit" value="회원가입" style="width:100%;"></td>
                </tr>
            </table>
        </form>
    </body>
</html>