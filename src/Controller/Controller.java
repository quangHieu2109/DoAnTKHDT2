package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.Timer;

import models.Bai;
import models.BoBai;
import models.Models;
import models.Player;
import models.TaiKhoan;
import view.APanel;

public abstract class Controller implements ActionListener{
	protected static Models models;
	Animation animation;
	APanel panel;
	Timer timer;
public Controller() {
	
	timer = new Timer(100, this);

}
public BoBai getBoBai() {
	return models.getBoBai();
}
public void setPlayer() {
	models.setPlayer();
}
public Player getPlayer() {
	return models.getPlayer();
}
public boolean checkTaiKhoan(String userName,String pass) {
	return models.checkTaiKhoan(userName, pass);
}
public abstract void themTkVaoDs(String userName,String pass);



public static void setModels(Models other) {
	models = other;
}
@Override
public  void actionPerformed(ActionEvent e) {
	
}
}
