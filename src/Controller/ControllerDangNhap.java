package controller;

import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;
import javax.swing.Timer;

import models.Models;
import view.APanel;
import view.GDDangKy;
import view.GDDangNhap;
import view.PanelFactory;
import view.View;

public class ControllerDangNhap extends Controller {
	GDDangNhap panel;
	View view;

	public ControllerDangNhap(APanel panel) {

		this.panel = (GDDangNhap) panel;
		this.view=panel.getView();

	}

	@Override
	public void themTkVaoDs(String userName, String pass) {
		// K lam gi
		
	}

}
