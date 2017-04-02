package com.weixin.servlet;

import com.weixin.bean.Announce;
import com.weixin.bean.Song;
import com.weixin.service.AnnounceService;
import com.weixin.service.SongService;
import com.weixin.util.DateUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by Liuqi
 * Date: 2016/11/5.
 */
public class SongServlet extends HttpServlet {

    @Override
    public void destroy() {
        System.out.println("-------destroy-------");
        super.destroy();
    }

    @Override
    public void init() throws ServletException {
        System.out.println("-------init---------");
        super.init();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        String forword = "/index.jsp";
        String action = req.getParameter("action");
        SongService songService = new SongService();
        AnnounceService announceService = new AnnounceService();
        if (action.equals("findPassedSongs")) {//查找审核通过的点歌
            List<Song> list = new ArrayList<Song>();
            list = songService.selectSongByStatus(1);
            Announce announce = announceService.findAnnounce();
            req.getSession().setAttribute("songs", list);
            req.getSession().setAttribute("announce", announceService.findAnnounce());
            forword = "index.jsp";
        } else if (action.equals("addSong")) {//添加点歌
            System.out.println("添加点歌");
            Song song = new Song();
            song.setSong(req.getParameter("song"));
            song.setSinger(req.getParameter("singer"));
            song.setDiangeren(req.getParameter("name"));
            song.setReceiver(req.getParameter("receiver"));
            song.setJiyu(req.getParameter("jiyu"));
            //song.setNiming(Integer.parseInt(req.getParameter("niming")));
            song.setTime(DateUtils.toMin());
            songService.addSong(song);

        } else if (action.equals("doVerify")) {//审核点歌通过，将状态设为1
            int id = Integer.parseInt(req.getParameter("id"));
            /*System.out.println("------id----" + id);
            System.out.println("dovarify");*/
            songService.doVerify(id, 1);
            forword = "/master.jsp";

        } else if (action.equals("doDelete")) {//删除点歌
            songService.deleteById(Integer.parseInt(req.getParameter("id")));
        } else if (action.equals("findUnpassed")) {//查找还未审核通过的点歌
            List<Song> list = new ArrayList<Song>();
            list = songService.selectSongByStatus(0);
            req.getSession().setAttribute("unpassed", list);
            forword = "/master.jsp";

        } else if (action.equals("findPlayed")) {//查找经审核过而且播放已过的点歌
            List<Song> list = new ArrayList<Song>();
            list = songService.selectSongByStatus(2);
            req.getSession().setAttribute("played", list);
            forword = "/finishSong.jsp";

        } else if (action.equals("playSongs")) {//播放点歌将状态设为2
            int id = Integer.parseInt(req.getParameter("id"));
            System.out.println("-----qqqqqqqqq-----" + id);
            forword = "/master.jsp";
            songService.doVerify(id, 2);

        } else if (action.equals("findPlayedSong")) {
            List<Song> list = new ArrayList<Song>();
            list = songService.selectSongByStatus(2);
            req.getSession().setAttribute("data", list);
            forword = "/finishSong.jsp";
            System.out.println("数量" + list.size());

        } else if (action.equals("masterFind")) {
            List<Song> list = new ArrayList<Song>();
            list = songService.masterFind();
            req.getSession().setAttribute("master", list);
            forword = "/master.jsp";
        } else {
            req.getRequestDispatcher("/index.jsp").forward(req, resp);
            return;
        }
        req.getRequestDispatcher(forword).forward(req, resp);
    }
}
