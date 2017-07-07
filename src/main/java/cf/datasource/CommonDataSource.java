package cf.datasource;



import javax.annotation.PreDestroy;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import oracle.net.aso.i;

@Configuration
@EnableConfigurationProperties(DataSourceProperties.class)
@ImportResource({"classpath:MapperScannerConfigurer.xml"})
public class CommonDataSource {
	@Autowired
	private DataSourceProperties dataSourceProperties;
	
	public final static String BasePackage = "cf.dao";
	
	public DataSource pool;
	
	@Bean(destroyMethod = "close")
	public DataSource dataSource(){
		if (pool != null) {
			System.out.println("pool不为null，直接返回pool");
			return pool;
		}
		
		DataSourceProperties dataSourceProperties = this.dataSourceProperties;
		pool = new DataSource();
		pool.setDriverClassName(dataSourceProperties.getDriver());
		pool.setUrl(dataSourceProperties.getUrl());
		pool.setUsername(dataSourceProperties.getUsername());
		pool.setPassword(dataSourceProperties.getPassword());
		pool.setInitialSize(dataSourceProperties.getInitialSize());
		pool.setMaxActive(dataSourceProperties.getMaxActive());
		pool.setMaxIdle(dataSourceProperties.getMaxIdle());
		pool.setMinIdle(dataSourceProperties.getMinIdle());
		pool.setMaxWait(pool.getMaxWait());
		return pool;
	}
	
	@PreDestroy
	public void close(){
		if (pool != null) {
			System.out.println("关闭pool");
			pool.close();
		}
	}
	
	@Bean
	public SqlSessionFactoryBean sqlSessionFactoryBean(){
		SqlSessionFactoryBean sessionFactoryBean = new SqlSessionFactoryBean();
		sessionFactoryBean.setDataSource(dataSource());
		return sessionFactoryBean;
	}
	
	@Bean
	public PlatformTransactionManager platformTransactionManager(){
		return new DataSourceTransactionManager(dataSource());
	}
}
