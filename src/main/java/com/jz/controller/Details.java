package com.jz.controller;

import com.jz.dto.OwnerDTO;
import com.jz.dto.RepoDTO;
import com.jz.service.GetData;
import com.jz.service.Languages;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet("/details")
public class Details extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String username = req.getParameter("username");

        List<RepoDTO> list = GetData.getUsersRepos(username);
        OwnerDTO owner = GetData.getOwnerByUsername(username);
        Map<String, Integer> stats = Languages.getStats(list);

        req.setAttribute("list", list);
        req.setAttribute("owner", owner);
        req.setAttribute("stats", stats);

        req.getRequestDispatcher("/details.jsp").forward(req, resp);
    }

}
