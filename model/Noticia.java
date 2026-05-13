package model;

import utils.ClassificacaoNoticia;

/**
 * Classe que representa uma notícia no sistema de monitoramento de fake news.
 * Contém informações sobre o texto da notícia e sua classificação.
 */
public class Noticia {
	private String texto;
    private ClassificacaoNoticia classificacao;

    public Noticia() {}

    public Noticia(String texto, ClassificacaoNoticia classificacaoNoticia) {
        this.texto = texto;
        this.classificacao = classificacaoNoticia;
    }

    /**
     * Retorna o texto da notícia.
     *
     * @return o texto da notícia
     */
    public String getTexto() {
        return texto;
    }

    /**
     * Define o texto da notícia.
     *
     * @param texto o texto a ser definido
     */
    public void setTexto(String texto) {
        this.texto = texto;
    }

    /**
     * Retorna a classificação da notícia.
     *
     * @return a classificação da notícia
     */
    public ClassificacaoNoticia getClassificacao() {
        return classificacao;
    }

    /**
     * Define a classificação da notícia.
     *
     * @param classificacao a classificação a ser definida
     */
    public void setClassificacao(ClassificacaoNoticia classificacao) {
        this.classificacao = classificacao;
    }
}


