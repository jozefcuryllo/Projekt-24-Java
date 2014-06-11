package tabele;


public class Data {
	private int id_podr;
	private int id_daty;
	private int dzien;
	private int miesiac;
	private int rok;
	
	public Data(){}
	public Data(int id_daty,int id_podr, int dzien, int miesiac, int rok){
		this.id_podr=id_podr;
		this.id_daty=id_daty;
		this.dzien=dzien;
		this.miesiac=miesiac;
		this.rok=rok;

	}
	
	public int getId_podrozy(){
		return id_podr;
	}
	public void setId_podrozy(int id_podr){
		this.id_podr=id_podr;
	}
	public int getId_daty(){
		return id_daty;
	}
	public void setId_daty(int id_daty){
		this.id_daty=id_daty;
	}
	public int getDzien(){
		return dzien;
	}
	public void setDzien(int dzien){
		this.dzien=dzien;
	}
	public int getMiesiac(){
		return miesiac;
	}
	public void setMiesiac(int miesiac){
		this.miesiac=miesiac;
	}
	public int getRok(){
		return rok;
	}
	public void setRok(int rok){
		this.rok=rok;
	}

    public String toString() {
        return "["+id_podr+"] - ["+id_daty+"] -  "+dzien+"/"+miesiac+"/"+rok;
    }

}
