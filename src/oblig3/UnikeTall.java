package oblig3;

import static javax.swing.JOptionPane.*;
import java.util.Arrays;

public class UnikeTall {
	private int[] liste;
	
	public UnikeTall(int lengde) {
		liste = new int[lengde];
	}
	
	private boolean sjekkArray(int random) {
		boolean duplicate = false;
		for (int i : liste) {
			if (random == i) {
				duplicate = true;
				break;
			}
		}
		return duplicate;
	}
	
	public void fyllArray() {
		for (int i = 0; i < liste.length; i++) {
			int random = (int)(Math.random() * (900) + 100);
			boolean duplicate = sjekkArray(random);
			if (!duplicate) {
				liste[i] = random;
			} else {
				i--;
			}
		}
	}
	
	private int finnMinsteTall() {
		Arrays.sort(liste);
		return liste[0];
	}
	
	private int finnStørsteTall() {
		return liste[liste.length - 1];
	}
	
	private double finnGjennomsnitt() {
		int antallNummer = liste.length;
		int sum = 0;
		for (int i : liste) {
			sum += i;
		}
		return (double)sum / (double)antallNummer;
	}
	
	public void visMelding() {
		String tallString = "";
		int teller = 0;
		for (int i : liste) {
			teller++;
			tallString += i + " ";
			if (teller % 10 == 0) {
				tallString += "\n";
			}
		}
		
		String melding = tallString + "\n" +
				"\n" +
				"Minste tall er " + finnMinsteTall() + "\n" +
				"Største tall er " + finnStørsteTall() + "\n" +
				"Gjennomsnittsverdien er " + String.format("%.2f", finnGjennomsnitt());
		showMessageDialog(null, melding);
	}
}