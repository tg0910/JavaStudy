package gmail.wjdxorud456.set;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;

public class SetClassCompare {
	
	public static void main(String[] args) {
		
		//문자열을 저장하는 set 인스턴스 3개 생성
		
		HashSet <String> hashset = new HashSet<>();
		LinkedHashSet <String> linkedHashSet = new LinkedHashSet<>();
		TreeSet <String> treeSet = new TreeSet<>();
		
		hashset.add("LG EDS");
		linkedHashSet.add("LG EDS");
		treeSet.add("LG EDS");
		
		hashset.add("Samsung");
		linkedHashSet.add("Samsung");
		treeSet.add("Samsung");
		
		hashset.add("naver");
		linkedHashSet.add("naver");
		treeSet.add("naver");
		
		hashset.add("33");
		linkedHashSet.add("33");
		treeSet.add("33");
		
		hashset.add("LG EDS");
		linkedHashSet.add("LG EDS");
		treeSet.add("LG EDS");
		
		hashset.add("kakao");
		linkedHashSet.add("kakao");
		treeSet.add("kakao");
		
		
		
		//데이터 출력
		//HashSet
		//HashSet : 어떤 순서로 출력될 지 예측할 수 없음
		for(String company : hashset) {
			System.out.print(company + "\t");
		}
		System.out.println();
		
		//linkedHashSet
		//linkedHashSet: add 한 순서대로 출력됨
		for(String company : linkedHashSet) {
			System.out.print(company + "\t");
		}
		System.out.println();
		
		//treeSet
		//treeSet : 정렬한 순서대로 출력되는데 숫자가 영문자보다 작고 대문자가 소문자보다 작음
		for(String company : treeSet) {
		System.out.print(company + "\t");
		}
		System.out.println();
		
				
		
		
	}

}
