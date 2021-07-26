package club.dlblog.param.transfer.web;

import club.dlblog.param.transfer.bean.Result;
import club.dlblog.param.transfer.component.ParamTransfer;
import club.dlblog.param.transfer.dto.TransferInputDto;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * @author chaolei
 */
@RestController
@Api(value = "参数转换中台", tags = "参数转换中台服务")
public class TransferController extends BaseController {

    @Autowired
    ParamTransfer paramTransfer;

    @RequestMapping(value = "transfer", method = RequestMethod.POST)
    public Result transfer(@RequestBody TransferInputDto inputDto) {
        String out ;
        if (inputDto.getTransferId() != null) {
            out = paramTransfer.doTransferById(inputDto.getTransferId(), inputDto.getTransferContent());
        } else {
            out = paramTransfer.doTransferByName(inputDto.getTransferName(), inputDto.getTransferContent());
        }
       return success(out);
    }

}
