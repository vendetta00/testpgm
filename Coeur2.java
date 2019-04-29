package testWin;

import java.util.Calendar;

public class Coeur2 extends Thread {

	public int temps2;
	public int tempsMatin;
	public int tempsPauseMidi; 

	public Coeur2 (String name, int temps, int tempsMatin, int tempsPauseMidi) {

		super (name);
		this.temps2 = temps;	
		this.tempsMatin = tempsMatin;
		this.tempsPauseMidi = tempsPauseMidi; 
	}

	public void start(int a)
	{
		this.start();

	}

	public void run() {

		try {
			Thread.sleep(temps2);

			int Rushhour;
			int heureTotalTravail;
			double tempsfinEst;
			int tempsfinEst2;
			double tempsTotal = 440;
			int tempsTotal2 = 440;
			double tempsfinEstMinute;
			double tempsfinEstHeure;
			int tempsfinEstMinute2;
			int tempsfinEstHeure2;
			double progression;
			String tempsfinEstHeureEtMinutesDisplay ;
			double minuteRestantes;
			int minuteRestantes2;
		    //----------------------------------------------------------------
			Calendar cal = Calendar.getInstance();
			int hour = cal.get(Calendar.HOUR_OF_DAY);
			int minute = cal.get(Calendar.MINUTE);

			Rushhour = (hour * 60) + minute;
			heureTotalTravail = Rushhour - tempsMatin - tempsPauseMidi;
			tempsfinEst = tempsMatin + tempsTotal + tempsPauseMidi;
			tempsfinEst2 = tempsMatin + tempsTotal2 + tempsPauseMidi;
			//--------------------------------------
			
			tempsfinEstHeure = tempsfinEst / 60;
			tempsfinEstMinute = tempsfinEst % 60; 
			
			//----------------------
			tempsfinEstMinute2 =  tempsfinEst2  %60;
			tempsfinEstHeure2 =  tempsfinEst2 /60;
			
			tempsfinEstHeureEtMinutesDisplay = String.valueOf(tempsfinEstHeure2) + ":" + String.valueOf(tempsfinEstMinute2) ;
			
			minuteRestantes = tempsfinEst - Rushhour  ;
			minuteRestantes2 = tempsfinEst2 - Rushhour  ;
			//----------------------------------------
			
			if (tempsTotal2 >= minuteRestantes2) {
				System.out.println("ici");
				
				progression = (tempsTotal - minuteRestantes) * 100 / tempsTotal ;
				System.out.println("progression" + progression);
			}
			else {
				progression = 100; 
			}
			System.out.println(minuteRestantes);
			System.out.println(tempsTotal);
			System.out.println(progression);
			
			Fenetre.miseAjourTempsRestant(minuteRestantes2);
			Fenetre.miseAjourHeureDepart(String.valueOf(tempsfinEstHeureEtMinutesDisplay));
			Fenetre.miseAjourProgressBar(progression);
			this.run();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}






}
