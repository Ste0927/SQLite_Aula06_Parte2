package br.com.stefany.filadechamados;
import java.io.Serializable;
import java.util.List;

class Fila implements Serializable {
    private int id;
    private String nome;
    private int iconId;
    private List<Chamado> chamados;

    public Fila(int id, String nome, int iconId) {
        setId(id);
        setNome(nome);
        setIconId(iconId);
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIconId() {
        return iconId;
    }

    public void setIconId(int iconId) {
        this.iconId = iconId;
    }

    public List<Chamado> getChamados() {
        return chamados;
    }

    public void setChamados(List<Chamado> chamados) {
        this.chamados = chamados;
    }
}

