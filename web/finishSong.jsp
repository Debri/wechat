<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%><!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width,initial-scale=1.0,maximum-scale=1.0,user-scalable=0;">
    <meta charset="utf-8">
    <title>快来点首歌吧</title>
    <link rel="stylesheet" href="css/finishSong.css">
    <script type="text/javascript" src="js/jquery-1.11.3.min.js"></script>
    <script type="text/javascript" src="js/finishSong.js"></script>
</head>
<body>
<div class="head">
    <div class="y_title">
        EMIT点歌台
    </div>
    <div class="y_nav">
        <div class="y_button">
            <div class="y_text"><a href="/song?action=findPassedSongs">实况点播</a></div>
            <div class="y_text border_bottom"><a href="/song?action=findPlayed">已播歌曲</a></div>
        </div>
    </div>
</div>

<div id="content">
    <c:forEach items="${played}" var="finish">
    <input value="${finish.id}" type="hidden"/>
    <div class="user">
        <div class="con_header">
            <p>点歌人：${finish.diangeren}</p>
        </div>
        <div class="con_content">
            <div class="left">
                <div class="song"><p>《${finish.song}》
                    <p></div>
                <div class="singer"><p>${finish.singer}</p></div>
            </div>
            <div class="right">
                <p>To ${finish.receiver}：</p>
                <p class="words">${finish.jiyu}</p>
                <p class="date">${finish.time}</p>
            </div>
            </ul>
        </div>
    </div>

    </c:forEach>

    <%--<div class="user">
        <div class="con_header">
            <p>点歌人：某某某</p>
        </div>
        <div class="con_content">
            <div class="left">
                <div class="song"><p>《我们的明天》
                    <p></div>
                <div class="singer"><p></p>鹿晗</div>
            </div>
            <div class="right">
                <p>To 某某某：</p>
                <p class="words">一个人走到终点，不小心回到起点，一个新的世界，此刻我才发现，世界没有绝对。直到有另一个人，能体会我</p>
                <p class="date">2016-10-21</p>
            </div>
            </ul>
        </div>
    </div>--%>
</html>