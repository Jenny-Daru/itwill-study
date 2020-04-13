package site.itwill10.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

//ÀÔ·Â°ªÀÌ ÀúÀåµÇ´Â ÇÊµå¿¡ À¯È¿¼º °Ë»ç °ü·Ã ¾î³ëÅ×ÀÌ¼ÇÀ» »ç¿ëÇÏ¿© Ã³¸® 
public class Hewon {
//	@NotEmpty : ÀÔ·Â°ª Á¸Àç¸¦ °Ë»çÇÏ´Â ¾î³ëÅ×ÀÌ¼Ç / id°¡ ºñ¾îÀÖÀ¸¸é ¾ÈµÇ¿ä ~ 
//				 => ¿¡·¯ ¹ß»ı½Ã ¾î³ëÅ×ÀÌ¼ÇÀÌ Á¦°øÇÏ´Â ±âº» ¸Ş¼¼Áö Àü´Ş
//				 => message ¼Ó¼ºÀ» ÀÌ¿ëÇÏ¿© Àü´Ş ¸Ş¼¼Áö ¼³Á¤ °¡´É
	@NotEmpty(message = "¾ÆÀÌµğ ²¿¿Á ÀÔ·ÂÇØÁ¶")
//	@Size : ÀÔ·Â°ª ±æÀÌ¸¦ °Ë»çÇÏ±â À§ÇÑ ¾î³ëÅ×ÀÌ¼Ç
//			min¼Ó¼º : ÃÖ¼Ò±æÀÌ
//			max¼Ó¼º : ÃÖ´ë±æÀÌ
	//@Size(min = 6, max = 20, message = "¾ÆÀÌµğ´Â ÃÖ¼Ò 6ÀÚ ÀÌ»ó! ÃÖ´ë 20ÀÚ ÀÌÇÏ! ÀÔ·ÂÇØ¶û")
//	@Pattern() : ÀÔ·Â°ª ÆĞÅÏÀ» °Ë»çÇÏ´Â ¾î³ëÅ×ÀÌ¼Ç - ¡Ú´Üµ¶À¸·Î »ç¿ëÇÏ´Â °ÍÀ» ±ÇÀå¡Ú >> ´Ù¸¥°Å¶û °ãÃÄ¼­ ÀÌ»óÇØÁü 
	@Pattern(regexp = "^[a-zA-Z]\\w{5,19}$", message = "¾ÆÀÌµğÁ» Çü½Ä¿¡ ¸Â°Ô ÀÔ·ÂÂÍ ºäÅ¹Çà")
	private String id;
	
	@Pattern(regexp = "^(?=.*[a-zA-Z])(?=.*[0-9])(?=.*[~!@#$%^&*_-]).{6,20}$", message = "ºñ¹Ğ¹øÈ£ Çü½Ä¿¡ ¸Â°Ô ÀÔ·ÂÂÍ ºäÅ¹Çà")
	private String pw;
	
	@Pattern(regexp = "^[°¡-ÆR]{2,10}$", message = "ÀÌ¸§ Çü½Ä¿¡ ¸Â°Ô ÀÔ·ÂÂÍ ºäÅ¹Çà")
	private String name;
	
	@NotEmpty(message = "ÀÌ¸ŞÀÏ ²¿¿Á ÀÔ·ÂÇØÁ¶")
//	@Email : ÀÌ¸ŞÀÏÀÇ ÀÔ·Â°ªÀ» °Ë»çÇÏ´Â ¾î³ëÅ×ÀÌ¼Ç
	@Email(message = "ÀÌ¸ŞÀÏÀ» Çü½Ä¿¡ ¸Â°Ô ÀÔ·ÂÂÍ ºäÅ¹Çà")
	private String email;
	
	@NotEmpty(message = "¼ºº°À» ¼±ÅÃÇØ Áê¼¼¿ë")
	private String gender;
	
	public Hewon() {
		// TODO Auto-generated constructor stub
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	
	
	
}
