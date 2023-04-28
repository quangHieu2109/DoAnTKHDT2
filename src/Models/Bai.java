package models;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Bai extends JLabel{
int so;
int chat;
ImageIcon imgMatSau;
ImageIcon imgMatTruoc;
public Bai(int so, int chat) {
	this.chat = chat;
	this.so = so;
	this.imgMatSau = new ImageIcon("./img/bobai/matsau.png");
	this.imgMatTruoc = new ImageIcon("./img/bobai/" + so + "" + chat + ".png");
	setHinhLaBai(imgMatSau);
}
public int getWidthImg() {
	return imgMatTruoc.getIconWidth();
}
public int getHeightImg() {
	return imgMatTruoc.getIconHeight();
}
public void setHinhLaBai(ImageIcon img) {
	this.setIcon(img);
}
public int getSo() {
	return so;
}

public int getChat() {
	return chat;
}

public ImageIcon getImgMatSau() {
	return imgMatSau;
}

public ImageIcon getImgMatTruoc() {
	return imgMatTruoc;
}

@Override
public String toString() {
	return "Bai [so=" + so + ", chat=" + chat + "]";
}

}
