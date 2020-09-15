package www.study.com.framework.model;

import lombok.Data;

@Data
public class Criteria {
	//Page navigation button을 총 몇개로 설정할지...
	private static final float PAGING_BTN_CNT = 10;
	protected int pageNo;
	protected int amount;
	
	private int startPage, endPage, total;
	private boolean prev, next;
	
	public Criteria() {
		this(1, 10);
	}

	public Criteria(int pageNo, int amount) {
		this.pageNo = pageNo;
		this.amount = amount;
	}

	public Criteria(Criteria other, int tot) {
		this.pageNo = other.pageNo;
		this.amount = other.amount;
		
		calc(tot);
	}

	public Criteria(int pageNo, int amount, int tot) {
		this.pageNo = pageNo;
		this.amount = amount;
		
		calc(tot);
	}

	private void calc(int tot) {
		total = tot;

		//endPage = (int) (Math.ceil(pageNo / PAGING_BTN_CNT) * PAGING_BTN_CNT); 10, 20, 30 끊어 처리

		endPage = pageNo + (int) (PAGING_BTN_CNT / 2) - 1;	//현재의 내가 중앙에 올 것이야
		startPage = endPage - ((int) PAGING_BTN_CNT - 1);
		if (startPage < 1)
			startPage = 1;
		int realEnd = (int) (Math.ceil((float) total / amount));
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