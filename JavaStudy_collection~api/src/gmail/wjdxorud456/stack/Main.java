package gmail.wjdxorud456.stack;

import java.util.Date;
import java.util.Stack;

public class Main {
	
	public static void main(String[] args) {
		//PersonVo 클래의 인스턴스를 저장할 수 있는 Stack를 생성
		Stack <PersonVO> stack = new Stack<>();
		//Stack에 데이터 저장 - push
		stack.push(new PersonVO(1, "카리나" , new Date(100,3,11) , 
				"01011112222"));
		stack.push(new PersonVO(1, "민지" , new Date(104,5,7,0,0) , 
				"01033334444"));
		
		//Stack에서 데이터 꺼내기
		
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		
		//데이터가 2개 존재해서 2번 pop을 하며 모두 제거된 상태인데
		//pop을 수행해서 UnderFlow 발생 -프로그램에서는 예외 발생
//		System.out.println(stack.pop());
	}

}
