package controller;



import java.awt.Component;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.TimerTask;
import java.util.logging.Handler;

import javax.swing.Timer;
import view.GDBoxPlayer;

public class Animation extends Observable implements ActionListener {

	Component obj;
	Timer timer;
	boolean stateAnimation;
	List<Observer> obsevers;
	int setOffTime = 0;
	GDBoxPlayer gd;

	private final int MOVE_TO_Y = 1;
	private final int MOVE_TO_X = 2;
	private final int MOVE_TO_X_Y = 3;
	int dichX;
	int dichY;
	int viTrix;
	int viTriy;
	int selection;
	int speed = 5;

	public void removeObs(Observer o) {
		obsevers.remove(o);
	}

	public void setOfTime(int longTime) {
		setOffTime = longTime;
	}

	public Animation(GDBoxPlayer player) {
		this.gd = player;
		obsevers = new ArrayList<>();
		timer = new Timer(15, this);
		stateAnimation = false;
	}

	public void moveToX_Y(int x, int y, Component obj) {
		selection = MOVE_TO_X_Y;
		this.obj = obj;
		viTrix = x;
		viTriy = y;
	}

	public void moveTo_X(int x, Component obj) {
		viTrix = x;
		this.obj = obj;
		selection = MOVE_TO_X;

	}

	public void moveTo_Y(int y, Component obj) {
		this.obj = obj;
		selection = MOVE_TO_Y;
		viTriy = y;
	}

	public void registerObs(Observer o) {
		obsevers.add(o);
	}

	@Override
	public void notifyObservers() {
		for (Observer observer : obsevers) {
			observer.update(this, gd);
		}
	}

	private void moveToY(int y, Component obj) {

		stateAnimation = true;
		if (obj.getY() < y) {
			obj.setBounds(obj.getX(), obj.getY() + speed, obj.getWidth(), obj.getHeight());
		}
		if (obj.getY() > y) {
			obj.setBounds(obj.getX(), obj.getY() - speed, obj.getWidth(), obj.getHeight());
		}
		if (obj.getY() >= y - 4 && obj.getY() <= y + 4) {
			stateAnimation = false;
			timer.stop();
		}

	}

	private void moveToX(int x, Component obj) {

		stateAnimation = true;

		if (obj.getX() < x) {
			obj.setBounds(obj.getX() + speed, obj.getY(), obj.getWidth(), obj.getHeight());
		}
		if (obj.getX() > x) {
			obj.setBounds(obj.getX() - speed, obj.getY(), obj.getWidth(), obj.getHeight());
		}
		if (obj.getX() >= x - 4 && obj.getX() <= x + 4) {
			stateAnimation = false;
			timer.stop();
		}

	}

	private void moveTo_X_Y(int x, int y, Component obj) {
		stateAnimation = true;

		if (obj.getX() < x) {
			obj.setBounds(obj.getX() + speed, obj.getY(), obj.getWidth(), obj.getHeight());
		}
		if (obj.getX() > x) {
			obj.setBounds(obj.getX() - speed, obj.getY(), obj.getWidth(), obj.getHeight());
		}
		if (obj.getY() < y) {
			obj.setBounds(obj.getX(), obj.getY() + speed, obj.getWidth(), obj.getHeight());
		}
		if (obj.getY() > y) {
			obj.setBounds(obj.getX(), obj.getY() - speed, obj.getWidth(), obj.getHeight());
		}
		if (obj.getY() >= y - 4 && obj.getY() <= y + 4 && obj.getX() <= x + 4 && obj.getX() >= x - 4) {
			timer.stop();
			stateAnimation = false;
		}

	}

	public boolean getStateAnimation() {
		return stateAnimation;
	}

	public Component getObj() {
		return this.obj;
	}

	public void start(long delay) {
		java.util.Timer t = new java.util.Timer();
		TimerTask task = new TimerTask() {

			@Override
			public void run() {
				timer.start();

			}
		};
		t.schedule(task, delay);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (selection == MOVE_TO_Y) {
			moveToY(viTriy, obj);
		}
		if (selection == MOVE_TO_X) {
			moveTo_X(viTrix, obj);
		}
		if (selection == MOVE_TO_X_Y) {
			moveTo_X_Y(viTrix, viTriy, obj);
		}
		if (stateAnimation == false) {
			notifyObservers();
		}

	}

}
