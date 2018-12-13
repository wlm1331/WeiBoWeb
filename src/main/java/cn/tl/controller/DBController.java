package cn.tl.controller;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.tl.manager.WeiBoDBManager;

@Controller
public class DBController {
	@Autowired
	private WeiBoDBManager weiBoDBManager;
	
	@RequestMapping("/hotwords")
	String getHotWords(ModelMap modelMap) {
	       List<Map<String, Object>> list = weiBoDBManager.getHotWordsList();
	       modelMap.put("result", list);
	       return "weibo_hotwords";
           
	}
        
  
        

	public static void main(String[] args) throws Exception{
		SpringApplication.run(DBController.class, args);
	}
	

}
