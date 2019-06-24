package JSONparse;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Filters extends Hotel{

	private int size;
	public Filters() {	
	}

	public void Filters(ArrayList<Hotel> tabHotel) {
		int room[]= new int[size];
		int bed[]= new int[size];
		int toilet[]= new int[size];
		String structureType[]= new String[size];
		String businessType[]= new String[size];
		String scia_aut[]= new String[size];
		String classification[]= new String[size];
		String denomination[]= new String[size];
		
		String CAP[]= new String[size];
		String address[]= new String[size];
		String tel[]= new String[size];
		String data[]= new String[size];
		String prenotation[]= new String[size];
		String duration[]= new String[size];
		int i=0;
		for (Hotel item: tabHotel) //taking all the datas for tabHotel
		{
			room[i]=item.getRoom();
			bed[i]=item.getBed();
			toilet[i]=item.getToilet();
			structureType[i]=item.getStructure();
			businessType[i]=item.getBusiness();
			scia_aut[i]=item.getSiaAut();
			classification[i]=item.getClassification();
			denomination[i]=item.getDenomination();
			
			CAP[i]=item.getCAP();
			address[i]=item.getAddress();
			tel[i]=item.getTel();
			data[i]=item.getData();
			prenotation[i]=item.getPrenotation();
			duration[i]=item.getDuration();
			i++;
		}
		
		this.Menu(room, bed, toilet,structureType, businessType, scia_aut, classification, denomination, CAP, address, tel, data, prenotation, duration);
	}
	
	protected void setSize(int sizeTab) {
		this.size=sizeTab;
	}

	private void Menu(int room[], int bed[], int toilet[], String structureType[], String businessType[], String scia_aut[], String classification[], String denomination[], String CAP[], String address[], String tel[], String data[], String prenotation[], String duration[]) {
		int cat=0, go=0;
		Scanner sc = new Scanner(System.in);
		do // print the number of each category
		{
			do
			{	
				System.out.printf("%n%n:::::Choose a category to apply your filter::::: %n");
				System.out.printf("0.--END--4 %n");
				System.out.printf("1.Rooms in hostel %n");
				System.out.printf("2.Beds in hostel %n");
				System.out.printf("3.Toilets in hostel %n");
				System.out.printf("4.Structure %n");
				System.out.printf("5.Classification %n");
				System.out.printf("6.Denomination %n");
				System.out.printf("7.CAP %n");
				System.out.printf("8.Adress %n");
				System.out.printf("9.Tel %n");
				System.out.printf("10.Data %n");
				System.out.printf("11.Prenotation %n");
				System.out.printf("12.Duration %n");
				
				cat = sc.nextInt();

				switch (cat)
				{
				 case 1:
					  System.out.printf("%n%nHere are the sub-categories of Rooms, choose one to filter:%n");
					  PrintCat(room);
					  PrintFilter(room);
				    break;
				 case 2:
					  System.out.printf("%n%nHere are the sub-categories of Beds, choose one to filter:%n");
					  PrintCat(bed);
					  PrintFilter(bed);
				    break;
				 case 3:
					  System.out.printf("%n%nHere are the sub-categories of Toilets, choose one to filter:%n");
					  PrintCat(toilet);
					  PrintFilter(toilet);
				    break;
				  case 4:
					  System.out.printf("%n%nHere are the sub-categories of Business, choose one to filter:%n");
					  PrintCat(structureType);
					  PrintFilter(structureType);
				    break;
				  case 5:
					  System.out.printf("%n%nHere are the sub-categories of Classification, choose one to filter:%n");
					  PrintCat(classification);
					  PrintFilter(classification);
				    break;
				  case 6:
					  System.out.printf("%n%nHere are the sub-categories of Denomination, choose one to filter:%n");
					  PrintCat(denomination);
					  PrintFilter(denomination);
				    break;
				  case 7:
					  System.out.printf("%n%nHere are the sub-categories of CAP, choose one to filter:%n");
					  PrintCat(CAP);
					  PrintFilter(CAP);
				    break;
				  case 8:
					  System.out.printf("%n%nHere are the sub-categories of Adress, choose one to filter:%n");
					  PrintCat(address);
					  PrintFilter(address);
				    break;
				  case 9:
					  System.out.printf("%n%nHere are the sub-categories of Tel, choose one to filter:%n");
					  PrintCat(tel);
					  PrintFilter(tel);
				    break;
				  case 10:
					  System.out.printf("%n%nHere are the sub-categories of Data, choose one to filter:%n");
					  PrintCat(data);
					  PrintFilter(data);
				    break;
				  case 11:
					  System.out.printf("%n%nHere are the sub-categories of Prenotation, choose one to filter:%n");
					  PrintCat(prenotation);
					  PrintFilter(prenotation);
				    break;
				  case 12:
					  System.out.printf("%n%nHere are the sub-categories of Duration, choose one to filter:%n");
					  PrintCat(duration);
					  PrintFilter(duration);
				    break;
				    
				  default:
				    System.out.printf("%n%nNot a choice");
				}
				
			} while(cat<0);
			System.out.printf("%n%nChoose an other filter? (1:yes,0:no) %n");
			go = sc.nextInt();
		} while (go==1);
	}
	
	private void PrintCat(String tab[]) {
		String[] cat= new String[size];
		int flag=0, j=0;
		
		for(int i=0;i<size;i++)
		{
			cat[i]="";
		} 

		int nCat=1;
		cat[0]=tab[0];
		
		   for (int i=0;i<size;i++) {
		       while ( j<nCat) // search an existing category in the array
		       {
		           if (tab[i].equals(cat[j]))
		           {
		               flag=1;
		           }
		           j++;
		       }
		       if (flag==0) //if there is no existing category : create a new one
		       {
		           cat[j]=tab[i];
		           nCat++;
		       }
		       j=0;
		       flag=0;
		   }
		for(int i=0;i<nCat;i++) // print the number of each category
		{
			System.out.printf("-  %s%n", cat[i]);
		} 
	}
	
	private void PrintCat(int tab[]) {
		int[] cat= new int[size];
		int flag=0, j=0;
		
		for(int i=0;i<size;i++)
		{
			cat[i]=0;
		} 

		int nCat=1;
		cat[0]=tab[0];
		
		   for (int i=0;i<size;i++) {
		       while ( j<nCat) // search an existing category in the array
		       {
		           if (tab[i]==cat[j])
		           {
		               flag=1;
		           }
		           j++;
		       }
		       if (flag==0) //if there is no existing category : create a new one
		       {
		           cat[j]=tab[i];
		           nCat++;
		       }
		       j=0;
		       flag=0;
		   }
		for(int i=0;i<nCat;i++) // print the number of each category
		{
			System.out.printf("-  %s%n", cat[i]);
		} 
	}
	
	private void PrintFilter(String tab[]) {
		String choice= new String();
		System.out.printf("%n%nWhat is your filter?%n");
		Scanner sc = new Scanner(System.in);
		choice = sc.nextLine();
		
		System.out.printf("%n%n");
		
		   for (int i=0;i<size;i++) {
		           if (tab[i].equals(choice))
		           {
		        	   System.out.printf("Row n°%d%n",i+1);
		           }
		 
		   }
	}
	
	private void PrintFilter(int tab[]) {
		int choice= 0;
		System.out.printf("%n%nWhat is your filter?%n");
		Scanner sc = new Scanner(System.in);
		choice = sc.nextInt();
		
		System.out.printf("%n%n");
		
		   for (int i=0;i<size;i++) {
		           if (tab[i]==choice)
		           {
		        	   System.out.printf("Row n°%d%n",i+1);
		           }
		 
		   }
	}
}