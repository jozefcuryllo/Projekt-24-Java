import javax.swing.JFrame;


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
		frame = new JFrame("Business Travel Helper");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
