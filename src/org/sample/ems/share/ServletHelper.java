package org.sample.ems.share;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

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
    public static void forward(ServletRequest request, ServletResponse response,
            String path) throws ServletException, IOException {

        RequestDispatcher dispatcher = request.getRequestDispatcher(path);
        dispatcher.forward(request, response);
    }
}
