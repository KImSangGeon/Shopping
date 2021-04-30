package shopping_list.panel;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.BoxLayout;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TopPicProduct extends JPanel {
	private JLabel lblPic;
	private JButton btnPic;
	
	private static TopPicProduct instance = new TopPicProduct();
	
	
	public static TopPicProduct getInstance() {
		return instance;
	}
	public TopPicProduct() {
		

		initialize();
	}
	private void initialize() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel pTop = new JPanel();
		add(pTop, BorderLayout.CENTER);
		
		JPanel pPic = new JPanel();
		pTop.add(pPic);
		pPic.setLayout(new BorderLayout(0, 0));
		
		lblPic = new JLabel("New label");
		lblPic.setHorizontalAlignment(SwingConstants.CENTER);
		lblPic.setPreferredSize(new Dimension(150, 180));
		pPic.add(lblPic);
		
		btnPic = new JButton("사진 추가");
		pPic.add(btnPic, BorderLayout.SOUTH);
	}
	public JLabel getLblPic() {
		return lblPic;
	}
	public void setLblPic(JLabel lblPic) {
		this.lblPic = lblPic;
	}
	public JButton getBtnPic() {
		return btnPic;
	}
	public void setBtnPic(JButton btnPic) {
		this.btnPic = btnPic;
	}
	
}
