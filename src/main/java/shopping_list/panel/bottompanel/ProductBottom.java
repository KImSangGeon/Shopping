package shopping_list.panel.bottompanel;

import java.awt.GridLayout;
import java.text.DecimalFormat;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import shopping.dto.Sales;
import shopping.service.SalesService;

@SuppressWarnings("serial")
public class ProductBottom extends JPanel {
	private SalesService service;	
	private JLabel lblROrderNum;
	private JLabel lblRProfit;
	
	private DecimalFormat df = new DecimalFormat("#,###원");
	private List<Sales> saleList;
	
	public ProductBottom() {
		service = new SalesService();
		saleList = service.showProdcutList();
		initialize();
		//메서드 소환
		setBottomProduct();
	}
	private void initialize() {
		setLayout(new GridLayout(0, 4, 0, 0));
		
		JLabel lblOrderNum = new JLabel("총 주문수량");
		lblOrderNum.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblOrderNum);
		
		lblROrderNum = new JLabel();
		lblROrderNum.setHorizontalAlignment(SwingConstants.RIGHT);
		add(lblROrderNum);
		
		JLabel lblProfit = new JLabel("총 이익금액");
		lblProfit.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblProfit);
		
		lblRProfit = new JLabel();
		lblRProfit.setHorizontalAlignment(SwingConstants.RIGHT);
		add(lblRProfit);
	}
	
	public JLabel getlblOrderNum() {
		return lblROrderNum;
	}
	
	public JLabel getlblProfit() {
		return lblRProfit;
	}
	public void setBottomProduct() {
		int totalSales = saleList.parallelStream().mapToInt(Sales::getProfit).sum();
		lblRProfit.setText(df.format(totalSales));
		
		int totalOrder = saleList.parallelStream().mapToInt(Sales::getOrderNum).sum();
		lblROrderNum.setText(totalOrder +"건");
	}
	

}
