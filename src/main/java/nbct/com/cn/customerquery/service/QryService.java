package nbct.com.cn.customerquery.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nbct.com.cn.customerquery.entity.Container;
import nbct.com.cn.customerquery.mapper.qry.YardContainerMapper;

/**
* @author PJ 
* @version 创建时间：2019年7月9日 上午9:08:22
*/
@Service
public class QryService {
	
	@Autowired
	YardContainerMapper yardContainerMapper;
	
	public List<Container> getYardContainers(){
		return yardContainerMapper.getYardContainers();
	};

}
