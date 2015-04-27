package awt;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class XMLComponentTesting extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6454418537204021923L;

	/**
	 * Create the panel.
	 */
	public XMLComponentTesting() {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Text");
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel.setToolTipText("tooltip\r\n");
		lblNewLabel.setLabelFor(this);
		lblNewLabel.setIcon(null);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setEnabled(false);
		lblNewLabel.setDisplayedMnemonic(' ');
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setBounds(202, 5, 46, 14);
		add(lblNewLabel);

	}

}
