package service;

import java.util.ArrayList;
import java.util.Optional;

import model.Noticia;
import utils.ClassificacaoNoticia;
import utils.StringValidator;

/**
 * Serviço responsável pelo gerenciamento de notícias.
 * Permite adicionar, criar, salvar e listar notícias.
 */
public class NoticiaService {
	
	/** Lista estática que armazena todas as notícias do sistema. */
	static ArrayList<Noticia> listaNoticia = new ArrayList<>();

	/**
	 * Adiciona uma nova notícia ao sistema com texto e classificação fornecidos.
	 * Cria a notícia e a salva na lista.
	 *
	 * @param texto o texto da notícia
	 * @param classificacao a classificação da notícia
	 */
	public static void adicionarNoticia(String texto, String classificacao) {
		try {
			Noticia noticia = getNoticiaValida(texto, classificacao);
			salvarNoticia(noticia);
		} catch (IllegalArgumentException ex) {
			System.err.println(ex.getMessage());
		}
	}
	  
	/**
	 * Cria uma nova instância de Noticia com o texto e classificação fornecidos.
	 * Valida o texto e trata a classificação.
	 *
	 * @param texto o texto da notícia
	 * @param classificacao a classificação da notícia
	 * @return a notícia criada
	 */
	public static Noticia getNoticiaValida(String texto, String classificacao) {
		String classificacaoTratada = StringValidator.validarString(classificacao, ClassificacaoNoticia.Duvidosa.name());
		Optional<ClassificacaoNoticia> classificacaoValida = ClassificacaoNoticia.getValidValue(classificacaoTratada);
		Optional<String> textoValido = StringValidator.validarString(texto);

		if (classificacaoValida.isEmpty()) {
			throw new IllegalArgumentException("ERRO: classificação inválida");
		}

		if (textoValido.isEmpty()) {
			throw new IllegalArgumentException("ERRO: texto inválido");
		}

		return new Noticia(textoValido.get(), classificacaoValida.get());
	}
	  
	/**
	 * Salva uma notícia na lista de notícias.
	 *
	 * @param noticia a notícia a ser salva
	 */
	public static void salvarNoticia(Noticia noticia) {
		listaNoticia.add(noticia);
	}


	/**
	 * Lista todas as notícias armazenadas no sistema.
	 * Imprime o texto e a classificação de cada notícia.
	 */
	public static void listarNoticias() {
	    for (int i = 0; i < listaNoticia.size(); i++) {
			System.out.println("Texto: " + listaNoticia.get(i).getTexto());
	      	System.out.println("Classificacao: " + listaNoticia.get(i).getClassificacao());
	      	System.out.println("-------------------");
	    }
	}

}
