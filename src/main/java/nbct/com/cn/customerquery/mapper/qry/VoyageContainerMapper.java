package nbct.com.cn.customerquery.mapper.qry;

import nbct.com.cn.customerquery.entity.Voyage;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author LSH
 * @version 创建时间：2019年9月16日 14:48
 * 船舶集装箱列表接口
 */
public interface VoyageContainerMapper {
    /**
     * 船舶列表
     */
    List<Voyage> getVoyageList(@Param("vsvy") String vsvy, @Param("vsdr") String vsdr, @Param("lncd") String lncd);
}
