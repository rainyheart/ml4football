package com.mis.web;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@RequestMapping("/")
	public String home(HttpServletRequest request) {
		String ctx = request.getRequestURL().toString();
		Map<String,Object> model = new HashMap<String,Object>();
		model.put("ctx", ctx);
		return "index"; // 可访问到：src/main/webapp/pages/index.jsp
	}
}
