package service;

public class AnaliseService {
	//substitui analisar()
	  public static int calcularScore(String texto) {
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
		    
		 return score;
	  }
	  
	  //substitui analisar()
	  public static String analisarClassificacaoDaNoticia(String texto) {
		  int score = calcularScore(texto);
		  
		  if (score == 0) {
		        return "confiavel";
		    } else if (score == 1) {
		        return "duvidosa";
		    } else {
		        return "falsa";
		    }
	  }
	  
}
