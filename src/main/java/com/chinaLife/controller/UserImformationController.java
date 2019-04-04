package com.chinaLife.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.chinaLife.model.UserImformation;
import com.chinaLife.service.UserImformationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import javax.enterprise.inject.New;
//import javax.json.JsonObject;
import javax.json.JsonObject;
import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class UserImformationController {

    @Resource
    private UserImformationService userImformationService;

    @RequestMapping(value = "/UserImformation")
    public ModelAndView UserImformation(){
        ModelAndView modelAndView=new ModelAndView();
        List<UserImformation> list=userImformationService.QueryA();
        modelAndView.addObject("list",list);
        modelAndView.setViewName("UserImformation");
        return modelAndView;
    }

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public String addUserImformation(HttpServletRequest request, Model model) throws UnsupportedEncodingException {

        //获取页面传入的值
        request.setCharacterEncoding("utf-8");
        String username=request.getParameter("userName");
        String phone=request.getParameter("phone");
        String address=request.getParameter("address");
        //实例化
        try{
            UserImformation userImformation=new UserImformation();
            userImformation.setUsername(username);
            userImformation.setPhone(phone);
            userImformation.setAdress(address);
            System.out.println("username"+username+"phone"+phone+"address"+address);
            //新增
            int result=userImformationService.insertUserImformation(userImformation);
            if (result!=0){
                return "redirect:/UserImformation";
            }else {
                System.out.println("异常判断多余了");
                return "redirect:/UserImformation";
            }
        }catch (Exception e){
            System.out.println("新增失败");
        }
        return "redirect:/UserImformation";
    }

    /*
    * 删除
    * */
    @RequestMapping(value = "/deleteUserimformation",method = RequestMethod.GET)
    public String deleteUserimformation(HttpServletRequest request,Model model) throws UnsupportedEncodingException {

        //重新编码
        request.setCharacterEncoding("utf-8");
        //或缺删除表的主键信息
        UserImformation userImformation=new UserImformation();
        System.out.println(userImformation.getUsername());
        userImformation.setUsername(request.getParameter("username"));
        //更新数据库
        int result=userImformationService.delectUserImformation(userImformation.getUsername());
        //若是map可以将返回结果给前台，进行验证，这里就简单的做一下刷新页面操作
        return "redirect:/UserImformation";
    }


    // 测试json
    @ResponseBody
    @RequestMapping(value = "/josnQuery", method = RequestMethod.POST)
    public JSONObject josnQuery() throws Exception{

        System.out.println("josnQuery json测试");
        Map<String, Object> resultMap = new HashMap<String, Object>();
        List<UserImformation> list=userImformationService.QueryA();
            resultMap.put("list",list);
            resultMap.put("msg", "success");
            resultMap.put("page_url", "UserImformation");
            String returnJsonString = JSON.toJSONString(resultMap);
            JSONObject returnJsonObj = JSON.parseObject(returnJsonString);

            System.out.println(returnJsonObj.toJSONString());

        return returnJsonObj;
    }
}
