package site.itwill09.springMVC;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class ViewController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Member member=new Member("AAA", "´Ù·ç¶ò", "ruru@ruru.com");
		
		ModelAndView mav=new ModelAndView();
		
		mav.addObject("member", member);
		
		mav.setViewName("member_view");
		
		return mav;
	}

}
