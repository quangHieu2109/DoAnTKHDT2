package view;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import controller.ControllerBanGame;
import models.BoBai;

public class GDBanGame extends APanel {
	static int soNguoiChoi;//so người đấu với bạn
	ControllerBanGame ctrBanGame;
	List<GDBoxPlayer> lstBoxPlayer;// dách sách panel hiển thị đại diện người chơi
	

	public GDBanGame(View view) {
		super(view);
	}

	@Override
	public void init() {
		super.init();
		ctrBanGame = new ControllerBanGame(this);
		lstBoxPlayer = new ArrayList<>();
		lstBoxPlayer.add(new GDBoxPlayer(ctrBanGame.getPlayer()));
		themPVaoBox();
		setBoxPVaoBanGame();
		

	}

	public void themPVaoBox() {// thêm bot vào các lstBox
		for (int i = 0; i < soNguoiChoi; i++) {
			lstBoxPlayer.add(new GDBoxPlayer(ctrBanGame.getBot(i)));
		}
	}

	public void setBoxPVaoBanGame() {// set các vị trí cho mỗi người chơi
		switch (soNguoiChoi) {//set vị trí cho bot
		case 1: {//set vị trí cho bot 1
			lstBoxPlayer.get(1).roatePanel(180);
			lstBoxPlayer.get(1).setBounds(CHIEURONGFRAME / 2 - lstBoxPlayer.get(1).width / 2, 0,
					lstBoxPlayer.get(1).width, lstBoxPlayer.get(1).height);
			break;
		}
		case 2: {//set vị trí cho bot 1,2
			lstBoxPlayer.get(1).roatePanel(90);
			lstBoxPlayer.get(2).roatePanel(270);

			lstBoxPlayer.get(1).setBounds(0, CHIEUCAOFRAME / 2 - lstBoxPlayer.get(1).height / 2,
					lstBoxPlayer.get(1).width, lstBoxPlayer.get(1).height);

			lstBoxPlayer.get(2).setBounds(CHIEURONGFRAME - lstBoxPlayer.get(2).width,
					CHIEUCAOFRAME / 2 - lstBoxPlayer.get(2).height / 2, lstBoxPlayer.get(2).width,
					lstBoxPlayer.get(2).height);

			break;
		}
		case 3: {//set vị trí cho bot 1,2,3
			lstBoxPlayer.get(1).roatePanel(90);
			lstBoxPlayer.get(2).roatePanel(270);
			lstBoxPlayer.get(3).roatePanel(180);

			lstBoxPlayer.get(3).setBounds(CHIEURONGFRAME / 2 - lstBoxPlayer.get(3).width / 2, 0,
					lstBoxPlayer.get(3).width, lstBoxPlayer.get(3).height);
			lstBoxPlayer.get(1).setBounds(0, CHIEUCAOFRAME / 2 - lstBoxPlayer.get(1).height / 2,
					lstBoxPlayer.get(1).width, lstBoxPlayer.get(1).height);

			lstBoxPlayer.get(2).setBounds(CHIEURONGFRAME - lstBoxPlayer.get(2).width,

					CHIEUCAOFRAME / 2 - lstBoxPlayer.get(2).height / 2, lstBoxPlayer.get(2).width,
					lstBoxPlayer.get(2).height);
			break;
		}
		}
		for (int i = 0; i < lstBoxPlayer.size(); i++) {
			this.add(lstBoxPlayer.get(i));
		}
		//set Vị trí cho người chơi
		lstBoxPlayer.get(0).setBounds(CHIEURONGFRAME / 2 - lstBoxPlayer.get(0).width / 2,
				CHIEUCAOFRAME - lstBoxPlayer.get(0).height - 2 * SPACE, lstBoxPlayer.get(0).width,
				lstBoxPlayer.get(0).height);
		this.add(lstBoxPlayer.get(0));
	}

	public List<GDBoxPlayer> getLstBoxPlayer() {
		return lstBoxPlayer;
	}

	public static void setSoNguoiChoi(int num) {//set số người chơi đáu với bạn
		soNguoiChoi = num;
	}
	public int getSoNguoiChoi(){
		return soNguoiChoi;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		

	}

	@Override
	public void addAction() {
		// TODO Auto-generated method stub

	}

}
