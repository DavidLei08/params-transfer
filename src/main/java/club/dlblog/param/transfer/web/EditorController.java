package club.dlblog.param.transfer.web;

import club.dlblog.param.transfer.bean.Result;
import club.dlblog.param.transfer.entity.Resource;
import club.dlblog.param.transfer.service.ResourceService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chaolei
 */
@RestController
@Api(value = "参数转换中台", tags = "参数转换中台管理服务")
public class EditorController  extends  BaseController{

    @Autowired
    ResourceService resourceService;

    @ApiOperation(value = "转化配置查询", notes = "中台转换服务")
    @RequestMapping(value = "query",method = RequestMethod.GET)
    public Result query(String transferId,String transferName){
        return success(resourceService.query(transferId,transferName));
    }

    @ApiOperation(value = "转化配置增加", notes = "中台转换服务")
    @RequestMapping(value = "insert",method = RequestMethod.PUT)
    public Result insert(@RequestBody  Resource resource){
        return success(resourceService.insert(resource));
    }

    @ApiOperation(value = "转化配置删除", notes = "中台转换服务")
    @RequestMapping(value = "del",method = RequestMethod.DELETE)
    public Result del(String id){
        return success(resourceService.del(id));
    }


    @ApiOperation(value = "转化配置更新", notes = "中台转换服务")
    @RequestMapping(value = "update",method = RequestMethod.POST)
    public Result update(@RequestBody  Resource resource){
        return success(resourceService.update(resource));
    }
}
