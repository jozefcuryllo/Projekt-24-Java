import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;


public class PanelFactory {

	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	
	public JPanel producePanel(){
		
		JPanel panel = new JPanel();
		
		JLabel lblstJanuary = new JLabel("1st January 2014");
		
		JLabel lblKosztyDojazdu = new JLabel("Travel prices");
		
		JLabel lblFood = new JLabel("Food");
		
		JLabel lblHotel = new JLabel("Hotel");
		
		JLabel lblLiving = new JLabel("Living");
		
		JLabel lblBusinessPrices = new JLabel("Business prices");
		
		textField = new JTextField();
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		
		JLabel lblTotal = new JLabel("Total:  ");
		
		JLabel label = new JLabel("999.98$");
		
		JLabel lblOther = new JLabel("Other");
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		
		JCheckBox chckbxPaid = new JCheckBox("Paid");
		
		JCheckBox chckbxPaid_1 = new JCheckBox("Paid");
		
		JCheckBox chckbxPaid_2 = new JCheckBox("Paid");
		
		JCheckBox chckbxPaid_3 = new JCheckBox("Paid");
		
		JCheckBox chckbxPaid_4 = new JCheckBox("Paid");
		
		JCheckBox chckbxPaid_5 = new JCheckBox("Paid");
		
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(24)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addComponent(lblBusinessPrices)
										.addComponent(lblKosztyDojazdu)
										.addComponent(lblFood)
										.addComponent(lblHotel)
										.addComponent(lblLiving)
										.addComponent(lblOther))
									.addGap(30)
									.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_panel.createSequentialGroup()
											.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
												.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
											.addGap(22)
											.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
												.addComponent(chckbxPaid_1)
												.addComponent(chckbxPaid)
												.addComponent(chckbxPaid_2)))
										.addGroup(gl_panel.createSequentialGroup()
											.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
												.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addComponent(textField_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
											.addGap(21)
											.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
												.addComponent(chckbxPaid_4)
												.addComponent(chckbxPaid_3)
												.addComponent(chckbxPaid_5)))))
								.addComponent(lblstJanuary))
							.addPreferredGap(ComponentPlacement.RELATED, 432, Short.MAX_VALUE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(91)
							.addComponent(lblTotal)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(label)))
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
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
										.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(chckbxPaid_1))
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
										.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(chckbxPaid_2))
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lblKosztyDojazdu)
									.addGap(18)
									.addComponent(lblFood)
									.addGap(18)
									.addComponent(lblHotel)
									.addGap(18)
									.addComponent(lblLiving)))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(chckbxPaid_4)
								.addComponent(lblBusinessPrices)))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(chckbxPaid)
							.addGap(70)
							.addComponent(chckbxPaid_3)))
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(11)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(chckbxPaid_5)
								.addComponent(textField_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_panel.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(lblOther)))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTotal)
						.addComponent(label))
					.addContainerGap(285, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
		return panel;
		
		
		
		
	}
	
	
}
