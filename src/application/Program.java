package application;

import dao.DAO;
import dao.DAOFactory;
import db.JDBCConnection;
import domain.*;

import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {

		/*
		// Tabela Modalidade
		System.out.println("TESTE TABELA MODALIDADE");
		Modalidade modalidade = null;
		Modalidade modalidadeFromDB = null;
		DAO<Modalidade> modalidadeDAO = DAOFactory.createModalidadeDAO();

		// Listando uma modalidade
		System.out.println("\n--------------- Listando uma modalidade ---------------");
		modalidadeFromDB = modalidadeDAO.findById((long) 4);
		System.out.println(modalidadeFromDB);

		// Listando todas modalidades
		System.out.println("\n--------------- Listando todas modalidades ---------------");
		List<Modalidade> modalidades = modalidadeDAO.findAll();
		modalidades.forEach(System.out::println);

		// Inserindo uma modalidade
		System.out.println("\n--------------- Inserindo uma modalidade ---------------");
		modalidade = new Modalidade("Passeio de helicóptero");
//		modalidadeDAO.save(modalidade);
		modalidadeFromDB = modalidadeDAO.saveAndCheck(modalidade);
		System.out.println("Modalidade salva no banco = " + modalidadeFromDB);

		// Atualizando uma modalidade
		System.out.println("\n--------------- Atualizando uma modalidade ---------------");
		modalidade = modalidadeDAO.findById((long) 6);
		System.out.println("Modalidade original = " + modalidade);
		modalidade.setNome("Museu");
//		modalidadeDAO.update(modalidade);
		modalidadeFromDB = modalidadeDAO.updateAndCheck(modalidade);
		System.out.println("Modalidade atualizada = " + modalidadeFromDB);

		// Deletando uma modalidade
		System.out.println("\n--------------- Deletando uma modalidade ---------------");
		modalidade = modalidadeDAO.findById((long) 8);
		System.out.println("Modalidade a ser deletada = " + modalidade);
		modalidadeDAO.delete(modalidade);

		// Fechando conexão
		JDBCConnection.closeConnection();
		*/

		/***************************************************************************************************/

		/*
		// Tabela Tipo de Passeio
		System.out.println("TESTE TABELA TIPO_PASSEIO");
		TipoPasseio tipoPasseio = null;
		TipoPasseio tipoPasseioFromDB = null;
		DAO<TipoPasseio> tipoPasseioDAO = DAOFactory.createTipoPasseioDAO();

		// Listando um tipo de passeio
		System.out.println("\n--------------- Listando um tipo de passeio ---------------");
		tipoPasseioFromDB = tipoPasseioDAO.findById((long) 3);
		System.out.println(tipoPasseioFromDB);

		// Listando todos tipos de passeios
		System.out.println("\n--------------- Listando todos tipos de passeios ---------------");
		List<TipoPasseio> tiposPasseios = tipoPasseioDAO.findAll();
		tiposPasseios.forEach(System.out::println);

		// Inserindo um tipo de passeio
		System.out.println("\n--------------- Inserindo um tipo de passeio ---------------");
		tipoPasseio = new TipoPasseio("Em bando", "Passeio para um bando de gente");
//		tipoPasseioDAO.save(tipoPasseio);
		tipoPasseioFromDB = tipoPasseioDAO.saveAndCheck(tipoPasseio);
		System.out.println("Tipo de passeio salvo no banco = " + tipoPasseioFromDB);

		// Atualizando um tipo de passeio
		System.out.println("\n--------------- Atualizando um tipo de passeio ---------------");
		tipoPasseio = tipoPasseioDAO.findById((long) 1);
		System.out.println("Tipo de passeio original = " + tipoPasseio);
		tipoPasseio.setNomePasseio("Privativo");
		tipoPasseio.setDescricaoPasseio("Passeio somente para pessoa ou casal");
//		tipoPasseioDAO.update(tipoPasseio);
		tipoPasseioFromDB = tipoPasseioDAO.updateAndCheck(tipoPasseio);
		System.out.println("Tipo de passeio atualizado = " + tipoPasseioFromDB);

		// Deletando um tipo de passeio
		System.out.println("\n--------------- Deletando um tipo de passeio ---------------");
		tipoPasseio = tipoPasseioDAO.findById((long) 4);
		System.out.println("Tipo de passeio a ser deletado = " + tipoPasseio);
		tipoPasseioDAO.delete(tipoPasseio);

		// Fechando conexão
		JDBCConnection.closeConnection();
		*/

		/***************************************************************************************************/

		/*
		// Tabela País
		System.out.println("TESTE TABELA PAÍS");
		Pais pais = null;
		Pais paisFromDB = null;
		DAO<Pais> paisDAO = DAOFactory.createPaisDAO();

		// Listando um país
		System.out.println("\n--------------- Listando um pais ---------------");
		paisFromDB = paisDAO.findById((long) 2);
		System.out.println(paisFromDB);

		// Listando todos paises
		System.out.println("\n--------------- Listando todos países ---------------");
		List<Pais> paises = paisDAO.findAll();
		paises.forEach(System.out::println);

		// Inserindo um país
		System.out.println("\n--------------- Inserindo um país ---------------");
		pais = new Pais("Itália");
//		paisDAO.save(pais);
		paisFromDB = paisDAO.saveAndCheck(pais);
		System.out.println("País salvo no banco = " + paisFromDB);

		// Atualizando um país
		System.out.println("\n--------------- Atualizando um país ---------------");
		pais = paisDAO.findById((long) 2);
		System.out.println("País original = " + pais);
		pais.setNomePais("França");
//		paisDAO.update(pais);
		paisFromDB = paisDAO.updateAndCheck(pais);
		System.out.println("País atualizado = " + paisFromDB);

		// Deletando um país
		System.out.println("\n--------------- Deletando um país ---------------");
		pais = paisDAO.findById((long) 5);
		System.out.println("País a ser deletado = " + pais);
		paisDAO.delete(pais);

		// Fechando conexão
		JDBCConnection.closeConnection();
		*/

		// Tabela Estado
		System.out.println("TESTE TABELA ESTADO");
		Estado estado = null;
		Estado estadoFromDB = null;
		DAO<Estado> estadoDAO = DAOFactory.createEstadoDAO();

		// Listando um estado
		System.out.println("\n--------------- Listando um estado ---------------");
		estadoFromDB = estadoDAO.findById((long) 4);
		System.out.println(estadoFromDB);

		// Listando todos estados
		System.out.println("\n--------------- Listando todos estados ---------------");
		List<Estado> estados = estadoDAO.findAll();
		estados.forEach(System.out::println);

		// Inserindo um estado
		System.out.println("\n--------------- Inserindo um estado ---------------");
		DAO<Pais> paisDAO = DAOFactory.createPaisDAO();
		Pais pais = paisDAO.findById((long) 1);
		estado = new Estado("Bahia", pais);
//		estadoDAO.save(estado);
		estadoFromDB = estadoDAO.saveAndCheck(estado);
		System.out.println("Estado salvo no banco = " + estadoFromDB);

		// Atualizando um estado
		System.out.println("\n--------------- Atualizando um estado ---------------");
		estado = estadoDAO.findById((long) 5);
		System.out.println("Estado original = " + estado);
		estado.setNomeEstado("Santa Catarina");
//		estadoDAO.update(estado);
		estadoFromDB = estadoDAO.updateAndCheck(estado);
		System.out.println("Estado atualizado = " + estadoFromDB);

		// Deletando um estado
		System.out.println("\n--------------- Deletando um estado ---------------");
		estado = estadoDAO.findById((long) 7);
		System.out.println("Estado a ser deletado = " + estado);
		estadoDAO.delete(estado);

		// Fechando conexão
		JDBCConnection.closeConnection();






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
