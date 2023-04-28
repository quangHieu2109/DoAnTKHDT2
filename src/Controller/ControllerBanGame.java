package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import models.Bai;
import models.Player;
import view.APanel;
import view.GDBanGame;
import view.GDBoxPlayer;

public class ControllerBanGame extends Controller {
	GDBanGame panel;

	public ControllerBanGame(GDBanGame panel) {
		this.panel = panel;

	}

	public Player getBot(int index) {
		return models.getLstBot().get(index);
	}

	public void themBaiVaoGame() {
		for (int i = 0; i < 52; i++) {

			models.getBoBai().getBaiTai(i).setBounds(
					panel.CHIEURONGFRAME / 2 - models.getBoBai().getBaiTai(i).getWidthImg() / 2,
					panel.CHIEUCAOFRAME / 2 - models.getBoBai().getBaiTai(i).getHeightImg() / 2,
					models.getBoBai().getBaiTai(i).getWidthImg(), models.getBoBai().getBaiTai(i).getHeightImg());
			panel.add(models.getBoBai().getBaiTai(i));
		}
	}

	@Override
	public void themTkVaoDs(String userName, String pass) {
		// K lam gi
		
	}
}
