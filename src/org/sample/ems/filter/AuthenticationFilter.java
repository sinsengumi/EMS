package org.sample.ems.filter;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.sample.ems.entity.Employee;


/**
 * リクエストの認証を行うフィルタークラスです。<br>
 * 指定されたURLパターンのリクエストに対して、認証を行います。<br>
 * 認証を除外するサーブレットは初期化パラメータ（<strong>ignoreServletPaths</strong>）で、カンマ区切りで指定します。<br>
 * 認証の結果が正常であれば、次のサーブレット（またはフィルター）にリクエストをチェーンします。<br>
 * 認証の結果が異常であれば、ログアウト処理を行うサーブレットにリクエストをフォーワードします。
 *
 * @author Tomoya Yoshida
 * @version $Revision$
 */
public class AuthenticationFilter implements Filter {

    /** 除外サーブレットパスの一覧 */
    private List<String> ignoreServletPaths = null;

    @Override
    public void init(FilterConfig fConfig) throws ServletException {
        ignoreServletPaths = Arrays
                .asList(fConfig.getInitParameter("ignoreServletPath").split(","));
    }

    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        String servletPath = httpServletRequest.getServletPath();

        if (!ignoreServletPaths.contains(servletPath)) {

            HttpSession session = httpServletRequest.getSession();
            Employee employee = (Employee) session.getAttribute("loginEmployee");

            if (employee == null) {
                RequestDispatcher dispatcher = request.getRequestDispatcher("/logout.action");
                dispatcher.forward(request, response);
                return;
            }
        }

        chain.doFilter(request, response);
    }
}
