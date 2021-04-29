package shopping_list.panel;

import javax.swing.SwingConstants;

import shopping.dto.Sales;
import shopping.exception.NotSelectedException;
import shopping.service.SalesService;

public class DetailPanel extends AbstractCustomTablePanel<Sales> {

	private SalesService service;
	@Override
	public Sales getItem() {
		int row = table.getSelectedRow();
		int orderNo = (int)table.getValueAt(row, 1);
		
		if(row == -1) {
			throw new NotSelectedException();
		}
		return list.get(list.indexOf(new Sales(orderNo)));
	}

	@Override
	public void initList() {
		list = service.showDetailList();
	}
	public void setService(SalesService service) {
		this.service = service;
	}
//	date, order_no,  p_code, p_name, ID,cu_no, cu_name, order_num, price,Total_Sales, Profit_Cost
	@Override
	public String[] getColumnNames() {
		return new String[] {"날짜", "주문번호", "제품코드", "제품명", "아이디", 
				"고객번호", "고객이름", "주문수량", "단가", "판매액","이익금액"};
	}

	@Override
	protected void setAlignAndWidth() {
		setTableCellAlign(SwingConstants.CENTER, 0, 1, 2, 3, 4, 5, 6, 7);
		setTableCellAlign(SwingConstants.RIGHT, 8, 9, 10);
		setTableCellWidth(270, 100, 110, 150, 150, 150, 110, 100, 220, 220, 220);
		
	}

	@Override
	protected Object[] toArray(Sales t) {
		return new Object[] {
				t.getDate(), t.getOrderNo(), t.getpCode(),
				t.getpCode().getpName(),
				t.getCuNo().getId(), t.getCuNo().getCuNo(),
				t.getCuNo().getCuName(), t.getOrderNum(),
				String.format("%,d", t.getpCode().getPrice()),
				String.format("%,d", t.getSaleAmount()),
				String.format("%,d", t.getProfit())				
				};
	}

}
