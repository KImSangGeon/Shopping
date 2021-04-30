package shopping_list.panel;

import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
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
import java.awt.Graphics2D;

public class AddPanel extends JPanel {
	private JTextField tfPcode;
	private JSpinner spStock;
	private JSpinner spPrice;
	private JTextField tfPname;
	private TopPicProduct topPic;
	//

	//
	public TopPicProduct getTopPic() {
		return topPic;
	}

	public void setTopPic(TopPicProduct topPic) {
		this.topPic = topPic;
	}

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
		byte[] pic = getImage();
		return new Product(pCode, pName, price, stock, pic);
	}
	
	private byte[] getImage() {		
		try(ByteArrayOutputStream baos = new ByteArrayOutputStream()){
			ImageIcon icon = (ImageIcon)topPic.getLblPic().getIcon();
			System.out.println(topPic.getLblPic());
			System.out.println(icon);
			BufferedImage bi = new BufferedImage(icon.getIconWidth(), icon.getIconHeight(), BufferedImage.TYPE_INT_RGB);
			//이미지 생성, 만들어주기   icon-> image
			Graphics2D g2 = bi.createGraphics();
			g2.drawImage(icon.getImage(), 0, 0, null);
			g2.dispose();
			//입출력
			ImageIO.write(bi, "png", baos);
			return baos.toByteArray();	
		} catch (Exception e) {
		e.printStackTrace();
	}
	return null;
}	
	
	public void setProduct() {
		tfPcode.setText("");
		tfPname.setText("");
		spPrice.setModel(new SpinnerNumberModel(0, 0, 2000000, 1000));
		spStock.setModel(new SpinnerNumberModel(0, 0, 100, 1));
	}

}
