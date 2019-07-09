package nbct.com.cn.customerquery.config;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
* @author PJ 
* @version 创建时间：2019年7月7日 上午11:38:56
*/
@Configuration
@ConfigurationProperties("secrity")
public class ServerSecrity {

	private String key;
	
	private long expireInterval;
	
	private long expireRefresh;

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public long getExpireInterval() {
		return expireInterval;
	}

	public void setExpireInterval(long expireInterval) {
		this.expireInterval = expireInterval;
	}

	public long getExpireRefresh() {
		return expireRefresh;
	}

	public void setExpireRefresh(long expireRefresh) {
		this.expireRefresh = expireRefresh;
	}

}
