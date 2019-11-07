package minijuegos.generala;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

public class PuntajesAnuncio extends JFrame {

	private JPanel contentPane;



	/**
	 * Create the frame.
	 */
	public PuntajesAnuncio(String msg) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAnuncio = new JLabel(msg);
		lblAnuncio.setBounds(61, 11, 339, 218);
		contentPane.add(lblAnuncio);
	}

}
