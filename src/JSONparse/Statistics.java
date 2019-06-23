package JSONparse;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Statistics extends Hotel{

	private int size;
	public Statistics() {	
	}

	public void Statistics(ArrayList<Hotel> tabHotel) {
		System.out.println(size);
		int room[]= new int[size];
		int bed[]= new int[size];
		int toilet[]= new int[size];
		String structureType[]= new String[size];
		String businessType[]= new String[size];
		String scia_aut[]= new String[size];
		int i=0;
		for (Hotel item: tabHotel) //taking all the datas for tabHotel
		{
			room[i]=item.getRoom();
			bed[i]=item.getBed();
			toilet[i]=item.getToilet();
			structureType[i]=item.getStructure();
			businessType[i]=item.getBusiness();
			scia_aut[i]=item.getSiaAut();
			i++;
		}
		
		this.Print(room, bed, toilet,structureType, businessType,scia_aut); //Print the stats
	}
	
	protected void setSize(int sizeTab) {
		this.size=sizeTab;
	}
	
	private void Print(int room[], int bed[], int toilet[], String structureType[], String businessType[], String scia_aut[]) {
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
		System.out.printf("Min toilets : %d%n%n", Min(toilet));

		System.out.printf("%n---Structure--%n");
		Count(structureType);
		
		System.out.printf("%n---Business--%n");
		Count(businessType);
		
		System.out.printf("%n---Scia/Auth--%n");
		Count(scia_aut);
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
	
	private void Count(String tab[]) {
		String[] cat= new String[size];
		int[] number= new int[size];
		int flag=0, j=0;
		
		for(int i=0;i<size;i++)
		{
			cat[i]="";
			number[i]=0;
		} 

		int nCat=1;
		cat[0]=tab[0];
		
		   for (int i=0;i<size;i++) {
		       while ( j<nCat) // search an existing category in the array
		       {
		           if (tab[i].equals(cat[j]))
		           {
		               number[j]++;
		               flag=1;

		           }
		           j++;
		       }
		       if (flag==0) //if there is no existing category : create a new one
		       {
		           cat[j]=tab[i];
		           number[j]++;
		           nCat++;
		       }
		       j=0;
		       flag=0;
		   }
		for(int i=0;i<nCat;i++) // print the number of each category
		{
			System.out.printf("Categorie : %s counted %d times%n", cat[i], number[i]);
		} 
	}
}
