package utils;

import java.util.Optional;

/**
 * Classe utilitária para validação de strings.
 * Fornece métodos para verificar se uma string é válida (não nula e não vazia).
 */
public class StringValidator {

	/**
	 * Valida uma string, retornando Optional com o valor se for válida,
	 * ou Optional vazio se for nula ou vazia.
	 *
	 * @param s a string a ser validada
	 * @return Optional contendo a string se válida, ou vazio
	 */
	public static Optional<String> validarString(String s) {
    	if (s != null && !s.isEmpty()) {
    	    return Optional.of(s);
    	}

    	return Optional.empty();
	}

	/**
	 * Valida uma string, retornando o valor se for válida,
	 * ou um valor de fallback se for nula ou vazia.
	 *
	 * @param s a string a ser validada
	 * @param fallback o valor a ser retornado se a string for inválida
	 * @return a string válida ou o fallback
	 */
	public static String validarString(String s, String fallback) {
    	if (s != null && !s.isEmpty()) {
    	    return s;
    	}

    	return fallback;
	}
}
