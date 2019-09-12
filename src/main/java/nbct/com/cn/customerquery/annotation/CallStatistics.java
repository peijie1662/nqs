package nbct.com.cn.customerquery.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 调用次数统计<br>
 * 
 * 此注解需要使用用户信息，而用戶信息存在于JWT令牌中，为避免多次解析令牌带来的性能开销，<br>
 * 复用TokenCheck注解解析的用户信息，所以必须与TokenCheck注解同时使用才有效。
 * 
 * @author PJ
 * @version 创建时间：2019年9月10日 上午9:19:06
 */
@Target({ ElementType.METHOD, ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface CallStatistics {
	NBCTWebFunction value() default NBCTWebFunction.NODEFINED;
}
