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
            @Override
            public void run() {
                new MyFrame();
            }
        });



	}

}