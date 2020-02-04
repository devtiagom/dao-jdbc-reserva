package application;

import domain.Modalidade;
import domain.TipoPasseio;
import domain.Viajante;

import java.util.Date;

public class Program {

	public static void main(String[] args) {

		Modalidade m = new Modalidade((long) 1, "Caminhada");
		TipoPasseio tp = new TipoPasseio((long) 1, "Em Grupo", "Passeio para grupos abertos");
		Viajante v = new Viajante((long) 1, "Fulano de Tal", "159753", new Date());
		
		System.out.println(m);
		System.out.println(tp);
		System.out.println(v);
	}

}
