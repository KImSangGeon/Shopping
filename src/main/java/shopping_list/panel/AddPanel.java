package shopping_list.panel;

import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SpinnerModel;
import javax.swing.JSpinner;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeListener;

import shopping.dto.Product;
import shopping.exception.InvaildCheckException;

import javax.swing.SpinnerNumberModel;
import java.awt.Font;

public class AddPanel extends JPanel {
	private JTextField tfPcode;
	private JSpinner spStock;
	private JSpinner spPrice;
	private JTextField tfPname;

	
	public AddPanel() {

		initialize();
	}
	private void initialize() {
		setLayout(new GridLayout(0, 2, 0, 5));
		
		JLabel lblPcode = new JLabel("제품코드");
		lblPcode.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblPcode);
		
		tfPcode = new JTextField();
		tfPcode.setFont(new Font("굴림", Font.PLAIN, 20));
		tfPcode.setHorizontalAlignment(SwingConstants.RIGHT);
		add(tfPcode);
		tfPcode.setColumns(10);
		
		JLabel lblPname = new JLabel("제품명");
		lblPname.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblPname);
		
		tfPname = new JTextField();
		tfPname.setFont(new Font("굴림", Font.PLAIN, 20));
		tfPname.setHorizontalAlignment(SwingConstants.RIGHT);
		tfPname.setColumns(10);
		add(tfPname);
		
		JLabel lblPrice = new JLabel("단가");
		lblPrice.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblPrice);
		
		spPrice = new JSpinner();
		spPrice.setFont(new Font("굴림", Font.PLAIN, 20));
		spPrice.setModel(new SpinnerNumberModel(10000, 5000, 2000000, 1000));
		add(spPrice);
		
		JLabel lblStock = new JLabel("재고");
		lblStock.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblStock);
		
		spStock = new JSpinner();
		spStock.setFont(new Font("굴림", Font.PLAIN, 20));
		spStock.setModel(new SpinnerNumberModel(5, 1, 100, 1));
		add(spStock);
	}
	private void validCheck(){
		if (tfPcode.getText().equals("") || tfPname.getText().equals("")){
			throw new InvaildCheckException();
		}
	}
	public Product getProduct() {
		validCheck();
		String pCode = tfPcode.getText().trim();
		String pName = tfPname.getText().trim();
		int price = (int)spPrice.getValue();
		int stock = (int)spStock.getValue();		
		return new Product(pCode, pName, price, stock);
	}
	
	public void setProduct() {
		tfPcode.setText("");
		tfPname.setText("");
		spPrice.setModel(new SpinnerNumberModel(0, 0, 2000000, 1000));
		spStock.setModel(new SpinnerNumberModel(0, 0, 100, 1));
	}

}
