package controller;

import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;

import models.Models;
import models.TaiKhoan;
import view.GDDangKy;

public class ControllerDangKy extends Controller {
	GDDangKy panel;
//	static Models models;

	public ControllerDangKy(GDDangKy dangKy) {
		this.panel = dangKy;
	}

	public void themTkVaoDs(String userName, String pass) {
//		models.getDsTK().add(new TaiKhoan(userName, pass));
		models.themTaiKhoan(userName, pass);
		models.dangKyTaiKhoan();
	}
}
