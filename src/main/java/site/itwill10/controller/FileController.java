package site.itwill10.controller;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.imgscalr.Scalr;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.multipart.MultipartFile;

import site.itwill10.dto.FileBoard;
import site.itwill10.service.FileBoardService;

@Controller
//ApplicationContextAware 인터페이스를 상속받아 클래스가 Spring Bean으로 등록될때 setApplicationContext() 메소드를 호출하여 매개변수의 전달값으로 필드 초기화
// => ApplicationContext 인스턴스를 매개변수에 저장하여 필드값 변경
// => Spring Bean으로 등록하여 인젝션처리 못할 경우 인터페이스 사용
public class FileController implements ApplicationContextAware {
	
	@Autowired
//	@Autowired 를 사용하여 인젝션하여 초기화 설정 
	private FileBoardService fileBoardService;
	
//	WebApplicationContext : SpringMVC의 Front Controller에서 사용하기 위한 Spring Bean을 관리하기 위한 Spring Container 관련 인스턴스
//	web에 관련된 모든 정보저장되어 있음!!! 
//	@Autowired 사용 불가 => Spring Bean이 아닌 Spring Bean을 관리하는 Container이기 때문에 ApplicationContext을 변경가능하도록 하는 인터페이스 ApplicationContextAware 상속
	
	private WebApplicationContext context;
	
//	Spring bean으로 생성 후 자동 호출되는 메소드 
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
//		부모를 자식으로 변환하여 저장
//		ApplicationContext 인스턴스는 WebApplicationContext 인스턴스의 부모 인스턴스 이므로 객체 형변환을 해야만 필드에 저장 가능
		context=(WebApplicationContext)applicationContext;
	}
	
	@RequestMapping(value = "/upload", method = RequestMethod.GET)
	public String upload() {
		return "file/upload";
	}
/*	
//	모든 입력값을 가져오는게 아님!!!!

   <<파일 업로드 방법>>
   [1) 값을 가져오는것 ]  
//	아파치제공 multiFile 라이브러리 사용
	
//	MultipartHttpServletRequest : "multipart/form-data"로 전달받은 입력파일과 입력값을 처리하는 인스턴스
	@RequestMapping(value ="/upload", method = RequestMethod.POST)
	public String upload(MultipartHttpServletRequest request) throws IllegalStateException, IOException {
		String uploader=request.getParameter("uploader");
//		MultipartServletRequest.getFile(String name) : 입력파일을 전달받아 MultipartFile 인스턴스로 반환하는 메소드
//		MultipartFile : 입력파일 정보를 저장하기 위한 인스턴스 (파일정보에 관한것들 저장 ex.파일명 , 파일크기, 파일종류 등) 
//		이걸 했다고 파일이 업로드 되눈것이 아님
		MultipartFile uploadFile=request.getFile("uploadFile");
		
//		MultipartFile.getContentType() : 입력파일 형식(MimeType)을 반환하는 메소드 
		System.out.println(uploadFile.getContentType());
//		MultipartFile.getBytes() : 입력파일을 Byte 배열로 변환하여 반환하는 메소드 
		System.out.println(uploadFile.getBytes().length);
		
//		업로드처리
//		MultipartFile.isEmpty() : 입력파일 정보가 존재하지 않을 경우 true를 반환하는 메소드 
//								  => 입력파일에 대한 유효성 검사 가능 - 파일형식, 파일크기 등
		
//		!uploadFile.getContentType().equals("image/jpeg") : 업로드 파일 형태
//		uploadFile.getBytes().length>3000000 : 업로드 파일 크기 
		if(uploadFile.isEmpty()) { //파일을 미입력시 이동하는 jsp
			return "file/upload_fail";
		}
		
//		입력파일을 저장하기 위한 업로드 디렉토리의 시스템 경로를 반환받아 저장
		String uploadDirPath=request.getServletContext().getRealPath("/resources/upload");
		
//		입력파일을 서버 디렉토리에 저장하기 위한 File 인스턴스 생성
		//MultipartFile.getOriginalFilename() : 입력파일의 이름을 반환하는 메소드 
//												 =>uploadDirPath위치에 "uploadFile.getOriginalFilename()"의 이름을 저장 
		File file=new File(uploadDirPath, uploadFile.getOriginalFilename());
		
//		업로드 처리
//		MultipartFile.transferTo(File file) : 입력파일을 서버 시스템에 전송하여 저장하는 메소드
//      => 서버에 동일한 이름의 파일이 이미 존재할 경우 덮어씌우기 
		uploadFile.transferTo(file); 
		
		request.setAttribute("uploader", uploader);
		request.setAttribute("originalFilename", uploadFile.getOriginalFilename());
		
		return "file/upload_ok";
	}
*/
	
//	[2) 입력파일을 요청하는 방법 ] - 동일한 파일명이 존재한다면 덮어씌우지 않고 규칙을 제공하여 다른이름으로 저장가능 
	@RequestMapping(value = "/upload", method = RequestMethod.POST)
//	파일을 MultipartFile에 객체로 넣어달라고 요청 
	public String upload(@RequestParam String uploader, @RequestParam MultipartFile uploadFile, Model model) throws IllegalStateException, IOException {

		if(uploadFile.isEmpty()) { 
			return "file/upload_fail";
		}
		
//		입력파일을 저장하기 위한 업로드 디렉토리의 시스템 경로를 반환받아 저장
//		WebApplicationContext는 미리 만들어 놓기 때문에 그냥 요청만 하면되고 request는 요청시 만들어서 전달하므로 속도가 느림
//		WebApplicationContext 인스턴스를 이용하여 서버의 업로드 디렉토리의 시스템 경로를 반환받아 저장
		String uploadDirPath=context.getServletContext().getRealPath("/resources/upload");
		
//		서버에 입력파일과 동일한 이름의 파일이 존재할 경우 입력파일명을 변경하여 서버에 저장되도록 설정
		String originalFilename=uploadFile.getOriginalFilename();
		File file=new File(uploadDirPath, originalFilename);
		
//		실제 서버에 저장하기 위한 파일명을 저장하기 위한 변수 선언 
//		 => 초기값으로 입력파일명을 저장 
		String uploadFilename=originalFilename;
		
//		<< 파일의 이름을 변경하기 위한 규칙 설정 >>
//		서버에 입력파일명과 같은 이름의 파일이 존재할 경우 입력파일명을 변경 - 반복처리
		int i=1;
		while(file.exists()) {   //업로드 전에 파일이 존재한다면 서버에 같은 이름의 파일이 존재 한다는 경우!!! 
			int index=originalFilename.lastIndexOf(".");
//			입력파일명 뒤에 "_숫자"를 추가하여 변경처리 후 확장자 붙이기 
			uploadFilename=originalFilename.substring(0, index) +"_"+i+originalFilename.substring(index);
			file=new File(uploadDirPath, uploadFilename);
			i++;
		}
		
		uploadFile.transferTo(file); 

		model.addAttribute("uploader", uploader);
		model.addAttribute("originalFilename", originalFilename);
		model.addAttribute("uploadFilename", uploadFilename);
		
		return "file/upload_ok";
	}
	
	
//	[ 파일의 용량이 클경우 자동으로 용량을 줄이는 방법 ]
	@RequestMapping(value = "/thumbnail", method = RequestMethod.GET)
	public String thumbnail() {
		return "file/thumbnail";
	}
	
	
	@RequestMapping(value = "/thumbnail", method = RequestMethod.POST)
	public String thumbnail(@RequestParam MultipartFile imageFile, Model model) throws IllegalStateException, IOException {
		if(!imageFile.getContentType().equals("image/jpeg")) {
			return "file/thumbnail_fail";
		}
		
		String uploadDirPath=context.getServletContext().getRealPath("/resources/upload");
		String imageFilename=imageFile.getOriginalFilename();
		File file=new File(uploadDirPath, imageFilename);
		imageFile.transferTo(file);
		
//		업로드 처리된 이미지 파일을 이용하여 썸네일 파일 생성 
//		1.이미지 파일을 읽어 이미지를 메모리에 저장
//		BufferedImage : 이미지 파일의 정보를 저장하는 클래스
//		ImageIO.read(File file) : 이미지 파일 정보를 읽어 BufferedImage 인스턴스로 반환하는 메소드 
		BufferedImage sourceImage=ImageIO.read(file);
		
//		2.메모리에 저장된 이미지의 크기를 변경하여 썸네일 이미지 생성 => 파일생성하는 것이 아니고 메모리에 생성 
//		  => 이미지 크기를 변경하기 위해서는 Spring이나 JDK는 이미지 크기를 조절하는 클래스가 미존재 
//		     pom.xml에 라이브러리 빌드하여 사용 
		
//		Scalr.resize(BufferedImage src, Method scalingMethod, Mode resizeMode, int targetSize) 
//		 : 메모리에 저장된 이미지의 크기를 변경하는 메소드 , 높이나 폭 둘중 하나를 지정하여 자동으로 변환되게 설정
//		   => Scalr.Method.AUTOMATIC : 이미지의 폭 또는 높이를 자동으로 변경
//		   => FIT_TO_WIDTH : 이미지의 폭 변경
		BufferedImage thumbnailImage=Scalr.resize(sourceImage, Scalr.Method.AUTOMATIC, Scalr.Mode.FIT_TO_WIDTH, 400);
		
//		3.메모리에 저장된 썸네일 이미지를 이용하여 파일 생성
//		  *주의* 썸네일 파일의 이름 설정해야함
		int index=imageFilename.lastIndexOf(".");
		String thumbnailFilename=imageFilename.substring(0, index)+"_s"+imageFilename.substring(index);
		
		index=thumbnailFilename.lastIndexOf(".");
//		ImageIO.write(RenderedImage im, String formatName, File output) : 저장된 이미지 정보를 읽어 이미지 파일로 생성하는 메소드
		ImageIO.write(thumbnailImage, thumbnailFilename.substring(index+1),new File(uploadDirPath,thumbnailFilename));

		model.addAttribute("imageFilename",imageFilename);
		model.addAttribute("thumbnailFilename",thumbnailFilename);

		return "file/thumbnail_ok";
	}
	
	
//	******************************* DB 연동하여 파일 업로드 하는 방법 **********************************
	
	@RequestMapping(value = "/file_upload", method = RequestMethod.GET)
	public String fileUpload() {
		
		return "file/file_upload"; //파일 입력페이지
	}
	
	@RequestMapping(value = "/file_upload", method = RequestMethod.POST)
	public String fileUpload(@ModelAttribute FileBoard fileBoard) throws IllegalStateException, IOException {
//		입력파일에 대한 유효성 검사 - 형식과 크기 등 검사
		if(fileBoard.getFile().isEmpty()) {
			return "file/file_upload";
		}
		
//		파일 업로드 처리 - 우선 DB테이블에 저장할 정보를 가져와야함 
//		무조건 Front Controller 를 거쳐 업로드 되게 설정 => 직접 접근 불가 및 Front Controller 통해서만 접근 가능
		String uploadDirPath= context.getServletContext().getRealPath("/WEB-INF/upload");
		
//		입력파일명을 반환받아 저장
		String origin=fileBoard.getFile().getOriginalFilename();
//		업로드 파일명을 TimeStamp(현재시간을 1/1000 s 단위로 생성)를 이용하여 생성 => 그러므로 중복불가 및 이름명만 보고서 무엇인지 알기 어려움(보안강화)
//		 => 업로드 파일명이 중복되지 않도록 설정 
		String upload=System.currentTimeMillis()+"";
		
//		파일 업로드 처리 (TimpeStamp로 생성된 이름으로 저장) 
		fileBoard.getFile().transferTo(new File(uploadDirPath, upload));
		
//		테이블에 저장하기위해 필드값 변경(Setter메소드사용)
		fileBoard.setOrigin(origin);
		fileBoard.setUpload(upload);
		
//		FILE_BOARD 테이블에 파일게시글 관련 정보를 저장 
		fileBoardService.addFileBoard(fileBoard);
		
//		리다이렉트 이동
		return "redirect:/file_list"; 
	}
	
	@RequestMapping(value = "/file_list")
	public String fileList(Model model) {
		model.addAttribute("fileBoardList", fileBoardService.getFileBoardList());
		return "file/file_list";
	}
	
	
	
}












