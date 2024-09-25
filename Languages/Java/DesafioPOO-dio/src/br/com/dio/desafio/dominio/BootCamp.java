package br.com.dio.desafio.dominio;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class BootCamp {
    private String nome;
    private String descricao;
    private LocalDate dataInicial;
    private LocalDate dataFinal;
    private Set<Dev> inscritos;
    private Set<Conteudo> conteudos;

    public BootCamp() {
      this.dataInicial = LocalDate.now();
      this.dataInicial = dataInicial.plusDays(45l);
      this.inscritos = new HashSet<>();
      this.conteudos = new LinkedHashSet<>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDate getDataInicial() {
        return dataInicial;
    }

    public void setDataInicial(LocalDate dataInicial) {
        this.dataInicial = dataInicial;
    }

    public LocalDate getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(LocalDate dataFinal) {
        this.dataFinal = dataFinal;
    }

    public Set<Dev> getInscritos() {
        return inscritos;
    }

    public void setInscritos(Set<Dev> inscritos) {
        this.inscritos = inscritos;
    }

    public Set<Conteudo> getConteudos() {
        return conteudos;
    }

    public void setConteudos(Set<Conteudo> conteudos) {
        this.conteudos = conteudos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BootCamp bootCamp)) return false;

        if (getNome() != null ? !getNome().equals(bootCamp.getNome()) : bootCamp.getNome() != null) return false;
        if (getDescricao() != null ? !getDescricao().equals(bootCamp.getDescricao()) : bootCamp.getDescricao() != null)
            return false;
        if (getDataInicial() != null ? !getDataInicial().equals(bootCamp.getDataInicial()) : bootCamp.getDataInicial() != null)
            return false;
        if (getDataFinal() != null ? !getDataFinal().equals(bootCamp.getDataFinal()) : bootCamp.getDataFinal() != null)
            return false;
        if (getInscritos() != null ? !getInscritos().equals(bootCamp.getInscritos()) : bootCamp.getInscritos() != null)
            return false;
        return getConteudos() != null ? getConteudos().equals(bootCamp.getConteudos()) : bootCamp.getConteudos() == null;
    }

    @Override
    public int hashCode() {
        int result = getNome() != null ? getNome().hashCode() : 0;
        result = 31 * result + (getDescricao() != null ? getDescricao().hashCode() : 0);
        result = 31 * result + (getDataInicial() != null ? getDataInicial().hashCode() : 0);
        result = 31 * result + (getDataFinal() != null ? getDataFinal().hashCode() : 0);
        result = 31 * result + (getInscritos() != null ? getInscritos().hashCode() : 0);
        result = 31 * result + (getConteudos() != null ? getConteudos().hashCode() : 0);
        return result;
    }
}
