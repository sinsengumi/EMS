package org.sample.ems.share;

import java.text.MessageFormat;

/**
 * メッセージを定義する列挙型。
 *
 * @author Tomoya Yoshida
 * @version $Revision: 530 $
 */
public enum Messages {

    /** 社員番号もしくはパスワードが間違えています。 */
    MSG_INPUT_FAILED_AUTHENTICATION("社員番号もしくはパスワードが間違えています。"),

    /** 「{0}」が未入力です。 */
    MSG_INPUT_EMPTY("「{0}」が未入力です。"),

    /** 「{0}」と「{1}」が等しくありません。 */
    MSG_INPUT_NOT_EQUAL("「{0}」と「{1}」が等しくありません。"),

    /** 「{0}」が不正です。 */
    MSG_INPUT_INVALID("「{0}」が不正です。"),

    /** 「{0}」のフォーマットが不正です。 */
    MSG_INPUT_INVALID_FORMAT("「{0}」のフォーマットが不正です。"),

    /** 「{0}」が{1}桁より長すぎます。 */
    MSG_INPUT_GRATER_LENGTH("「{0}」が{1}桁より長すぎます。"),

    /** 入力された「社員番号」は既に使用されています。 */
    MSG_INPUT_UNIQUE_CONSTRAINT_EMPLOYEE_ID("入力された「社員番号」は既に使用されています。"),

    /** 不正な操作が行われました。 */
    MSG_INVALID_OPERATION("不正な操作が行われました。");

    /** メッセージ */
    private String message;

    /**
     * コンストラクタ。
     *
     * @param mesasge メッセージ
     */
    private Messages(String message) {
        this.message = message;
    }

    /**
     * メッセージを取得します。
     *
     * @return メッセージ
     */
    public String getMessage() {
        return message;
    }

    /**
     * メッセージを整形します。
     *
     * @return 整形されたメッセージ
     */
    public String format() {
        return format(new Object[]{});
    }

    /**
     * メッセージを整形します。
     *
     * @param arguments 埋め込み文字
     * @return 整形されたメッセージ
     */
    public String format(Object... arguments) {
        return MessageFormat.format(message.toString(), arguments);
    }
}
