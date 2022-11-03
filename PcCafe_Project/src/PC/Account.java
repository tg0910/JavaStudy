package PC;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.*;

public class Account extends JFrame {
	
	//마지막 회원가입시에 정상적인데이터라면 1로바뀌고
	//아니면 0으로 유지하는 조건검사용 변수
	int idchecking =0;
	int pwcheck =0;
	int phonecheck =0;
	int birthcheck =0;
	int emailcheck= 0;
	int namecheck = 0;
	
	
	int x = 100;
	int x1 = 210;
	
	 public Account() {
		 	
		 	//기본 배경이 되주는 panel 생성후 배치관리자로 설정해줌
		 	JPanel panel = new JPanel();  	
		 	panel.setLayout(null);
		 	
		 	//각각 ID,패스워드,패스워드 재확인,이름,핸드폰번호,생년월일,회원가입,뒤로가기를 만들어주고 
		 	//위에 panel에 각각 배치해줌
		 	//x의 위치는 동일하게 했기에 x와 x1변수로 미리 지정해두고 사용함 
		 	JLabel idlabel = new JLabel("아이디"); 
		 	panel.add(idlabel).setBounds(x,100,100,30);
		 	JTextField idtext = new JTextField();
		 	panel.add(idtext).setBounds(x1,100,250,30);
		 	JButton idcheck = new JButton("아이디확인");
		 	panel.add(idcheck).setBounds(470,100,110,30);
		 	
	    	JLabel passlabel = new JLabel("비밀번호");
	    	panel.add(passlabel).setBounds(x,150,100,30);
	    	JPasswordField passtext = new JPasswordField();
	    	panel.add(passtext).setBounds(x1,150,250,30);
	    	
	    	JLabel passlabel2 = new JLabel("비밀번호재확인");
	    	panel.add(passlabel2).setBounds(x,200,100,30);
	    	JPasswordField pass2text = new JPasswordField();
	    	panel.add(pass2text).setBounds(x1,200,250,30);
	    	
	    	JLabel namelabel = new JLabel("이름");
	    	panel.add(namelabel).setBounds(x,250,100,30);
	    	JTextField nametext = new JTextField();
	    	panel.add(nametext).setBounds(x1,250,250,30);
	    	
	    	JLabel phonelabel = new JLabel("핸드폰 번호");
	    	panel.add(phonelabel).setBounds(x,300,100,30);
	    	JTextField phonetext = new JTextField(10);
	    	panel.add(phonetext).setBounds(x1,300,250,30);
	    	
	    	JLabel birthlabel = new JLabel("생년월일6자리");
	    	panel.add(birthlabel).setBounds(x,350,100,30);
	    	JTextField birthtext = new JTextField(10);
	    	panel.add(birthtext).setBounds(x1,350,250,30);
	    	
	    	JButton sineup = new JButton("회원가입");
	    	panel.add(sineup).setBounds(210, 400, 100, 50);
	    	
	    	JButton cancel = new JButton("뒤로가기");
	    	panel.add(cancel).setBounds(370,400,100,50);
		
	    	add(panel);//마지막으로 모두 배치한 panel을 만들어줌
		
	   //기본 크기와 설정
		setVisible(true);
	    setSize(700,600);
	    setLocationRelativeTo(null);
	    setResizable(false);
	    
	    idcheck.addActionListener(new ActionListener() {
			
	    	//여기서 아이디 유효성검사를 해줌
	    	//먼저 개인정보가 저장된 usefrinfo 텍스트파일을 불러와서
	    	//중복검사를 진행한 뒤, idregex에 저장한 정규식을 통하여 유효한id인지 체크해줌
			@Override
			public void actionPerformed(ActionEvent e) {
				 String idch = idtext.getText();
				 String idregex = "^[a-zA-Z]{1}[a-zA-Z0-9_]{4,11}$";
				 
				
				 //임의의 String 변수를 만들어두고 유저정보가 저장된 파일에서
				 //BufferedReader 을 통해 readLine으로 1줄씩 데이터를 공백인 줄까지 계속 데이터를 받아준다.
				 //아래 회원가입에서 설명하겠지만, 저장된 데이터는 '/'로 각각 id 비밀번호 ..... 순으로 저장해준상황에서
				 //split "/"를 통해서 각각 데이터를 구분해줌
			     String check = null;
				try {
				BufferedReader br = new BufferedReader(new FileReader("userinfo.txt"));
				try {
				while((check = br.readLine()) != null) {
									        
				// 아이디 중복확인
				// 결과 array 배열에 [0]에는 id [1]은 비밀번호가 저장된상황이다
				// 여기서 그후 입력한 텍스트박스에서 입력된 데이터를 가져와서 array[0]을 계속 while문으로 반복해서
				// 전체 데이터를 확인해주고 중복이 발견되릿 return;을 통해서 탈출한다.
				String[] array = check.split("/");
				if(array[0].equals(idtext.getText())){
				JOptionPane.showMessageDialog(null, "아이디 중복입니다");
				return;
				   	}
				 }
				br.close();
				
				} catch (IOException e1) {
				e1.printStackTrace();
					}
				
				} catch (FileNotFoundException e1) {
				e1.printStackTrace();
					}
				
				//id유효정규식 검사 구간
				//matches를 통해서 검사를 해주고 만약 유효한 id라면 idchecking을 1로바꿔줘서 유효한데이터인것을 확인해준다.
				if(idch.matches(idregex)) {
				JOptionPane.showMessageDialog(null, "사용가능한 아이디입니다.");
				idchecking = 1;
					}
				else {
				JOptionPane.showMessageDialog(null, "사용불가능한 아이디입니다.");
			                
			            }
			}
		});
	    
	    //회원가입버튼을 누를시 진행되는 이벤트조건을 설정해준 것
	    //각각 패스워드 정규식,핸드폰 정규식,생년월일 정규식,이름 정규식을 통해 데이터를 확인해준다.
	    
	    sineup.addActionListener(new ActionListener() {
				
			@Override
			public void actionPerformed(ActionEvent e) {
				//정규표현식
				//^는 문자열의 시작 $는 문자열의 마지막을 표시 한것
				//나와도 되는 문자들을[]안에 지정해주고, {}중괄호 안에는 길이의 조건을 준다.
				// 그 후 (정규표현식이 매칭되는지 확인하고싶은 하는 문자열).Matches(정규표현식)을 통해서
				// True 와 false를 받을수 있고, 그 후에 True일떄와 false일떄 각각 다른 결과를 준다.
				
				String pwregex = "^[a-zA-Z\\\\d`~!@#$%^&*()-_=+]{8,24}$";
				//패스워드 조건 a -z A-Z /d는 0~9 문자열들 그리고 최소 길이 8에서 24까지 가능하다는 조건
				String phoneregex = "^01([0|1|6|7|8|9])-?([0-9]{3,4})-?([0-9]{4})$";
				//핸드폰번호 조건:01은 기본 베이스 핸드폰 번호에 등장하는 번호만 조건으로 주고, 뒤에는 0~9인지 확인하고 각각 길이의 조건을 넣어주었다.
				String birthregex = "^([0-9]{2}(0[1-9]|1[0-2])(0[1-9]|[1,2][0-9]|3[0,1]))$";
				//생년월일 조건: 위에 정규식은 19940910 이 아닌 940910 6자리 기준의 정규식조건이고 ,년 월 일 을 계산해서 각각 정규식조건을 넣어주었다.
				String nameregax ="^[가-힣]$";
				//이름 조건:한글로 가~ 힣 까지만 가능하고 예를들어 ㅁㄴㅇㄹ asdf 이런 글자가 등장할시 조건에 부합하지 못하게 설정해주었다.
				
				//회원가입시 첫번쨰 비밀번호와 비밀번호재확인에 입력한 번호가 동일한지 확인
				//그 후 정상이라면 위에 check변수를 1로 바꿔줌
				//만약 패스워드가 비정상이라면 공백으로 바꿔서 다시 입력하게 요구한다.
				if(passtext.getText().equals(pass2text.getText())) {
					pwcheck=1;
				}else {
					JOptionPane.showMessageDialog(null, "비밀번호랑 비밀번호확인이랑 맞지않습니다");
					passtext.setText("");
					pass2text.setText("");
					pwcheck=0;
				}
				//비밀번호 정규식 검사
				if(passtext.getText().matches(pwregex)) {
					pwcheck=1;
				}else {
					JOptionPane.showMessageDialog(null, "비밀번호는 8자리이상 대문자 소문자 특수문자가 포함되어야합니다.");
					passtext.setText("");
					pass2text.setText("");
					pwcheck=0;
				}
				
				//핸드폰번호 정규식검사
				if(phonetext.getText().matches(phoneregex)) {
					phonecheck=1;
				}else {
					JOptionPane.showMessageDialog(null, "핸드폰번호를 확인해주세요 하이폰은제외");
					phonetext.setText("");
					
				}
				//생년월일 정규식검사
				//원래 이것을 통해 22시가 지나면 미성년자 유무확인용으로 지정해둠
				if(birthtext.getText().matches(birthregex)) {
					birthcheck=1;
				}else {
					JOptionPane.showMessageDialog(null, "생년월일을 확인해주세요");
					birthtext.setText("");
				}
				
				//만약 위에서 아이디확인 버튼을 통하여 검사를 했는지 확인해준다.
				//만약 1이라면 이미 확인항상황이고,0이라면 확인하지 않거나,위에서 중복검사나 정규식검사를 통과하지 못한상황
				if(idchecking ==0) {
					JOptionPane.showMessageDialog(null, "아이디를 다시 확인해주세요");
				}
				
				//이름 정규식 검사
				if(nametext.getText().matches(nameregax)) {
					namecheck =1;
				}
				else {
					JOptionPane.showMessageDialog(null, "이름을 다시 확인해주세요");
					nametext.setText("");
				}
				
				//위에 정상동작 유무로 선언한 변수들을 마지막으로 확인하여 다정상인지 확인
				//그후 저장할 파일을 선언해주고 true를 통해서 데이터가 덮어지지말고 누적되게 함
				//그후 "/"를 통해서 데이터를 구분해줘서 저장해준다
				//그리고 마지막에 "\r\n을 통해 줄바꿈을 통하여 readline으로 읽기 용이하게 만듬
				
				if(pwcheck==1&&idchecking==1&&phonecheck==1&&birthcheck==1&&namecheck==1) {
					try {
						BufferedWriter bw = new BufferedWriter(new FileWriter("userinfo.txt", true));
						 bw.write(idtext.getText() + "/");
                         bw.write(passtext.getText() + "/");
                         bw.write(nametext.getText() + "/");
                         bw.write(phonetext.getText() + "/");
                         bw.write(birthtext.getText() + "\r\n");
                         bw.close();
                         
                         //모든것이 정상이고 회원가입이 완료된 후
                         //dispose를 통하여 현재 화면만 자동으로 닫아지게해줌
                         JOptionPane.showMessageDialog(null,"회원가입이 완료되었습니다.");
                         dispose();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
		        }
			}
		});
	    //취소버튼 누를시 이벤트
	    //현재 화면이 닫혀서 그전 초기화면이 보이게해줌
	    cancel.addActionListener(new ActionListener() {  
			
			@Override
			public void actionPerformed(ActionEvent e) {
					dispose();
			}
		});
	}
	 	
	 
	 
	
	 public static void main(String[] args) {
		 
	        new Account();
	
	 }
	

}
