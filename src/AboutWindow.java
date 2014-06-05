import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextPane;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class AboutWindow extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();

	/**
	* Create a dialog
	 */
	public AboutWindow() {
		setTitle("About");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		

		
		getContentPane().add(contentPanel, BorderLayout.NORTH);
		{
			JLabel lblTravel = new JLabel("Business Travel Helper");
			lblTravel.setFont(new Font("Times New Roman", Font.BOLD, 24));
			contentPanel.add(lblTravel);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				final JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
				okButton.addActionListener(new ActionListener() {
					//@Override
					public void actionPerformed(ActionEvent arg0) {
						//HelpWindow.setVisible(false);
						dispose();
					}
				});
			}
		}
		{
			JTextPane txtpna = new JTextPane();
			txtpna.setEditable(false);
			txtpna.setBackground(SystemColor.control);
			txtpna.setContentType("text/html");
			txtpna.setText("<center>Authors:<br />J\u00F3zef Cury\u0142\u0142o<br />Micha\u0142 Bucior<br />Maciej Guzikowski<br /><br /><br /><br />Project for Java faculty at Univeristy of Technology in Cracow. <br />All rights reserved. 2014</center>");
			getContentPane().add(txtpna, BorderLayout.CENTER);
		}
		
	}

}
