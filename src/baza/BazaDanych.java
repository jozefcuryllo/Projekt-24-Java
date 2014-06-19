package baza;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
 
import tabele.Rozliczenia;
import tabele.Podroze;

public class BazaDanych {
	public static final String DRIVER = "org.sqlite.JDBC";
    public static final String DB_URL = "jdbc:sqlite:BazaDanych.db";
 
    private Connection conn;
    private Statement stat;
 
    public BazaDanych() {
        try {
            Class.forName(BazaDanych.DRIVER);
        } catch (ClassNotFoundException e) {
            System.err.println("Brak sterownika JDBC");
            e.printStackTrace();
        }
 
        try {
            conn = DriverManager.getConnection(DB_URL);
            stat = conn.createStatement();
        } catch (SQLException e) {
            System.err.println("Problem z otwarciem polaczenia");
            e.printStackTrace();
        }
 
        createTables();
    }
 
	
    public boolean createTables()  {
        String createPodroze = "CREATE TABLE IF NOT EXISTS PODROZE (id_podr INTEGER PRIMARY KEY AUTOINCREMENT, data INTEGER,  data DATE, nazwa_miejsc varchar(255), sr_transportu varchar(255), godzina varchar(255))";
        String createRozliczenia = "CREATE TABLE IF NOT EXISTS ROZLICZENIA (id_rozl INTEGER PRIMARY KEY AUTOINCREMENT, p_food DOUBLE, p_hotel DOUBLE, p_travel DOUBLE, p_living DOUBLE, p_other DOUBLE))";
        try {
            stat.execute(createPodroze);
            stat.execute(createRozliczenia);
        } catch (SQLException e) {
            System.err.println("Blad przy tworzeniu tabeli");
            e.printStackTrace();
            return false;
        }
        return true;
    }
 
    public boolean insertPodroze(int id_rozl, Date data, String nazwa_miejsc, String sr_transportu, String godzina) {
        try {
            PreparedStatement prepStmt = conn.prepareStatement(
                    "insert into PODROZE values (NULL, ?, ?, ?, ?, ?);");
            prepStmt.setInt(1, id_rozl);
            prepStmt.setDate(2, (java.sql.Date) data);
            prepStmt.setString(3, nazwa_miejsc);
            prepStmt.setString(4, sr_transportu);
            prepStmt.setString(5, godzina);
            prepStmt.execute();
        } catch (SQLException e) {
            System.err.println("Blad przy wstawianiu PODROZY");
            e.printStackTrace();
            return false;
        }
        return true;
    }
 
    public boolean insertRozliczenia(double p_food,double p_hotel,double p_travel,double p_living,double p_other) {
        try {
            PreparedStatement prepStmt = conn.prepareStatement(
                    "insert into ROZLICZENIA values (NULL, ?, ?, ?, ?, ?);");
            prepStmt.setDouble(1, p_food);
            prepStmt.setDouble(2, p_hotel);
            prepStmt.setDouble(3, p_travel);
            prepStmt.setDouble(4, p_living);
            prepStmt.setDouble(5, p_other);
            prepStmt.execute();
        } catch (SQLException e) {
            System.err.println("Blad przy wstawianiu ROZLICZEN");
            return false;
        }
        return true;
    }
 
 
    public List<Podroze> selectPodroze() {
        List<Podroze> podroz = new LinkedList<Podroze>();
        try {
            ResultSet result = stat.executeQuery("SELECT * FROM PODROZE");
            int id_podr;
            int id_rozl;
            Date data;
            String nazwa_miejsc;
            String sr_transportu;
            String godzina;
            while(result.next()) {
            		id_podr = result.getInt("id_podr");
            		id_rozl = result.getInt("id_rozl");
            		data = result.getDate("data");
            		nazwa_miejsc = result.getString("nazwa_miejsc");
            		sr_transportu = result.getString("sr_transportu");
            		godzina = result.getString("godzina");
                podroz.add(new Podroze(id_podr,id_rozl,data,nazwa_miejsc,sr_transportu,godzina));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return podroz;
    }
 
    public List<Rozliczenia> selectRozliczenia() {
        List<Rozliczenia> rozlicz = new LinkedList<Rozliczenia>();
        try {
            ResultSet result = stat.executeQuery("SELECT * FROM ROZLICZENIA");
            int id_rozl;
            double p_food;
            double p_hotel;
            double p_travel;
            double p_living;
            double p_other;
            while(result.next()) {
            		id_rozl = result.getInt("id_rozl");
            		p_food = result.getDouble("p_food");
                    p_hotel = result.getDouble("p_hotel");
                    p_travel = result.getDouble("p_travel");
                    p_living = result.getDouble("p_living");
                    p_other = result.getDouble("p_other");
                rozlicz.add(new Rozliczenia(id_rozl, p_food, p_hotel, p_travel, p_living, p_other));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return rozlicz;
}
 
    public void closeConnection() {
        try {
            conn.close();
        } catch (SQLException e) {
            System.err.println("Problem z zamknieciem polaczenia");
            e.printStackTrace();
        }
    }


}
