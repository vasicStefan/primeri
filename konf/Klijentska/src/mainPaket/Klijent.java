package mainPaket;

import java.util.List;

import mojServis.Conference;
import mojServis.KonfWebRemote;
import mojServis.KonfWebService;

public class Klijent {

	public static void main(String[] args) {
		KonfWebService kws = new KonfWebService();
		KonfWebRemote kwr = kws.getKonfWebPort();
		List<Conference> lista = kwr.getKonferencije("Nauka neka");
		for (Conference conference : lista) {
			System.out.println(conference.toString());
		}

	}

}
