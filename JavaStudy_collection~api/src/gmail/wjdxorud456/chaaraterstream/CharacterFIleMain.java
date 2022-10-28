package gmail.wjdxorud456.chaaraterstream;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

public class CharacterFIleMain {
	
	public static void main(String[] args) {
		//파일에 문자열을 문자 단위로 기록하기 : FileWriter 와 PrintWriter 이용
		try {
			//버퍼를 이용해서 파일에 문자열을 기록하는 클래스의 인스턴스를 생성
			//한번 기록하고 두번째 기록할 때 이어서 기록하는 인스턴스
			
			//true를 생략하고 false를 설정하면 파일의 내용을 항상 새로 작성합니다.
			PrintWriter pw = new PrintWriter(new FileWriter("./ch.txt",true));
			//문자열을 기록
			//문자열을 기록할 때 ,나 공백 및 탭 등으로 구분이 가능한데
			//이렇게 만들어진 텍스트를 csv 라고 합니다.
			//이 방식은 변하지 않는 고정적인 데이터를 기록할 때 주로 이용
			pw.print("adam,사이버가수\n");
			pw.print("강진축구,온라인축구게임\n");
			pw.print("프리스톤테일,MMORPG\n");
			
			//버퍼의 내용 전부 출력
			pw.flush();
			
			//닫기
			pw.close();
			
		}catch(Exception e) {
			System.out.println(e.getLocalizedMessage());
		}
		
		//파일에서 문자열을 문자 단위로 읽어오기: FileReader 와 BufferedReader 이용
		try {
			BufferedReader br = new BufferedReader(new FileReader("./ch.txt"));
			//줄 단위로 읽어서 출력하기
			while(true) {
				//한 줄 일기
				String line = br.readLine();
				//읽은 데이터가 없으면 종료
				if(line==null) {
					break;
				}
				//읽은 데이터 출력
//				System.out.println(line);
				
				//읽은 문자열에서 , 를 기준으로 앞의 데이터만 출력
				String[] ar = line.split(",");
				System.out.println(ar[0]);
			}
			
			br.close();
		}catch(Exception e) {
			System.out.println(e.getLocalizedMessage());
		}
	
		
	}

}
