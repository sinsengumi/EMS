package org.sample.ems.dao;

import javax.sql.DataSource;

import org.sample.ems.share.Configs;
import org.seasar.doma.jdbc.DomaAbstractConfig;
import org.seasar.doma.jdbc.SimpleDataSource;
import org.seasar.doma.jdbc.dialect.Dialect;
import org.seasar.doma.jdbc.dialect.PostgresDialect;
import org.seasar.doma.jdbc.tx.LocalTransaction;
import org.seasar.doma.jdbc.tx.LocalTransactionalDataSource;

/**
 * Doma設定の実装クラスです。
 *
 * @author Tomoya Yoshida
 * @version $Revision$
 */
public class AppConfig extends DomaAbstractConfig {

    /** データソース */
    protected static final LocalTransactionalDataSource dataSource = createDataSource();

    /** ダイアレクト（データベースの方言） */
    protected static final Dialect dialect = new PostgresDialect();

    @Override
    public DataSource getDataSource() {
        return dataSource;
    }

    @Override
    public Dialect getDialect() {
        return dialect;
    }

    /**
     * データソースを生成します。
     *
     * @return データソース
     */
    protected static LocalTransactionalDataSource createDataSource() {

        Configs configs = Configs.getInstance();

        SimpleDataSource dataSource = new SimpleDataSource();
        dataSource.setUrl(configs.get("db.url"));
        dataSource.setUser(configs.get("db.user"));
        dataSource.setPassword(configs.get("db.password"));

        return new LocalTransactionalDataSource(dataSource);
    }

    /**
     * ローカルトランザクションを取得します。
     *
     * @return ローカルトランザクション
     */
    public static LocalTransaction getLocalTransaction() {
        return dataSource.getLocalTransaction(defaultJdbcLogger);
    }

}
