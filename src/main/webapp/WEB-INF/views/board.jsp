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
        <form action="./write" method="get">
            <table style="width:900px; border:1px solid red; margin:2px;">
                <th style="width:100px; text-align:center; border:1px solid red;">글번호</th>
                <th style="width:500px; text-align:center; border:1px solid red;">제목</th>
                <th style="width:100px; text-align:center; border:1px solid red;">작성자</th>
                <th style="width:100px; text-align:center; border:1px solid red;">등록일</th>
                <th style="width:100px; text-align:center; border:1px solid red;">조회수</th>

                <!--게시판-->
                <tr>
                    <td style="text-align:center;">1</td>
                    <td>2</td>
                    <td style="text-align:center;">3</td>
                    <td style="text-align:center;">4</td>
                    <td style="text-align:center;">5</td>
                </tr>

                <tr>
                    <td colspan="5" style="border-top:1px solid red;">
                        <input type="submit" value="글쓰기" style="float:right; margin:4px 2px 2px;"></td>
                </tr>
            </table>
        </form>
    </body>
</html>