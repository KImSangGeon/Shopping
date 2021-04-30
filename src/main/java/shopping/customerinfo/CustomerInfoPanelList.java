package shopping.customerinfo;

import java.util.List;

import javax.swing.SwingConstants;

import shopping.dto.Sales;
import shopping.exception.NotSelectedException;
import shopping.service.SalesService;
import shopping_list.panel.AbstractCustomTablePanel;

@SuppressWarnings("serial")
public class CustomerInfoPanelList extends AbstractCustomTablePanel<Sales> {
	public CustomerInfoPanelList() {}

	private SalesService service;
	@Override
	public Sales getItem() {
		int row = table.getSelectedRow();
		int orderNo = (int)table.getValueAt(row, 0);
		System.out.println(row);
		System.out.println(orderNo);
		if(row == -1) {
			throw new NotSelectedException();
		}
		return list.get(list.indexOf(new Sales(orderNo)));
	}

	@Override
	public void initList() {}
	
	public void initList2(List<Sales> sales) {
		list = sales;	
		setList();
		}
	
	public void setSerive(SalesService service) {
		this.service = service;
	}

	@Override
	public String[] getColumnNames() {
		return new String[]{"주문번호", "제품코드", "제품명", "주문수량", "소비자가격", "구매금액"} ;
	}

	@Override
	protected void setAlignAndWidth() {
		setTableCellAlign(SwingConstants.CENTER, 0, 1, 2, 3);
		setTableCellAlign(SwingConstants.RIGHT, 4, 5);
		setTableCellWidth(100, 100, 150, 100, 200, 200);		
	}


	@Override
	protected Object[] toArray(Sales t) {
		return new Object[] {
				t.getOrderNo(),	t.getpCode().getpCode(), t.getpCode().getpName(),
				t.getOrderNum(),
				String.format("%,d", t.getpCode().getPrice()),
				String.format("%,d", t.getCustomerPrice())
				};
	}

}
