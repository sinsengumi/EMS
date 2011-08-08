SELECT
    EMPLOYEE_ID,
    KANJI_LAST_NAME,
    KANJI_FIRST_NAME,
    ENTER_DATE,
    SEX,
    BRANCH,
    EMAIL
FROM
    EMPLOYEES
WHERE
    /*%if searchCondition.employeeId != null && searchCondition.employeeId != "" */
        EMPLOYEE_ID = /* searchCondition.employeeId */'00000'
    /*%end*/
    /*%if searchCondition.sex != null */
        AND SEX = /* searchCondition.sex */'F'
    /*%end*/
    /*%if searchCondition.branch != null */
        AND BRANCH = /* searchCondition.branch */'BS1G'
    /*%end*/
    /*%if searchCondition.fromEnterDate != null */
        AND ENTER_DATE >= /* searchCondition.fromEnterDate */'20100101'
    /*%end*/
    /*%if searchCondition.toEnterDate != null */
        AND ENTER_DATE <= /* searchCondition.toEnterDate */'20100101'
    /*%end*/
ORDER BY
    /*%if searchCondition.sortType == "employeeId" */
        /*%if searchCondition.isDesc == true */
            EMPLOYEE_ID DESC
        /*%else*/
            EMPLOYEE_ID
        /*%end*/
    /*%elseif searchCondition.sortType == "enterDate" */
        /*%if searchCondition.isDesc == true */
            ENTER_DATE DESC,
        /*%else*/
            ENTER_DATE,
        /*%end*/
        EMPLOYEE_ID
    /*%else*/
        EMPLOYEE_ID
    /*%end*/
