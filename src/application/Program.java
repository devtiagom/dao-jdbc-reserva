package application;

import dao.DAO;
import dao.DAOFactory;
import domain.Modalidade;
import domain.TipoPasseio;
import domain.Viajante;

import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {

		// Listando uma modalidade
		System.out.println("Listando uma modalidade");
		DAO<Modalidade> modalidadeDAO = DAOFactory.createModalidadeDAO();
		Modalidade modalidade = modalidadeDAO.findById((long) 11);
		System.out.println(modalidade);

		// Listando todas modalidades
		System.out.println("\nListando todas modalidades");
		List<Modalidade> modalidades = modalidadeDAO.findAll();
		modalidades.forEach(System.out::println);

		// Inserindo uma modalidade
		//System.out.println("\nInserindo uma modalidade");
		//modalidade = new Modalidade("Bicicleta");
		//modalidadeDAO.save(modalidade);
		//System.out.println("Inserted! New id = " + modalidade.getIdModalidade());

		// Atualizando uma modalidade
		//System.out.println("\nAtualizando uma modalidade");
		//modalidade.setNome("Passeio de trêm");
		//modalidadeDAO.update(modalidade);

		// Deletando uma modalidade
		System.out.println("\nDeletando uma modalidade");
		modalidadeDAO.delete(modalidade);

		/*Locale.setDefault(Locale.US);

		Scanner scanner = new Scanner(System.in);

		boolean run = true;
		int table = 0;
		int query = 0;

		System.out.println("ACESSO A BASE DE DADOS DA APLICAÇÃO DE RESERVAS");

		while (run) {
			System.out.println("\nEscolha a tabela:");
			System.out.println("(1)\t\tviajante");
			System.out.println("(2)\t\tguia");
			System.out.println("(3)\t\tmodalidade");
			System.out.println("(4)\t\ttipo_passeio");
			System.out.println("(5)\t\tguia_modalidade");
			System.out.println("(6)\t\tguia_tipo_passeio");
			System.out.println("(7)\t\treserva");
			System.out.println("(8)\t\tcidade");
			System.out.println("(9)\t\testado");
			System.out.println("(10)\tpais");
			System.out.println("(0)\t\tSair");

			table = scanner.nextInt();

			if (table > 0 && table <= 10) {
				System.out.println("\nEscolha o tipo de consulta:");
				System.out.println("(1)\t\tSalvar um novo dado");
				System.out.println("(2)\t\tAtualizar um dado existente");
				System.out.println("(3)\t\tDeletar um dado existente");
				System.out.println("(4)\t\tListar um único dado");
				System.out.println("(5)\t\tListar todos os dados");
				System.out.println("(6)\t\tVoltar");
				System.out.println("(0)\t\tSair");

				query = scanner.nextInt();

				switch (query) {
					case 1:
						System.out.println("Salvar um novo dado");
						// TODO
						break;
					case 2:
						System.out.println("Atualizar um dado existente");
						// TODO
						break;
					case 3:
						System.out.println("Deletar um novo dado");
						// TODO
						break;
					case 4:
						System.out.println("Listar um único dado");
						// TODO
						break;
					case 5:
						System.out.println("Listar todos os dados");
						// TODO
						break;
					case 6:
						System.out.println("Voltar");
						// TODO
						break;
					case 0:
						System.out.println("Sair");
						// TODO
						break;
					default:
						System.out.println("Opao inválida!");
						// TODO
						break;
				}
			} else if (table == 0) {
				System.out.println("Aplicação encerrada");
				run = false;
			} else {
				System.out.println("Opção inválida!");
			}
		}

		scanner.close();*/
	}

}
