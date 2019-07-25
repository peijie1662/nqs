package nbct.com.cn.customerquery.entity;

/**
 * 调用结果
 */
public class CallResult {

	/**
	 * 成功标记
	 */
	private boolean flag;
	
	/**
	 * 返回数据
	 */
	private Object data;
	
	/**
	 * 错误信息
	 */
	private String errMsg;
	
	/**
	 * 返回信息
	 */
	private String outMsg;

	public boolean getFlag() {
		return flag;
	}

	public void setFlag(boolean b) {
		this.flag = b;
	}

	public String getErrMsg() {
		return errMsg;
	}

	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public String getOutMsg() {
		return outMsg;
	}

	public void setOutMsg(String outMsg) {
		this.outMsg = outMsg;
	}

	@Override
	public String toString() {
		return "CallResult [flag=" + flag + ", data=" + data + ", errMsg=" + errMsg + ", outMsg=" + outMsg + "]";
	}
	
}
