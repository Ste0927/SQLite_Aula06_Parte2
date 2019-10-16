package br.com.stefany.filadechamados;

import androidx.annotation.NonNull;

import java.io.Serializable;
import java.util.Date;
import java.util.Locale;

public class Chamado implements Serializable {
    private int id;
    private String descricao;
    private Date dataAbertura;
    private Date dataFechamento;
    private String status;
    private Fila fila;

    @NonNull
    @Override
    public String toString() {
        return String.format(
                Locale.getDefault(),
                "%s: %s",
                getDescricao(),
                getStatus()
        );
    }

    public Chamado(int id, Fila fila, String descricao, Date dataAbertura,
                   Date dataFechamento, String status) {
        setFila(fila);
        setDescricao(descricao);
        setDataAbertura(dataAbertura);
        setDataFechamento(dataFechamento);
        setStatus(status);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getDataAbertura() {
        return dataAbertura;
    }

    public void setDataAbertura(Date dataAbertura) {
        this.dataAbertura = dataAbertura;
    }

    public Date getDataFechamento() {
        return dataFechamento;
    }

    public void setDataFechamento(Date dataFechamento) {
        this.dataFechamento = dataFechamento;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Fila getFila() {
        return fila;
    }

    public void setFila(Fila fila) {
        this.fila = fila;
    }
}
