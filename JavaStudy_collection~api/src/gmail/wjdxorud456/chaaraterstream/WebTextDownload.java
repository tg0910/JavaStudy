package gmail.wjdxorud456.chaaraterstream;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class WebTextDownload {
	
	public static void main(String[] args) {
		
		try {
			//읽어올 URL을 생성
			URL url = new URL("https://www.naver.com");
			//URL에 연결
			HttpsURLConnection con = (HttpsURLConnection)url.openConnection();
			//문자열을 읽기 위한 스트림 생성
			BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
			
			while(true) {
				String line = br.readLine();
				if(line == null) {
					break;
				}
				System.out.println(line);
			}
			
			
			br.close();
			
		}catch(Exception e) {
			
		}
	}

}
