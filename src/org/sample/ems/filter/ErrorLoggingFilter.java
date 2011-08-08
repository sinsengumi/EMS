package org.sample.ems.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.sample.ems.exception.EMSException;

/**
 * エラーログ出力を行うフィルタークラスです。<br>
 * 指定されたURLパターンのリクエスト処理中に、例外がスローされた場合に、その例外を捕捉し、エラーログを出力し、再スローします。<br>
 *
 * @author Tomoya Yoshida
 * @version $Revision$
 */
public class ErrorLoggingFilter implements Filter {

    @Override
    public void init(FilterConfig fConfig) throws ServletException {
    }

    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        try {
            chain.doFilter(request, response);
        } catch (EMSException e) {
            System.out.println(e.getMessage());
            throw e;
        } catch (IOException e) {
            System.out.println(e.getMessage());
            throw e;
        } catch (ServletException e) {
            System.out.println(e.getMessage());
            throw e;
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }
}
