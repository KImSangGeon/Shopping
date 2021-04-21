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
public class MainBottom extends JPanel {
	private JLabel lblROrderNum;
	private JLabel lblRSales;
	private SalesService service;
	

	private DecimalFormat df = new DecimalFormat("#,###원");
	private List<Sales> saleList;
	

	public MainBottom() {
		service = new SalesService();
		saleList = service.showMainList();
		initialize();
		
		setBottomMain();	
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
	public JLabel getlblOrderNum() {
		return lblROrderNum;
	}
	public JLabel getlblSales() {
		return lblRSales;
	}
	
	public void setBottomMain() {
		int totalSales = saleList.parallelStream().mapToInt(Sales::getSaleAmount).sum();
		lblRSales.setText(df.format(totalSales));
		
		int totalOrderNum = saleList.parallelStream().mapToInt(Sales::getOrderNum).sum();
		lblROrderNum.setText(totalOrderNum + "건");
				
	}	

}
