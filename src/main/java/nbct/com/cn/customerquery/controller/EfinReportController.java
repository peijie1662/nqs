package nbct.com.cn.customerquery.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import nbct.com.cn.customerquery.annotation.TokenCheck;
import nbct.com.cn.customerquery.entity.CallResult;
import nbct.com.cn.customerquery.entity.EfinReport;
import nbct.com.cn.customerquery.entity.EfinReportFile;
import nbct.com.cn.customerquery.service.EfinReportService;

/**
 * @author sdw
 * @version 创建时间：20190924 09:31 <br>
 *          调用路径：http://localhost:8864/swagger-ui.html
 */
@Api(value = "EfinReport查询")
@RestController
public class EfinReportController {

	@Autowired
	EfinReportService efinReportService;

	/**
	 * 获得EfinReport报表列表
	 *
	 * @param p
	 * @return
	 */

	@ApiOperation(value = "获得EfinReport报表列表", notes = "获得EfinReport报表列表")
	@TokenCheck
	@RequestMapping(value = "/getefinreports", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public CallResult getEfinReports(@RequestBody JSONObject p) {
		CallResult r = new CallResult();
		String fnPyCocd = p.getString("fnPyCocd");
		String dtbg = p.getString("dtbg");

		List<EfinReport> efinReports = efinReportService.getEfinReport(fnPyCocd, dtbg);

		if (efinReports.size() != 0) {
			r.setData(efinReports);
		}
		r.setFlag(true);

		return r;
	}

	/**
	 * 下载Efin报表文件
	 * 
	 * @param p
	 * @param response
	 */
	@ApiOperation(value = "下载Efin报表文件", notes = "下载Efin报表文件")
	@TokenCheck
	@RequestMapping(value = "/downloadefinreport", method = RequestMethod.POST)
	public void downloadEfinReport(@RequestBody JSONObject p, HttpServletResponse response) {
		ServletOutputStream out = null;
		try {
			String fnPyCocd = p.getString("fnPyCocd");
			String skey = p.getString("skey");
			EfinReportFile efinReportFile = efinReportService.getEfinReportFile(fnPyCocd, skey);
			response.reset();
			if (efinReportFile != null) {
				byte[] bytes = efinReportFile.getFileName().trim().getBytes("UTF-8"); // fileName.getBytes("UTF-")处理safari的乱码问题
				String fileName = new String(bytes, "iso-8859-1");
				// 设置输出的格式
				response.setContentType("multipart/form-data");
				response.setHeader("Content-Disposition", "attachment;fileName=" + fileName);

				// 获取blob字段
				byte[] contents = efinReportFile.getFileData();
				out = response.getOutputStream();
				// 写到输出流
				out.write(contents);
				out.flush();
			} else {
				response.setStatus(404);

			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
