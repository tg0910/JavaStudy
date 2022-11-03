package PC;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.font.TextHitInfo;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.PublicKey;
import java.util.StringTokenizer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Main extends JFrame {
 
    public Main() {
    	
    	//메인화면 아이디 입력과 비밀번호 입력 버튼및 텍스트박스생성
    	JPanel panel = new JPanel();
    	
    	//각각 id와 비밀번호 버튼등을 배치해주었다.
    	//원래 같은 경우에는 위치를 setboundㄹ 지정해줬어야하나 그냥 add해줄시 자동으로 배치 되는 화면으로 출력해보았다.
    	JLabel idlabel = new JLabel("아이디");
    	panel.add(idlabel);
    	
    	JTextField idtext = new JTextField(10);
    	panel.add(idtext);
    	
    	JLabel passlabel = new JLabel("비밀번호");
    	panel.add(passlabel);
    	JPasswordField passtext = new JPasswordField(10);
    	panel.add(passtext);
    	
    	
    	JButton login = new JButton("로그인");
    	panel.add(login);
    	
    	JButton insert = new JButton("회원가입");
    	panel.add(insert);
    	
    	
    	//로그인버튼 클릭시 작동이벤트
    	//로그인시 기존에 저장되어있던 회원정보파일을 불러와서
    	//readline을 통해 1줄씩확인해준다.
    	//유저정보는 각각 아이디 비밀번호 이름 생일 핸드폰 번호가 "/"기준으로 나누어서 저장되어있기때문에
    	//String Array에 [id,비밀번호,이름,생일,핸드폰] 이순서로 저장되어있는 상황이다.
    	//로그인시 id와 비밀번호만 확인하면 되기때문에 , array[0],array[1]만 확인하고
    	//입력한 값들이 동시에 id와 비밀번호가 만족하면 로그인에 성공하게 조건을 주었다.
    	//아래 ok 변수는 로그인 성공시 true로 바뀌며 멈추기 위한 조건으로 주었고
    	//만약 false시 로그인실패 알림이 뜨게한다.
    	login.addActionListener(new ActionListener() {
    		
			@Override
			public void actionPerformed(ActionEvent e) {
				boolean ok = false;
    			String check =null;
    			
    			try {
					BufferedReader br = new BufferedReader(new FileReader("userinfo.txt"));
					try {
						while((check = br.readLine()) != null) {//데이터 마지막줄까지,다음줄에 공백이라면 멈춤
						
							String[] array = check.split("/");  // "/"로 데이터를 나누어주었기 떄문에 "/"기준으로 array배열에 나누어줌
						
							if(array[0].equals(idtext.getText())&&array[1].equals(passtext.getText())) { //id와 비밀번호 동시에 만족할시 동작하는조건
							JOptionPane.showMessageDialog(null,"로그인성공");
							ok = true;
							}
						}
						
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					
					
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
    			
    			if(ok==false) {   //위에서 모든 유저데이터를 확인했는데도 로그인에 실패했다면 ok는 false상태이기떄문에 다시 id와 비밀번호를 확인하라고 알림.
					JOptionPane.showMessageDialog(null,"로그인실패,아이디랑 비밀번호를 확인하세요");
					}
    			
			}
		});
    	
    	
    	
    	insert.addActionListener(new ActionListener() {   //회원가입 버튼 작동이벤트, 회원가입창이 뜨게된다.
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new Account();
				
			}
		});
    	
    
    add(panel);				//패널에 모든 버튼과 텍스트박스를 배치해준뒤, 마지막으로 화면에 나오게 추가해줌
    
    setVisible(true);		//보이는지 유무
    setSize(400,300);		//창크기
    setLocationRelativeTo(null); //null로 설정함으로써 윈도우창 가운데 뜨게해준다.
    setResizable(true);		//사이즈 조절가능, false로 할시 고정
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //창을 닫을시 완전히 종료하게 설정해줌,회원가입에서 뒤로가기는 그창만 닫으면 되기때문에 dispose를 사용
    
    }
 
  public static void main(String[] args) {
 
        new Main();
 
 
  }
 
 
 
}
