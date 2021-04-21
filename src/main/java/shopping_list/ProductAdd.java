package shopping_list;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import shopping.ui.TabbedUi;
import shopping_list.panel.AddPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ProductAdd extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JButton btnCancel;
	private JButton btnReset;
	private AddPanel pItem;
	


	public ProductAdd() {
		initialize();
	}
	private void initialize() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		pItem = new AddPanel();
		contentPane.add(pItem, BorderLayout.CENTER);
		
		JPanel pBtns = new JPanel();
		contentPane.add(pBtns, BorderLayout.SOUTH);
		
		JButton btnAdd = new JButton("추가");
		pBtns.add(btnAdd);
		
		btnReset = new JButton("초기화");
		btnReset.addActionListener(this);
		pBtns.add(btnReset);
		
		btnCancel = new JButton("취소");
		btnCancel.addActionListener(this);
		pBtns.add(btnCancel);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnReset) {
			actionPerformedBtnReset(e);
		}
		if (e.getSource() == btnCancel) {
			actionPerformedBtnCancel(e);
		}
	}
	protected void actionPerformedBtnCancel(ActionEvent e) {
		setVisible(false);
		TabbedUi frame = new TabbedUi();
		frame.setVisible(true);		
		
	}
	protected void actionPerformedBtnReset(ActionEvent e) {
		pItem.setPanel();
	}
}
