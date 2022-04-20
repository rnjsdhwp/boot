<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript">
    $(document).ready(function(){
        var oldVal="";
        var idchk=0;

        $('#idchk').on('click', function(){
            var id = $('#id').val();

            $.ajax({
                type:"POST",
                url: "/regist/chkID?id=" + id,
                success : function(data) {
                    console.log(data);
                    var chkdata="isExistID_true";
                    if(data.includes(chkdata)){
                        idchk=0;
                        alert("이미 있는 아이디입니다.");
                        document.getElementById('idchktxt').value = idchk;
                    }else{
                        idchk=1;
                        alert("사용 가능한 아이디입니다.");
                        document.getElementById('idchktxt').value = idchk;
                    }
                }
            });
        });

        $("#id").on("propertychange change keyup paste input", function() {
            var currentVal = $(this).val();
            if(currentVal == oldVal) {
                return;
            }

            oldVal = currentVal;
            idchk=0;
            document.getElementById('idchktxt').value = idchk;
        });

        $("#regist").on('click',function(){
            var name = $('#name').val();
            var id = $('#id').val();
            var pw = $('#pw').val();
            var pwchk = $('#pwchk').val();
            var email = $('#email').val();
            var email2 = $('#email2').val();

            if(!name){
                alert("이름을 입력하세요.");
                return;
            }else if(!id){
                alert("아이디를 입력하세요.");
                return;
            }else if(!pw){
                 alert("비밀번호를 입력하세요.");
                 return;
            }else if(!pw){
                 alert("비밀번호확인을 입력하세요.");
                 return;
            }else if(!email){
                 alert("이메일을 입력하세요.");
                 return;
            }else if(!email2){
                 alert("이메일을 입력하세요.");
                 return;
            }

            if(idchk==0){
                alert("id 중복확인을 해야합니다.");
            }else{
                if(pw==pwchk){
                    alert("회원가입 완료");
                    ${"registForm"}.submit();
                }else{
                    alert("비밀번호가 다릅니다.");
                }
            }
        });
    });
</script>

<html>
    <head>
    <meta charset="UTF-8">
        <title>Spring Test</title>
    </head>

    <body>
        <input type="hidden" value="${data}" id="isExistID"/>
        <h2>회원가입</h2>
        </br>
        <form action="/regist/registuser" method="post" id="registForm">
            <input type="hidden" id="idchktxt" name="idchktxt" value="0" />
            <table style="width:500px; border:1px solid red; margin:2px;">
                <tr>
                    <td style="width:20%">이름</td>
                    <td><input type="text" id="name" name="name" placeholder="username" style="width:100%;"></td>
                </tr>
                <tr>
                    <td>아이디</td>
                    <td><input type="text" id="id" name="id" placeholder="ID" style="width:100%;"></td>
                    <td><input type="button" id="idchk" value='중복확인'></td>
                </tr>

                <tr>
                    <td>비밀번호</td>
                    <td><input type="password" id="pw" name="pw" placeholder="pw" style="width:100%;"></td>
                </tr>

                <tr>
                    <td>비밀번호확인</td>
                    <td><input type="password" id="pwchk" name="pwchk" placeholder="pwchk" style="width:100%;"></td>
                </tr>

                <tr>
                    <td>이메일</td>
                    <td><input type="text" id="email" name="email" placeholder="email" style="width:45%;"/>
                        @
                        <input type="text" id="email2" name="email2" style="float:right; width:45%;"/></td>
                </tr>

                <tr>
                    <td></td>
                    <td><input type="button" id="regist" value="회원가입" style="width:100%;"></td>
                    <td></td>
                </tr>
            </table>
        </form>
    </body>
</html>