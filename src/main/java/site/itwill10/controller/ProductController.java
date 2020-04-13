package site.itwill10.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import site.itwill10.dto.Product;
import site.itwill10.dto.ProductCollection;

@Controller
public class ProductController {
	
	@RequestMapping(value = "/product", method = RequestMethod.GET)
	public String productInput() {
		return "product_input";
	}
	
/*	
	[ 하나의 제품을 등록하는 방법 ]
	@RequestMapping(value = "/product", method = RequestMethod.POST)
	public String productOutput(@ModelAttribute Product product) {
		return "product_output";
	}
*/
	
//	[ 다수의 제품을 등록하는 방법 ]
//	 => 입력페이지에서 입력태그의 name변경 
	@RequestMapping(value = "/product", method = RequestMethod.POST)
	public String productOutput(@ModelAttribute(value = "collection" ) ProductCollection collection) {
		return "product_output";
	}
	

}
















