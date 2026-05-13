package view;

import java.util.Scanner;

import service.AnaliseService;
import service.NoticiaService;
import utils.ClassificacaoNoticia;

/**
 * Classe responsável pela interface de menu do sistema.
 * Permite ao usuário interagir com o sistema através de opções no console.
 */
public class Menu {

	private Scanner sc = new Scanner(System.in);

	/**
	 * Lê uma string do usuário a partir do console.
	 * Exibe uma mensagem opcional antes da leitura.
	 *
	 * @param mensagem a mensagem exibida ao usuário antes da entrada
	 * @return a string digitada pelo usuário
	 */
	private String getStringDoUsuario(String mensagem) {
		if (mensagem != null && !mensagem.isEmpty()) {
			System.out.print(mensagem);
		}

		String entrada = sc.nextLine();

		return entrada;
	}

    /**
     * Adiciona uma notícia manualmente, solicitando texto e classificação ao usuário.
     * Se a classificação for vazia, adiciona com classificação nula.
     */
    public void adicionarNoticiaManual() {
        String texto = getStringDoUsuario("Digite o texto: ");
        String classificacao = getStringDoUsuario("Digite a classificação: ");

        if (classificacao.equals("")) {
            NoticiaService.adicionarNoticia(texto, null);
        } else {
			NoticiaService.adicionarNoticia(texto, classificacao);
        }
    }

    /**
     * Adiciona uma notícia automaticamente, analisando o texto fornecido.
     * A classificação é determinada pelo serviço de análise.
     */
    public void adicionarNoticiaAutomatica() {
        String texto = getStringDoUsuario("Digite o texto: ");
        ClassificacaoNoticia classificacao = AnaliseService.analisarClassificacaoDaNoticia(texto);
        NoticiaService.adicionarNoticia(texto, classificacao.name());
    }

    /**
     * Executa o menu principal do sistema em um loop até o usuário escolher sair.
     * Oferece opções para adicionar notícias manualmente, automaticamente, listar ou sair.
     */
    public void executarMenu() {
		while (true) {
			System.out.println("1 - adicionar manual");
			System.out.println("2 - adicionar automatico");
			System.out.println("3 - listar");
			System.out.println("4 - sair");

			String opcao = getStringDoUsuario(null);

			if (opcao.equals("1")) {
				adicionarNoticiaManual();
			} else if (opcao.equals("2")) {
				adicionarNoticiaAutomatica();
			} else if (opcao.equals("3")) {
				NoticiaService.listarNoticias();
			} else if (opcao.equals("4")) {
				break;
			} else {
				System.out.println("Opção inválida");
			}
		}

		sc.close();
	}

}