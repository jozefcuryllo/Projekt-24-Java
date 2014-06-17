import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import tabele.Podroze;
import tabele.Rozliczenia;

import baza.BazaDanych;


public class PanelFactory {


	public String rok;

	private double suma = 0.0;
	public JPanel producePanel(){
		
		JPanel panel = new JPanel();
		
		//JLabel lblstJanuary = new JLabel("1st January 2014"); chyba mo¿na to wyrzuciæ bo trochê zaœmieca
		
		JLabel lblKosztyDojazdu = new JLabel("Travel prices");
		
		JLabel lblFood = new JLabel("Food");
		
		JLabel lblHotel = new JLabel("Hotel");
		
		JLabel lblLiving = new JLabel("Living");
		
		JLabel lblTime = new JLabel("Time");
		
		JLabel lblConveyance = new JLabel("Conveyance");
		
		JLabel lblCity = new JLabel("City");
		
		JLabel lblTotal = new JLabel("Total:  ");
		
		final JLabel label = new JLabel("0$");
		
		JLabel lblOther = new JLabel("Other");
		
		final JTextField textFieldTravelPrices = new JTextField();
		textFieldTravelPrices.setColumns(10);
		
		final JTextField textFieldFood = new JTextField();
		textFieldFood.setColumns(10);
		
		final JTextField textFieldHotel = new JTextField();
		textFieldHotel.setColumns(10);
		
		final JTextField textFieldLiving = new JTextField();
		textFieldLiving.setColumns(10);
	
		final JTextField textFieldTime = new JTextField();
		textFieldTime.setColumns(10);
		
		final JTextField textFieldConveyance = new JTextField();
		textFieldConveyance.setColumns(10);
		
		final JTextField textFieldCity = new JTextField();
		textFieldCity.setColumns(10);
		

		
		final JTextField textFieldOther = new JTextField("0");
		textFieldOther.setColumns(10);
		
		JCheckBox chckbxTravelPrices = new JCheckBox("Paid");
		
		JCheckBox chckbxFood = new JCheckBox("Paid");
		
		JCheckBox chckbxHotel = new JCheckBox("Paid");
		
		JCheckBox chckbxLiving = new JCheckBox("Paid");
		
		JCheckBox chckbxOther = new JCheckBox("Paid");
		
		textFieldTravelPrices.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				suma = suma + Double.parseDouble(textFieldTravelPrices.getText());  //te wszystkie action listenery sa pic na wode
				label.setText(suma+" $");						//trzeba je poprawic bo reaguja na enter tylko
			}													//i dolar sie nie pojawia no i dodaje ciagle ta sume
																//nawet jak zmienimy jakas wartosc...
		});
		textFieldFood.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				suma = suma + Double.parseDouble(textFieldFood.getText());
				label.setText(suma+" $");
				
			}
			
		});
		textFieldHotel.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				suma = suma + Double.parseDouble(textFieldHotel.getText());
				label.setText(suma+" $");
			}
			
		});
		textFieldLiving.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				suma = suma + Double.parseDouble(textFieldLiving.getText());
				label.setText(suma+" $");
			}
			
		});
		textFieldOther.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				suma = suma + Double.parseDouble(textFieldOther.getText());
				label.setText(suma+" $");
			}
			
		});
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				double food,hotel,living,other,travel;
				
				if(textFieldTravelPrices.getText().isEmpty())
					food=0.0;
				else
					food = Double.parseDouble(textFieldTravelPrices.getText());  
				if(textFieldFood.getText().isEmpty())
					hotel=0.0;
				else
					hotel = Double.parseDouble(textFieldFood.getText());
				if(textFieldHotel.getText().isEmpty())
					living=0.0;
				else
					living = Double.parseDouble(textFieldHotel.getText());
				if(textFieldLiving.getText().isEmpty())
					travel=0.0;
				else
					travel = Double.parseDouble(textFieldLiving.getText());
				if(textFieldOther.getText().isEmpty())
					other=0.0;
				else
					other = Double.parseDouble(textFieldOther.getText());
				
				BazaDanych b = new BazaDanych();
			   // b.insertRozliczenia(food, hotel, living, travel, other);
				// b.insertData(day,month,year);
				// b.insertPodroze(id_rozl, id_data, nazwa_miejsc, sr_trans, godzina);
				
				//tutaj w insertPodroze id daty i id rozl trzeba wydobyc z dopiero co wsadzonych danych w insertData i insertRozliczenia
			    List<Rozliczenia> rozliczenia = b.selectRozliczenia();
			    
			    textFieldTravelPrices.setText(String.valueOf(rozliczenia.get(0).getPTravel()));	    
			    textFieldFood.setText(String.valueOf(rozliczenia.get(0).getPFood())); //to sa przykladowe ustawienia zeby pokazac jak wydowbywac dane z bazy
			    textFieldHotel.setText(String.valueOf(rozliczenia.get(0).getPHotel()));
			    textFieldLiving.setText(String.valueOf(rozliczenia.get(0).getPLiving()));
			    textFieldOther.setText(String.valueOf(rozliczenia.get(0).getPOther()));

				b.closeConnection();
				
			}
		});
		
		
		
		
		
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(24)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblKosztyDojazdu)
								.addComponent(lblFood)
								.addComponent(lblHotel)
								.addComponent(lblLiving)
								.addComponent(lblOther)
								.addComponent(lblTime)
								.addComponent(lblConveyance)
								.addComponent(lblCity))
							.addGap(30)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(textFieldOther, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(chckbxOther))
								.addGroup(gl_panel.createSequentialGroup()
									.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addComponent(textFieldFood, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(textFieldTravelPrices, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(textFieldHotel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(textFieldTime, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(textFieldConveyance, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(textFieldCity, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
									.addGap(18)
									.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addComponent(chckbxTravelPrices)
										.addComponent(chckbxLiving)
										.addComponent(chckbxFood)))
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(textFieldLiving, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(chckbxHotel))))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblTotal)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(label)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(btnUpdate)))
					.addContainerGap(134, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(textFieldCity, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblCity))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(textFieldConveyance, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblConveyance))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(textFieldTime, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblTime))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(textFieldTravelPrices, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(chckbxTravelPrices))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(textFieldFood, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(chckbxLiving))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(textFieldHotel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(chckbxFood))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(textFieldLiving, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(chckbxHotel))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(textFieldOther, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(chckbxOther)))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblKosztyDojazdu)
							.addGap(18)
							.addComponent(lblFood)
							.addGap(18)
							.addComponent(lblHotel)
							.addGap(18)
							.addComponent(lblLiving)
							.addGap(18)
							.addComponent(lblOther)))
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(18)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblTotal)
								.addComponent(label)))
						.addGroup(gl_panel.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnUpdate)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
		return panel;
		
		
		
		
	}
	
	
}
