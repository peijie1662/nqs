package nbct.com.cn.customerquery.interceptor;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import nbct.com.cn.customerquery.entity.CallResult;

/**
* @author PJ 
* @version 创建时间：2019年7月7日 下午8:37:32
*/
@ControllerAdvice
public class GloablExceptionHandler {
    @ResponseBody
    @ExceptionHandler(Exception.class)
    public Object handleException(Exception e) {
        CallResult r = new CallResult();
    	String msg = e.getMessage();
        if (msg == null || msg.equals("")) {
            msg = "服务器出错";
        }
        r.setFlag(false);
        r.setOutMsg(msg);
        return r;
    }
}
