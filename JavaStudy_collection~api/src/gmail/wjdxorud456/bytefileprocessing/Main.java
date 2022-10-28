package gmail.wjdxorud456.bytefileprocessing;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {
	
	public static void main(String[] args) {
		//바이트 단위로 파일에 기록하기
		try {
			//오늘 날짜를 문자열로 만들기
			Date date = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			//기록할 파일 만들기
			FileOutputStream fos = new FileOutputStream("C:\\Users\\wjdxo\\git\\JavaStudy\\가%@" + sdf.format(date) + ".txt ",true);
			
			//기록할 메시지 생성
			String msg = "파일에 덮어쓰기\n";
			
			//파일에 기록
			fos.write(msg.getBytes());
			
			//파일을 닫기
			fos.close();
			
		}catch(Exception e) {
			System.out.println("파일 기록 실패");
			System.out.println(e.getLocalizedMessage());
		}
		
		//앞에서 작성 판일 읽기
		try {
			//읽기 위한 파일 생성
			FileInputStream fis = new FileInputStream("./2022-10-27.txt"); //?경로를 지정안해도나옴>
			//읽어서 저장할 바이트 배열을 생성
			byte[] b = new byte[fis.available()];
			//읽기
			fis.read(b);
			//읽은내용 확인
			System.out.println(new String(b));
			fis.close();
			
		}catch(Exception e){
			System.out.println(e.getLocalizedMessage());
		}
		
	}

}
