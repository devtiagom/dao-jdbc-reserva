package application;

import model.entities.Modalidade;
import model.entities.TipoPasseio;

public class Program {

	public static void main(String[] args) {

		Modalidade m = new Modalidade(1, "Caminhada");
		TipoPasseio tp = new TipoPasseio(1, "Em Grupo", "Passeio para grupos abertos");
		
		System.out.println(m);
		System.out.println(tp);
	}

}
