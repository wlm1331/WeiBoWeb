package cn.tl.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@EnableAutoConfiguration
public class DemoController {
	@RequestMapping("/getString")
	@ResponseBody
	public String index(){
		return "Hello World";
		
	}
	@RequestMapping("/weibo")
	public String weibo(){
		return "weibo";
	}
	
	@RequestMapping("/dynamic")
	public String dynamic(ModelMap map){
		map.put("nickname", "小明");
		return "dynamic";
	}
	
	@RequestMapping("/dynamic_v2")
	public String dynamic(ModelMap map,String nickname) {
	       map.put("nickname",nickname);
	       return "dynamic";
	   }

	public static void main(String[] args) {
		SpringApplication.run(DemoController.class, args);
	}
	

}
