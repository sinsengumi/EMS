package org.sample.ems.entity;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.seasar.doma.Column;
import org.seasar.doma.Entity;
import org.seasar.doma.Id;
import org.seasar.doma.Table;
import org.seasar.doma.jdbc.entity.NamingType;

/**
 * 社員情報のモデルクラスです。
 *
 * @author Tomoya Yoshida
 * @version $Revision$
 */
@Entity(naming = NamingType.SNAKE_UPPER_CASE)
@Table(name = "EMPLOYEES")
public class Employee implements Serializable {

    /** シリアルバージョンUID */
    private static final long serialVersionUID = 1L;

    /**
     * コンストラクタ。
     */
    public Employee() {
    }

    /**
     * コンストラクタ。
     *
     * @param employeeId 社員番号
     */
    public Employee(String employeeId) {
        this.employeeId = employeeId;
    }

    /** 社員番号 */
    @Id
    String employeeId;

    /** パスワード */
    @Column(updatable = false)
    String password;

    /** 名前（漢字） 姓 */
    String kanjiLastName;

    /** 名前（漢字） 名 */
    String kanjiFirstName;

    /** 性別 */
    Sex sex;

    /** 入社年月日 */
    Date enterDate;

    /** 部門 */
    Branch branch;

    /** メールアドレス */
    String email;

    /**
     * 社員番号を取得します。
     *
     * @return 社員番号
     */
    public String getEmployeeId() {
        return employeeId;
    }

    /**
     * 社員番号を設定します。
     *
     * @param employeeId 社員番号
     */
    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    /**
     * パスワードを取得します。
     *
     * @return パスワード
     */
    public String getPassword() {
        return password;
    }

    /**
     * パスワードを設定します。
     *
     * @param password パスワード
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 名前（漢字） 姓を取得します。
     *
     * @return 名前（漢字） 姓
     */
    public String getKanjiLastName() {
        return kanjiLastName;
    }

    /**
     * 名前（漢字） 姓を設定します。
     *
     * @param kanjiLastName 名前（漢字） 姓
     */
    public void setKanjiLastName(String kanjiLastName) {
        this.kanjiLastName = kanjiLastName;
    }

    /**
     * 名前（漢字） 名を取得します。
     *
     * @return 名前（漢字） 名
     */
    public String getKanjiFirstName() {
        return kanjiFirstName;
    }

    /**
     * 名前（漢字） 名を設定します。
     *
     * @param kanjiFirstName 名前（漢字） 名
     */
    public void setKanjiFirstName(String kanjiFirstName) {
        this.kanjiFirstName = kanjiFirstName;
    }

    /**
     * 性別を取得します。
     *
     * @return 性別
     */
    public Sex getSex() {
        return sex;
    }

    /**
     * 性別を設定します。
     *
     * @param sex 性別
     */
    public void setSex(Sex sex) {
        this.sex = sex;
    }

    /**
     * 性別を設定します。<br>
     * {@link Sex}の取りうる値以外が渡された場合、<code>null</code>で設定します。
     *
     * @param sex 性別
     */
    public void setSex(String sex) {
        try {
            this.sex = Sex.valueOf(sex);
        } catch (Exception e) {
            this.sex = null;
        }
    }

    /**
     * 入社年月日を取得します。
     *
     * @return 入社年月日
     */
    public Date getEnterDate() {
        return enterDate;
    }

    /**
     * 入社年月日を設定します。
     *
     * @param enterDate 入社年月日
     */
    public void setEnterDate(Date enterDate) {
        this.enterDate = enterDate;
    }

    /**
     * 入社年月日を設定します。<br>
     * yyyyMMdd形式以外、もしくは存在しない日付が渡された場合、<code>null</code>で設定します。
     *
     * @param enterDate 入社年月日（yyyyMMdd形式）
     */
    public void setEnterDate(String enterDate) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        dateFormat.setLenient(false);

        try {
            this.enterDate = dateFormat.parse(enterDate);
        } catch (ParseException e) {
            this.enterDate = null;
        }
    }

    /**
     * 部門を取得します。
     *
     * @return 部門
     */
    public Branch getBranch() {
        return branch;
    }

    /**
     * 部門を設定します。
     *
     * @param branch 部門
     */
    public void setBranch(Branch branch) {
        this.branch = branch;
    }

    /**
     * 部門を設定します。<br>
     * {@link Branch}の取りうる値以外が渡された場合、<code>null</code>で設定します。
     *
     * @param branch 部門
     */
    public void setBranch(String branch) {
        try {
            this.branch = Branch.valueOf(branch);
        } catch (Exception e) {
            this.branch = null;
        }
    }

    /**
     * メールアドレスを取得します。
     *
     * @return メールアドレス
     */
    public String getEmail() {
        return email;
    }

    /**
     * メールアドレスを設定します。
     *
     * @param email メールアドレス
     */
    public void setEmail(String email) {
        this.email = email;
    }
}
