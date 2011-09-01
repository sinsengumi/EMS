package org.sample.ems.controller.menu;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.sample.ems.share.ServletHelper;

/**
 * 「メニュー」のコントローラクラスです。
 *
 * @author Tomoya Yoshida
 * @version $Revision$
 */
@WebServlet("/menu.action")
public class MenuController extends HttpServlet {

    /** シリアルバージョンUID */
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ServletHelper.forward(request, response, "/WEB-INF/jsp/menu.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
