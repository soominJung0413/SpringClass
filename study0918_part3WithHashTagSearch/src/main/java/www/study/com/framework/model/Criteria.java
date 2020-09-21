package www.study.com.framework.model;

import lombok.Data;

@Data
public class Criteria {
	//Page navigation button을 총 몇개로 설정할지...
	private static final float PAGING_BTN_CNT = 10;
	private static final int AMOUNT_PER_PAGE = 13;

	protected int pageNo;
	
	private int startPage, endPage;
	private long total;
	private boolean prev, next;
	
	public Criteria() {
		this(1);
	}

	public Criteria(int pageNo) {
		this.pageNo = pageNo;
	}

	public Criteria(Criteria other, long tot) {
		this.pageNo = other.pageNo;
		
		calc(tot);
	}

	public Criteria(int pageNo, int tot) {
		this.pageNo = pageNo;
		
		calc(tot);
	}

	private void calc(long tot) {
		total = tot;

		//endPage = (int) (Math.ceil(pageNo / PAGING_BTN_CNT) * PAGING_BTN_CNT); 10, 20, 30 끊어 처리

		endPage = pageNo + (int) (PAGING_BTN_CNT / 2) - 1;	//현재의 내가 중앙에 올 것이야
		if (endPage < (int) PAGING_BTN_CNT)
			endPage = (int) PAGING_BTN_CNT;				//너무 앞쪽이면 뒤를 충분히 활용 할 것이야.
		startPage = endPage - ((int) PAGING_BTN_CNT - 1);
		if (startPage < 1)
			startPage = 1;
		int realEnd = (int) (Math.ceil((float) total / AMOUNT_PER_PAGE));
		if (endPage > realEnd)
			endPage = realEnd;
		prev = startPage > 1;
		next = endPage < realEnd;
	}
}

/*
DTO : data transfer object
화면...controller  사이에서...
*/