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

import org.apache.commons.codec.digest.DigestUtils;
import org.sample.ems.entity.Employee;
import org.sample.ems.entity.EmployeeValidator;
import org.sample.ems.helper.ServletHelper;
import org.sample.ems.share.Messages;

/**
 * 「社員情報登録 確認」のコントローラクラスです。
 *
 * @author Tomoya Yoshida
 * @version $Revision$
 */
@WebServlet("/employee/create/confirm.action")
public class ConfirmController extends HttpServlet {

    /** シリアルバージョンUID */
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        if (isValidInput(request)) {
            HttpSession session = request.getSession();
            session.setAttribute("createEmployee", getEmployee(request));

            ServletHelper.forward(request, response, "/WEB-INF/jsp/employee/create/confirm.jsp");
        } else {
            ServletHelper.forward(request, response, "/WEB-INF/jsp/employee/create/input.jsp");
        }
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
        String password = request.getParameter("password");
        String passwordConfirm = request.getParameter("passwordConfirm");
        String kanjiLastName = request.getParameter("kanjiLastName");
        String kanjiFirstName = request.getParameter("kanjiFirstName");
        String sex = request.getParameter("sex");
        String enterDate = request.getParameter("enterDate");
        String branch = request.getParameter("branch");
        String email = request.getParameter("email");

        // 社員番号
        if (EmployeeValidator.isEmptyEmployeeId(employeeId)) {
            errorMessages.add(Messages.MSG_INPUT_EMPTY.format("社員番号"));
        } else {
            if (!EmployeeValidator.isValidFormatEmployeeId(employeeId)) {
                errorMessages.add(Messages.MSG_INPUT_INVALID_FORMAT.format("社員番号"));
            }
        }

        // パスワード
        if (EmployeeValidator.isEmptyPassword(password)) {
            errorMessages.add(Messages.MSG_INPUT_EMPTY.format("パスワード"));
        } else {
            if (!EmployeeValidator.isEqualPassword(password, passwordConfirm)) {
                errorMessages.add(Messages.MSG_INPUT_NOT_EQUAL.format("パスワード", "パスワード（確認）"));
            }
        }

        // 名前（漢字） 姓
        if (EmployeeValidator.isEmptyKanjiLastName(kanjiLastName)) {
            errorMessages.add(Messages.MSG_INPUT_EMPTY.format("名前（漢字） 姓"));
        } else {
            if (!EmployeeValidator.isValidLengthKanjiLastName(kanjiLastName)) {
                errorMessages.add(Messages.MSG_INPUT_GRATER_LENGTH.format("名前（漢字） 姓", "10"));
            }
        }

        // 名前（漢字） 名
        if (EmployeeValidator.isEmptyKanjiFirstName(kanjiFirstName)) {
            errorMessages.add(Messages.MSG_INPUT_EMPTY.format("名前（漢字） 名"));
        } else {
            if (!EmployeeValidator.isValidLengthKanjiFirstName(kanjiFirstName)) {
                errorMessages.add(Messages.MSG_INPUT_GRATER_LENGTH.format("名前（漢字） 名", "10"));
            }
        }

        // 性別
        if (EmployeeValidator.isEmptySex(sex)) {
            errorMessages.add(Messages.MSG_INPUT_EMPTY.format("性別"));
        } else {
            if (!EmployeeValidator.isValidSex(sex)) {
                errorMessages.add(Messages.MSG_INPUT_INVALID.format("性別"));
            }
        }

        // 入社年月日
        if (EmployeeValidator.isEmptyEnterDate(enterDate)) {
            errorMessages.add(Messages.MSG_INPUT_EMPTY.format("入社年月日"));
        } else {
            if (!EmployeeValidator.isValidFormatEnterDate(enterDate)) {
                errorMessages.add(Messages.MSG_INPUT_INVALID_FORMAT.format("入社年月日"));
            }
        }

        // 部門
        if (EmployeeValidator.isEmptyBranch(branch)) {
            errorMessages.add(Messages.MSG_INPUT_EMPTY.format("部門"));
        } else {
            if (!EmployeeValidator.isValidBranch(branch)) {
                errorMessages.add(Messages.MSG_INPUT_INVALID.format("部門"));
            }
        }

        // メールアドレス
        if (!EmployeeValidator.isEmptyEmail(email)) {
            if (!EmployeeValidator.isValidFormatEmail(email)) {
                errorMessages.add(Messages.MSG_INPUT_INVALID_FORMAT.format("メールアドレス"));
            }
        }

        if (errorMessages.isEmpty()) {
            return true;
        } else {
            request.setAttribute("errorMessages", errorMessages);

            return false;
        }
    }

    /**
     * 社員情報を取得します。<br>
     * HTTPリクエストパラメータから社員情報を構築し、返却します。
     *
     * @param request HTTPリクエスト
     * @return 社員情報
     */
    private Employee getEmployee(HttpServletRequest request) {

        Employee result = new Employee();
        result.setEmployeeId(request.getParameter("employeeId"));
        result.setPassword(DigestUtils.sha256Hex(request.getParameter("password")));
        result.setKanjiLastName(request.getParameter("kanjiLastName"));
        result.setKanjiFirstName(request.getParameter("kanjiFirstName"));
        result.setSex(request.getParameter("sex"));
        result.setEnterDate(request.getParameter("enterDate"));
        result.setBranch(request.getParameter("branch"));
        result.setEmail(request.getParameter("email"));

        return result;
    }
}
