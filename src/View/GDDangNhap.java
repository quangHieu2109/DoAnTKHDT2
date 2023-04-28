package view;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import controller.ControllerDangNhap;

public class GDDangNhap extends APanel {
	ControllerDangNhap ctrDangNhap;
	public GDDangNhap(View view) {
		super(view);
	}

	JButton btnDangNhap;
	JButton btnDangKy;
	
	JLabel lbUserName;
	JLabel lbPass;
	
	JTextField txtUsername;
	JTextField txtPass;
	
	@Override
	public void init() {
		super.init();
		btnDangKy = new JButton("Đăng ký");
		btnDangNhap = new JButton("Đăng nhập");
		lbUserName = new JLabel("Tên đăng nhập:");
		lbPass = new JLabel("Mật khẩu:");
		txtUsername = new JTextField(8);
		txtPass = new JTextField(8);
		
		btnDangKy.setActionCommand("DangKy");
		btnDangNhap.setActionCommand("DangNhap");
		
		lbUserName.setBounds(CHIEURONGFRAME / 2 - LABEL_SIZE_WIDTH - SPACE,
				CHIEUCAOFRAME / 2 - LABEL_SIZE_HEIGHT / 2, LABEL_SIZE_WIDTH, LABEL_SIZE_HEIGHT);
		txtUsername.setBounds(CHIEURONGFRAME / 2 + SPACE, CHIEUCAOFRAME / 2 - TXT_SIZE_HEIGHT / 2, TXT_SIZE_WIDTH,
				TXT_SIZE_HEIGHT);

		lbPass.setBounds(CHIEURONGFRAME / 2 - LABEL_SIZE_WIDTH - SPACE,
				CHIEUCAOFRAME / 2 + LABEL_SIZE_HEIGHT * 2 - SPACE, LABEL_SIZE_WIDTH, LABEL_SIZE_HEIGHT);
		txtPass.setBounds(CHIEURONGFRAME / 2 + SPACE, CHIEUCAOFRAME / 2 + TXT_SIZE_HEIGHT * 2 - SPACE,
				TXT_SIZE_WIDTH, TXT_SIZE_HEIGHT);

		btnDangKy.setBounds(CHIEURONGFRAME / 2 - BTN_SIZE_WIDTH - SPACE, CHIEUCAOFRAME / 2 + LABEL_SIZE_WIDTH - SPACE,
				BTN_SIZE_WIDTH, BTN_SIZE_HEIGHT);
		btnDangNhap.setBounds(CHIEURONGFRAME / 2 + SPACE, CHIEUCAOFRAME / 2 + LABEL_SIZE_WIDTH - SPACE, BTN_SIZE_WIDTH,
				BTN_SIZE_HEIGHT);
		
		
		this.add(btnDangKy);
		this.add(btnDangNhap);
		this.add(lbPass);
		this.add(lbUserName);
		this.add(txtUsername);
		this.add(txtPass);
		
		
		btnOut.setVisible(false);
		
	}

	public JTextField getTxtUsername() {
		return txtUsername;
	}

	public JTextField getTxtPass() {
		return txtPass;
	}

	@Override
	public void addAction() {//thêm các sụ kiện cho panel này
		ctrDangNhap = new ControllerDangNhap(this);
		Component[] comps =  this.getComponents();
		for(Component comp : comps) {
			if(comp instanceof JButton) {
				JButton btn = (JButton) comp;
				btn.addActionListener(this);
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand()==btnDangNhap.getActionCommand()) {
			clickBtnDangNhap();
		}
		if(e.getActionCommand()==btnDangKy.getActionCommand()) {
			clickBtnDangky();
		}
		
	}

	public void clickBtnDangNhap() {
		
		if (ctrDangNhap.checkTaiKhoan(txtUsername.getText(), txtPass.getText())){
             if(view.hasPanel("SanhGame")) {//nếu đã có panel sảnh game thì xóa đi
            	 view.removePanel("SanhGame");
             }
             view.addPanel("SanhGame", PanelFactory.createPanel("SanhGame", view));//thêm panel vào ds các panel
             view.setContentPane(view.getPanel("SanhGame"));//set panel vào view
             view.setVisible(true);
             
             ctrDangNhap.setPlayer();
		}
		else {
			JOptionPane.showMessageDialog(this, "Bạn đã nhập sai tài khoản hoặc mật khẩu!");
		}
	}

	public void clickBtnDangky() {
		if(!view.hasPanel("DangKy")) {
			view.addPanel("DangKy",  PanelFactory.createPanel("DangKy", this.getView()));
			
		}
		view.setContentPane(view.getPanel("DangKy"));
		view.setVisible(true);
		

	}
}
