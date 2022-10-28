package gmali.wjdxorud45.fileinformation;

import java.io.File;
import java.util.Date;

public class Main {
	
	public static void main(String[] args) {
		//파일에 대한 정보 확인
		
		try {
			//File 객체 생성
			//Windows 안에는 디렉토리 구분  \ 기호가 인데
			//프로그래밍 언어에서는 \ 가오고 하나의 문자아 오면 제어문자로 인식
			//\를 입력하고자 할 때는 \\ 이렇게 해야 합니다.
			File f = new File("C:\\Program Files\\Windows Defender Advanced Threat Protection\\ThirdPartyNotice");
			
			//파일의 존재 여부 확인
			System.out.println(f.exists());
			
			//마지막 수정 날짜
			System.out.println(f.lastModified());
			System.out.println(new Date(f.lastModified()));
			
		}catch(Exception e){
			System.out.println(e.getLocalizedMessage());
		}
	}

}
