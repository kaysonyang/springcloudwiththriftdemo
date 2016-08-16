package com.deep.home;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/view")
public class FreemarkerAction {
	
	
	@RequestMapping("/index")
	public String agreement(Map<String, Object> model) {
		return "index";
	}
	

}
