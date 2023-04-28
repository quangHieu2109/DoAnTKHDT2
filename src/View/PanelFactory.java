package view;

public class PanelFactory {
public static APanel createPanel(String type,View view) {
	APanel panel = null;
	switch (type) {
	case "DangNhap": {
		panel= new GDDangNhap(view);
		break;
	}
	case "DangKy": {
		panel= new GDDangKy(view);
		break;
	}
	case "SanhGame": {
		panel = new GDSanhGame(view);
		break;
	}
	case "XiDach": {
		panel =  new GDGameXiDach(view);
	}
	
	}
	return panel;
}
}
