package nbct.com.cn.customerquery.config;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import nbct.com.cn.customerquery.mapper.as400dl.As400dlCirculationTaskMapper;
import nbct.com.cn.customerquery.mapper.qry.QryCirculationTaskMapper;
import nbct.com.cn.customerquery.mapper.web.WebCirculationTaskMapper;
import nbct.com.cn.customerquery.service.RedisService;

/**
 * 定时任务
 */
@Component
@EnableScheduling
public class Schedule {
	
	private static final Logger logger = LoggerFactory.getLogger(RedisService.class);

	@Autowired
	private As400dlCirculationTaskMapper asMapper;

	@Autowired
	private QryCirculationTaskMapper qryMapper;

	@Autowired
	private WebCirculationTaskMapper webMapper;

	/**
	 * 定时访问
	 */
	@Scheduled(cron = "0 */15 * * * ?")
	public void idleCall() {
		asMapper.idleCall();
		qryMapper.idleCall();
		webMapper.idleCall();
		logger.info("Idle DB Call:" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
	}
}
