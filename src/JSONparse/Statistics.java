package JSONparse;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Statistics extends Hotel{

	private ArrayList<Hotel> hotel;
	private int size;
	public Statistics() {	
	}

	public void Statistics(ArrayList<Hotel> tabHotel) {
		int room[]= new int[size];
		int bed[]= new int[size];
		int toilet[]= new int[size];
		String structureType[]= new String[size];
		int i=0;
		//hotel = tabHotel;
		for (Hotel item: tabHotel)
		{
			room[i]=item.getRoom();
			bed[i]=item.getBed();
			toilet[i]=item.getToilet();
			structureType[i]=item.getStructure();
			i++;
		}
		
		this.Print(room, bed, toilet, structureType);
	}
	
	protected void setSize(int sizeTab) {
		this.size=sizeTab;
	}
	
	private void Print(int room[], int bed[], int toilet[], String structureType[]) {
		System.out.printf("%n%n:::::::::::::STATISTICS:::::::::::::%n%n");
		
		System.out.printf("%n---Rooms---%n");
		System.out.printf("Rooms average in hotels : %d %n", Average(room));
		System.out.printf("Max rooms : %d %n", Max(room));
		System.out.printf("Min rooms : %d %n", Min(room));
		
		System.out.printf("%n---Beds---%n");
		System.out.printf("Beds average in hotels : %d %n", Average(bed));
		System.out.printf("Max beds : %d %n", Max(bed));
		System.out.printf("Min beds : %d %n", Min(bed));
		
		System.out.printf("%n---Toilets---%n");
		System.out.printf("Toilets average in hotels : %d%n", Average(toilet));
		System.out.printf("Max toilets : %d%n", Max(toilet));
		System.out.printf("Min toilets : %d %n%n", Min(toilet));
	}
	
	private int Average(int tab[]) {
		int avg=0;
		for(int n : tab) {		
			avg+=n; //devo usare item e non v per vedere
		}
		
		return (avg/size);
	}
	
	private int Max(int tab[]) {
		int max=tab[0];
		for(int i=0;i<size;i++) {		
			if (tab[i]>max)
				max=tab[i];
		}
		return max;
	}
	
	private int Min(int tab[]) {
		int min=tab[0];
		for(int i=0;i<size;i++) {		
			if (tab[i]<min)
				min=tab[i];
		}
		return min;
	}
}
