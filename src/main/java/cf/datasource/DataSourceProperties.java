package cf.datasource;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = DataSourceProperties.PREFIX)
public class DataSourceProperties {
	public static final String PREFIX = "app.datasource";
	
	private String driver;
	private String url;
	private String username;
	private String password;
	//初始化连接大小
	private int initialSize;
	//连接池最大数量
	private int maxActive;
	//连接池最大空闲
	private int maxIdle;
	//连接池最小空闲
	private int minIdle;
	//获取连接最大等待时间
	private int maxWait;
	
	public String getDriver() {
		return driver;
	}
	public void setDriver(String driver) {
		this.driver = driver;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getInitialSize() {
		return initialSize;
	}
	public void setInitialSize(int initialSize) {
		this.initialSize = initialSize;
	}
	public int getMaxActive() {
		return maxActive;
	}
	public void setMaxActive(int maxActive) {
		this.maxActive = maxActive;
	}
	public int getMaxIdle() {
		return maxIdle;
	}
	public void setMaxIdle(int maxIdle) {
		this.maxIdle = maxIdle;
	}
	public int getMinIdle() {
		return minIdle;
	}
	public void setMinIdle(int minIdle) {
		this.minIdle = minIdle;
	}
	public int getMaxWait() {
		return maxWait;
	}
	public void setMaxWait(int maxWait) {
		this.maxWait = maxWait;
	}
	@Override
	public String toString() {
		return "DataSourceProperties [driver=" + driver + ", url=" + url + ", username=" + username + ", password="
				+ password + ", initialSize=" + initialSize + ", maxActive=" + maxActive + ", maxIdle=" + maxIdle
				+ ", minIdle=" + minIdle + ", maxWait=" + maxWait + "]";
	}
	
	
	
	
	
}
