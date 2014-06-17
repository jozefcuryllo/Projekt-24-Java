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
	//JTextField textField;
	//JTextField textField_1;
	//private JTextField textField_2;
	//private JTextField textField_3;
	//private JTextField textField_5;
	private double suma = 0.0;
	public JPanel producePanel(){
		
		JPanel panel = new JPanel();
		
		JLabel lblstJanuary = new JLabel("1st January 2014");
		
		JLabel lblKosztyDojazdu = new JLabel("Travel prices");
		
		JLabel lblFood = new JLabel("Food");
		
		JLabel lblHotel = new JLabel("Hotel");
		
		JLabel lblLiving = new JLabel("Living");
		
		
		final JTextField textField = new JTextField("0");
		textField.setColumns(10);
		
		final JTextField textField_1 = new JTextField("0");
		textField_1.setColumns(10);
		
		final JTextField textField_2 = new JTextField("0");
		textField_2.setColumns(10);
		
		final JTextField textField_3 = new JTextField("0");
		textField_3.setColumns(10);
	
		
		JLabel lblTotal = new JLabel("Total:  ");
		
		final JLabel label = new JLabel("0$");
		
		JLabel lblOther = new JLabel("Other");
		
		final JTextField textField_5 = new JTextField("0");
		textField_5.setColumns(10);
		
		JCheckBox chckbxPaid = new JCheckBox("Paid");
		
		JCheckBox chckbxPaid_1 = new JCheckBox("Paid");
		
		JCheckBox chckbxPaid_2 = new JCheckBox("Paid");
		
		JCheckBox chckbxPaid_3 = new JCheckBox("Paid");
		
		JCheckBox chckbxPaid_5 = new JCheckBox("Paid");
		
		textField.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				suma = suma + Double.parseDouble(textField.getText());  //te wszystkie action listenery sa pic na wode
				label.setText(suma+" $");						//trzeba je poprawic bo reaguja na enter tylko
			}													//i dolar sie nie pojawia no i dodaje ciagle ta sume
																//nawet jak zmienimy jakas wartosc...
		});
		textField_1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				suma = suma + Double.parseDouble(textField_1.getText());
				label.setText(suma+" $");
				
			}
			
		});
		textField_2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				suma = suma + Double.parseDouble(textField_2.getText());
				label.setText(suma+" $");
			}
			
		});
		textField_3.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				suma = suma + Double.parseDouble(textField_3.getText());
				label.setText(suma+" $");
			}
			
		});
		textField_5.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				suma = suma + Double.parseDouble(textField_5.getText());
				label.setText(suma+" $");
			}
			
		});
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				double food,hotel,living,other,travel;
				
				if(textField.getText().isEmpty())
					food=0.0;
				else
					food = Double.parseDouble(textField.getText());  
				if(textField_1.getText().isEmpty())
					hotel=0.0;
				else
					hotel = Double.parseDouble(textField_1.getText());
				if(textField_2.getText().isEmpty())
					living=0.0;
				else
					living = Double.parseDouble(textField_2.getText());
				if(textField_3.getText().isEmpty())
					travel=0.0;
				else
					travel = Double.parseDouble(textField_3.getText());
				if(textField_5.getText().isEmpty())
					other=0.0;
				else
					other = Double.parseDouble(textField_5.getText());
				
				BazaDanych b = new BazaDanych();
			   // b.insertRozliczenia(food, hotel, living, travel, other);
				// b.insertData(day,month,year);
				// b.insertPodroze(id_rozl, id_data, nazwa_miejsc, sr_trans, godzina);
				
				//tutaj w insertPodroze id daty i id rozl trzeba wydobyc z dopiero co wsadzonych danych w insertData i insertRozliczenia
			    List<Rozliczenia> rozliczenia = b.selectRozliczenia();
			    
			   textField.setText(String.valueOf(rozliczenia.get(0).getPTravel()));	    
			    textField_1.setText(String.valueOf(rozliczenia.get(0).getPFood())); //to sa przykladowe ustawienia zeby pokazac jak wydowbywac dane z bazy
			    textField_2.setText(String.valueOf(rozliczenia.get(0).getPHotel()));
			    textField_3.setText(String.valueOf(rozliczenia.get(0).getPLiving()));
			    textField_5.setText(String.valueOf(rozliczenia.get(0).getPOther()));

				// tutaj akcja na przycisk Save
				
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
								.addComponent(lblOther))
							.addGap(30)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(textField_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(chckbxPaid_5))
								.addGroup(gl_panel.createSequentialGroup()
									.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
									.addGap(18)
									.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addComponent(chckbxPaid)
										.addComponent(chckbxPaid_3)
										.addComponent(chckbxPaid_1)))
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(chckbxPaid_2))))
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblTotal)
								.addComponent(lblstJanuary))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(label)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(btnUpdate)))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblstJanuary)
					.addGap(39)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(chckbxPaid))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(chckbxPaid_3))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(chckbxPaid_1))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(chckbxPaid_2))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(textField_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(chckbxPaid_5)))
						.addGroup(gl_panel.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
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
					.addGap(46))
		);
		panel.setLayout(gl_panel);
		
		return panel;
		
		
		
		
	}
	
	
}
