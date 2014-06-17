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
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.swing.Box;
import javax.swing.JDialog;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JPanel;

import tabele.Data;
import tabele.Podroze;
import tabele.Rozliczenia;
import baza.BazaDanych;


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
				int dzien=0, mies=0, rok=0;
				String trans = null, miejsc = null, godzina = null;
				double kasa=0.0;
				String datastr;
				Date n = new Date();
				long nwart = n.getTime();
				Date t = null; 
				SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd");
				long diff = nwart;
				int id_dat=0;
				int id_rozl=0;
				BazaDanych b = new BazaDanych();
				
				
				
				List<Rozliczenia> rozliczenia = b.selectRozliczenia();
				List<Podroze> podroze = b.selectPodroze();
				List<Data> data = b.selectData();
				
				for(int i=0; i<data.size(); i++){
					
					datastr = String.valueOf(data.get(i).getRok())+'-'+String.valueOf(data.get(i).getMiesiac())+'-'+String.valueOf(data.get(i).getDzien());
					
					try { 
				          t = ft.parse(datastr); 
				      } catch (Exception e) { 
				          System.out.println("Unparseable using " + ft); 
				      }
					
					if((diff>(t.getTime() - nwart)) && ((t.getTime() - nwart)>=0)){
					diff = t.getTime() - nwart;
					id_dat = data.get(i).getId_daty();
					dzien =data.get(i).getDzien();
					mies = data.get(i).getMiesiac();
					rok = data.get(i).getRok();
					}					
				}
					
				for (int p=0; p<podroze.size(); p++){
					if(podroze.get(p).getId_daty() == id_dat){
						id_rozl = podroze.get(p).getId_rozl();
						trans = podroze.get(p).getSr_transportu();
						godzina = podroze.get(p).getGodzina();
						miejsc = podroze.get(p).getNazwa_miejsc();
					}
				}
				
				for (int k=0; k<rozliczenia.size(); k++){
					if(rozliczenia.get(k).getId() == id_rozl){
						kasa = rozliczenia.get(k).getPFood() + rozliczenia.get(k).getPHotel() + rozliczenia.get(k).getPLiving() + rozliczenia.get(k).getPOther() + rozliczenia.get(k).getPTravel();
					}
				}	
				
				NextTravel dialog = new NextTravel(dzien, mies, rok, trans, godzina, miejsc, kasa);
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
