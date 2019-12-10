package skillup.collection.list.controller;

import java.util.Comparator;

import skillup.collection.list.model.Score;

public class ScoreSorting implements Comparator{

	@Override
	public int compare(Object o1, Object o2) {
		//점수로 기본 정렬... 오름차순
		int other1 = ((Score)o1).getScore();
		int other2 = ((Score)o2).getScore();
		
		if(other1 > other2) {
			return 1;
			//1이면 오른쪽으로 간다. other1이 크다면 오른쪽으로 보내겠죠?? 그러니 1리턴
			//return -1; 
			//-1 을리턴 하면 내림차순이겟져? 큰게 왼쪽으로...
			
			
		} else if(other1 < other2) {
			return 0;
		} else {
			return -1;
		}
	}
	//테스트로 돌아간다~
}
