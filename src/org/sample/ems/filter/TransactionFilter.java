package org.sample.ems.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.sample.ems.dao.AppConfig;
import org.seasar.doma.jdbc.tx.LocalTransaction;

/**
 * データベースのトランザクション処理を行うフィルタークラスです。
 *
 * @author Tomoya Yoshida
 * @version $Revision$
 */
public class TransactionFilter implements Filter {

    @Override
    public void init(FilterConfig fConfig) throws ServletException {
    }

    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        LocalTransaction tx = AppConfig.getLocalTransaction();

        try {
            tx.begin();
            chain.doFilter(request, response);
            tx.commit();
        } finally {
            tx.rollback();
        }
    }
}
