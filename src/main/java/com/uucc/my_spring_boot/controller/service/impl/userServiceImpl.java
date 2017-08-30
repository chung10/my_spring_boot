package com.uucc.my_spring_boot.controller.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.uucc.my_spring_boot.controller.service.UserService;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

import java.util.Map;

@Service
public class userServiceImpl implements UserService {
    /**
     * @return
     */
    @Override
    public String getNames() {
        Jedis Jedis = new Jedis("localhost", 6379);
        Map<String, String> nameMap = Jedis.hgetAll("demo");
        JSONObject jsonObject = new JSONObject();
        JSONArray jsonArray = new JSONArray();
        for (Map.Entry<String, String> entry : nameMap.entrySet()) {
            jsonObject = new JSONObject();
            jsonObject.put("name", entry.getValue());
            jsonArray.add(jsonObject);
        }
//        return jsonArray.toJSONString();
        return "小明，小华,小赵";
    }
}
