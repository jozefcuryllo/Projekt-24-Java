package tabele;
import java.util.*;

public class Rezerwacje {
	private int id_rez;
	private int id_kli;
	private int id_przej;
	private int id_rozl;
	private Date data_rez;
	
	public int getId_rez(){
		return id_rez;
	}
	public void setId_rez(int id_rez){
		this.id_rez=id_rez;
	}
	public int getId_kli(){
		return id_kli;
	}
	public void setId_kli(int id_kli){
		this.id_kli=id_kli;
	}
	public int getId_przej(){
		return id_przej;
	}
	public void setId_przej(int id_przj){
		this.id_przej=id_przej;
	}
	public int getId_rozl(){
		return id_rozl;
	}
	public void setId_rozl(int id_rozl){
		this.id_rozl=id_rozl;
	}
	public Date getData(){
		return data_rez;
	}
	public void setData(Date data){
		this.data_rez=data;
	}
	
}
