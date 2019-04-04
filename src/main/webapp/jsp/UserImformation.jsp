<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: wangkang
  Date: 2019-03-30
  Time: 10:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<html>
<head>
    <title>UserImformation</title>
    <meta http-equiv=”Content-Type” content=”text/html; charset=UTF-8”>
    <script type="text/javascript" src="../js/myScript.js"></script>
    <link rel="stylesheet" type="text/css" href="../css/mystyle.css">

    <%--引入datatable所需的js，jquery，css文件--%>
    <link rel="stylesheet" type="text/css" href="../css/jquery.dataTables.min.css">
    <link rel="stylesheet" type="text/css" href="../css/fixedColumns.dataTables.min.css">
    <link rel="stylesheet" href="../css/jquery-ui.css">

    <script src="../js/jquery.min.js"></script>
    <script src="../js/jquery.dataTables.min.js"></script>
    <script src="../js/jquery-ui.js"></script>

    <script src="../js/datepicker-zh-CN.js"></script>
    <script src="../js/dataTables.fixedColumns.min.js"></script>
</head>
<body>
<script>
    $(document).ready( function () {
        $('#table_id_example').DataTable();
    } );

</script>
<% request.setCharacterEncoding("UTF-8"); %>
<h2 align="center">欢迎登陆人员管理系统</h2>
<table ID="table_id_example" CLASS="display">
    <thead>
        <tr>
            <th>姓名</th>
            <th>电话</th>
            <th>地址</th>
            <th>操作</th>
        </tr>
    </thead>
    <tbody id="mytest">
    <c:forEach items="${list}" var="list" varStatus="mapStatus">
        <tr>
            <td align="center">${list.username}</td>
            <td align="center">${list.phone}</td>
            <td align="center">${list.adress}</td>
            <td align="center">
                <a  href="/?username=${list.username}">编辑</a>
                <a id="deleteUserImformation"  href="/deleteUserimformation?username=${list.username}">删除</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
    <div>
        <div>
            <form action="" name="addUserImformation" onsubmit="return validateForm()">
                <input type="text" name="userName" id="userName" placeholder="请输入姓名" required="required">
                <input type="text" name="phone" id="phone" placeholder="请输入电话信息" required="required">
                <input type="text" name="address" id="address" placeholder="请输入地址" required="required">
                <input type="submit"  value="新增" >
            </form>
        </div>
    </div>
    <form action="/add" method="post" id="userAdd">
    </form>

    <button id="queryUser" type="button" onclick="queryUser()">查询</button>

<table id="example" class="display compact"  style="width:100%"></table>
</body>

</html>
