package service;

import java.util.ArrayList;

import model.Noticia;
import utils.StringValidator;

public class NoticiaService {
	
	static ArrayList<Noticia> listaNoticia = new ArrayList<>();

	  //substitui f()
	  public static void adicionarNoticia(String texto, String classificacao) {
	      Noticia noticia = criarNoticia(texto, classificacao);
				salvarNoticia(noticia);
	  }
	  
	  //substitui f()
	  public static Noticia criarNoticia(String texto, String classificacao) {
			Noticia noticia = new Noticia();

			StringValidator.validarString(texto).ifPresentOrElse(
				(valor) -> noticia.setTexto(valor),
				() -> System.err.println("ERRO: texto inválido")
 			);	

			String classificacaoTratada = StringValidator.validarString(classificacao, "duvidosa");
			noticia.setClassificacao(classificacaoTratada);

			return noticia;
	  }
	  
	  //substitui f()
	  public static void salvarNoticia(Noticia noticia) {
	      listaNoticia.add(noticia);
	  }


	  public static void listarNoticias() {
	    // lista tudo
	    for (int i = 0; i < listaNoticia.size(); i++) {
	      System.out.println("Texto: " + listaNoticia.get(i).getTexto());
	      System.out.println("Classificacao: " + listaNoticia.get(i).getClassificacao());
	      System.out.println("-------------------");
	    }
	  }

}
