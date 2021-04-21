package shopping_list.panel;

import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SpinnerModel;
import javax.swing.JSpinner;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeListener;
import javax.swing.SpinnerNumberModel;

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
		tfPcode.setHorizontalAlignment(SwingConstants.RIGHT);
		add(tfPcode);
		tfPcode.setColumns(10);
		
		JLabel lblPname = new JLabel("제품명");
		lblPname.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblPname);
		
		tfPname = new JTextField();
		tfPname.setHorizontalAlignment(SwingConstants.RIGHT);
		tfPname.setColumns(10);
		add(tfPname);
		
		JLabel lblPrice = new JLabel("단가");
		lblPrice.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblPrice);
		
		spPrice = new JSpinner();
		spPrice.setModel(new SpinnerNumberModel(10000, 5000, 2000000, 1000));
		add(spPrice);
		
		JLabel lblStock = new JLabel("재고");
		lblStock.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblStock);
		
		spStock = new JSpinner();
		spStock.setModel(new SpinnerNumberModel(5, 1, 100, 1));
		add(spStock);
	}
	public void setPanel() {
		tfPcode.setText("");
		tfPname.setText("");
		spPrice.setModel(new SpinnerNumberModel(0, 0, 2000000, 1000));
		spStock.setModel(new SpinnerNumberModel(0, 0, 100, 1));
	}

}
