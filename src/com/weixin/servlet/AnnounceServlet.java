package com.weixin.servlet;

import com.weixin.bean.Announce;
import com.weixin.service.AnnounceService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Liuqi
 * Date: 2016/11/8.
 */
public class AnnounceServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        AnnounceService announceService = new AnnounceService();
        String forward = "/master.jsp";
        String action = req.getParameter("action");
        if (action.equals("addAnnounce")) {
            announceService.addAnnounce(new Announce(req.getParameter("title"), req.getParameter("content")));

        } else {
            req.getRequestDispatcher("/master.jsp").forward(req, resp);
            return;
        }
        req.getRequestDispatcher("/master.jsp").forward(req, resp);
    }
}
