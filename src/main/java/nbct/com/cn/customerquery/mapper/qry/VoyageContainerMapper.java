package nbct.com.cn.customerquery.mapper.qry;

import nbct.com.cn.customerquery.entity.*;
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


    //船舶经营人代码
    String getCrcd(@Param("vscd") String vscd);

    //船公司的母公司代码
    String getParentLncd(@Param("lncd") String lncd);

    /**
     * 船公司进口箱清单
     */
    List<ImContainer> getImContainerList(@Param("vscd") String vscd,@Param("vsvy") String vsvy, @Param("vsdr") String vsdr, @Param("lncd") String lncd,@Param("ordertype") String ordertype);

    /**
     * 船公司/货代出口箱清单-未装船
     */
    List<ExContainer> getExContainerListInYard(@Param("vscd") String vscd,@Param("vsvy") String vsvy, @Param("vsdr") String vsdr, @Param("usertype") String usertype,@Param("lncd") String lncd,@Param("caag") String caag,@Param("ordertype") String ordertype);
    /**
     * 船公司/货代出口箱清单-已装船
     */
    List<ExContainer> getExContainerListInShip(@Param("vscd") String vscd,@Param("vsvy") String vsvy, @Param("vsdr") String vsdr, @Param("usertype") String usertype,@Param("lncd") String lncd,@Param("caag") String caag,@Param("ordertype") String ordertype);

    /**
     * 货代在场出口箱
     */
    List<Container> getExYardContainerListByCaag(@Param("caag") String caag, @Param("ordertype") String ordertype);

    /**
     * 在场单箱信息
     */
    Container getYardContainerInfo(@Param("ctpf") String ctpf,@Param("ctnr") String ctnr,@Param("ctck") String ctck);

    /**
     * 单箱历史列表
     */
    List<ContainerHis> getContainerHisList(@Param("ctpf") String ctpf,@Param("ctnr") String ctnr,@Param("ctck") String ctck,@Param("accd") String accd,@Param("jbnr") String jbnr,@Param("jbns") String jbns);

    /**
     * 单箱某一历史记录对应的提单信息列表
     */
    List<BLInfo> getBLList(@Param("accd") String accd,@Param("jbnr") String jbnr,@Param("jbns") String jbns);
}
