package org.sample.ems.controller.authentication;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.codec.digest.DigestUtils;
import org.sample.ems.dao.EmployeeDao;
import org.sample.ems.dao.EmployeeDaoImpl;
import org.sample.ems.entity.Employee;
import org.sample.ems.helper.ServletHelper;
import org.sample.ems.share.Messages;

/**
 * 「認証 ログイン」のコントローラクラスです。
 *
 * @author Tomoya Yoshida
 * @version $Revision$
 */
@WebServlet("/login.action")
public class LoginController extends HttpServlet {

    /** シリアルバージョンUID */
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        Employee employee = (Employee) session.getAttribute("loginEmployee");

        if (employee == null) {
            // 未認証の場合は、ログイン画面を表示
            ServletHelper.forward(request, response, "/WEB-INF/jsp/login.jsp");
        } else {
            // 認証済の場合は、メニュー画面を表示
            response.sendRedirect(request.getContextPath() + "/menu.action");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String employeeId = request.getParameter("employeeId");
        String password = request.getParameter("password");

        EmployeeDao dao = new EmployeeDaoImpl();
        Employee employee = dao.authenticate(employeeId, DigestUtils.sha256Hex(password));

        if (employee == null) {
            List<String> errorMessages = new ArrayList<String>();
            errorMessages.add(Messages.MSG_INPUT_FAILED_AUTHENTICATION.format());
            request.setAttribute("errorMessages", errorMessages);

            ServletHelper.forward(request, response, "/WEB-INF/jsp/login.jsp");
        } else {
            HttpSession session = request.getSession();
            session.setAttribute("loginEmployee", employee);

            response.sendRedirect(request.getContextPath() + "/menu.action");
        }
    }
}
