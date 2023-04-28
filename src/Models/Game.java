package models;

import java.util.List;

public class Game {
List<Player> players;
BoBai boBai;
int soNguoiChoi;
public Game(int soNguoiChoi) {
	this.soNguoiChoi=soNguoiChoi;
	boBai = new BoBai();
}
}
