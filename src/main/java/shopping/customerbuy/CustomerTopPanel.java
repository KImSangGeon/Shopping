package shopping.customerbuy;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.text.DecimalFormat;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import shopping.dto.Product;
import shopping.exception.InvaildCheckException;
import shopping.service.ProductService;

@SuppressWarnings("serial")
public class CustomerTopPanel extends JPanel implements ChangeListener  {
	private JLabel lblPic;
	private JLabel lblRpname;
	private JLabel lblRprice;
	private JSpinner spStock;
	private JLabel lblRTotal;
	
	private DecimalFormat df = new DecimalFormat("#,###원");	
	private ProductService service;
	private JLabel lblRPcode;
	
	public CustomerTopPanel() {
		service= new ProductService();

		initialize();
	}
	private void initialize() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel pPic = new JPanel();
		add(pPic, BorderLayout.CENTER);
		pPic.setLayout(new GridLayout(0, 2, 0, 0));
		
		lblPic = new JLabel("New label");
		lblPic.setHorizontalAlignment(SwingConstants.CENTER);
		pPic.add(lblPic);
		
		JPanel pContents = new JPanel();
		pPic.add(pContents);
		pContents.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblPcode = new JLabel("제품코드");
		lblPcode.setHorizontalAlignment(SwingConstants.CENTER);
		pContents.add(lblPcode);
		
		lblRPcode = new JLabel("");
		lblRPcode.setHorizontalAlignment(SwingConstants.RIGHT);
		lblRPcode.setEnabled(false);
		pContents.add(lblRPcode);
		
		JLabel lblPname = new JLabel("제품명");
		lblPname.setHorizontalAlignment(SwingConstants.CENTER);
		pContents.add(lblPname);
		
		lblRpname = new JLabel("");
		lblRpname.setHorizontalAlignment(SwingConstants.RIGHT);
		pContents.add(lblRpname);
		
		JLabel lblPrice = new JLabel("가격");
		lblPrice.setHorizontalAlignment(SwingConstants.CENTER);
		pContents.add(lblPrice);
		
		lblRprice = new JLabel("");
		lblRprice.setHorizontalAlignment(SwingConstants.RIGHT);
		pContents.add(lblRprice);
		
		JLabel lblStock = new JLabel("수량");
		lblStock.setHorizontalAlignment(SwingConstants.CENTER);
		pContents.add(lblStock);
		
		spStock = new JSpinner();
		spStock.setModel(new SpinnerNumberModel(0, 0, 500, 1));
		spStock.addChangeListener(this);
		pContents.add(spStock);
		
		JLabel lblTotal = new JLabel("구매금액");
		lblTotal.setHorizontalAlignment(SwingConstants.CENTER);
		pContents.add(lblTotal);
		
		lblRTotal = new JLabel("");
		lblRTotal.setHorizontalAlignment(SwingConstants.RIGHT);
		pContents.add(lblRTotal);
		
		
		
	}
	private void vaildCheck() {
		if(lblRpname.getText().equals("") || lblRprice.getText().equals(0) ||
				spStock.getValue().equals(0) ) {
			throw new InvaildCheckException();
		}
	}
	public void setItem(Product p) {
		lblRPcode.setText(p.getpCode().trim());
		lblRpname.setText(p.getpName().trim());
		lblRprice.setText(p.getPrice() + "");
		spStock.setValue(1);
	}


	public void stateChanged(ChangeEvent e) {
		if (e.getSource() == spStock) {
			stateChangedSpStock(e);
		}
	}
	protected void stateChangedSpStock(ChangeEvent e) {	
		lblRTotal.setText(df.format(
				(int)(Integer.parseInt(lblRprice.getText())
						*(int)spStock.getValue()))+"");

	}
}
