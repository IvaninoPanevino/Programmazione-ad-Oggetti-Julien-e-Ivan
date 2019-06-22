package JSONparse;

import java.io.*;
//La serializzazione è la trasformazione di un oggetto in memoria in una sequenza di byte 
//(ospitata in un file, trasmesso in rete ecc..)

public class Hotel implements Serializable {
	private String structureType;
	private String businessType;
	private String classification;
	private String denomination;
	private String CAP;
	private String address;
	private String tel;
	private int room;
	private int toilet;
	private int bed;
	private String scia_aut;
	private String data;
	private String prenotation;
	private String duration;
	
	public Hotel() {
		
	}
	
	public Hotel(String structureType, String businessType, String classification, String denomination, String CAP, String address, String tel, int room, int toilet, int bed, String scia_aut, String data, String prenotation, String duration) {
		
		this.structureType = structureType;
		this.businessType = businessType;
		this.classification = classification;
		this.denomination = denomination;
		this.CAP = CAP;
		this.address = address;
		this.tel = tel;
		this.room = room;
		this.toilet = toilet;
		this.bed = bed;
		this.scia_aut = scia_aut;
		this.data = data;
		this.prenotation = prenotation;
		this.duration = duration;
	}
	//---------structure type------------
	public String getStructure() { 
		return structureType;
	}
	public void setStructure(String structureType) {
		this.structureType = structureType;
	}
	//-----------Business type--------------
	public String getBusiness() {
		return businessType;
	}
	public void setBusiness(String bussinessType) {
		this.businessType = businessType;
	}
	//--------------classification------------
	public String getClassification() {
		return classification;
	}
	public void setClassification(String classification) {
		this.classification = classification;
	}
	//----------denomination-----------
	public String getDenomination() {
		return denomination;
	}
	public void setDenomination(String denomination) {
		this.denomination = denomination;
	}
	//----------CAP--------------
	public String getCAP() {
		return CAP;
	}
	public void setCAP(String CAP) {
		this.CAP = CAP;
	}
	//------------address--------
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	//----------tel----------
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	//--------room-------
	public int getRoom() {
		return room;
	}
	public void setRoom(int room) {
		this.room = room;
	}
	//------toilet-------
	public int getToilet() {
		return toilet;
	}
	public void setToilet(int toilet) {
		this.toilet = toilet;
	}
	//-----------bed-----------
	public int getBed() {
		return bed;
	}
	public void setBed(int bed) {
		this.bed = bed;
	}
	//---------scia_aut---------
	public String getSiaAut() {
		return scia_aut;
	}
	public void setSciaAut(String scia_aut) {
		this.scia_aut = scia_aut;
	}	
	//---------data--------
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	//----------prenotation-------
	public String getPrenotation() {
		return prenotation;
	}
	public void setPrenotation(String prenotation) {
		this.prenotation = prenotation;
	}
	//-------duration--------
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	
	@Override
	public String toString() {
		return "custom method toString for Hotel [Structure=" + structureType + ", Business=" + businessType + ", Classification=" + classification + ", Denomination=" + denomination + ", CAP=" + CAP + ", Address=" + address + ", Telephone=" + tel + ", Room=" + room + ", Toilet=" + toilet + ", Bed=" + bed + ", Scia/Aut=" + scia_aut + ", Data=" + data + ", Prenotation=" + prenotation + ", Duration=" + duration + "]";
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
