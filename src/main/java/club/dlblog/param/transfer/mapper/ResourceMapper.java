package club.dlblog.param.transfer.mapper;

import club.dlblog.param.transfer.entity.Resource;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ResourceMapper {

    @Select("<script>" +
            "SELECT * FROM resource WHERE 1=1 " +
            "<if test='transferId!=null'> AND  transfer_id like CONCAT(#{transferId},'%')</if>" +
            "<if test='transferName!=null'> AND  transfer_name like CONCAT(#{transferName},'%')</if>"+
            "</script>")
    List<Resource> query(@Param("transferId") String transferId, @Param("transferName")String transferName);

    @Select("SELECT * FROM resource WHERE  transfer_id =#{transferId}")
    Resource queryByTransferId(@Param("transferId") String transferId);

    @Select("SELECT * FROM resource WHERE  transfer_name =#{transferName}")
    Resource queryByTransferName(@Param("transferName")String transferName);

    @Select("INSERT INTO resource (transfer_id,transfer_name,transfer_script,transfer_type)" +
            "VALUES (#{resource.transferId},#{resource.transferName},#{transferScript},#{transferType})")
    int insert(@Param("resource")Resource resource);

    int update(Resource resource);

    int del(String id);

}
