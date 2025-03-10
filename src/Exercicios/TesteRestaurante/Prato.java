package Exercicios.TesteRestaurante;

import java.lang.invoke.StringConcatFactory;

public class Prato {
    private String nome;
    private double preco;
    private String descricao;

    public Prato(String nome, double preco, String descricao){
        this.nome = nome;
        this.preco = preco;
        this.descricao = descricao;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public String getDescricao() {
        return descricao;
    }

    @Override
    public String toString(){
        return "Prato{" +
                "nome='" + nome + '\'' +
                ", preço='" + preco + '\'' +
                ", descrição='" + descricao + '\'' +
                '}';
    }

}
