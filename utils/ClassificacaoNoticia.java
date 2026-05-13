package utils;

import java.util.Optional;

/**
 * Enumeração que representa as possíveis classificações de uma notícia.
 */
public enum ClassificacaoNoticia {
	Confiavel,
	Duvidosa,
	Falsa;
  
	/**
	 * Tenta obter um valor válido do enum a partir de uma string.
	 * Retorna Optional vazio se a string não corresponder a nenhum valor.
	 *
	 * @param classificacaoString a string a ser convertida
	 * @return Optional contendo o valor do enum se válido, ou vazio
	 */
	public static Optional<ClassificacaoNoticia> getValidValue(String classificacaoString) {
		try {
			return Optional.of(ClassificacaoNoticia.valueOf(classificacaoString));
		} catch (IllegalArgumentException ex) {
			return Optional.empty();
		}
	}
}
