<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width,initial-scale=1.0,maximum-scale=1.0,user-scalable=0">
    <meta charset="utf-8">
    <title>快来点首歌吧</title>
    <link rel="stylesheet" href="css/form.css">
</head>
<body>
<div class="y_title">
    EMIT点歌台
</div>
<!--返回首页-->
<div class="back_index"><a href="/song?action=findPassedSongs">
    <返回首页>
</a></div>
<div class="form" id="form">
    <form id="form1">
        <p>用户名</p>
        <input type="text" class="song" id="Name" name="name">
        <div class="y_count" id="NameIimit">*已超出字数,不超过10字</div>
        <p>点播歌名:</p>
        <input type="text" class="song" id="songName" name="song">
        <div class="y_count" id="songNameIimit">*歌名已超出字数,汉字不超过20字</div>
        <p>歌手姓名:</p>
        <input type="text" class="song" id="personName" name="singer">
        <div class="y_count" id="personNameIimit">*歌手姓名已超出10字</div>
        <p>To：</p>
        <input type="text" class="song" id="forName" name="receiver">
        <div class="y_count" id="forNameIimit">*点歌对象名已超出10字</div>
        <p>寄语:</p>
        <textarea class="message" id="message" name="jiyu"></textarea>
        <div class="y_count" id="massageIimit">已输入0个字，还可输入50个字</div>
        <input type="button" action="" method="post" value="提交" class="submit" id="songSubmit">
    </form>
</div>
</body>
</html>
<script type="text/javascript" src=js/form.js></script>
<script type="text/javascript" src="js/jquery-1.11.3.min.js"></script>
