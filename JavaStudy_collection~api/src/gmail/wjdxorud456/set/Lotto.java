package gmail.wjdxorud456.set;

import java.util.ArrayList;
import java.util.Random;
import java.util.TreeSet;

public class Lotto {
	
	public static void main(String[] args) {
		
		Random r = new Random();
		
		//ArrayList활용
		ArrayList <Integer> a1 = new ArrayList<>();
		
		while(a1.size() <6) {
			//1 ~45 까지의 숫자를 랜덤하게 추출
			int su = r.nextInt(45) +1;
			//중복 검사를 해서 통과하면 add하고 통과하지 못하면 add 수행하지 않음
			if(a1.contains(su)) {
				continue;
			}
			a1.add(su);
		}
		//출력하기 전에 정렬
		a1.sort(null);
		
		System.out.println(a1);
		
		//TreeSet: 중복된 데이터를 저장하지 않고 저장된 순서를 기억합니다.
		TreeSet <Integer> treeset = new TreeSet<>();
		while(treeset.size() <6) {
			//1 ~45 까지의 숫자를 랜덤하게 추출
			int su = r.nextInt(45) +1;
			//TreeSEt은 중복된 데이터를 저장하지 않기 때문에 검사할 필요가 없음
			treeset.add(su);
		}
		for(Integer i : treeset) {
			System.out.print(i + "\t");
		}
	}

}
