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
    <meta name="viewport" content="width=device-width,initial-scale=1.0,maximum-scale=1.0,user-scalable=0;">
    <meta http-equiv="refresh" content="20">
    <meta charset="utf-8">
    <title>管理员审核</title>
    <link rel="stylesheet" href="css/master.css">
    <script type="text/javascript" src="./js/jquery-1.11.3.min.js"></script>
    <script src="./js/master.js"></script>
</head>
<body>
<div class="head">
    <div class="y_title">
        EMIT点歌台
    </div>
</div>
<div id="notice">
    <input id="publish" type="button" value="发布公告">
    <div id="pub_part">
        公告标题：
        <form>
            <p><input class="title" type="text" name="title"></p>
            <p>公告内容：
            <p>
                <textarea class="area" id="" cols="30" rows="10" name="content"></textarea>
            <div class="sure_not">
                <button class="sure" type="submit">确认发布</button>
                <button class="reset" type="reset" onclick="">取消发布</button>
            </div>
        </form>
    </div>
</div>

<c:forEach items="${master}" var="master">

<div class="user">
    <div class="con_header">
        <p>点歌人：${master.diangeren}</p>
        <%--<c:if test="${master.status==1}">
            <input class="pass" type="button" value="审核通过" data-id="${master.id}" >
        </c:if>--%>
        <c:choose>
            <c:when test="${master.status==1}">
                <input class="pass" type="button" value="已经通过" data-id="${master.id}" disabled="disabled">
            </c:when>
            <c:otherwise>
                <input class="pass" type="button" value="尚未通过" data-id="${master.id}">
            </c:otherwise>
        </c:choose>
            <%--<input class="pass" type="button" value="审核通过" data-id="${master.id}">--%>
        <input name="id" type="hidden" value="${master.id}"/>
        <input class="finish" type="button" value="播放歌曲">
    </div>
    <div class="con_content">
        <div class="left">
            <div class="song"><p>《${master.song}》</p></div>
            <div class="singer"><p>${master.singer}</p></div>
        </div>
        <div class="right">
            <p>To ${master.receiver}：</p>
            <p class="words">${master.jiyu}</p>
            <p class="date">${master.time}</p>
        </div>
    </div>
</div>
</c:forEach>
<%--
<div class="user">
    <div class="con_header">
        <p>点歌人：某某某</p>
        <input class="pass" type="button" value="审核通过">
        <input class="finish" type="button" value="歌曲已播">
    </div>
    <div class="con_content">
        <div class="left">
            <div class="song"><p>《我们的明天》</p></div>
            <div class="singer"><p>鹿晗</p></div>
        </div>
        <div class="right">
            <p>To 某某某：</p>
            <p class="words">一个人走到终点，不小心回到起点，一个新的世界，此刻我才发现，世界没有绝对。直到有另一个人，能体会我</p>
            <p class="date">2016-10-21</p>
        </div>
    </div>
</div>--%>

</html>