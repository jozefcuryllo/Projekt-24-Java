import java.awt.EventQueue;


public class General {

	/**
	 * Main 
	 * 
	 * @param args
	 * 
	 */
	public static void main(String[] args) {
		  EventQueue.invokeLater(new Runnable() {
           // @Override
            public void run() {
            	try {
					MyFrame window = new MyFrame();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}

            }
        });



	}

}
