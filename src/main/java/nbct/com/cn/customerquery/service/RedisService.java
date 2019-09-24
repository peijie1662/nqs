package nbct.com.cn.customerquery.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.BoundZSetOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ZSetOperations.TypedTuple;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import nbct.com.cn.customerquery.entity.satistics.CallSatistics;

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
		Set<String> items = ops.rangeByScore(dt, dt);
		if (items.size() <= 0) {
			JSONObject statisticsItem = new JSONObject();
			statisticsItem.put("callDt", curDt);
			statisticsItem.put("count", 1);
			String item = statisticsItem.toJSONString();
			ops.add(item, dt);
		} else {
			items.forEach(item -> {
				JSONObject csi = JSON.parseObject(item, JSONObject.class);
				csi.put("count", csi.getInteger("count") + 1);
				ops.remove(item);
				ops.add(JSON.toJSONString(csi), dt);
			});
		}
	}

	/**
	 * 查询时间范围内调用日志
	 * 
	 * @param bg
	 * @param ed
	 */
	public List<CallSatistics> periodFunctionCallLog(int bg, int ed) {
		List<CallSatistics> r = new ArrayList<CallSatistics>();
		String pattern = "CALLSATISTICS*";
		Set<String> keys = redis.keys(pattern);
		keys.forEach(key -> {
			BoundZSetOperations<String, String> ops = redis.boundZSetOps(key);
			Set<TypedTuple<String>> items = ops.rangeByScoreWithScores(bg, ed);
			List<CallSatistics> css = items.stream().map(s -> {
				CallSatistics cs = new CallSatistics();
				String[] k = key.split(":");
				cs.setUserId(k[1]);
				cs.setFun(k[2]);
				cs.setCallDt(s.getScore().intValue());
				JSONObject j = JSON.parseObject(s.getValue(), JSONObject.class);
				cs.setCallNum(j.getInteger("count"));
				return cs;
			}).collect(Collectors.toList());
			r.addAll(css);
		});
		return r;
	}

	/**
	 * 按用户统计访问量
	 * 
	 * @param bg
	 * @param ed
	 * @return
	 */
	public Map<String, Integer> groupByUser(int bg, int ed) {
		List<CallSatistics> css = periodFunctionCallLog(bg, ed);
		Map<String, Integer> m = css.stream().collect(
				Collectors.groupingBy(CallSatistics::getUserId, Collectors.summingInt(CallSatistics::getCallNum)));
		return m;
	}

	/**
	 * 按功能统计访问量
	 * 
	 * @param bg
	 * @param ed
	 * @return
	 */
	public Map<String, Integer> groupByFunction(int bg, int ed) {
		List<CallSatistics> css = periodFunctionCallLog(bg, ed);
		Map<String, Integer> m = css.stream().collect(
				Collectors.groupingBy(CallSatistics::getFun, Collectors.summingInt(CallSatistics::getCallNum)));
		return m;
	}

	/**
	 * 按日期统计访问量
	 * 
	 * @param bg
	 * @param ed
	 * @return
	 */
	public Map<Integer, Integer> groupByCallDt(int bg, int ed) {
		List<CallSatistics> css = periodFunctionCallLog(bg, ed);
		Map<Integer, Integer> m = css.stream().collect(
				Collectors.groupingBy(CallSatistics::getCallDt, Collectors.summingInt(CallSatistics::getCallNum)));
		return m;
	}

}
