package site.itwill07.aop;

//핵심관심모듈
public class ExecutionTimeBean {
//	핵심관심모듈의 핵심코드(메소드) - 이 메소드가 실행될때 걸리는 시간
	public void run() {
//		for문 20억번 돌려!
		int count=0;
		for(int i=1; i<=2000000000; i++ ) {
			count++;
		}
		System.out.println("count = "+count);
	}
}
