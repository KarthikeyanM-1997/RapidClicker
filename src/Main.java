import java.awt.EventQueue;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JFrame;
import javax.swing.JLabel;

import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;

public class Main implements NativeKeyListener {

	
	public void nativeKeyPressed(NativeKeyEvent e) {
		if (NativeKeyEvent.getKeyText(e.getKeyCode()).equals("S")) {
			try {
				Robot r = new Robot();

				for (int t = 0; t < 1; t++) {
					r.mousePress(InputEvent.BUTTON1_MASK);
					r.mouseRelease(InputEvent.BUTTON1_MASK);
				}

			} catch (Exception e1) {
				System.out.println(e1.toString());
			}
		}

		if (NativeKeyEvent.getKeyText(e.getKeyCode()).equals("P")) {
			try {
				GlobalScreen.unregisterNativeHook();
				System.exit(1);
			} catch (Exception ex) {

			}
		}
	}

	public void nativeKeyReleased(NativeKeyEvent e) {
		// System.out.println("Key Released: " +
		// NativeKeyEvent.getKeyText(e.getKeyCode()));
	}

	public void nativeKeyTyped(NativeKeyEvent e) {
		// System.out.println("Key Typed: " + e.getKeyText(e.getKeyCode()));
	}

	private JFrame frmRapidClickerV;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frmRapidClickerV.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		try {
			GlobalScreen.registerNativeHook();
		} catch (NativeHookException ex) {
			System.err.println("There was a problem registering the native hook.");
			System.err.println(ex.getMessage());
			System.exit(1);
		}

		GlobalScreen.addNativeKeyListener(new Main());

		Logger logger = Logger.getLogger(GlobalScreen.class.getPackage().getName());
		logger.setLevel(Level.OFF);
		Handler[] handlers = Logger.getLogger("").getHandlers();
		for (int i = 0; i < handlers.length; i++) {
			handlers[i].setLevel(Level.OFF);
		}
	}

	/**
	 * Create the application.
	 */
	public Main() {
		
		//System.out.println("!!!!!!!!!!!!!!!!");
		initialize();


	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmRapidClickerV = new JFrame();
		frmRapidClickerV.setTitle("Rapid Clicker V1.0");
		frmRapidClickerV.setBounds(100, 100, 450, 300);
		frmRapidClickerV.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmRapidClickerV.getContentPane().setLayout(null);

		JLabel lblRapidClickerV = new JLabel("Rapid Clicker V1.0");
		lblRapidClickerV.setBounds(168, 11, 155, 14);
		frmRapidClickerV.getContentPane().add(lblRapidClickerV);

		JLabel lblPresssTo = new JLabel("Press \"S\" to rapidy click at the position of the cursor.");
		lblPresssTo.setBounds(10, 76, 414, 22);
		frmRapidClickerV.getContentPane().add(lblPresssTo);

		JLabel lblPresspTo = new JLabel("Press \"P\" to exit the program.");
		lblPresspTo.setBounds(10, 109, 268, 14);
		frmRapidClickerV.getContentPane().add(lblPresspTo);

		JLabel lblMadeBy = new JLabel("Made By :");
		lblMadeBy.setBounds(258, 174, 85, 14);
		frmRapidClickerV.getContentPane().add(lblMadeBy);

		JLabel lblKarthikeyanM = new JLabel("Karthikeyan M");
		lblKarthikeyanM.setBounds(287, 187, 85, 14);
		frmRapidClickerV.getContentPane().add(lblKarthikeyanM);

		JLabel lblSrmUniversity = new JLabel("SRM University");
		lblSrmUniversity.setBounds(287, 199, 96, 14);
		frmRapidClickerV.getContentPane().add(lblSrmUniversity);

		JLabel lblUsing = new JLabel("Using :");
		lblUsing.setBounds(258, 212, 46, 14);
		frmRapidClickerV.getContentPane().add(lblUsing);

		JLabel lblJnativehook = new JLabel("jnativehook");
		lblJnativehook.setBounds(287, 223, 73, 14);
		frmRapidClickerV.getContentPane().add(lblJnativehook);
	}
}
