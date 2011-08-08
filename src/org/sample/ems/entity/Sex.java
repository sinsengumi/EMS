package org.sample.ems.entity;

/**
 * 性別を表す列挙型です。
 *
 * @author Tomoya Yoshida
 * @version $Revision$
 */
public enum Sex {

    /** 男性 */
    M("男性"),

    /** 女性 */
    F("女性");

    /** ラベル */
    private String label;

    /**
     * コンストラクタ
     *
     * @param label ラベル
     */
    private Sex(String label) {
        this.label = label;
    }

    /**
     * ラベルを取得します。
     *
     * @return ラベル
     */
    public String getLabel() {
        return label;
    }
}
