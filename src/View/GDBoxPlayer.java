package view;

import java.awt.Color;

import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JLabel;
import javax.swing.JPanel;

import models.Bai;
import models.Player;

public class GDBoxPlayer extends JPanel {
	Player player;
	int width = 250;
	int height = 130;
	int SPACE = 5;
	int angle = 0;
	int widthBoundIn4 = 100;
	int heightBoundIn4 = 50;
	int widthBoundBai = width;
	int heightBoundBai = 67;
	JLabel lbName;
	JLabel lbMoney;
	JPanel boundBai;
	JPanel boundIn4Player;
	String name;
	int money;
	int x;
	int y;

	public GDBoxPlayer(Player player) {
		this.player = player;
		name = player.getName();
		money = player.getMoney();
		lbName = new JLabel(name);
		lbMoney = new JLabel(money + "");
		x = width / 2;
		y = height / 2;
		boundIn4Player = new JPanel();
		boundBai = new JPanel();
		this.init();
	}

	public void init() {

		this.setOpaque(false);
		this.setLayout(null);

		boundIn4Player.setBounds(width / 2 - widthBoundIn4 / 2, height - heightBoundIn4, widthBoundIn4, heightBoundIn4);
		boundIn4Player.setBackground(Color.black);
		boundBai.setBounds(0, boundIn4Player.getY() - heightBoundBai, widthBoundBai, heightBoundBai);
		lbName.setBounds(widthBoundIn4 / 2 - name.length() * 6 - SPACE, heightBoundIn4 / 2 - 5, 10, 10);
		lbMoney.setBounds(widthBoundIn4 / 2 + SPACE, heightBoundIn4 / 2 - 5, 10, 10);
		lbName.setForeground(Color.white);
		lbMoney.setForeground(Color.white);

		boundIn4Player.add(lbName);
		boundIn4Player.add(lbMoney);

		boundBai.setLayout(new FlowLayout());
		this.add(boundIn4Player);
		this.add(boundBai);

	}

	public Player getPlayer() {
		return this.player;
	}

	public void updateMoney(int money) {
		this.money = money;
		repaint();
	}

	public JPanel getBoundBai() {
		return boundBai;
	}

	public void setBoundBai(JPanel boundBai) {
		this.boundBai = boundBai;
	}

	public void themBaiVaoTay(Bai bai, int type) {

		boundBai.add(bai);
		switch (type) {
		case 0: {

			bai.setHinhLaBai(bai.getImgMatTruoc());
			break;
		}
		}
		this.repaint();

	}

	public void roatePanel(int angle) {
		if (angle == 270 || angle == 90) {
			int temp = height;
			height = width;
			width = temp;

		}
		this.angle = angle;
		repaint();
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		if (angle == 270) {
			g2.rotate(Math.toRadians(angle), height / 2, height / 2);
		}
		if (angle == 90) {
			g2.rotate(Math.toRadians(angle), width / 2, width / 2);
		}
		if (angle == 180) {
			g2.rotate(Math.toRadians(angle), width / 2, height / 2);
		}

	}

}
