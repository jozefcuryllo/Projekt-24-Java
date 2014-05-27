import javax.swing.JFrame;
import javax.swing.JToolBar;
import java.awt.BorderLayout;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;
import javax.swing.JComboBox;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.JDialog;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JCheckBox;


public class MyFrame {

	JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

	/**
	 * Create the application.
	 */
	public MyFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Business Travel Helper");
		frame.setBounds(100, 100, 770, 647);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmNew = new JMenuItem("New");
		mnFile.add(mntmNew);
		
		JMenuItem mntmOpen = new JMenuItem("Open");
		mnFile.add(mntmOpen);
		
		JMenuItem mntmSave = new JMenuItem("Save");
		mnFile.add(mntmSave);
		
		JMenuItem mntmPrint = new JMenuItem("Print");
		mnFile.add(mntmPrint);
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mnFile.add(mntmExit);
		
		mntmExit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		
		JMenu mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);
		
		JMenuItem mntmHelp = new JMenuItem("Help");

		
		mnHelp.add(mntmHelp);
		
		mntmHelp.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				HelpWindow dialog = new HelpWindow();
				dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				dialog.setVisible(true);
				
				
			}
		});
		
		
		
		JMenuItem mntmAbout = new JMenuItem("About");
		mnHelp.add(mntmAbout);
		
		mntmAbout.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				AboutWindow dialog = new AboutWindow();
				dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				dialog.setVisible(true);	
			}
		});
		
		JToolBar toolBar = new JToolBar();
		frame.getContentPane().add(toolBar, BorderLayout.NORTH);
		
		JLabel lblRok = new JLabel("Year  ");
		toolBar.add(lblRok);
		
		JComboBox<Object> comboBox = new JComboBox<Object>();
		comboBox.setModel(new DefaultComboBoxModel<Object>(new String[] {"2014", "2013", "2012", "2011", "2010", "2009"}));
		comboBox.setToolTipText("Choose a year");
		toolBar.add(comboBox);
		
		Component verticalStrut = Box.createVerticalStrut(20);
		toolBar.add(verticalStrut);
		
		JLabel lblMiesic = new JLabel("Month  ");
		toolBar.add(lblMiesic);
		
		JComboBox<Object> comboBox_1 = new JComboBox<Object>();
		comboBox_1.setModel(new DefaultComboBoxModel<Object>(new String[] {"January", "February", "March", "April", "May", "Juli", "Juni", "September", "Oktober", "November", "December"}));
		comboBox_1.setToolTipText("Choose a month");
		toolBar.add(comboBox_1);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.LEFT);
		frame.getContentPane().add(tabbedPane, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("1", null, panel, "1");
		
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
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("2", null, panel_1, null);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("3", null, panel_2, null);
		
		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("4", null, panel_3, null);
		
		JPanel panel_4 = new JPanel();
		tabbedPane.addTab("5", null, panel_4, null);
		
		JPanel panel_5 = new JPanel();
		tabbedPane.addTab("6", null, panel_5, null);
		
		JPanel panel_6 = new JPanel();
		tabbedPane.addTab("7", null, panel_6, null);
		
		JPanel panel_7 = new JPanel();
		tabbedPane.addTab("8", null, panel_7, null);
		
		JPanel panel_8 = new JPanel();
		tabbedPane.addTab("9", null, panel_8, null);
		
		JPanel panel_9 = new JPanel();
		tabbedPane.addTab("10", null, panel_9, null);
		
		JPanel panel_10 = new JPanel();
		tabbedPane.addTab("11", null, panel_10, null);
		
		JPanel panel_11 = new JPanel();
		tabbedPane.addTab("12", null, panel_11, null);
		
		JPanel panel_12 = new JPanel();
		tabbedPane.addTab("13", null, panel_12, null);
		
		JPanel panel_13 = new JPanel();
		tabbedPane.addTab("14", null, panel_13, null);
		
		JPanel panel_14 = new JPanel();
		tabbedPane.addTab("15", null, panel_14, null);
		
		JPanel panel_15 = new JPanel();
		tabbedPane.addTab("16", null, panel_15, null);
		
		JPanel panel_16 = new JPanel();
		tabbedPane.addTab("17", null, panel_16, null);
		
		JPanel panel_17 = new JPanel();
		tabbedPane.addTab("18", null, panel_17, null);
		
		JPanel panel_18 = new JPanel();
		tabbedPane.addTab("19", null, panel_18, null);
		
		JPanel panel_19 = new JPanel();
		tabbedPane.addTab("20", null, panel_19, null);
		
		JPanel panel_20 = new JPanel();
		tabbedPane.addTab("21", null, panel_20, null);
		
		JPanel panel_21 = new JPanel();
		tabbedPane.addTab("22", null, panel_21, null);
		
		JPanel panel_22 = new JPanel();
		tabbedPane.addTab("23", null, panel_22, null);
		
		JPanel panel_23 = new JPanel();
		tabbedPane.addTab("24", null, panel_23, null);
		
		JPanel panel_24 = new JPanel();
		tabbedPane.addTab("25", null, panel_24, null);
		
		JPanel panel_25 = new JPanel();
		tabbedPane.addTab("26", null, panel_25, null);
		
		JPanel panel_26 = new JPanel();
		tabbedPane.addTab("27", null, panel_26, null);
		
		JPanel panel_27 = new JPanel();
		tabbedPane.addTab("28", null, panel_27, null);
		
		JPanel panel_28 = new JPanel();
		tabbedPane.addTab("29", null, panel_28, null);
		
		JPanel panel_29 = new JPanel();
		tabbedPane.addTab("30", null, panel_29, null);
		
		JPanel panel_30 = new JPanel();
		tabbedPane.addTab("31", null, panel_30, null);
	}
}
