package org.sample.ems.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * リクエスト・レスポンスの文字エンコーディングを行うフィルタークラスです。<br>
 * 指定されたURLパターンのリクエストに対して、文字エンコーディングを行います。<br>
 * 文字コードは初期化パラメータ（<strong>encoding</strong>）で指定します。
 *
 * @author Tomoya Yoshida
 * @version $Revision$
 */
public class EncodingFilter implements Filter {

    /** 文字コード */
    private String encoding = null;

    @Override
    public void init(FilterConfig fConfig) throws ServletException {
        encoding = fConfig.getInitParameter("encoding");
    }

    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        request.setCharacterEncoding(encoding);
        response.setCharacterEncoding(encoding);
        chain.doFilter(request, response);
    }
}
