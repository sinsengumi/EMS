package org.sample.ems.controller.employee.search;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.sample.ems.dao.EmployeeDao;
import org.sample.ems.dao.EmployeeDaoImpl;
import org.sample.ems.entity.Employee;
import org.sample.ems.entity.EmployeeSearchCondition;
import org.sample.ems.entity.IllegalSearchConditionException;
import org.sample.ems.share.EMSException;
import org.sample.ems.share.Messages;
import org.sample.ems.share.ServletHelper;

/**
 * 「社員情報検索 一覧（検索）」のコントローラクラスです。
 *
 * @author Tomoya Yoshida
 * @version $Revision$
 */
@WebServlet("/employee/search/list.action")
public class ListController extends HttpServlet {

    /** シリアルバージョンUID */
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<Employee> employees = null;
        try {
            EmployeeDao dao = new EmployeeDaoImpl();
            employees = dao.getEmployees(getEmployeeSearchCondition(request));
        } catch (IllegalSearchConditionException e) {
            employees = Collections.emptyList();
        }

        request.setAttribute("employees", employees);

        ServletHelper.forward(request, response, "/WEB-INF/jsp/employee/search/list.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        throw new EMSException(Messages.MSG_INVALID_OPERATION.format());
    }

    /**
     * リクエストパラメータから社員情報の検索条件を取得する。
     *
     * @param request HTTPリクエスト
     * @return 社員情報の検索条件オブジェクト
     * @throws IllegalSearchConditionException 不正な検索条件が渡された場合
     */
    private EmployeeSearchCondition getEmployeeSearchCondition(HttpServletRequest request)
            throws IllegalSearchConditionException {

        EmployeeSearchCondition searchCondition = new EmployeeSearchCondition();
        searchCondition.setEmployeeId(request.getParameter("employeeId"));
        searchCondition.setSex(request.getParameter("sex"));
        searchCondition.setBranch(request.getParameter("branch"));
        searchCondition.setFromEnterDate(request.getParameter("fromEnterDate"));
        searchCondition.setToEnterDate(request.getParameter("toEnterDate"));
        searchCondition.setSortType(request.getParameter("sortType"));
        searchCondition.setDesc(request.getParameter("isDesc"));

        return searchCondition;
    }
}
