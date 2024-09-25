package br.com.dio.desafio.dominio;

import java.util.LinkedHashSet;
import java.util.Optional;
import java.util.Set;

public class Dev {
    private String nome;

    private Set<Conteudo> conteudosInscrito;
    private Set<Conteudo> conteudosConcluidos;
    public Dev() {
        this.conteudosInscrito = new LinkedHashSet<>();
        this.conteudosConcluidos = new LinkedHashSet<>();
    }

    /**
     * Quando o Dev se inscrever no bootcamp devera ser inscrito em todos os conteudo
     * daquele bootcamp
     * */
    public void inscreverBootCamp(BootCamp bootCamp){
        //TODO
        bootCamp.getInscritos().add(this); // inscreve o dev no boot camp
        this.conteudosInscrito.addAll(bootCamp.getConteudos());
    }

    /**
     * Para progredir o conteudo inscrito tem de ir para dentro de conteudo concluido
     * */
    public void progressao(){
        //TODO
        Optional<Conteudo> conteudoInscrito = this.conteudosInscrito.stream().findFirst();
        if (conteudoInscrito.isPresent()){
            this.conteudosConcluidos.add(conteudoInscrito.get());
            this.conteudosInscrito.remove(conteudoInscrito.get());
        }else {
            System.err.println("Nao existe nenhum conteudo para cursar.!");
        }
    }

    public double calcularXP(){
        //TODO

        return this.conteudosConcluidos.stream().
                                        mapToDouble(conteudo -> conteudo.calcularXP()).
                                        sum();
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public Set<Conteudo> getConteudosInscrito() {
        return conteudosInscrito;
    }

    public void setConteudosInscrito(Set<Conteudo> conteudosInscrito) {
        this.conteudosInscrito = conteudosInscrito;
    }

    public Set<Conteudo> getConteudosConcluidos() {
        return conteudosConcluidos;
    }

    public void setConteudosConcluidos(Set<Conteudo> conteudosConcluidos) {
        this.conteudosConcluidos = conteudosConcluidos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Dev dev)) return false;

        if (getNome() != null ? !getNome().equals(dev.getNome()) : dev.getNome() != null) return false;
        if (getConteudosInscrito() != null ? !getConteudosInscrito().equals(dev.getConteudosInscrito()) : dev.getConteudosInscrito() != null)
            return false;
        return getConteudosConcluidos() != null ? getConteudosConcluidos().equals(dev.getConteudosConcluidos()) : dev.getConteudosConcluidos() == null;
    }

    @Override
    public String toString() {
        return "Dev{" +
                "nome='" + nome + '\'' +
                ", conteudosInscrito=" + conteudosInscrito +
                ", conteudosConcluidos=" + conteudosConcluidos +
                '}';
    }

    @Override
    public int hashCode() {
        int result = getNome() != null ? getNome().hashCode() : 0;
        result = 31 * result + (getConteudosInscrito() != null ? getConteudosInscrito().hashCode() : 0);
        result = 31 * result + (getConteudosConcluidos() != null ? getConteudosConcluidos().hashCode() : 0);
        return result;
    }
}
