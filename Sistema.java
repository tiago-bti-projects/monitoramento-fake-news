import java.util.ArrayList;
import java.util.Scanner;

class Noticia {
  String texto;
  String classificacao;
}

public class Sistema {

  static ArrayList<Noticia> listaNoticia = new ArrayList<>();

  // função que faz tudo
  public static void adicionarNoticia(String texto, String classificacao) {
    // adiciona coisa
    if (texto != null && !texto.equals("")) {
      Noticia noticia = new Noticia();
      noticia.texto = texto;

      if (classificacao == null || classificacao.equals("")) {
          noticia.classificacao = "duvidosa";
      } else {
          noticia.classificacao = classificacao;
      }

      listaNoticia.add(noticia);
    } else {
      System.out.println("erro");
    }
  }

  public static void listarNoticias() {
    // lista tudo
    for (int i = 0; i < listaNoticia.size(); i++) {
      System.out.println("Texto: " + listaNoticia.get(i).texto);
      System.out.println("Classificacao: " + listaNoticia.get(i).classificacao);
      System.out.println("-------------------");
    }
  }

  public static String analisarClassificacaoDaNoticia(String texto) {
    int score = 0;

    if (!texto.contains("FONTE")) {
        score = score + 1;
    }
    if (texto.contains("!!!")) {
        score = score + 1;
    }
    if (texto.contains("URGENTE")) {
        score = score + 1;
    }
    if (texto.length() < 10) {
        score = score + 1;
    }

    if (score == 0) {
        return "confiavel";
    } else if (score == 1) {
        return "duvidosa";
    } else {
        return "falsa";
    }
  }

  public static void adicionarNoticiaManual(Scanner sc) {
    System.out.print("Digite o texto: ");
    String texto = sc.nextLine();

    System.out.print("Digite classificacao: ");
    String classificacao = sc.nextLine();

    if (classificacao.equals("")) {
        adicionarNoticia(texto, null);
    } else {
        adicionarNoticia(texto, classificacao);
    }
  }

  public static void adicionarNoticiaAutomatica(Scanner sc) {
    System.out.print("Digite o texto: ");
    String texto = sc.nextLine();

    String classificacao = analisarClassificacaoDaNoticia(texto);
    adicionarNoticia(texto, classificacao);
  }

  public static void executarMenu() {
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
        listarNoticias();
      } else if (opcao.equals("4")) {
        break;
      } else {
        System.out.println("errado");
      }
    }

    sc.close();
  }

  // inicia programa
  public static void main(String[] args) {
	 executarMenu();
  }
}