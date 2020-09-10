package www.study.com.framework.model;

import lombok.Data;

@Data
public class Criteria {
	private static final float PAGING_BTN_COUNT = 10.0f;
	
	private int pageNo;
	private int amount;
	
	private int startPage, endPage, total;
	
	private boolean prev, next;
	
	public Criteria() {
		this(1,10);
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
