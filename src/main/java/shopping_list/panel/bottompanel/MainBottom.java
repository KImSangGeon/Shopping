package shopping_list.panel.bottompanel;

import java.awt.GridLayout;
import java.text.DecimalFormat;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import shopping.dto.Sales;
import shopping.service.SalesService;

public class MainBottom extends JPanel {
	private JLabel lblROrderNum;
	private JLabel lblRSales;
	private SalesService service;
	

	private DecimalFormat df = new DecimalFormat("#,###원");
	

	public MainBottom() {
		service = new SalesService();
		initialize();
		setOrderNum();
		setTotalSales();
	}
	private void initialize() {
		setLayout(new GridLayout(0, 4, 0, 0));
		
		JLabel lblOrderNum = new JLabel("총 주문수량");
		lblOrderNum.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblOrderNum);
		
		lblROrderNum = new JLabel();
		lblROrderNum.setHorizontalAlignment(SwingConstants.RIGHT);
		add(lblROrderNum);
		
		JLabel lblSales = new JLabel("총 판매액 ");
		lblSales.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblSales);
		
		lblRSales = new JLabel();
		lblRSales.setHorizontalAlignment(SwingConstants.RIGHT);
		add(lblRSales);
		
		
	}
	public void setTotalSales() {
		List<Sales> saleList = service.showMainList();
		int totalSales = saleList.parallelStream().mapToInt(Sales::getSaleAmount).sum();
		lblRSales.setText(df.format(totalSales));
	}
	public void setOrderNum() {
		List<Sales> saleList = service.showMainList();
		int totalOrderNum = saleList.parallelStream().mapToInt(Sales::getOrderNum).sum();
		lblROrderNum.setText(totalOrderNum + "건");
	}

}
