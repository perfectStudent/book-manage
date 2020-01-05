package cn.wmkfe.bookmanage.controller.api.admin;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractApiController {
    public Map<String,Object> resultJson(String code,String errMsg,Object data){
       Map<String,Object> map=new HashMap<>();
        map.put("code",code);
        map.put("msg",errMsg);
        map.put("data",data);
        map.put("data",data);
       return map;
    }


    public Map<String,Object> resultJsonLayui(String code,String errMsg,Integer count,Object data){
        Map<String,Object> map=new HashMap<>();
        map.put("code",code);
        map.put("msg",errMsg);
        map.put("count",count);
        map.put("data",data);
        return map;
    }
}
