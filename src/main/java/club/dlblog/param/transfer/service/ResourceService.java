package club.dlblog.param.transfer.service;

import club.dlblog.param.transfer.entity.Resource;
import club.dlblog.param.transfer.mapper.ResourceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResourceService {

    @Autowired
    private ResourceMapper resourceMapper;

    public List<Resource> query(String transferId,String transferName){
       return resourceMapper.query(transferId,transferName);
    }

    public int update(Resource resource){
        return resourceMapper.update(resource);
    }

    public int insert(Resource resource){
        return resourceMapper.insert(resource);
    }

    public int del(String id){
        return resourceMapper.del(id);
    }
}
