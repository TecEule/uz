package uz;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.text.DateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class uzPanel extends JPanel implements Runnable {
	Thread akt;

	JLabel lblUhrzeitDatum;

	/**
	 * Create the panel.
	 */
	public uzPanel() {

		setLayout(null);

		lblUhrzeitDatum = new JLabel("New label");
		lblUhrzeitDatum.setFont(new Font("Arial", Font.BOLD, 44));
		lblUhrzeitDatum.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUhrzeitDatum.setBounds(10, 11, 806, 102);
		add(lblUhrzeitDatum);

		akt = new Thread(this);
		akt.start();

	}

	private void initUhrzeitDatum() {
		LocalDate date = LocalDate.now();
		DateTimeFormatter format = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL);

		LocalTime zeit = LocalTime.now();
		DateTimeFormatter zeitFormat = DateTimeFormatter.ofLocalizedTime(FormatStyle.MEDIUM);

		lblUhrzeitDatum.setText("<html><body>" + date.format(format) + "<br><p align=\"right\">"
				+ zeit.format(zeitFormat) + "</body></html>");

	}

	@Override
	public void run() {
		while (true) {

			try {
				initUhrzeitDatum();
				akt.sleep(1000);
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
		}

	}

}
