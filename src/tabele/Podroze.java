package tabele;
import java.util.*;

public class Podroze {
	private int id_podr;
	private int id_rozl;
	private Date data;
	private String nazwa_miejsc;
	private String sr_transportu;
	private String godzina;
	
	public Podroze(){}
	public Podroze(int id_podr,int id_rozl,Date data,String nazwa_miejsc,String sr_transportu,String godzina){
		this.id_podr=id_podr;
		this.id_rozl=id_rozl;
		this.data=data;
		this.nazwa_miejsc=nazwa_miejsc;
		this.sr_transportu=sr_transportu;
		this.godzina=godzina;
	}
	
	public int getId_podrozy(){
		return id_podr;
	}
	public void setId_podrozy(int id_podr){
		this.id_podr=id_podr;
	}
	public int getId_rozl(){
		return id_rozl;
	}
	public void setId_rozl(int id_rozl){
		this.id_rozl=id_rozl;
	}
	public Date getData(){
		return data;
	}
	public void setData(Date data){
		this.data=data;
	}
	public String getNazwa_miejsc(){
		return nazwa_miejsc;
	}
	public void Sr_transportu(String sr_transportu){
		this.sr_transportu=sr_transportu;
	}
	public String getGodzina(){
		return godzina;
	}
	public void setGodzina(String godzina){
		this.godzina=godzina;
	}
}
