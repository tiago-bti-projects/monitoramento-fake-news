package service;

import java.util.ArrayList;

import model.Noticia;

public class NoticiaService {
	
	static ArrayList<Noticia> listaNoticia = new ArrayList<>();

	  //substitui f()
	  public static void adicionarNoticia(String texto, String classificacao) {
	      if (texto != null && !texto.equals("")) {
	          Noticia noticia = criarNoticia(texto, classificacao);
	          salvarNoticia(noticia);
	      } else {
	          System.out.println("Erro: texto inválido.");
	      }
	  }
	  
	  //substitui f()
	  public static Noticia criarNoticia(String texto, String classificacao) {
	      Noticia noticia = new Noticia();
	      noticia.texto = texto;
	      noticia.classificacao = definirClassificacao(classificacao);
	      return noticia;
	  }
	  
	  //substitui f()
	  public static String definirClassificacao(String classificacao) {
	      if (classificacao == null || classificacao.equals("")) {
	          return "duvidosa";
	      }
	      return classificacao;
	  }
	  
	  //substitui f()
	  public static void salvarNoticia(Noticia noticia) {
	      listaNoticia.add(noticia);
	  }


	  public static void listarNoticias() {
	    // lista tudo
	    for (int i = 0; i < listaNoticia.size(); i++) {
	      System.out.println("Texto: " + listaNoticia.get(i).texto);
	      System.out.println("Classificacao: " + listaNoticia.get(i).classificacao);
	      System.out.println("-------------------");
	    }
	  }

}
