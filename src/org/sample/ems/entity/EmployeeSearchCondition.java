package org.sample.ems.entity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * 社員情報の検索条件を表すクラスです。
 *
 * @author Tomoya Yoshida
 * @version $Revision$
 */
public class EmployeeSearchCondition {

    /** シリアルバージョンUID */
    private static final long serialVersionUID = 1L;

    /** 社員番号 */
    private String employeeId;

    /** 性別 */
    private Sex sex;

    /** 部門 */
    private Branch branch;

    /** 入社年月日（From） */
    private Date fromEnterDate;

    /** 入社年月日（To） */
    private Date toEnterDate;

    /** ソート区分 */
    private String sortType;

    /** 降順かどうか */
    private boolean isDesc;

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
     * 性別を取得します。
     *
     * @return 性別
     */
    public Sex getSex() {
        return sex;
    }

    /**
     * 性別を設定します。
     * <code>null</code>または空文字列が渡された場合は、<code>null</code>を設定する。
     *
     * @param sex 性別
     * @throws IllegalSearchConditionException 不正な検索条件（{@link Sex}の取りうる値以外が渡された場合）が渡された場合
     */
    public void setSex(String sex) throws IllegalSearchConditionException {
        if (sex == null || sex.equals("")) {
            this.sex = null;
            return;
        }

        try {
            this.sex = Sex.valueOf(sex);
        } catch (IllegalArgumentException e) {
            throw new IllegalSearchConditionException(e);
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
     * <code>null</code>または空文字列が渡された場合は、<code>null</code>を設定する。
     *
     * @param branch 部門
     * @throws IllegalSearchConditionException 不正な検索条件（{@link Branch}の取りうる値以外が渡された場合）が渡された場合
     */
    public void setBranch(String branch) throws IllegalSearchConditionException {
        if (branch == null || branch.equals("")) {
            this.branch = null;
            return;
        }

        try {
            this.branch = Branch.valueOf(branch);
        } catch (IllegalArgumentException e) {
            throw new IllegalSearchConditionException(e);
        }
    }

    /**
     * 入社年月日（From）を取得します。
     *
     * @return 入社年月日（From）
     */
    public Date getFromEnterDate() {
        return fromEnterDate;
    }

    /**
     * 入社年月日（From）を設定します。<br>
     * <code>null</code>または空文字列が渡された場合は、<code>null</code>を設定する。
     *
     * @param fromEnterDate 入社年月日（From）
     * @throws IllegalSearchConditionException 不正な検索条件（yyyyMMdd形式以外、もしくは存在しない日付）が渡された場合。
     */
    public void setFromEnterDate(String fromEnterDate) throws IllegalSearchConditionException {
        if (fromEnterDate == null || fromEnterDate.equals("")) {
            this.fromEnterDate = null;
            return;
        }

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        dateFormat.setLenient(false);

        try {
            this.fromEnterDate = dateFormat.parse(fromEnterDate);
        } catch (ParseException e) {
            throw new IllegalSearchConditionException(e);
        }
    }

    /**
     * 入社年月日（To）を取得します。
     *
     * @return 入社年月日（To）
     */
    public Date getToEnterDate() {
        return toEnterDate;
    }

    /**
     * 入社年月日（To）を設定します。<br>
     * <code>null</code>または空文字列が渡された場合は、<code>null</code>を設定する。
     *
     * @param toEnterDate 入社年月日（To）
     * @throws IllegalSearchConditionException 不正な検索条件（yyyyMMdd形式以外、もしくは存在しない日付）が渡された場合。
     */
    public void setToEnterDate(String toEnterDate) throws IllegalSearchConditionException {
        if (toEnterDate == null || toEnterDate.equals("")) {
            this.toEnterDate = null;
            return;
        }

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        dateFormat.setLenient(false);

        try {
            this.toEnterDate = dateFormat.parse(toEnterDate);
        } catch (ParseException e) {
            throw new IllegalSearchConditionException(e);
        }
    }

    /**
     * ソート区分を取得します。
     *
     * @return ソート区分
     */
    public String getSortType() {
        return sortType;
    }

    /**
     * ソート区分を設定します。
     *
     * @param sortType ソート区分
     */
    public void setSortType(String sortType) {
        this.sortType = sortType;
    }

    /**
     * 降順かどうかを取得します。
     *
     * @return 降順かどうか
     */
    public boolean isDesc() {
        return isDesc;
    }

    /**
     * 降順かどうかを設定します。
     *
     * @param isDesc 降順かどうか
     */
    public void setDesc(String isDesc) {
        this.isDesc = Boolean.valueOf(isDesc);
    }
}
