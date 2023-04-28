package view;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import controller.ControllerXiDach;

public class GDGameXiDach extends GDBanGame {
	ControllerXiDach ctrXiDach;
	JButton btnRutBai;
	JButton btnGapBai;
	JButton btnBatDau;
	JLabel lbDatCuoc;
	JTextField txtTienCuoc;
	final int soBaiDuocChia = 2;
	int luotPlayer = 0;// lượt player=0
	int process = 0;// biến hỗ trợ cho độ trễ animation

	public GDGameXiDach(View view) {
		super(view);
		datCuoc();
	}

	@Override
	public void init() {
		super.init();
		lbDatCuoc = new JLabel("Nhập số tiền cược: ");
		txtTienCuoc = new JTextField(8);
		lbDatCuoc.setBounds(CHIEURONGFRAME / 2 - LABEL_SIZE_WIDTH, CHIEUCAOFRAME / 2 - LABEL_SIZE_HEIGHT,
				LABEL_SIZE_WIDTH, LABEL_SIZE_HEIGHT);
		txtTienCuoc.setBounds(CHIEURONGFRAME / 2 + SPACE, CHIEUCAOFRAME / 2 - TXT_SIZE_HEIGHT, TXT_SIZE_WIDTH,
				TXT_SIZE_HEIGHT);

		btnBatDau = new JButton("Bắt đầu");
		btnBatDau.setActionCommand("Bat Dau");
		btnBatDau.setBounds(CHIEURONGFRAME / 2 - BTN_SIZE_WIDTH / 2, CHIEUCAOFRAME / 2 + lbDatCuoc.getHeight() + SPACE,
				BTN_SIZE_WIDTH, BTN_SIZE_HEIGHT);
		btnRutBai = new JButton("Rút bài");
		btnRutBai.setActionCommand("RutBai");
		btnRutBai.setBounds(CHIEURONGFRAME / 2 + SPACE * 3, lstBoxPlayer.get(0).getY()- BTN_SIZE_HEIGHT -SPACE, BTN_SIZE_WIDTH,
				BTN_SIZE_HEIGHT);// thiết lập cho nút rút bài
		btnGapBai = new JButton("Gập bài");
		btnGapBai.setActionCommand("GapBai");
		btnGapBai.setBounds(CHIEURONGFRAME / 2 - SPACE * 3 - BTN_SIZE_WIDTH, lstBoxPlayer.get(0).getY()-SPACE - BTN_SIZE_HEIGHT,
				BTN_SIZE_WIDTH, BTN_SIZE_HEIGHT);// thiết lập nút gập bài

		this.add(btnGapBai);
		this.add(btnBatDau);
		this.add(btnRutBai);
		this.add(lbDatCuoc);
		this.add(txtTienCuoc);

	}

	public void datCuoc() {
		btnGapBai.setVisible(false);
		btnRutBai.setVisible(false);

	}

	public void start() {// phương thức bắt đầu ván game
		lbDatCuoc.setVisible(false);
		txtTienCuoc.setVisible(false);
		btnBatDau.setVisible(false);
		ctrBanGame.themBaiVaoGame();
		btnGapBai.setVisible(true);
		btnRutBai.setVisible(true);
		ctrXiDach.xaoBai();// xào bài
		for (GDBoxPlayer gdBoxPlayer : lstBoxPlayer) {// chia cho mỗi người chơi 2 lá bài

			ctrXiDach.rutBai(gdBoxPlayer);
			process++;
		}
		for (GDBoxPlayer gdBoxPlayer : lstBoxPlayer) {// chia cho mỗi người chơi 2 lá bài

			ctrXiDach.rutBai(gdBoxPlayer);
			process++;
		}
		process = 0;
	}

	public int getProcess() {// lấy tiến trình hàng đợi rút bài
		return process;
	}

	public void clickBtnGapBai() {
		for (int i = 1; i < lstBoxPlayer.size(); i++) {
			ctrXiDach.botPlay(lstBoxPlayer.get(i));
			lstBoxPlayer.get(i).repaint();
		}
		Timer timer = new Timer();
		System.out.println(process);
		TimerTask task = new TimerTask() {

			@Override
			public void run() {
				ctrXiDach.hienThiAllBai(lstBoxPlayer);

			}
		};
		System.out.println(process);
		timer.schedule(task, process * 500 + 1000);

	}

	public void clickBtnRutBai() {
		ctrXiDach.rutBai(lstBoxPlayer.get(luotPlayer));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand() == btnRutBai.getActionCommand()) {
			clickBtnRutBai();
		}
		if (e.getActionCommand() == btnGapBai.getActionCommand()) {
			clickBtnGapBai();
		}
		if(e.getActionCommand()== btnBatDau.getActionCommand()) {
			start();
		}
		view.setVisible(true);
	}

	public void incrementProcess() {
		process += 1;
	}

	@Override
	public void addAction() {
		ctrXiDach = new ControllerXiDach(this);
		Component[] comps = this.getComponents();
		for (Component comp : comps) {
			if (comp instanceof JButton) {
				JButton btn = (JButton) comp;
				btn.addActionListener(this);
			}
		}

	}

}
