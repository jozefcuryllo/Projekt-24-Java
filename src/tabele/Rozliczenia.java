package tabele;

public class Rozliczenia {
	public int id_rozl;
	public double p_food;
	public double p_hotel;
	public double p_travel;
	public double p_living;
	public double p_other;
	
	public Rozliczenia() {}
	public Rozliczenia(int id_rozl,double p_food,double p_hotel,double p_travel,double p_living,double p_other){
		this.id_rozl=id_rozl;
		this.p_food=p_food;
		this.p_hotel=p_hotel;
		this.p_living=p_living;
		this.p_other=p_other;
		this.p_travel=p_travel;
	}
	
	public int getId(){
		return id_rozl;
	}
	public void setId(int id){
		this.id_rozl=id;
	}
	public double getPFood(){
		return p_food;
	}
	public void setPFood(int p_food){
		this.p_food=p_food;
	}
	public double getPHotel(){
		return p_hotel;
	}
	public void setPHotel(int p_hotel){
		this.p_hotel=p_hotel;
	}
	public double getPTravel(){
		return p_travel;
	}
	public void setPTravel(int p_travel){
		this.p_travel=p_travel;
	}
	public double getPLiving(){
		return p_living;
	}
	public void setPLiving(int p_living){
		this.p_living=p_living;
	}
	public double getPOther(){
		return p_other;
	}
	public void setPOther(int p_other){
		this.p_other=p_other;
	}
}
