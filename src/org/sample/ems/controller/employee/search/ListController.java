package org.sample.ems.controller.employee.search;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.sample.ems.dao.EmployeeDao;
import org.sample.ems.dao.EmployeeDaoImpl;
import org.sample.ems.entity.Employee;
import org.sample.ems.entity.EmployeeSearchCondition;
import org.sample.ems.helper.ServletHelper;

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

        EmployeeDao dao = new EmployeeDaoImpl();
        List<Employee> employees = dao.getEmployees(getEmployeeSearchCondition(request));

        request.setAttribute("employees", employees);

        ServletHelper.forward(request, response, "/WEB-INF/jsp/employee/search/list.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    /**
     * リクエストパラメータから社員情報の検索条件を取得する。
     *
     * @param request HTTPリクエスト
     * @return 社員情報の検索条件オブジェクト
     */
    private EmployeeSearchCondition getEmployeeSearchCondition(HttpServletRequest request) {

        Map<String, String> decodedParameters = ServletHelper.getDecodedParameters(request);

        EmployeeSearchCondition searchCondition = new EmployeeSearchCondition();
        searchCondition.setEmployeeId(decodedParameters.get("employeeId"));
        searchCondition.setSex(decodedParameters.get("sex"));
        searchCondition.setBranch(decodedParameters.get("branch"));
        searchCondition.setFromEnterDate(decodedParameters.get("fromEnterDate"));
        searchCondition.setToEnterDate(decodedParameters.get("toEnterDate"));
        searchCondition.setSortType(decodedParameters.get("sortType"));
        searchCondition.setDesc(decodedParameters.get("isDesc"));

        return searchCondition;
    }
}
