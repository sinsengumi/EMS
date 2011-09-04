package org.sample.ems.controller.employee.create;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.sample.ems.dao.EmployeeDao;
import org.sample.ems.dao.EmployeeDaoImpl;
import org.sample.ems.entity.Employee;
import org.sample.ems.share.EMSException;
import org.sample.ems.share.Messages;
import org.sample.ems.share.ServletHelper;
import org.seasar.doma.jdbc.UniqueConstraintException;

/**
 * 「社員情報登録 完了」のコントローラクラスです。
 *
 * @author Tomoya Yoshida
 * @version $Revision$
 */
@WebServlet("/employee/create/finish.action")
public class FinishController extends HttpServlet {

    /** シリアルバージョンUID */
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        throw new EMSException(Messages.MSG_INVALID_OPERATION.format());
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        if (isValidInput(request)) {
            HttpSession session = request.getSession();
            Employee employee = (Employee) session.getAttribute("createEmployee");

            EmployeeDao dao = new EmployeeDaoImpl();

            try {
                int result = dao.insertEmployee(employee);

                if (result > 0) {
                    session.removeAttribute("createEmployee");

                    ServletHelper.forward(
                            request, response, "/WEB-INF/jsp/employee/create/finish.jsp");
                } else {
                    List<String> errorMessages = new ArrayList<String>();
                    errorMessages.add(Messages.MSG_INVALID_OPERATION.format());
                    request.setAttribute("errorMessages", errorMessages);

                    ServletHelper.forward(
                            request, response, "/WEB-INF/jsp/employee/create/confirm.jsp");
                }
            } catch (UniqueConstraintException e) {
                List<String> errorMessages = new ArrayList<String>();
                errorMessages.add(Messages.MSG_INPUT_UNIQUE_CONSTRAINT_EMPLOYEE_ID.format());
                request.setAttribute("errorMessages", errorMessages);

                ServletHelper.forward(
                        request, response, "/WEB-INF/jsp/employee/create/confirm.jsp");
            }
        } else {
            ServletHelper.forward(request, response, "/WEB-INF/jsp/employee/create/confirm.jsp");
        }
    }

    /**
     * リクエストパラメータの入力チェックを行います。<br>
     * 入力チェックを行い、エラーがあればリクエストスコープにエラーメッセージを設定します。
     *
     * @param request HTTPリクエスト
     * @return 正常な入力であれば<code>true</code>、そうでない場合は<code>false</code>。
     */
    public boolean isValidInput(HttpServletRequest request) {
        HttpSession session = request.getSession();
        Object employee = session.getAttribute("createEmployee");

        if (employee == null) {
            List<String> errorMessages = new ArrayList<String>();
            errorMessages.add(Messages.MSG_INVALID_OPERATION.format());
            request.setAttribute("errorMessages", errorMessages);

            return false;
        }

        return true;
    }
}
