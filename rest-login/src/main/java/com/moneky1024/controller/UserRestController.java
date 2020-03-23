package com.moneky1024.controller;

import com.alibaba.fastjson.JSON;
import com.moneky1024.bean.User;
import com.moneky1024.util.DataUtil;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
public class UserRestController {

    /**
     * 查找所有的用户
     * @return
     * @throws Exception
     */
    @GetMapping("/users")
    public Object findAll() throws  Exception{

        HashMap<String, User> allUser = DataUtil.findAll();
        return JSON.toJSONString(allUser);
    }

    /**
     * 根据id查找用户
     * @return
     */
    @GetMapping("/users/{id}")
    public Object findById(@PathVariable String id)  throws  Exception{

        User user = DataUtil.findById(id);
        return JSON.toJSONString(user);
    }
    /**
     * 添加用户
     */
    @PostMapping("/users")
    public  String create(@RequestBody User user){
        try {
            DataUtil.create(user);

        } catch (Exception e) {
            e.printStackTrace();
            return JSON.toJSONString("fail");
        }
        return JSON.toJSONString("success");
    }


    /**
     * 修改用户
     */
    @PutMapping("/users/{id}")
    public String update(@PathVariable String id, @RequestBody User user) {
        try {
            DataUtil.update(id, user);
        } catch (Exception e) {
            e.printStackTrace();
            return JSON.toJSONString("fail");
        }
        return JSON.toJSONString("success");

}
/**
 * 删除用户
 */
@DeleteMapping("/users/{id}")
    public String delete(@PathVariable String id){
        try {
            DataUtil.dalete(id);
        } catch (Exception e) {
            e.printStackTrace();
            return JSON.toJSONString("fail");
        }
        return JSON.toJSONString("success");
    }
}








