package view;

import java.util.Scanner;

import service.AnaliseService;
import service.NoticiaService;
import utils.ClassificacaoNoticia;

public class Menu {


    public void adicionarNoticiaManual(Scanner sc) {
        System.out.print("Digite o texto: ");
        String texto = sc.nextLine();

        System.out.print("Digite a classificação: ");
        String classificacao = sc.nextLine();

        if (classificacao.equals("")) {
            NoticiaService.adicionarNoticia(texto, null);
        } else {
			ClassificacaoNoticia.getValidValue(classificacao).ifPresentOrElse(
				classificacaoValida -> NoticiaService.adicionarNoticia(texto, classificacaoValida),
				() -> System.err.println("ERRO: Classificação inválida")
			);
        }
    }

    public void adicionarNoticiaAutomatica(Scanner sc) {
        System.out.print("Digite o texto: ");
        String texto = sc.nextLine();

        ClassificacaoNoticia classificacao = AnaliseService.analisarClassificacaoDaNoticia(texto);

        NoticiaService.adicionarNoticia(texto, classificacao);
    }

    public  void executarMenu() {
        Scanner sc = new Scanner(System.in);

        while (true) {
          System.out.println("1 - adicionar manual");
          System.out.println("2 - adicionar automatico");
          System.out.println("3 - listar");
          System.out.println("4 - sair");

          String opcao = sc.nextLine();

          if (opcao.equals("1")) {
            adicionarNoticiaManual(sc);
          } else if (opcao.equals("2")) {
        	 adicionarNoticiaAutomatica(sc);
          } else if (opcao.equals("3")) {
            NoticiaService.listarNoticias();
          } else if (opcao.equals("4")) {
            break;
          } else {
            System.out.println("errado");
          }
        }

        sc.close();
      }

}