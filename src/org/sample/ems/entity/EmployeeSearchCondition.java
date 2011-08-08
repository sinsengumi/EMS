package org.sample.ems.entity;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 社員情報の検索条件を表すクラスです。
 *
 * @author Tomoya Yoshida
 * @version $Revision$
 */
public class EmployeeSearchCondition extends Employee {

    /** シリアルバージョンUID */
    private static final long serialVersionUID = 1L;

    /** 入社年月日（From） */
    private Date fromEnterDate;

    /** 入社年月日（To） */
    private Date toEnterDate;

    /** ソート区分 */
    private String sortType;

    /** 降順かどうか */
    private boolean isDesc;

    /**
     * 入社年月日（From）を取得します。
     *
     * @return 入社年月日（From）
     */
    public Date getFromEnterDate() {
        return fromEnterDate;
    }

    /**
     * 入社年月日（From）を設定します。
     *
     * @param fromEnterDate 入社年月日（From）
     */
    public void setFromEnterDate(Date fromEnterDate) {
        this.fromEnterDate = fromEnterDate;
    }

    /**
     * 入社年月日（From）を設定します。<br>
     * yyyyMMdd形式以外、もしくは存在しない日付が渡された場合、<code>null</code>で設定します。
     *
     * @param fromEnterDate 入社年月日（From）（yyyyMMdd形式）
     */
    public void setFromEnterDate(String fromEnterDate) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        dateFormat.setLenient(false);

        try {
            this.fromEnterDate = dateFormat.parse(fromEnterDate);
        } catch (Exception e) {
            this.fromEnterDate = null;
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
     * 入社年月日（To）を設定します。
     *
     * @param toEnterDate 入社年月日（To）
     */
    public void setToEnterDate(Date toEnterDate) {
        this.toEnterDate = toEnterDate;
    }

    /**
     * 入社年月日（To）を設定します。<br>
     * yyyyMMdd形式以外、もしくは存在しない日付が渡された場合、<code>null</code>で設定します。
     *
     * @param toEnterDate 入社年月日（To）（yyyyMMdd形式）
     */
    public void setToEnterDate(String toEnterDate) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        dateFormat.setLenient(false);

        try {
            this.toEnterDate = dateFormat.parse(toEnterDate);
        } catch (Exception e) {
            this.toEnterDate = null;
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
    public void setDesc(boolean isDesc) {
        this.isDesc = isDesc;
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
