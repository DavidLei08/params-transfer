package club.dlblog.param.transfer.web;

import club.dlblog.param.transfer.bean.Result;

public class BaseController {

    public Result success(Object o){
        Result result = new Result();
        result.setCode("0");
        result.setMessage("success");
        result.setResult(o);
        return result;
    }

    public Result error(String message){
        Result result = new Result();
        result.setCode("9999");
        result.setMessage(message);
        return result;
    }
}
