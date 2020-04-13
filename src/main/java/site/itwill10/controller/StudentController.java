package site.itwill10.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import site.itwill10.dto.Student;
import site.itwill10.service.StudentService;

//Controller 클래스 : 클라이언트의 요청을 받아 ★Service클래스의 메소드를 호출★하여 요청 처리 후 ViewName을 반환하여 JSP 문서로 응답처리 하는 메소드가 선언된 클래스
//					   => Service 클래스의 메소드를 호출하여 클라이언트의 요청 처리 (이것이 핵심 코드) 할라믄 @Controller 어노테이션 설정
//@Controller : Controller 관련 클래스를 Spring Bean으로 등록하기 위한 어노테이션
@Controller
//컨트롤러 클래스의 @RequestMapping 어노테이션을 사용하여 모든 요청처리메소드에 공통적으로 앞부분에 포함되어 적용되는 URL 주소를 설정 
@RequestMapping("/student")
public class StudentController {
//	Service 클래스 관련 Spring Bean을 인젝션 처리하여 필드에 저장
	@Autowired
	private StudentService studentService;
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String add() {
		return "student/add_student";
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String add(@ModelAttribute Student student, Model model) {
		try {
//			명령이 제대로 실행되지 않을 수 있으니 예외 발생 가능성 존재 
			studentService.addstudent(student);
		} catch (Exception e) {
			model.addAttribute("message", "이미 사용중인 학번이지롱~");
			return "student/add_student";
		}
		return "redirect:/student/display";
	}
	@RequestMapping("/display")
	public String display(Model model) {
		model.addAttribute("studentList", studentService.getStudentList());
		return "student/display_student";
	}
}



















