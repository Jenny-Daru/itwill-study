package site.itwill10.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import site.itwill10.dto.Employee;

@Controller
public class EmpController {
	@RequestMapping(value = "/emp", method = RequestMethod.GET)
	public String input() {
		return "emp_input";
	}
	
	@RequestMapping(value = "/emp", method = RequestMethod.POST)
//	command 객체 사용 : 입력값을 저장 및 view페이지에 제공
//	클래스의 포함관계 설정시 입력태그변경 
	public String output(@ModelAttribute Employee employee) {
		return "emp_output";
	}	
	
	
	
	
	
	

}
