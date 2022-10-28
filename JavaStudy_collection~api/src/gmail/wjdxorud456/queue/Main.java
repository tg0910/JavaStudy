package gmail.wjdxorud456.queue;

import java.util.Comparator;
import java.util.Date;
import java.util.PriorityQueue;

import gmail.wjdxorud456.stack.PersonVO;

public class Main {
	
	public static void main(String[] args) {
		
			//PriorityQueue는 데이터를 정려로딘 순서대로 꺼낼 수 있도록 해주는 클래스
			
		try { // try문을 사용해서 언더플로우 날시 오류문제가뜨게함
			//정수를 저장하는 PriorityQueue를 만들어서 출력
			PriorityQueue<Integer> intQueue = new PriorityQueue<>();
			
			//데이터저장
			intQueue.offer(100);
			intQueue.offer(70);
			intQueue.offer(90);
			
			//데이터 꺼내기 - poll을 쓰면 null값이 돌아와서 예외처리가 힘들어보이는데 remove는 예외가 발생하기때문에 remove를 사용해봄
			System.out.println(intQueue.remove());
			System.out.println(intQueue.remove());
			System.out.println(intQueue.remove());
			
		} catch (Exception e) { //언더플로우나 오버플로우가 날시 범위가 벗어났다고 알려줌
			System.out.println("Queue의 범위를 벗어났습니다");
		}
		
		//PersonVO 클래스를 저장하는 우선순위 큐
		//이상태에서 만들면 PersonVO의 크기 비교를 할 수 없기 때문에 예외 발생
//		PriorityQueue<PersonVO> persons = new PriorityQueue<>();
		
		
		//PersonVO 클래스에 comparable 인터페이스를 implements 하고
		//compareTO 라는 메서드를 재정의해서 해결할 수 있고
		
		
		//기존에 만들어둔 PersonVO클래스를 건드는것은 그전에 동작하던 데이터도 위험할 수 있기 떄문에,      아래의 방법을 추천합니다
		
		//Comparator 인터페이스를 대입받을 수 있는 경우에는 COmparator 인터페이스를
		//구현한 클래스 인스턴스를 이용해서 생성해도 됩니다.
		PriorityQueue<PersonVO> persons = 
				new PriorityQueue<>(new Comparator<PersonVO>() {

					@Override
					public int compare(PersonVO o1, PersonVO o2) {
						return o1.getName().compareTo(o2.getName());   //이름의의 오름차순, 날짜로 비교하는경우에도 compareTo 로 비교가능
					}
		});
		
		persons.offer(new PersonVO(1, "강진추구", new Date(100,9,10), "01011112222"));
		persons.offer(new PersonVO(2, "프리스톤테일", new Date(102,1,3), "01055556666"));
		persons.offer(new PersonVO(3, "아담", new Date(97,1,3), "01033334444"));
		
		System.out.println(persons.remove());
		System.out.println(persons.remove());
		System.out.println(persons.remove());
		
	}

}
