package testWin;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.util.Calendar;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.JTextPane;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import java.awt.SystemColor;
import javax.swing.JEditorPane;
import javax.swing.ProgressMonitor;
import java.awt.Component;
import javax.swing.Box;

public class Fenetre implements ActionListener {

	private JFrame fenetre;

	//public String panelNonModifiableHeureDepart;
	static JFormattedTextField panelHeureDepart;
	JEditorPane panelNonModifiableHeureDepart;
	JButton validerFinal;
	//----------Matin----------------
	public String heureMatinString;
	JLabel HeureMatinValid;

	//----------Midi------------------

	JFormattedTextField heureMidiValid;

	//----------ApMidi----------------

	JFormattedTextField heureApValid;

	//-------------MAJ----------------

	static JFormattedTextField panelMinuteRestante;

	//---------Boolean----------------

	boolean calcul ;

	//------------calcul--------------

	public int minutesTravailReglementaire = 440 ;
	public int totalMinutesMatin;
	public int totalMinutesMidi;
	public int totalMinutesApMidi;
	public int totalPauseMidi; 
	public int totalMinutesSystem;


	//-----------------------
	public Coeur2 temps;

	//----------
	static JProgressBar progressBar;
	
	//------
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Fenetre window = new Fenetre();
					window.fenetre.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Fenetre() {
		initialize();
	}


	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		fenetre = new JFrame();
		fenetre.setBounds(100, 100, 450, 300);
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fenetre.getContentPane().setLayout(null);






		//--------------------------------------------------------------
		//---------------------------matin------------------------------
		//--------------------------------------------------------------

		JFormattedTextField heureMatinPanel = new JFormattedTextField();
		heureMatinPanel.setBounds(82, 29, 61, 22);
		fenetre.getContentPane().add(heureMatinPanel);
		heureMatinPanel.setText("");


		JTextPane deuxPointsPanel_1 = new JTextPane();
		deuxPointsPanel_1.setBackground(SystemColor.menu);
		deuxPointsPanel_1.setText(":");
		deuxPointsPanel_1.setBounds(153, 31, 6, 20);
		fenetre.getContentPane().add(deuxPointsPanel_1);
		deuxPointsPanel_1.setEditable(false);


		JFormattedTextField MinuteMatinPanel = new JFormattedTextField();
		MinuteMatinPanel.setText("");
		MinuteMatinPanel.setBounds(172, 29, 61, 22);
		fenetre.getContentPane().add(MinuteMatinPanel);




		JButton validerBouton_1 = new JButton("Valider");
		validerBouton_1.setBounds(260, 28, 71, 23);
		fenetre.getContentPane().add(validerBouton_1);

		validerBouton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				int heureMatin = 0;
				int minuteMatin = 0;
				try {
					heureMatin = Integer.parseInt(heureMatinPanel.getText());	
					minuteMatin = Integer.parseInt(MinuteMatinPanel.getText());
				}catch (Exception e){
					e.getMessage(); 
					e.printStackTrace();
				}

				//--Récupération des données


				HeureMatinValid.setText(String.valueOf(heureMatin + ":" + minuteMatin ))  ;	

				//--Calcul à partir des données récupérées
				System.out.println(HeureMatinValid.getText() + "" + heureMidiValid.getText() + "" + heureApValid.getText() );
				totalMinutesMatin = (heureMatin * 60) + minuteMatin;
				System.out.println("totalMinutesMatin :" + totalMinutesMatin);

				//--déblocage boutton final valid------

				if (!HeureMatinValid.getText().equals("")  && !heureMidiValid.getText().equals("") && !heureApValid.getText().equals("")) {

					validerFinal.setEnabled(true);

				}



			}
		});

		//--------------------------------------------------------------
		//---------------------------midi-------------------------------
		//--------------------------------------------------------------

		JFormattedTextField heureMidiPanel = new JFormattedTextField();
		heureMidiPanel.setText("");
		heureMidiPanel.setBounds(82, 80, 61, 22);
		fenetre.getContentPane().add(heureMidiPanel); 



		JTextPane deuxPointsPanel_2 = new JTextPane();
		deuxPointsPanel_2.setText(":");
		deuxPointsPanel_2.setEditable(false);
		deuxPointsPanel_2.setBackground(SystemColor.menu);
		deuxPointsPanel_2.setBounds(153, 82, 6, 20);
		fenetre.getContentPane().add(deuxPointsPanel_2);

		JFormattedTextField minuteMidiPanel = new JFormattedTextField();
		minuteMidiPanel.setText("");
		minuteMidiPanel.setBounds(172, 80, 61, 22);
		fenetre.getContentPane().add(minuteMidiPanel);



		JButton validerBouton_2 = new JButton("Valider");
		validerBouton_2.setBounds(260, 79, 71, 23);
		fenetre.getContentPane().add(validerBouton_2);

		validerBouton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg1) {

				int heureMidi = 0;
				int minuteMidi = 0;
				try {
					heureMidi = Integer.parseInt(heureMidiPanel.getText());	
					minuteMidi = Integer.parseInt(minuteMidiPanel.getText());
				}catch (Exception e){
					e.getMessage(); 
					e.printStackTrace();
				}

				//--Récupération des données

				heureMidiValid.setText(String.valueOf(heureMidi + ":" + minuteMidi ))  ;	

				//--Calcul à partir des données récupérées

				totalMinutesMidi = (heureMidi * 60) + minuteMidi;
				System.out.println("totalMinutesMatin :" + totalMinutesMidi);

				//--déblocage boutton final valid------

				if (!HeureMatinValid.getText().equals("")  && !heureMidiValid.getText().equals("") && !heureApValid.getText().equals("")) {

					validerFinal.setEnabled(true);

				}
			}
		});

		//--------------------------------------------------------------
		//---------------------------ApMidi-----------------------------
		//--------------------------------------------------------------

		JFormattedTextField heureApPanel = new JFormattedTextField();
		heureApPanel.setText("");
		heureApPanel.setBounds(82, 134, 61, 22);
		fenetre.getContentPane().add(heureApPanel);

		JTextPane deuxPointsPanel_3 = new JTextPane();
		deuxPointsPanel_3.setText(":");
		deuxPointsPanel_3.setEditable(false);
		deuxPointsPanel_3.setBackground(SystemColor.menu);
		deuxPointsPanel_3.setBounds(153, 136, 6, 20);
		fenetre.getContentPane().add(deuxPointsPanel_3);

		JFormattedTextField minuteApPanel = new JFormattedTextField();
		minuteApPanel.setText("");
		minuteApPanel.setBounds(172, 134, 61, 22);
		fenetre.getContentPane().add(minuteApPanel);



		JButton validerBouton_3 = new JButton("Valider");
		validerBouton_3.setBounds(260, 134, 71, 23);
		fenetre.getContentPane().add(validerBouton_3);

		validerBouton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg2) {

				int heureApMidi = 0;
				int minuteApMidi = 0;
				try {
					heureApMidi = Integer.parseInt(heureApPanel.getText());	
					minuteApMidi = Integer.parseInt(minuteApPanel.getText());
				}catch (Exception e){
					e.getMessage(); 
					e.printStackTrace();
				}

				heureApValid.setText(String.valueOf(heureApMidi + ":" + minuteApMidi ))  ;	

				//--Calcul à partir des données récupérées

				totalMinutesApMidi = (heureApMidi * 60) + minuteApMidi;
				System.out.println("totalMinutesMatin :" + totalMinutesApMidi);

				//--déblocage boutton final valid------

				if (!HeureMatinValid.getText().equals("")  && !heureMidiValid.getText().equals("") && !heureApValid.getText().equals("")) {

					validerFinal.setEnabled(true);

				}

			}
		});


		//**************************************************************************

		validerFinal = new JButton("Lancement");
		validerFinal.setEnabled(false);	
		validerFinal.setBounds(10, 179, 89, 23);
		fenetre.getContentPane().add(validerFinal);


		validerFinal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg3) {

				totalPauseMidi = totalMinutesApMidi - totalMinutesMidi;
				temps = new Coeur2("temps" , 1000, totalMinutesMatin , totalPauseMidi  );
				temps.start();



			}
		});



		panelHeureDepart = new JFormattedTextField();
		panelHeureDepart.setEditable(false);
		panelHeureDepart.setEnabled(false);
		panelHeureDepart.setBounds(105, 179, 102, 22);
		fenetre.getContentPane().add(panelHeureDepart);

		panelMinuteRestante = new JFormattedTextField();
		panelMinuteRestante.setEditable(false);
		panelMinuteRestante.setEnabled(false);
		panelMinuteRestante.setBounds(215, 180, 102, 22);
		fenetre.getContentPane().add(panelMinuteRestante);

		JEditorPane panelNonModifiableHeure_1 = new JEditorPane();
		panelNonModifiableHeure_1.setEditable(false);
		panelNonModifiableHeure_1.setText("Heure");
		panelNonModifiableHeure_1.setBackground(SystemColor.menu);
		panelNonModifiableHeure_1.setBounds(82, 11, 66, 20);
		fenetre.getContentPane().add(panelNonModifiableHeure_1);

		JEditorPane panelNonModifiableMinute_1 = new JEditorPane();
		panelNonModifiableMinute_1.setEditable(false);
		panelNonModifiableMinute_1.setText("Minutes");
		panelNonModifiableMinute_1.setBackground(SystemColor.menu);
		panelNonModifiableMinute_1.setBounds(172, 11, 66, 20);
		fenetre.getContentPane().add(panelNonModifiableMinute_1);

		JEditorPane panelNonModifiableHeure_2 = new JEditorPane();
		panelNonModifiableHeure_2.setEditable(false);
		panelNonModifiableHeure_2.setText("Heure");
		panelNonModifiableHeure_2.setBackground(SystemColor.menu);
		panelNonModifiableHeure_2.setBounds(82, 62, 66, 20);
		fenetre.getContentPane().add(panelNonModifiableHeure_2);

		JEditorPane panelNonModifiableMinute_2 = new JEditorPane();
		panelNonModifiableMinute_2.setEditable(false);
		panelNonModifiableMinute_2.setText("Minutes");
		panelNonModifiableMinute_2.setBackground(SystemColor.menu);
		panelNonModifiableMinute_2.setBounds(172, 62, 66, 20);
		fenetre.getContentPane().add(panelNonModifiableMinute_2);

		JEditorPane panelNonModifiableHeure_3 = new JEditorPane();
		panelNonModifiableHeure_3.setEditable(false);
		panelNonModifiableHeure_3.setText("Heure");
		panelNonModifiableHeure_3.setBackground(SystemColor.menu);
		panelNonModifiableHeure_3.setBounds(82, 113, 66, 20);
		fenetre.getContentPane().add(panelNonModifiableHeure_3);

		JEditorPane panelNonModifiableMinute_3 = new JEditorPane();
		panelNonModifiableMinute_3.setEditable(false);
		panelNonModifiableMinute_3.setText("Minutes");
		panelNonModifiableMinute_3.setBackground(SystemColor.menu);
		panelNonModifiableMinute_3.setBounds(172, 113, 66, 20);
		fenetre.getContentPane().add(panelNonModifiableMinute_3);

		JTextPane textPipe = new JTextPane();
		textPipe.setText("|");
		textPipe.setEditable(false);
		textPipe.setBackground(SystemColor.menu);
		textPipe.setBounds(206, 180, 6, 20);
		fenetre.getContentPane().add(textPipe);

		panelNonModifiableHeureDepart = new JEditorPane();
		panelNonModifiableHeureDepart.setEditable(false);
		panelNonModifiableHeureDepart.setText("Heure de d\u00E9part");
		panelNonModifiableHeureDepart.setBackground(SystemColor.menu);
		panelNonModifiableHeureDepart.setBounds(105, 160, 102, 20);
		fenetre.getContentPane().add(panelNonModifiableHeureDepart);

		JEditorPane panelNonModifiableMinuteRestante = new JEditorPane();
		panelNonModifiableMinuteRestante.setEditable(false);
		panelNonModifiableMinuteRestante.setText("Minutes restantes");
		panelNonModifiableMinuteRestante.setBackground(SystemColor.menu);
		panelNonModifiableMinuteRestante.setBounds(215, 161, 102, 20);
		fenetre.getContentPane().add(panelNonModifiableMinuteRestante);

		JEditorPane panelNonModifiableMatin = new JEditorPane();
		panelNonModifiableMatin.setEditable(false);
		panelNonModifiableMatin.setText("Matin");
		panelNonModifiableMatin.setBackground(SystemColor.menu);
		panelNonModifiableMatin.setBounds(6, 31, 66, 20);
		fenetre.getContentPane().add(panelNonModifiableMatin);

		JEditorPane panelNonModifiableMidi = new JEditorPane();
		panelNonModifiableMidi.setText("Midi");
		panelNonModifiableMidi.setEditable(false);
		panelNonModifiableMidi.setBackground(SystemColor.menu);
		panelNonModifiableMidi.setBounds(6, 79, 66, 20);
		fenetre.getContentPane().add(panelNonModifiableMidi);

		JEditorPane panelNonModifiableAprèsMidi = new JEditorPane();
		panelNonModifiableAprèsMidi.setText("Apr\u00E8s-Midi");
		panelNonModifiableAprèsMidi.setEditable(false);
		panelNonModifiableAprèsMidi.setBackground(SystemColor.menu);
		panelNonModifiableAprèsMidi.setBounds(6, 134, 66, 20);
		fenetre.getContentPane().add(panelNonModifiableAprèsMidi);

		HeureMatinValid = new JLabel();
		//HeureMatinValid.setEnabled(false);
		//HeureMatinValid.setEditable(false);
		HeureMatinValid.setBounds(344, 29, 77, 22);
		fenetre.getContentPane().add(HeureMatinValid);

		heureMidiValid = new JFormattedTextField();
		heureMidiValid.setEnabled(false);
		heureMidiValid.setEditable(false);
		heureMidiValid.setBounds(344, 80, 77, 22);
		fenetre.getContentPane().add(heureMidiValid);

		heureApValid = new JFormattedTextField();
		heureApValid.setEnabled(false);
		heureApValid.setEditable(false);
		heureApValid.setBounds(344, 135, 77, 22);
		fenetre.getContentPane().add(heureApValid);

		HeureMatinValid.setText("");
		heureMidiValid.setText("");
		heureApValid.setText("");

		//--------------------------------------------------------------
		//--------------------Barre de progression----------------------
		//--------------------------------------------------------------


		progressBar = new JProgressBar();
		//progressBar.setValue(progression);
		progressBar.setToolTipText("");
		progressBar.setStringPainted(true);
		progressBar.setBounds(17, 220, 305, 26);
		fenetre.getContentPane().add(progressBar);

	}

	public static void miseAjourTempsRestant(int temps)
	{
		panelMinuteRestante.setText(String.valueOf(temps));
	}
	public static void miseAjourHeureDepart(String heureDepart )
	{
		panelHeureDepart.setText(heureDepart);
	}

	public static void miseAjourProgressBar(double progression)
	{
		System.out.println(progression);
		progressBar.setValue( (int) progression);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
	}
}


