package exercicios.pooClasses;

public class Animal {

    private String nome;
    private String tipo;
    private int energia;
    private int velocidade;

    public Animal() {}

    public Animal(String nome, String tipo, int energia, int velocidade) {
        this.nome = nome;
        this.tipo = tipo;
        this.energia = energia;
        this.velocidade = velocidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getEnergia() {
        return energia;
    }

    public void setEnergia(int energia) {
        this.energia = energia;
    }

    public int getVelocidade() {
        return velocidade;
    }

    public void setVelocidade(int velocidade) {
        this.velocidade = velocidade;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Animal animal)) return false;

        if (getEnergia() != animal.getEnergia()) return false;
        if (getVelocidade() != animal.getVelocidade()) return false;
        if (getNome() != null ? !getNome().equals(animal.getNome()) : animal.getNome() != null) return false;
        return getTipo() != null ? getTipo().equals(animal.getTipo()) : animal.getTipo() == null;
    }

    @Override
    public int hashCode() {
        int result = getNome() != null ? getNome().hashCode() : 0;
        result = 31 * result + (getTipo() != null ? getTipo().hashCode() : 0);
        result = 31 * result + getEnergia();
        result = 31 * result + getVelocidade();
        return result;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "nome='" + nome + '\'' +
                ", tipo='" + tipo + '\'' +
                ", energia=" + energia +
                ", velocidade=" + velocidade +
                '}';
    }
}
