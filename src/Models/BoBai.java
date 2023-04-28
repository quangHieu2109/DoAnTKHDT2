package models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BoBai {
	private ArrayList<Bai> boBai;
	public BoBai() {
		boBai = new ArrayList<>();
		for(int i =0; i < 4;i++) {
			for(int j =1;j<14;j++) {
				boBai.add(new Bai(j, i));
			}
		}
	}
	
	public Bai getBaiTai(int i) {
		return boBai.get(i);
	}
	public int getSize() {
		return boBai.size();
	}
	public void xaoBai() {//xào bài
		Collections.shuffle(boBai);
	}
	public Bai rutBaiTrenCung() {//rút bài
		return boBai.remove(0);
	}
	
	public List<Bai> getLstBoBai(){
		return boBai;
	}
	public static void main(String[] args) {
		BoBai b = new BoBai();
		b.xaoBai();
		System.out.println(b.rutBaiTrenCung());
		System.out.println(b.rutBaiTrenCung());
	}
}
