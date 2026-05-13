package service;

import java.util.Set;

import utils.ClassificacaoNoticia;

/**
 * Serviço responsável pela análise de notícias para detectar possíveis fake news.
 * Utiliza indicadores para calcular um score e classificar a notícia.
 */
public class AnaliseService {
	/** Conjunto de indicadores que sugerem fake news. */
	private static final Set<String> INDICADORES_FAKE_NEWS = Set.of(
    	"!!!",
    	"URGENTE"
	);

	/** Conjunto de indicadores que sugerem notícia válida. */
	private static final Set<String> INDICADORES_NOTICIA_VALIDA = Set.of(
    	"FONTE"
	);

	/**
	 * Calcula o score de uma notícia baseado em indicadores de fake news e validade.
	 * O score aumenta se contiver indicadores de fake news, não contiver indicadores de validade,
	 * ou se o texto for muito curto.
	 *
	 * @param texto o texto da notícia a ser analisado
	 * @return o score calculado
	 */
	public static int calcularScore(String texto) {
		int score = 0;

		for (String indicadorFakeNews : INDICADORES_FAKE_NEWS) {
			if (texto.contains(indicadorFakeNews)) score++;
		}

		for (String indicadorNoticiaValida : INDICADORES_NOTICIA_VALIDA) {
			if (!texto.contains(indicadorNoticiaValida)) score++;
		}

		if (texto.length() < 10) {
			score = score + 1;
		}
		
		return score;
	}
	  
	/**
	 * Analisa e classifica uma notícia baseada no score calculado.
	 * Retorna Confiável se score = 0, Duvidosa se score = 1, Falsa caso contrário.
	 *
	 * @param texto o texto da notícia a ser classificada
	 * @return a classificação da notícia
	 */
	public static ClassificacaoNoticia analisarClassificacaoDaNoticia(String texto) {
		int score = calcularScore(texto);
		
		if (score == 0) {
			return ClassificacaoNoticia.Confiavel;
		} else if (score == 1) {
			return ClassificacaoNoticia.Duvidosa;
		} else {
			return ClassificacaoNoticia.Falsa;
		}
	}
	  
}
