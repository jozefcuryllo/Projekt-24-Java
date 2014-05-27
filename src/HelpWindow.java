import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import java.awt.SystemColor;


public class HelpWindow extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	/**
	 * Create the dialog.
	 */
	public HelpWindow() {
		setTitle("Help");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
				{
					JPanel panel = new JPanel();
					getContentPane().add(panel, BorderLayout.CENTER);
					{
						JTextPane txtpnFdfd = new JTextPane();
						txtpnFdfd.setBackground(SystemColor.control);
						txtpnFdfd.setContentType("text/html");
						txtpnFdfd.setText("In this application you need to choose <br />\r\nproper year, month (on the menu at top) and the day (on the left side).<br />\r\nAfter it you can add, browse and edit yours payments for this day. \r\n<br ><br />");
						panel.add(txtpnFdfd);
					}
				}
				okButton.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent arg0) {
						dispose();
					}
				});
			}
		}
	}

}
