package com.qjs.boot.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.alibaba.druid.pool.DruidDataSourceFactory;

@Configuration
@EnableTransactionManagement
public class DatasourceConfig {

	@Autowired
	private Environment env;

	/**
	 * MySQL数据源 // @Primary
	 * 
	 * @return
	 * @throws Exception
	 */
	@Bean(name = "dataSourceMySql")
	public DataSource dataSourceMySql() throws Exception {
		Properties dataSourceProps = new Properties();
		dataSourceProps.put("driverClassName", env.getProperty("mysql.driverClassName"));
		dataSourceProps.put("url", env.getProperty("mysql.db.url"));
		dataSourceProps.put("username", env.getProperty("mysql.db.username"));
		dataSourceProps.put("password", env.getProperty("mysql.db.password"));
		dataSourceProps.put("initialSize", env.getProperty("initialSize"));
		dataSourceProps.put("maxActive", env.getProperty("maxActive"));
		dataSourceProps.put("minIdle", env.getProperty("minIdle"));
		dataSourceProps.put("maxWait", env.getProperty("maxWait"));
		dataSourceProps.put("removeAbandoned", env.getProperty("removeAbandoned"));
		dataSourceProps.put("removeAbandonedTimeout", env.getProperty("removeAbandonedTimeout"));
		dataSourceProps.put("timeBetweenEvictionRunsMillis", env.getProperty("timeBetweenEvictionRunsMillis"));
		dataSourceProps.put("minEvictableIdleTimeMillis", env.getProperty("minEvictableIdleTimeMillis"));
		dataSourceProps.put("validationQuery", env.getProperty("validationQuery"));
		dataSourceProps.put("testWhileIdle", env.getProperty("testWhileIdle"));
		dataSourceProps.put("testOnBorrow", env.getProperty("testOnBorrow"));
		dataSourceProps.put("testOnReturn", env.getProperty("testOnReturn"));
		dataSourceProps.put("poolPreparedStatements", env.getProperty("poolPreparedStatements"));
		dataSourceProps.put("maxPoolPreparedStatementPerConnectionSize",
				env.getProperty("maxPoolPreparedStatementPerConnectionSize"));
		dataSourceProps.put("filters", env.getProperty("filters"));
		dataSourceProps.put("connectionProperties", env.getProperty("connectionProperties"));
		DataSource dataSource = DruidDataSourceFactory.createDataSource(dataSourceProps);
		return dataSource;
	}

	/**
	 * MySQL 事务管理
	 * 
	 * @return
	 * @throws Exception
	 */
	@Bean
	public DataSourceTransactionManager transactionManager() throws Exception {
		return new DataSourceTransactionManager(dataSourceMySql());
	}

	@Bean(name = "sqlSessionFactoryMySql")
	public SqlSessionFactory sqlSessionFactoryBean() throws Exception {
		SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
		bean.setDataSource(dataSourceMySql());
		bean.setTypeAliasesPackage("com.qjs.boot.model");

		// 分页插件
		// PageHelper pageHelper = new PageHelper();
		// Properties properties = new Properties();
		// properties.setProperty("reasonable", "true");
		// properties.setProperty("supportMethodsArguments", "true");
		// properties.setProperty("returnPageInfo", "check");
		// properties.setProperty("params", "count=countSql");
		// properties.setProperty("dialect", "mysql");
		// pageHelper.setProperties(properties);
		//
		// // 添加插件
		// bean.setPlugins(new Interceptor[] { pageHelper });
		// 添加XML目录
		ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
		try {
			bean.setMapperLocations(resolver.getResources("classpath:mapper/*.xml"));
			return bean.getObject();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	/**
	 * oracle数据源
	 * 
	 * @return
	 * @throws Exception
	 * 
	 * @Bean(name = "dataSourceOracle") public DataSource dataSourceOracle()
	 *            throws Exception { Properties dataSourceProps = new
	 *            Properties(); dataSourceProps.put("driverClassName",
	 *            env.getProperty("driverClassName"));
	 *            dataSourceProps.put("url", env.getProperty("db.url"));
	 *            dataSourceProps.put("username",
	 *            env.getProperty("db.username"));
	 *            dataSourceProps.put("password",
	 *            env.getProperty("db.password"));
	 *            dataSourceProps.put("initialSize",
	 *            env.getProperty("initialSize"));
	 *            dataSourceProps.put("maxActive",
	 *            env.getProperty("maxActive")); dataSourceProps.put("minIdle",
	 *            env.getProperty("minIdle")); dataSourceProps.put("maxWait",
	 *            env.getProperty("maxWait"));
	 *            dataSourceProps.put("removeAbandoned",
	 *            env.getProperty("removeAbandoned"));
	 *            dataSourceProps.put("removeAbandonedTimeout",
	 *            env.getProperty("removeAbandonedTimeout"));
	 *            dataSourceProps.put("timeBetweenEvictionRunsMillis",
	 *            env.getProperty("timeBetweenEvictionRunsMillis"));
	 *            dataSourceProps.put("minEvictableIdleTimeMillis",
	 *            env.getProperty("minEvictableIdleTimeMillis"));
	 *            dataSourceProps.put("validationQuery",
	 *            env.getProperty("validationQuery"));
	 *            dataSourceProps.put("testWhileIdle",
	 *            env.getProperty("testWhileIdle"));
	 *            dataSourceProps.put("testOnBorrow",
	 *            env.getProperty("testOnBorrow"));
	 *            dataSourceProps.put("testOnReturn",
	 *            env.getProperty("testOnReturn"));
	 *            dataSourceProps.put("poolPreparedStatements",
	 *            env.getProperty("poolPreparedStatements"));
	 *            dataSourceProps.put("maxPoolPreparedStatementPerConnectionSize",
	 *            env.getProperty("maxPoolPreparedStatementPerConnectionSize"));
	 *            dataSourceProps.put("filters", env.getProperty("filters"));
	 *            dataSourceProps.put("connectionProperties",
	 *            env.getProperty("connectionProperties")); DataSource
	 *            dataSource =
	 *            DruidDataSourceFactory.createDataSource(dataSourceProps);
	 *            return dataSource; }
	 * 
	 * @Bean public DataSourceTransactionManager transactionManagerOracle()
	 *       throws Exception { return new
	 *       DataSourceTransactionManager(dataSourceOracle()); }
	 * 
	 * @Bean(name = "sqlSessionFactoryOracle") public SqlSessionFactory
	 *            sqlSessionFactoryBeanOracle() throws Exception {
	 *            SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
	 *            bean.setDataSource(dataSourceOracle());
	 *            bean.setTypeAliasesPackage("com.yonyou.marketing.activity.model");
	 * 
	 *            ResourcePatternResolver resolver = new
	 *            PathMatchingResourcePatternResolver(); try {
	 *            bean.setMapperLocations(resolver.getResources("classpath:mapper/oracle/*.xml"));
	 *            return bean.getObject(); } catch (Exception e) {
	 *            e.printStackTrace(); throw new RuntimeException(e); } }
	 */
}
