package org.sample.ems.helper;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * サーブレット操作のヘルパークラスです。<br>
 * サーブレット操作を行う、様々なヘルパーメソッドを提供します。
 *
 * @author Tomoya Yoshida
 * @version $Revision$
 */
public final class ServletHelper {

    /**
     * コンストラクタ。
     */
    private ServletHelper() {
    }

    /**
     * サーブレットからの要求をサーバ上の別のリソース (サーブレット、JSP ファイル、または HTML ファイル) に転送します。
     *
     * @param request HTTPリクエスト
     * @param response HTTPレスポンス
     * @param path フォワード先のリソース
     * @throws ServletException 最終的なフォワード先となるリソースがこの例外をスローした場合
     * @throws IOException 最終的なフォワード先となるリソースがこの例外をスローした場合
     * @see RequestDispatcher#forward(javax.servlet.ServletRequest, javax.servlet.ServletResponse)
     */
    public static void forward(HttpServletRequest request, HttpServletResponse response,
            String path) throws ServletException, IOException {

        RequestDispatcher dispatcher = request.getRequestDispatcher(path);
        dispatcher.forward(request, response);
    }

    /**
     * リクエストパラメータをURLデコードします。<br>
     * リクエストパラメータの値をURLデコード（UTF-8固定）したものをマップインターフェースで返却します。
     *
     * @param request HTTPリクエスト
     * @return URLデコードされたリクエストパラメータ（キーがパラメータ名、バリューがURLデコードされたパラメータの値）（パラメータが無い場合は空のマップ）
     */
    public static Map<String, String> getDecodedParameters(HttpServletRequest request) {

        Map<String, String> result = new HashMap<String, String>();

        try {
            for (Enumeration<String> names = request.getParameterNames();
                    names.hasMoreElements();) {
                String name = names.nextElement();
                String parameter = request.getParameter(name);

                if (parameter == null) {
                    result.put(name, null);
                } else {
                    result.put(name, URLDecoder.decode(parameter, "UTF-8"));
                }
            }
        } catch (UnsupportedEncodingException e) {
            // ignore
        }

        return result;
    }
}
