package nbct.com.cn.customerquery.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 调用次数统计<br>
 * 
 * @author PJ
 * @version 创建时间：2019年9月10日 上午9:19:06
 */
@Target({ ElementType.METHOD, ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface CallStatistics {
	NBCTWebFunction value() default NBCTWebFunction.NODEFINED;
}
