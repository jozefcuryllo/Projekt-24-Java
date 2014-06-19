import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
import tabele.Data;

import baza.BazaDanych;


public class PanelFactory {


	private double suma = 0.0;
	public JPanel producePanel(final int argdzien){
		
		JPanel panel = new JPanel();
		
		//JLabel lblstJanuary = new JLabel("1st January 2014"); chyba mo¿na to wyrzuciæ bo trochê zaœmieca
		
		JLabel lblKosztyDojazdu = new JLabel("Travel prices($)");
		
		JLabel lblFood = new JLabel("Food($)");
		
		JLabel lblHotel = new JLabel("Hotel($)");
		
		JLabel lblLiving = new JLabel("Living($)");
		
		JLabel lblTime = new JLabel("Time");
		
		JLabel lblConveyance = new JLabel("Conveyance");
		
		JLabel lblCity = new JLabel("City");
		
		JLabel lblTotal = new JLabel("Total($):  ");
		
		final JLabel label = new JLabel("0");
		
		JLabel lblOther = new JLabel("Other($)");
		
		final JTextField textFieldTravelPrices = new JTextField("0");
		textFieldTravelPrices.setEnabled(false);
		textFieldTravelPrices.setColumns(10);
		
		final JTextField textFieldFood = new JTextField("0");
		textFieldFood.setEnabled(false);
		textFieldFood.setColumns(10);
		
		final JTextField textFieldHotel = new JTextField("0");
		textFieldHotel.setEnabled(false);
		textFieldHotel.setColumns(10);
		
		final JTextField textFieldLiving = new JTextField("0");
		textFieldLiving.setEnabled(false);
		textFieldLiving.setColumns(10);
	
		final JTextField textFieldTime = new JTextField("00:00");
		textFieldTime.setColumns(10);
		
		final JTextField textFieldConveyance = new JTextField();
		textFieldConveyance.setColumns(10);
		
		final JTextField textFieldCity = new JTextField();
		textFieldCity.setColumns(10);
		

		
		final JTextField textFieldOther = new JTextField("0");
		textFieldOther.setEnabled(false);
		textFieldOther.setColumns(10);
		
		final JCheckBox chckbxTravelPrices = new JCheckBox("Paid");
		
		final JCheckBox chckbxFood = new JCheckBox("Paid");
		
		final JCheckBox chckbxHotel = new JCheckBox("Paid");
		
		final JCheckBox chckbxLiving = new JCheckBox("Paid");
		
		final JCheckBox chckbxOther = new JCheckBox("Paid");
		
	    chckbxTravelPrices.addItemListener(new ItemListener()
        {
            public void itemStateChanged(ItemEvent ie){
            	textFieldTravelPrices.setEnabled(ie.getStateChange() == ItemEvent.SELECTED);
            	if(chckbxTravelPrices.isEnabled()){
            		textFieldTravelPrices.setText("");
            	}else{
            		textFieldTravelPrices.setText("0");
            	}
				}
			}
		);
	    
	    chckbxHotel.addItemListener(new ItemListener()
        {
            public void itemStateChanged(ItemEvent ie){
            	textFieldLiving.setEnabled(ie.getStateChange() == ItemEvent.SELECTED);	
            	if(chckbxHotel.isEnabled()){
            		textFieldLiving.setText("");
            	}else{
            		textFieldLiving.setText("0");
            	}
				}
			}
		);
	    
	    chckbxLiving.addItemListener(new ItemListener()
        {
            public void itemStateChanged(ItemEvent ie){
            	textFieldFood.setEnabled(ie.getStateChange() == ItemEvent.SELECTED);	
            	if(chckbxLiving.isEnabled()){
            		textFieldFood.setText("");
            	}else{
            		textFieldFood.setText("0");
            	}
				}
			}
		);
	    
	    chckbxFood.addItemListener(new ItemListener()
        {
            public void itemStateChanged(ItemEvent ie){
            	textFieldHotel.setEnabled(ie.getStateChange() == ItemEvent.SELECTED);	
            	if(chckbxFood.isEnabled()){
            		textFieldHotel.setText("");
            	}else{
            		textFieldHotel.setText("0");
            	}
				}
			}
		);
	    
	    chckbxOther.addItemListener(new ItemListener()
        {
            public void itemStateChanged(ItemEvent ie){
            	textFieldOther.setEnabled(ie.getStateChange() == ItemEvent.SELECTED);
            	if(chckbxOther.isEnabled()){
            		textFieldOther.setText("");
            	}else{
            		textFieldOther.setText("0");
            	}
				}
			}
		);
		
	    
	    
	    
	    textFieldTravelPrices.addMouseListener(new MouseAdapter() { 
	          public void mousePressed(MouseEvent me) { 
				if((chckbxTravelPrices.isSelected())&&(textFieldTravelPrices.isEnabled())){
					suma = GetSuma(textFieldTravelPrices.getText(),textFieldFood.getText(),textFieldHotel.getText(),textFieldLiving.getText(),textFieldOther.getText());
				label.setText(suma+" $");		
				suma = 0.0;
				}
			}	
			
		});
		textFieldFood.addMouseListener(new MouseAdapter() { 
	          public void mousePressed(MouseEvent me) { 
				if((chckbxLiving.isSelected())&&(textFieldFood.isEnabled())){
					suma = GetSuma(textFieldTravelPrices.getText(),textFieldFood.getText(),textFieldHotel.getText(),textFieldLiving.getText(),textFieldOther.getText());
				label.setText(suma+" $");
				suma = 0.0;
				}
				
			}
			
		});
		textFieldHotel.addMouseListener(new MouseAdapter() { 
	          public void mousePressed(MouseEvent me) { 
				if((chckbxFood.isSelected())&&(textFieldHotel.isEnabled())){
					suma = GetSuma(textFieldTravelPrices.getText(),textFieldFood.getText(),textFieldHotel.getText(),textFieldLiving.getText(),textFieldOther.getText());
				label.setText(suma+" $");
				suma = 0.0;
				}
			}
			
		});
		textFieldLiving.addMouseListener(new MouseAdapter() { 
	          public void mousePressed(MouseEvent me) { 
				if((chckbxHotel.isSelected())&&(textFieldLiving.isEnabled())){
					suma = GetSuma(textFieldTravelPrices.getText(),textFieldFood.getText(),textFieldHotel.getText(),textFieldLiving.getText(),textFieldOther.getText());
				label.setText(suma+" $");
				suma = 0.0;
				}
			}
			
		});
		textFieldOther.addMouseListener(new MouseAdapter() { 
	          public void mousePressed(MouseEvent me) { 
				if((chckbxOther.isSelected())&&(textFieldOther.isEnabled())){
				suma = GetSuma(textFieldTravelPrices.getText(),textFieldFood.getText(),textFieldHotel.getText(),textFieldLiving.getText(),textFieldOther.getText());
				label.setText(suma+" $");
				suma = 0.0;
				}
			}
			
		});
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				double food,hotel,living,other,travel;
				int dzien=argdzien,
				miesiac,
				rok;
				String nmiejsc, srtrans, godzina;
				int id_rozli, id_dat, id_podr;
				
				if((textFieldTravelPrices.getText().isEmpty()) && !(chckbxTravelPrices.isSelected()))
					food=0.0;
				else
					food = Double.parseDouble(textFieldTravelPrices.getText());  
				
				if((textFieldFood.getText().isEmpty()) && !(chckbxFood.isSelected()))
					hotel=0.0;
				else
					hotel = Double.parseDouble(textFieldFood.getText());
				
				if((textFieldHotel.getText().isEmpty()) && !(chckbxHotel.isSelected()))
					living=0.0;
				else
					living = Double.parseDouble(textFieldHotel.getText());
				
				if((textFieldLiving.getText().isEmpty()) && !(chckbxLiving.isSelected()))
					travel=0.0;
				else
					travel = Double.parseDouble(textFieldLiving.getText());
				
				if((textFieldOther.getText().isEmpty()) && !(chckbxOther.isSelected()))
					other=0.0;
				else
					other = Double.parseDouble(textFieldOther.getText());
				//=======================================================
				if(textFieldCity.getText().isEmpty())
					nmiejsc="Nie podano";
				else
					nmiejsc = textFieldCity.getText();
				if(textFieldConveyance.getText().isEmpty())
					srtrans="Nie podano";
				else
					srtrans = textFieldConveyance.getText();
				if(textFieldTime.getText().isEmpty())
					godzina="Nie podano";
				else
					godzina = textFieldTime.getText();
				
				BazaDanych b = new BazaDanych();
				
				List<Rozliczenia> rozliczenia = b.selectRozliczenia();
				List<Podroze> podroze = b.selectPodroze();
				List<Data> data = b.selectData();
				
				b.insertRozliczenia(food, hotel, living, travel, other);
				//DATA=======================
				b.insertData(argdzien,11,2014);
				//DATA=======================   
					id_podr=podroze.size();
					if(id_podr==0){
						id_rozli=1;
						id_dat=1;
					}else{
					id_rozli = rozliczenia.get(rozliczenia.size()-1).getId()+1;
					id_dat = data.get(data.size()-1).getId_daty()+1;
					}
			   b.insertPodroze(id_rozli, id_dat, nmiejsc, srtrans, godzina);
				

			    
			  //  textFieldTravelPrices.setText(String.valueOf(rozliczenia.get(0).getPTravel()));	    
			  //  textFieldFood.setText(String.valueOf(rozliczenia.get(0).getPFood())); //to sa przykladowe ustawienia zeby pokazac jak wydowbywac dane z bazy
			  //  textFieldHotel.setText(String.valueOf(rozliczenia.get(0).getPHotel()));
			  //  textFieldLiving.setText(String.valueOf(rozliczenia.get(0).getPLiving()));
			  //  textFieldOther.setText(String.valueOf(rozliczenia.get(0).getPOther()));
			    
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
	
	double GetSuma(String TP, String F, String H, String L, String O){
		double suma=0;	
		String tab[]={TP,F,H,L,O};
		for(int i=0; i<5; i++){
			if(tab[i].equals("")){
				suma = suma + 0;
			}else{
				suma = suma + Double.parseDouble(tab[i]);
			}
		}

		return suma;
	}
}
