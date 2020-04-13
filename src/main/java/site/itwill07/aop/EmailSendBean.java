package site.itwill07.aop;

import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.mail.javamail.JavaMailSender;

//이메일 전송 기능을 제공하는 클래스 - 핵심관심모듈
//메일을 보내는 서비스
//메일을 전송하는 라이브러리 없음 >> 빌드시켜쥬기 >> pom.xml >> dependency추가 
public class EmailSendBean {
	
//	참조변수는 부모로 선언
//	이메일 전송을 위한 JavaMailSender 인스턴스를 저장하기 위한 필드(아직저장안됨)
	private JavaMailSender mailSender;

//	getter은 사실 필요없움
	public JavaMailSender getMailSender() {
		return mailSender;
	}

//	setter가 필요한 이유 : EmailSendBean클래스를 SpringBean으로 등록되어야함 >> setter Injection하기 위해 필요
	public void setMailSender(JavaMailSender mailSender) {
		this.mailSender = mailSender;
	}
	
	
//	핵심관심코드를 가진 메소드작성
//	구글을 통해 보낼거기 때문에 구글계정이용 >> 보내는이는 일단 필요없움
//	이메일 전송메소드 - 핵심관심코드
//	 => 받는사람의 이메일주소, 제목, 내용을 매개변수로 전달받아 저장
//	 => 받는 사람의 이메일주소 반환 - 로그를 위해(누구한테 보냈다~~ 기록되어지게 하기위해)
	public String sendEmail(String email, String subject, String content) {                     // 이것이 target메소드임
		
//		JavaMailSender.createMimeMessage() : Mimessage 인스턴스를 반환하는 메소드 
//		MimeMessage : 이메일 전송 관련 정보를 저장하기 위한 클래스
//		mailSender가 실제로 메일을 보낼건데 메일들의 정보를 MimeMessge에 저장된것을 보낸다. 
//		createMimeMessage한테 이메일보낼거니까 객체하나만 만들어줘~ 하면 객체를 만들어쥼
		MimeMessage message=mailSender.createMimeMessage();
		
//		이메일을 보낼때 이메일의 제목을 변경가능 >> 예외처리 꼭 해야함 
		try {
//			MimeMessage.setSubject(String subject) : 이메일 제목을 변경하는 메소드 
			message.setSubject(subject);
			
//			MimeMessage.setContent(Multipart mp) : 이미지,첨부파일 같이 전송
//			MimeMessage.setText(String text) : 이메일 내용을 변경하는 메소드
//											   => 텍스트 메세지로만 변경하여 전달 가능
			message.setText(content);
			
//			MimeMessage.setRecipients(RecipientType type, (Address[] addresses:여러명, InternaetAddress email:한명)) 
//			: MimeMessage.RecipientType.TO >> 이메일을 받는 사람에 대한 정보를 변경하는 메소드 // CC : 참조는 누구한테 할거니?
//			  InternetAddress.parse(String Addressemail) >>문자열을 전달받아 InternaetAddress[] 배열로 변환하여 반환하는 메소드
//			   => 받는 사람의 이메일 주소 변경 >> InternetAddress 인스턴스 대신 String 인스턴스 전달 가능 
//			message.setRecipients(MimeMessage.RecipientType.TO, email);
			message.setRecipients(MimeMessage.RecipientType.TO, InternetAddress.parse(email));
			
//			JavaMailSender.sene(MimeMessage message) : 이메일을 전송하는 메소드
			mailSender.send(message);
			
//		  메세지를 받는사람의 정보가 잘못되었을 경우 예외발생 
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		return email;
	}
	
}











