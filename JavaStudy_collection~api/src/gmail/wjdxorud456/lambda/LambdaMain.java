package gmail.wjdxorud456.lambda;

import java.util.Arrays;
import java.util.Comparator;

public class LambdaMain {
	
	public static void main(String[] args) {
		
		//배열의 정렬
				String [] ar = {"아담","강진축구","프리스톤테일","카카오택시"};
			
			//배열의 내림차순 정렬
					//Arrays.sort(배열 , 비교를 위한 Comparator<T> 인터페이스를 구현한 클래스의 객체)
					//를 호출해야 합니다.
					
					Arrays.sort(ar,new Comparator<String>() {
						@Override
						public int compare(String o1, String o2) {
							return o2.compareTo(o1);
						}
					});
					
					//Comparator 인터페이스는 메서드가 1개 밖에 없으므로 람다로 표현하는 것이 가능
					//람다를 만들 때 인터페이스 이름과 메서드 이름은 중요하지 않음
					//매개변수의 개수와 리턴 타입만 확인하면됨
					//Comparator 인터페이스는 매개변수는 2개이고 리턴타입은 정수입니다.
					//매개변수가 1개이면 () 생략 가능
					//return 하는 문장만 존재한다면 {}와 return을 생략하는 것이 가능
					//메서드의 매개변수로 코드(함수)를 대입한 것 처럼 보이도록 함
					//메서드의 매개변수로 코드(함수)를 대입할 수 있는 방식을 함수형 프로그래밍이라고 함
					
					Arrays.sort(ar, (o1 , o2) -> o2.compareTo(o1));
					
					//배열의 요소를 빠르게 확인
					System.out.println(Arrays.toString(ar));
	}
	
}
