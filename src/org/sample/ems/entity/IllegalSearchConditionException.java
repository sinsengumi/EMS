package org.sample.ems.entity;

public class IllegalSearchConditionException extends Exception {

    /** シリアルバージョンUID */
    private static final long serialVersionUID = 1L;

    /**
     * 指定された原因を使用して新規例外を構築します。
     *
     * @param cause 原因
     */
    public IllegalSearchConditionException(Throwable cause) {
        super(cause);
    }
}
