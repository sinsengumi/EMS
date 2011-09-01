package org.sample.ems.share;

import java.util.Map;
import java.util.Map.Entry;

/**
 * JSPのEL式内で使用するユーザ定義関数を提供するクラスです。
 *
 * @author Tomoya Yoshida
 * @version $Revision$
 */
public final class EMSFunctions {

    /**
     * コンストラクタ。
     */
    private EMSFunctions() {
    }

    /**
     * HTMLのラジオボタンを生成します。
     *
     * @param name name属性
     * @param inputs inputタグになるMap（キーがvalue属性、バリューがラベルになる）
     * @param checked 現在チェックされている要素
     * @param separator inputタグを区切る文字列
     * @return 生成されたラジオボタンのHTML
     */
    public static String htmlRadios(String name, Map<String, String> inputs, String checked,
            String separator) {

        String format =
            "<label><input type=\"radio\" name=\"%s\" value=\"%s\" />%s</label>"
            + separator;
        String checkedFormat =
            "<label><input type=\"radio\" name=\"%s\" value=\"%s\" checked=\"checked\" />%s</label>"
            + separator;

        StringBuilder builder = new StringBuilder();

        for (Entry<String, String> input : inputs.entrySet()) {
            if (input.getKey().equals(checked)) {
                builder.append(
                        String.format(checkedFormat, name, input.getKey(), input.getValue()));
            } else {
                builder.append(
                        String.format(format, name, input.getKey(), input.getValue()));
            }
        }

        return builder.toString();
    }

    /**
     * HTMLのセレクトボックスを生成します。
     *
     * @param name name属性
     * @param options optionタグになるMap（キーがvalue属性、バリューがラベルになる）
     * @param selected 現在選択されている要素
     * @return 生成されたセレクトボックスのHTML
     */
    public static String htmlOptions(String name, Map<String, String> options, String selected) {

        StringBuilder builder = new StringBuilder();

        builder.append("<select name=\"").append(name).append("\">")
                        .append(System.getProperty("line.separator"));

        for (Entry<String, String> option : options.entrySet()) {
            builder.append("<option value=\"").append(option.getKey()).append("\"");

            if (option.getKey().equals(selected)) {
                builder.append(" selected=\"selected\"");
            }

            builder.append(">").append(option.getValue()).append("</option>")
                .append(System.getProperty("line.separator"));
        }

        builder.append("</select>").append(System.getProperty("line.separator"));

        return builder.toString();
    }
}
