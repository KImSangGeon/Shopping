package shopping.customerbuy;

import javax.swing.SwingConstants;

import shopping.dto.Product;
import shopping.dto.Sales;
import shopping.exception.NotSelectedException;
import shopping.service.ProductService;
import shopping_list.panel.AbstractCustomTablePanel;

@SuppressWarnings("serial")
public class CustomerBuyPanel extends AbstractCustomTablePanel<Product> {
		private ProductService service;
		private CustomerTopPanel customTop;//
		
		
		public CustomerTopPanel getCustomTop() {
			return customTop;
		}

		public void setCustomTop(CustomerTopPanel customTop) {
			this.customTop = customTop;
		}

	@Override
	public Product getItem() {
		int row = table.getSelectedRow();
		String pCode = (String)table.getValueAt(row, 0);
		if(row == -1) {
			throw new NotSelectedException();
		}
		return list.get(list.indexOf(new Product(pCode)));
	}

	@Override
	public void initList() {
		list = service.selectByProductAll();
	}
	public void setService(ProductService service) {
		this.service = service;
	}

	@Override
	public String[] getColumnNames() {
		return new String[] {"제품코드", "제품명", "가격", "재고"};
	}

	@Override
	protected void setAlignAndWidth() {
		setTableCellAlign(SwingConstants.CENTER, 0, 1, 3);
		setTableCellAlign(SwingConstants.RIGHT, 2);
		setTableCellWidth(100, 150, 200, 100);		
	}

	@Override
	protected Object[] toArray(Product t) {
		return new Object[] {
				t.getpCode(), t.getpName(),
				String.format("%,d", t.getPrice()),
				String.format("%,d", t.getStock())
				};
	}

}
