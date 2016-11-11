<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ page import="com.weixin.bean.Song" %>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <link rel="stylesheet" href="./css/index.css">
</head>
<body>
<!--头部-->
<div class="head">
    <div class="y_title">
        EMIT点歌台
    </div>
    <div class="y_nav">
        <div class="y_button">
            <div class="y_text border_bottom"><a href="/song?action=findPassedSongs">实况点播</a></div>
            <div class="y_text"><a href="/song?action=findPlayed">已播歌曲</a></div>
        </div>
    </div>
</div>

<!--公告-->
<div class="y_notice" id="notice">
    <img src="images/notice.gif">
    <div class="y_noticeTitle">公告</div>
    <div class="y_noticeTextTitle" id="TextTitle"><c:out value="${announce.title}"/></div>
    <div class="y_noticeText" id="text">
        <C:out value="${announce.content}"/>
    </div>
</div>
<!--点歌按钮-->
<a href="form.jsp">
    <div class="y_click">
        <p>点歌</p>
    </div>
</a>
<%--<% List<Song> list = (List<Song>) request.getAttribute("songs");
    for (Song song : list) {
        out.print(song.toString());
    }
%>--%>
<C:forEach items="${songs}" var="song">
    <div class="y_song" id="y_song">
        <div class="y_songTitle" id="y_songTitle">
            <img src="images/image.gif">
            <div class="y_songName" id="y_songName"><c:out value="${song.song}" default="haode"/>
                ----${song.singer}</div>
        </div>
        <div class="y-songcontent">
            <div class="y_personName">点歌人：${song.diangeren}</div>
            <div class="y_forPerson">to:${song.receiver}</div>
            <div class="y_songMessage">${song.jiyu}</div>
            <div class="y_time" id="Time">${song.time}</div>
        </div>
    </div>
</C:forEach>
</body>
<script type="text/javascript" src="js/jquery-1.11.3.min.js"></script>
<script type="text/javascript" src="js/index.js"></script>
</html>
