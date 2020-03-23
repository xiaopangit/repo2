package com.monkey1024.controller;

import com.monkey1024.User;
import com.monkey1024.util.DataUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;

@Controller
public class UserController {

    /**
     * 查找所有的用户
     */
    @RequestMapping("/findAll.do")
    public ModelAndView findAll() throws  Exception{

        HashMap<String, User> allUser = DataUtil.findAll();
        ModelAndView mv = new ModelAndView();
        mv.addObject("allUser", allUser);
        mv.setViewName("user_list");
        return  mv;
    }
/**
 * 新增
 */
@RequestMapping("/create.do")
    public String create(User user) throws  Exception{

        DataUtil.create(user);

        return "redirect:findAll.do";

    }

    /**
     * 通过id查找数据
      */
    @RequestMapping("/findById.do")
    public ModelAndView fingById(String id) throws  Exception{

        ModelAndView mv = new ModelAndView();
        User user = DataUtil.findById(id);

        HashMap<Object, Object> map = new HashMap<>();
        map.put(id, user);
        mv.addObject("allUser", map);
        mv.addObject("id", id);
        mv.setViewName("user_list");
        return  mv;
    }
    /**
     * 删除用户
     */
    @RequestMapping("/delete.do")
    public String delete(String id) throws  Exception{
        DataUtil.dalete(id);

        return "redirect:findAll.do";
    }
    /**
     * 修改用户
     */

    @RequestMapping("/goupdate.do")
    public ModelAndView goUpdate(String id) throws Exception{
        User user = DataUtil.findById(id);

        ModelAndView mv = new ModelAndView();
        mv.addObject("id", id);
        mv.addObject("user", user);
        mv.setViewName("user_update");
        return mv;

    }
    @RequestMapping("/update.do")
    public  String updaet(String id,User user) throws Exception{

        DataUtil.update(id,user);

        return "redirect:findAll.do";
    }

}









































