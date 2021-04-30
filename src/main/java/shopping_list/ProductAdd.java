package shopping_list;

import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import shopping.dto.Product;
import shopping.exception.InvaildCheckException;
import shopping.exception.SqlConstraintException;
import shopping.service.ProductService;
import shopping.ui.TabbedUi;
import shopping_list.panel.AddPanel;
import shopping_list.panel.TopPicProduct;

public class ProductAdd extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JButton btnCancel;
	private JButton btnReset;
	private AddPanel pItem;
	private JButton btnAdd;
	private ProductService service;
	private TopPicProduct pTop;
	
	private String imgPath = System.getProperty("user.dir") + File.separator + "images" + File.separator;
	private JFileChooser chooser = new JFileChooser(System.getProperty("user.dir"));


	public ProductAdd() {
		service = new ProductService();
		initialize();
		loadPic(null);
		pItem.setTopPic(pTop);
	}
	private void loadPic(String imgFilePath) {
		Image changeImageIcon = null;
		if(imgFilePath == null) {
			ImageIcon icon = new ImageIcon(imgPath + "NoImage.jpg");
			changeImageIcon = icon.getImage().getScaledInstance(150, 180, Image.SCALE_SMOOTH);
		}else {
			ImageIcon icon = new ImageIcon(imgFilePath);
			changeImageIcon = icon.getImage().getScaledInstance(150, 180, Image.SCALE_SMOOTH);
		}
		ImageIcon changeIcon = new ImageIcon(changeImageIcon);
		pTop.getLblPic().setIcon(changeIcon);
		
	}
	private void initialize() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(650, 300, 600, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		pItem = new AddPanel();
		contentPane.add(pItem, BorderLayout.CENTER);
		
		JPanel pBtns = new JPanel();
		contentPane.add(pBtns, BorderLayout.SOUTH);
		
		btnAdd = new JButton("추가");
		btnAdd.addActionListener(this);
		pBtns.add(btnAdd);
		
		btnReset = new JButton("초기화");
		btnReset.addActionListener(this);
		pBtns.add(btnReset);
		
		btnCancel = new JButton("취소");
		btnCancel.addActionListener(this);
		pBtns.add(btnCancel);
		
		pTop = new TopPicProduct();
		pTop.getBtnPic().addActionListener(this);
		
		contentPane.add(pTop, BorderLayout.NORTH);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == pTop.getBtnPic()) {
			actionPerformedPTopBtnPic(e);
		}
		try {
			if (e.getSource() == btnAdd) {
				actionPerformedBtnAdd(e);
			}
		}catch (SqlConstraintException e1) {			
			JOptionPane.showMessageDialog(null, "이미 등록된 제품입니다", "등록오류", JOptionPane.ERROR_MESSAGE);
		}catch (InvaildCheckException e2) {
			JOptionPane.showMessageDialog(null, "빈칸이 있습니다", "등록오류", JOptionPane.ERROR_MESSAGE);
		}
		
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
		pItem.setProduct();
	}
	
	protected void actionPerformedBtnAdd(ActionEvent e) {
		Product newProduct = pItem.getProduct();
		service.insertProduct(newProduct);
		pItem.setProduct();
		JOptionPane.showMessageDialog(null, "제품 등록 ", "확인", JOptionPane.INFORMATION_MESSAGE);
	}
	protected void actionPerformedPTopBtnPic(ActionEvent e) {
		FileNameExtensionFilter filter = 
				new FileNameExtensionFilter("JPG & PNG & GIF images", "jpg", "png", "gif");
		
		chooser.setFileFilter(filter);
		chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		
		int res = chooser.showOpenDialog(null);
		if(res != JFileChooser.APPROVE_OPTION) {
			JOptionPane.showMessageDialog(null, "파일을 선택하지 않았음", "경고", JOptionPane.WARNING_MESSAGE);
			return;
		}
		String chooserFilePath = chooser.getSelectedFile().getPath();
		loadPic(chooserFilePath);
		
		
	}
}
