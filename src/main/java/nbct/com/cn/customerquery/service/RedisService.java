package nbct.com.cn.customerquery.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.BoundZSetOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;

import nbct.com.cn.customerquery.entity.CallStatisticsItem;

/**
 * @author PJ
 * @version 创建时间：2019年9月9日 下午3:16:45
 */
@Component
public class RedisService {

	@Autowired
	private StringRedisTemplate redis;

	/**
	 * 记录接口调用历史
	 * 
	 * @param userId
	 * @param functionId
	 */
	public void saveFunctionCallLog(String userId, String functionId) {
		String key = String.format("CALLSATISTICS:%s:%s", new Object[] { userId, functionId });
		String curDt = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMMdd"));
		int dt = Integer.parseInt(curDt);
		BoundZSetOperations<String, String> ops = redis.boundZSetOps(key);
		//
		Set<String> items = ops.rangeByScore(dt, dt);
		if (items.size() <= 0) {
			String item = JSON.toJSONString(new CallStatisticsItem(curDt, 1));
			ops.add(item, dt);
		} else {
			items.forEach(item -> {
				CallStatisticsItem csi = JSON.parseObject(item,CallStatisticsItem.class);
				csi.setCount(csi.getCount()+1);
				ops.remove(item);
				ops.add(JSON.toJSONString(csi),dt);
			});
		}
	}

}
