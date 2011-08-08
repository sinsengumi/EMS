package org.sample.ems.dao;

import java.util.List;

import org.sample.ems.entity.Employee;
import org.sample.ems.entity.EmployeeSearchCondition;
import org.seasar.doma.Dao;
import org.seasar.doma.Delete;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.Update;

/**
 * 社員情報のデータアクセスインタフェースです。
 *
 * @author Tomoya Yoshida
 * @version $Revision$
 */
@Dao(config = AppConfig.class)
public interface EmployeeDao {

    /**
     * 社員情報を取得します。
     *
     * @param employeeId 社員番号
     * @param password パスワード
     * @return 社員情報
     */
    @Select
    Employee authenticate(String employeeId, String password);

    /**
     * 社員情報を取得します。
     *
     * @param employeeId 社員番号
     * @return 社員情報
     */
    @Select
    Employee getEmployee(String employeeId);

    /**
     * 社員情報一覧を取得します。
     *
     * @param searchCondition 検索条件
     * @return 社員情報
     */
    @Select
    List<Employee> getEmployees(EmployeeSearchCondition searchCondition);

    /**
     * 社員情報を追加します。
     *
     * @param employee 社員情報
     * @return 追加された行数
     */
    @Insert
    int insertEmployee(Employee employee);

    /**
     * 社員情報を更新します。
     *
     * @param employee 社員情報
     * @return 更新された行数
     */
    @Update
    int updateEmployee(Employee employee);

    /**
     * 社員情報を削除します。
     *
     * @param employee 社員情報
     * @return 削除された行数
     */
    @Delete
    int deleteEmployee(Employee employee);
}
