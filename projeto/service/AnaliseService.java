package service;

import java.util.Set;

import utils.ClassificacaoNoticia;

public class AnaliseService {
	private static final Set<String> INDICADORES_FAKE_NEWS = Set.of(
    	"!!!",
    	"URGENTE"
	);

	private static final Set<String> INDICADORES_NOTICIA_VALIDA = Set.of(
    	"FONTE"
	);

	//substitui analisar()
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
	  
	//substitui analisar()
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
