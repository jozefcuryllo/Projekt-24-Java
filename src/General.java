import java.awt.EventQueue;
import java.util.List;

import baza.BazaDanych;
import tabele.Podroze;
import tabele.Rozliczenia;

public class General {

	/**
	 * Main 
	 * 
	 * @param args
	 * 
	 */
	public static void main(String[] args) {
		  EventQueue.invokeLater(new Runnable() {
           // @Override
            public void run() {
            	try {
					MyFrame window = new MyFrame();
					window.frame.setVisible(true);
					BazaDanych b = new BazaDanych();
				} catch (Exception e) {
					e.printStackTrace();
				}

            }
        });



	}
	/*BazaDanych b = new BazaDanych();
    b.insertPodroze(1, "2014/05/06", "Busko", "Samochod", "13:00");

    List<Podroze> podroz = b.selectPodroze();


    for(Podroze c: podroz)
        System.out.println(c);


    b.closeConnection();




}*/
	
}
