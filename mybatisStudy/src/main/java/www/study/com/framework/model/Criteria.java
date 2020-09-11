package www.study.com.framework.model;

import lombok.Data;

@Data
public class Criteria {
	private static final float PAGING_BTN_COUNT = 10.0f;
	
	protected int pageNo;
	protected int amount;
	
	private int startPage, endPage, total;
	
	private boolean prev, next;
	
	public Criteria() {
		this(1,10);
	}
	
	public Criteria(Criteria other,int tot) {//넘겨야하는 객체안에서 변경사항을 관리하는 방법, 객체 안의 생성자에서 생성자의 변경점을 관리함.
		this.pageNo = other.pageNo;
		this.amount = other.amount;
		calc(tot);
	}

	public Criteria(int pageNo, int amount) {
		this.pageNo = pageNo;
		this.amount = amount;
	}
	
	public Criteria(int pageNo, int amount,int tot) {
		this(pageNo,amount);
		calc(tot);
	}

	private void calc(int tot) {
		total = tot;
		
		endPage= pageNo + (int)(PAGING_BTN_COUNT / 2 - 1); //  현재페이지 기준 + 4 만큼의 엔드페이지 번호 설정
		
//		endPage = (int)(Math.ceil(pageNo / PAGING_BTN_COUNT) * PAGING_BTN_COUNT); 10개식 고정방식.
		startPage = endPage - ((int)PAGING_BTN_COUNT -1);
		if(startPage < 1) {// 마지막 페이지 번호 변경으로 인한 제어
			startPage = 1;
		}
		
		int realEnd = (int)(Math.ceil((float)total / amount));
		
		if(realEnd < endPage) {
			endPage = realEnd;
		}
		
		prev = 1 < startPage;
		next = endPage < realEnd;
		
	}
	
	
}
