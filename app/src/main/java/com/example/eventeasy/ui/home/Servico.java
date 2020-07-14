package com.example.eventeasy.ui.home;

public class Servico {

    private int id;
    private String titulo;
    private String preco;
    private String tipo;
    private String descricao;
    private String endereco;
    private byte[] imagem;

    public Servico(String titulo, String preco, byte[] imagem, int id) {
        this.id = id;
        this.titulo = titulo;
        this.preco = preco;
//        this.descricao = descricao;
//        this.endereco = endereco;
        this.imagem = imagem;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getPreco() {
        return preco;
    }

    public void setPreco(String preco) {
        this.preco = preco;
    }

    public byte[] getImagem() {
        return imagem;
    }

    public void setImagem(byte[] imagem) {
        this.imagem = imagem;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
}
