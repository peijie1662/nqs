package nbct.com.cn.customerquery.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 需要检查
 * 
 * @author PJ
 * @version 创建时间：2019年7月6日 下午4:53:24
 */

@Target({ ElementType.METHOD, ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface TokenCheck {
	
}
