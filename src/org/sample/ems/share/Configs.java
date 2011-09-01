package org.sample.ems.share;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * 設定値を表すクラス（シングルトン）です。
 *
 * @author Tomoya Yoshida
 * @version $Revision$
 */
public final class Configs {

    /** 設定値 */
    private static Map<String, String> configs = new HashMap<String, String>();

    /** シングルトンインスタンス */
    private static Configs instance = new Configs();

    /**
     * コンストラクタ。<br>
     * 設定ファイルを読み込む。
     */
    private Configs() {
        InputStream is = null;
        try {
            Properties properties = new Properties();
            is = Configs.class.getResourceAsStream("/application.properties");
            properties.load(is);

            Set<String> propertyNames = properties.stringPropertyNames();
            for (String propertyName : propertyNames) {
                configs.put(propertyName, properties.getProperty(propertyName));
            }

        } catch (Throwable e) {
            throw new EMSException("設定ファイルの読み込みに失敗しました。", e);
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    // ignore
                }
            }
        }
    }

    /**
     * シングルトンインスタンスを取得する。
     *
     * @return シングルトンインスタンス
     */
    public static Configs getInstance() {
        return instance;
    }

    /**
     * 設定値を取得する。
     *
     * @param key キー
     * @return 設定値
     */
    public String get(String key) {
        return configs.get(key);
    }
}
