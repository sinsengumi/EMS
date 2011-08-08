package org.sample.ems.entity;

import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * 社員情報のバリデータクラスです。
 *
 * @author Tomoya Yoshida
 * @version $Revision$
 */
public final class EmployeeValidator {

    /** 名前（漢字）の最大長 */
    private static final int MAX_KANJI_NAME_LENGTH = 10;

    /**
     * コンストラクタ。
     */
    private EmployeeValidator() {
    }

    /**
     * 社員番号が空（<code>null</code>または、空文字列）かどうかを確認します。
     *
     * @param employeeId 社員番号
     * @return 空（<code>null</code>または、空文字列）であれば<code>true</code>、そうでない場合は<code>false</code>。
     */
    public static boolean isEmptyEmployeeId(String employeeId) {
        return isEmpty(employeeId);
    }

    /**
     * 社員番号が妥当なフォーマット（半角数値5桁）かどうかを確認します。
     *
     * @param employeeId 社員番号
     * @return 妥当なフォーマット（半角数値5桁）の場合は<code>true</code>、そうでない場合は<code>false</code>。
     */
    public static boolean isValidFormatEmployeeId(String employeeId) {
        if (!employeeId.matches("\\d{5}")) {
            return false;
        }

        return true;
    }

    /**
     * パスワードが空（<code>null</code>または、空文字列）かどうかを確認します。
     *
     * @param password パスワード
     * @return 空（<code>null</code>または、空文字列）であれば<code>true</code>、そうでない場合は<code>false</code>。
     */
    public static boolean isEmptyPassword(String password) {
        return isEmpty(password);
    }

    /**
     * パスワードとパスワード（確認）が等しいかどうかを確認します。
     *
     * @param password パスワード
     * @param passwordConfirm パスワード（確認）
     * @return 等しい場合は<code>true</code>、そうでない場合は<code>false</code>。
     */
    public static boolean isEqualPassword(String password, String passwordConfirm) {
        if (!password.equals(passwordConfirm)) {
            return false;
        }

        return true;
    }

    /**
     * 名前（漢字） 姓が空（<code>null</code>または、空文字列）かどうかを確認します。
     *
     * @param kanjiLastName 名前（漢字） 姓
     * @return 空（<code>null</code>または、空文字列）であれば<code>true</code>、そうでない場合は<code>false</code>。
     */
    public static boolean isEmptyKanjiLastName(String kanjiLastName) {
        return isEmpty(kanjiLastName);
    }

    /**
     * 名前（漢字） 姓が妥当な長さ（{@value EmployeeValidator#MAX_KANJI_NAME_LENGTH}文字以下）かどうかを確認します。
     *
     * @param kanjiLastName 名前（漢字） 姓
     * @return 妥当な長さ（{@value #MAX_KANJI_NAME_LENGTH}文字以下）の場合は<code>true</code>、
     *         そうでない場合は<code>false</code>。
     */
    public static boolean isValidLengthKanjiLastName(String kanjiLastName) {
        if (kanjiLastName.length() > MAX_KANJI_NAME_LENGTH) {
            return false;
        }

        return true;
    }

    /**
     * 名前（漢字） 名が空（<code>null</code>または、空文字列）かどうかを確認します。
     *
     * @param kanjiFirstName 名前（漢字） 名
     * @return 空（<code>null</code>または、空文字列）であれば<code>true</code>、そうでない場合は<code>false</code>。
     */
    public static boolean isEmptyKanjiFirstName(String kanjiFirstName) {
        return isEmpty(kanjiFirstName);
    }

    /**
     * 名前（漢字） 名が妥当な長さ（{@value EmployeeValidator#MAX_KANJI_NAME_LENGTH}文字以下）かどうかを確認します。
     *
     * @param kanjiFirstName 名前（漢字） 名
     * @return 妥当な長さ（{@value #MAX_KANJI_NAME_LENGTH}文字以下）の場合は<code>true</code>、
     *         そうでない場合は<code>false</code>。
     */
    public static boolean isValidLengthKanjiFirstName(String kanjiFirstName) {
        if (kanjiFirstName.length() > MAX_KANJI_NAME_LENGTH) {
            return false;
        }

        return true;
    }

    /**
     * 性別が空（<code>null</code>または、空文字列）かどうかを確認します。
     *
     * @param sex 性別
     * @return 空（<code>null</code>または、空文字列）であれば<code>true</code>、そうでない場合は<code>false</code>。
     */
    public static boolean isEmptySex(String sex) {
        return isEmpty(sex);
    }

    /**
     * 性別が妥当な値（{@value Sex#valueOf(String)}でインスタンス化できる}）かどうかを確認します。
     *
     * @param sex 性別
     * @return 妥当な値（{@value Sex#valueOf(String)}の場合は<code>true</code>、そうでない場合は<code>false</code>。
     */
    public static boolean isValidSex(String sex) {
        try {
            Sex.valueOf(sex);
        } catch (IllegalArgumentException e) {
            return false;
        }

        return true;
    }

    /**
     * 入社年月日が空（<code>null</code>または、空文字列）かどうかを確認します。
     *
     * @param enterDate 入社年月日
     * @return 空（<code>null</code>または、空文字列）であれば<code>true</code>、そうでない場合は<code>false</code>。
     */
    public static boolean isEmptyEnterDate(String enterDate) {
        return isEmpty(enterDate);
    }

    /**
     * 入社年月日が妥当な値（yyyyMMdd形式、かつ日付として存在する）かどうかを確認します。
     *
     * @param enterDate 入社年月日
     * @return 妥当な値（yyyyMMdd形式、かつ日付として存在する）の場合は<code>true</code>、そうでない場合は<code>false</code>。
     */
    public static boolean isValidFormatEnterDate(String enterDate) {

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        dateFormat.setLenient(false);

        try {
            dateFormat.parse(enterDate);
        } catch (ParseException e) {
            return false;
        }

        return true;
    }

    /**
     * 部門が空（<code>null</code>または、空文字列）かどうかを確認します。
     *
     * @param branch 部門
     * @return 空（<code>null</code>または、空文字列）であれば<code>true</code>、そうでない場合は<code>false</code>。
     */
    public static boolean isEmptyBranch(String branch) {
        return isEmpty(branch);
    }

    /**
     * 部門が妥当な値（{@value Branch#valueOf(String)}でインスタンス化できる}）かどうかを確認します。
     *
     * @param branch 部門
     * @return 妥当な値（{@value Branch#valueOf(String)}の場合は<code>true</code>、
     *         そうでない場合は<code>false</code>。
     */
    public static boolean isValidBranch(String branch) {
        try {
            Branch.valueOf(branch);
        } catch (IllegalArgumentException e) {
            return false;
        }

        return true;
    }

    /**
     * メールアドレスが空（<code>null</code>または、空文字列）かどうかを確認します。
     *
     * @param email メールアドレス
     * @return 空（<code>null</code>または、空文字列）であれば<code>true</code>、そうでない場合は<code>false</code>。
     */
    public static boolean isEmptyEmail(String email) {
        return isEmpty(email);
    }

    /**
     * メールアドレスが妥当な値（"^.+@.+"にマッチする）かどうかを確認します。
     *
     * @param email メールアドレス
     * @return 妥当な値（"^.+@.+"にマッチする）の場合は<code>true</code>、そうでない場合は<code>false</code>。
     */
    public static boolean isValidFormatEmail(String email) {

        // メールアドレスは簡易的にマッチさせる
        if (email.matches("^.+@.+")) {
            return true;
        }

        return false;
    }

    /**
     * 指定文字列が空（<code>null</code>または、空文字列）かどうかを確認します。
     *
     * @param target 指定文字列
     * @return 空（<code>null</code>または、空文字列）であれば<code>true</code>、そうでない場合は<code>false</code>。
     */
    private static boolean isEmpty(String target) {
        if (target == null || target.equals("")) {
            return true;
        }

        return false;
    }
}
