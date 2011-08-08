package org.sample.ems.exception;

/**
 * アプリケーションで使用する共通例外クラスです。
 *
 * @author Tomoya Yoshida
 * @version $Revision$
 */
public class EMSException extends RuntimeException {

    /** シリアルバージョンUID */
    private static final long serialVersionUID = 1L;

    /**
     * 指定された詳細メッセージを使用して新規例外を構築します。
     *
     * @param message 詳細メッセージ
     */
    public EMSException(String message) {
        super(message);
    }

    /**
     * 指定された原因を使用して新規例外を構築します。
     *
     * @param cause 原因
     */
    public EMSException(Throwable cause) {
        super(cause);
    }

    /**
     * 指定された詳細メッセージおよび原因を使用して新規例外を構築します。
     *
     * @param message 詳細メッセージ
     * @param cause 原因
     */
    public EMSException(String message, Throwable cause) {
        super(message, cause);
    }
}
