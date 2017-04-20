import java.util.Arrays;
import java.util.Scanner;

public class Matriisi {

	int rivi;
	int sarake;
	double matriisi[][];

	public Matriisi(int rivi, int sarake) {

		setRivi(rivi);
		setSarake(sarake);
		if (this.getSarake() != 0 && this.getRivi() != 0) {
			setMatriisi();
		}
	}

	public Matriisi() {
		// laskennassa käytetty tilapäinen matiriisi luodaan tyhjäksi
	}

	public int getRivi() {
		return rivi;
	}

	public void setRivi(int rivi) {
		if (rivi > 0) {
			this.rivi = rivi;
		} else {
			this.rivi = 0;
		}
	}

	public int getSarake() {
		return sarake;
	}

	public void setSarake(int sarake) {
		if (sarake > 0) {
			this.sarake = sarake;
		} else {
			this.sarake = 0;
		}
	}

	public double[][] getMatriisi() {
		return matriisi;
	}

	public void setMatriisi() {
		this.matriisi = new double[rivi][sarake];
		System.out
				.println("Syota matriisin sisalto jarjestyksessa rivi kerrallaan");
		Scanner lukija = new Scanner(System.in);

		for (int i = 0; i < this.getRivi(); i++) {
			for (int j = 0; j < this.getSarake(); j++) {
				double arvo = lukija.nextDouble();
				this.matriisi[i][j] = arvo;
			}

		}

	}
	
	//lisataan tahan vielä vakiokerroin myöhempää varten
	public Matriisi lisaa(Matriisi summa)
	{
		Matriisi summaaja = this;
		Matriisi summattava = (Matriisi) summa;
		Matriisi tulos = new Matriisi();
		tulos.setRivi(this.getRivi());
		tulos.setSarake(this.getSarake());
		
		//matriisien summaamisessa matrisien tulee olla saman kokoiset
		if(summaaja.getRivi() == summattava.getRivi() && summaaja.getSarake() == summattava.getSarake())
		{
			tulos.matriisi = new double [summattava.getRivi()][summattava.getSarake()]; 
			for (int i = 0; i<summaaja.getRivi(); i++ )
			{
				for (int j = 0; j<summaaja.getSarake(); j++)
				{
					tulos.matriisi[i][j] = summaaja.matriisi[i][j] + summattava.matriisi[i][j];
				}
			}
		}
		else
		{
			System.out.println("vain samanmuotoisia matriiseja voi summata");
		}
		return tulos;
	}
	
    public Matriisi kerro (int k)
    {

    	Matriisi tulos = new Matriisi();
		tulos.setRivi(this.getRivi());
		tulos.setSarake(this.getSarake());
		tulos.matriisi = new double[tulos.getRivi()][tulos.getSarake()];
    	for (int i = 0; i<this.getRivi(); i++)
    	{
    		for (int j = 0; j<this.getSarake(); j++)
        	{
        		tulos.matriisi[i][j] += this.matriisi[i][j] * k;
        	}	
    	}
    	return tulos;
    }
	

	public Matriisi kerroMatriisit(Matriisi kerro) {

		Matriisi kertoja = this;
		Matriisi kerrotava = (Matriisi) kerro;
		Matriisi tulos = new Matriisi();

		/*
		 * matriisin kertolaskun säännöt: Amxn matriisin voi kertoa ainoastaan
		 * muotoa Bnxz eli matriisin A sarakkeet = matriisin B rivit Tuloksena
		 * matriisi muotoa Amxz Väärän kokoisia matriiseja ei voi kertoa
		 * keskenään
		 * 
		 * Kertolaskussa lasketaan summa Matriisin A rivialkion Aj kertolaskusta
		 * Matriisin B sarakealkion Bj kanssa
		 */

		if (kertoja.getSarake() == kerrotava.getRivi()) {
			int Arivit = kertoja.getRivi();
			int Bsarake = kerrotava.getSarake();
			int Asarake = kertoja.getSarake();
			tulos.setRivi(kertoja.getRivi());
			tulos.setSarake(kerrotava.getSarake());
			tulos.matriisi = new double[tulos.getRivi()][tulos.getSarake()];

			// lasketaan tulosmatriisin arvot
			for (int i = 0; i < Arivit; i++) {
				for (int j = 0; j < Bsarake; j++) {
					for (int k = 0; k < Asarake; k++) {
						tulos.matriisi[i][j] += kertoja.matriisi[i][k]
								* kerrotava.matriisi[k][j];
					}
				}
			}

		}

		else {
			System.out.print("Matriisit eivät kerrottavissa");
		}
		return tulos;
	}

	public void tulosta() {

		for (int i = 0; i < this.rivi; i++) {
			for (int j = 0; j < this.sarake; j++) {
				System.out.print(this.matriisi[i][j] + " ");
			}
			System.out.println("");
		}

	}

}
