package controller;

import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;

import models.Models;
import view.APanel;
import view.GDSanhGame;
import view.View;

public class ControllerSanhGame extends Controller{
GDSanhGame panel;
View view;
	public ControllerSanhGame(APanel panel) {
	
		this.panel=(GDSanhGame) panel;
		this.view=panel.getView();
	}
	@Override
	public void themTkVaoDs(String userName, String pass) {
		// K lam gi
		
	}
}

