package club.dlblog.param.transfer.component;

import club.dlblog.param.transfer.engine.TransferEngine;
import club.dlblog.param.transfer.engine.TransferEngineManger;
import club.dlblog.param.transfer.mapper.ResourceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author chaolei
 */
@Component
public class ParamTransfer {

    @Autowired
    private TransferEngineManger transferEngineManger;

    @Resource
    private ResourceMapper resourceMapper;

    public String doTransferById(String json, String transferId) {
        String result = "";
        TransferEngine transferEngine = transferEngineManger.getEngine("javascript");
        result = transferEngine.transfer(json, resourceMapper.queryByTransferId(transferId).getTransferScript());
        return result;
    }

    public String doTransferByName(String json, String transferName) {
        String result = "";
        TransferEngine transferEngine = transferEngineManger.getEngine("javascript");
        result = transferEngine.transfer(json, resourceMapper.queryByTransferName(transferName).getTransferScript());
        return result;
    }
}
