package models;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import controller.Controller;

public class Models {
Controller controller;
BoBai boBai;
TaiKhoan taiKhoan;
List<TaiKhoan> dsTaiKhoan;
Player player;
List<Player> lstBot;

public Models() {
	boBai = new BoBai();
	Controller.setModels(this);
	dsTaiKhoan= new ArrayList<>();
	dsTaiKhoan.add(new TaiKhoan("root", "root"));
	lstBot = new ArrayList<>();
	createBots();
	dangKyTaiKhoan();
}
public List<TaiKhoan> getDsTK(){
	return dsTaiKhoan;
}

public void createBots() {
	lstBot.removeAll(lstBot);
	for(int i = 1; i <= 4;i++) {
		lstBot.add(new Player("bot "+i, 9000000,i));
	}
}
public void setPlayer() {
        player = new Player(taiKhoan.getName(), taiKhoan.getMoney(),0);
}
public boolean checkTaiKhoan(String name,String mk) {
	boolean res=false;
	for (TaiKhoan taiKhoan : dsTaiKhoan) {
		if(taiKhoan.dangNhap(name, mk)) {
			res=true;
			this.taiKhoan = taiKhoan;
			break;
		}
	}
	return res;
}
public boolean ktTaiKhoan(String tk) {
	boolean result = true;
	List<String> listTK = new ArrayList<>();
	for(TaiKhoan t :dsTaiKhoan) {
		listTK.add(t.getName());
	}
	if(listTK.contains(tk)) {
		result = false;
	}
	return result;
}
public void themTaiKhoan(String tk, String mk) {
	try {
		PrintWriter pw = new PrintWriter(new FileOutputStream("TaiKhoan.txt", true));
		pw.println(tk +" "+mk);
//		pw.flush();
		pw.close();
	} catch (Exception e) {
		// TODO: handle exception
	}
}
public void dangKyTaiKhoan() {
	File file = new File("TaiKhoan.txt");
	try {
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		String tk="";
		String mk="";
		String line ="";
		while((line = br.readLine())!= null) {
			String[] s = line.split(" ");
			tk=s[0];
			mk=s[1];
			if(ktTaiKhoan(tk)) {
				dsTaiKhoan.add(new TaiKhoan(tk, mk));
			}
		}
		
	} catch (Exception e) {
		// TODO: handle exception
	}
}
public List<Player> getLstBot(){
	return lstBot;
}
public BoBai getBoBai() {
	return boBai;
}

public TaiKhoan getTaiKhoan() {
	return taiKhoan;
}
public Player getPlayer() {
	return player;
}
public void tk() {
	for(TaiKhoan t : dsTaiKhoan) {
		System.out.println(t);
	}
}
public static void main(String[] args) {
	Models m = new Models();
//	m.themTaiKhoan("tk"	,"mk");
//	m.themTaiKhoan("tk2", "mk2");
//	m.dangKyTaiKhoan();
	m.tk();
}
}
