package shopping_list.panel;

import javax.swing.SwingConstants;

import shopping.dto.Sales;
import shopping.exception.NotSelectedException;
import shopping.service.SalesService;

@SuppressWarnings("serial")
public class ProductPanel extends AbstractCustomTablePanel<Sales> {
	
	private SalesService service;

	@Override
	public Sales getItem() {
		int row = table.getSelectedRow();
		int cuNo = (int)table.getValueAt(row, 1);
		
		if(row == -1) {
			throw new NotSelectedException();
		}
		return list.get(list.indexOf(new Sales(cuNo)));
	}
	
	public void setService(SalesService service) {
		this.service=service;
	}
	@Override
	public void initList() {
		list = service.showProdcutList();
		
	}
//	date, cu_no, p_code, p_name, order_num, price, "Total_Sales, Profit_Cost
	@Override
	public String[] getColumnNames() {
		return new String[] {"날짜", "고객번호", "제품코드", "제품명", "주문수량", "단가", "판매액", "이익금액"};
	}

	@Override
	protected void setAlignAndWidth() {
		 setTableCellAlign(SwingConstants.CENTER, 0, 1, 2, 3, 4, 5, 6, 7);
		 setTableCellWidth(270, 150, 110, 150, 100, 220, 220, 200);		
	}

	@Override
	protected Object[] toArray(Sales t) {
		return new Object[] {t.getDate(), t.getCuNo().getCuNo(), t.getpCode(), t.getpCode().getpName(), 
				t.getOrderNum(), t.getpCode().getPrice(), t.getSaleAmount(), t.getProfit()};
	}

}
