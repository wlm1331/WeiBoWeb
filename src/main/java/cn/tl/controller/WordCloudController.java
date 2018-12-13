package cn.tl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.tl.manager.WeiBoDBManager;

import com.alibaba.fastjson.JSONArray;

/**
 * 注解声明，该类为Controller类 并自动加载所需要的其它类
 */
@Controller
public class WordCloudController {   
	  @Autowired
	    private WeiBoDBManager weiBoDBManager;
	   
	    @RequestMapping("/wordcloud_original")
	    String getHotWordsOriginal(ModelMap modelMap) {
	        return "wordcloud_original";
	    }
	   
	    @RequestMapping("/wordcloud")
	    String getHotWords(ModelMap modelMap) {
	        JSONArray jsonArray = weiBoDBManager.getHotWordsJsonArray();
	        modelMap.put("result", jsonArray.toJSONString());
	        return "wordcloud";
	    }
  
   // 主方法，像一般的Java类一般去右击run as application时候，执行该方法
   public static void main(String[] args) throws Exception {
      SpringApplication.run(WordCloudController.class, args);
   }
}
