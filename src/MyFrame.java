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
import javax.swing.DefaultComboBoxModel;
import javax.swing.JPanel;


public class MyFrame {

	JFrame frame;


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
		frame = new JFrame("Travel Helper");
		frame.setResizable(false);
		frame.setBounds(100, 100, 770, 678);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mnFile.add(mntmExit);
		
		mntmExit.addActionListener(new ActionListener() {
			//@Override
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		
		JMenu mnView = new JMenu("View");
		menuBar.add(mnView);
		
		JMenuItem mntmNextTravel = new JMenuItem("Next travel");
		mnView.add(mntmNextTravel);
			
		mntmNextTravel.addActionListener(new ActionListener() {
			//@Override
			public void actionPerformed(ActionEvent arg0) {
				NextTravel dialog = new NextTravel();
				dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				dialog.setVisible(true);	
			}
		});
		
		JMenu mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);
		
		JMenuItem mntmHelp = new JMenuItem("Help");

		
		mnHelp.add(mntmHelp);
		
		mntmHelp.addActionListener(new ActionListener() {
			//@Override
			public void actionPerformed(ActionEvent arg0) {
				HelpWindow dialog = new HelpWindow();
				dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				dialog.setVisible(true);
				
				
			}
		});
		
		
		
		JMenuItem mntmAbout = new JMenuItem("About");
		mnHelp.add(mntmAbout);
		
		mntmAbout.addActionListener(new ActionListener() {
			//@Override
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
		
		final JPanel[] panel = new JPanel [31];
		PanelFactory fabryka = new PanelFactory();
		

		for (int i=0; i<31; i++){
			panel[i] = fabryka.producePanel();
			tabbedPane.addTab( Integer.toString(i+1), null, panel[i], Integer.toString(i+1));
		}
		
		
	}
}
