package utils;

import java.util.Optional;

public enum ClassificacaoNoticia {
  Confiavel,
  Duvidosa,
  Falsa;
  
  public static Optional<ClassificacaoNoticia> getValidValue(String classificacaoString) {
    try {
      return Optional.of(ClassificacaoNoticia.valueOf(classificacaoString));
    } catch (IllegalArgumentException ex) {
      return Optional.empty();
    }
  }
}
