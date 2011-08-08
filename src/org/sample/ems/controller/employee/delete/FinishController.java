package org.sample.ems.controller.employee.delete;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.sample.ems.dao.EmployeeDao;
import org.sample.ems.dao.EmployeeDaoImpl;
import org.sample.ems.entity.Employee;
import org.sample.ems.entity.EmployeeValidator;
import org.sample.ems.helper.ServletHelper;
import org.sample.ems.share.Messages;

/**
 * 「社員情報削除 完了」のコントローラクラスです。
 *
 * @author Tomoya Yoshida
 * @version $Revision$
 */
@WebServlet("/employee/delete/finish.action")
public class FinishController extends HttpServlet {

    /** シリアルバージョンUID */
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        if (isValidInput(request)) {
            EmployeeDao dao = new EmployeeDaoImpl();
            int result = dao.deleteEmployee(new Employee(request.getParameter("employeeId")));

            if (result == 0) {
                List<String> errorMessages = new ArrayList<String>();
                errorMessages.add(Messages.MSG_INVALID_OPERATION.format());
                request.setAttribute("errorMessages", errorMessages);
            }
        }

        ServletHelper.forward(request, response, "/WEB-INF/jsp/employee/delete/finish.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    /**
     * リクエストパラメータの入力チェックを行います。<br>
     * 入力チェックを行い、エラーがあればリクエストスコープにエラーメッセージを設定します。
     *
     * @param request HTTPリクエスト
     * @return 正常な入力であれば<code>true</code>、そうでない場合は<code>false</code>。
     */
    private boolean isValidInput(HttpServletRequest request) {

        List<String> errorMessages = new ArrayList<String>();

        String employeeId = request.getParameter("employeeId");

        if (EmployeeValidator.isEmptyEmployeeId(employeeId)) {
            errorMessages.add(Messages.MSG_INPUT_EMPTY.format("社員番号"));
        } else {
            if (!EmployeeValidator.isValidFormatEmployeeId(employeeId)) {
                errorMessages.add(Messages.MSG_INPUT_INVALID_FORMAT.format("社員番号"));
            }
        }

        if (errorMessages.isEmpty()) {
            return true;
        } else {
            request.setAttribute("errorMessages", errorMessages);

            return false;
        }
    }
}
