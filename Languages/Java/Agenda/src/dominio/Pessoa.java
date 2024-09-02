package dominio;

public class Pessoa {
    private int id_pessoa;
    private String nome;
    private String sobrenome;
    private String tipo;
    private String valor;
    private int pessoa_fk;

    public Pessoa() {
    }

    public Pessoa(int id_pessoa, String nome, String sobrenome, String tipo, String valor, int pessoa_fk) {
        this.id_pessoa = id_pessoa;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.tipo = tipo;
        this.valor = valor;
        this.pessoa_fk = pessoa_fk;
    }

    public int getId_pessoa() {
        return id_pessoa;
    }

    public void setId_pessoa(int id_pessoa) {
        this.id_pessoa = id_pessoa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public int getPessoa_fk() {
        return pessoa_fk;
    }

    public void setPessoa_fk(int pessoa_fk) {
        this.pessoa_fk = pessoa_fk;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pessoa pessoa)) return false;

        if (getId_pessoa() != pessoa.getId_pessoa()) return false;
        if (getPessoa_fk() != pessoa.getPessoa_fk()) return false;
        if (getNome() != null ? !getNome().equals(pessoa.getNome()) : pessoa.getNome() != null) return false;
        if (getSobrenome() != null ? !getSobrenome().equals(pessoa.getSobrenome()) : pessoa.getSobrenome() != null)
            return false;
        if (getTipo() != null ? !getTipo().equals(pessoa.getTipo()) : pessoa.getTipo() != null) return false;
        return getValor() != null ? getValor().equals(pessoa.getValor()) : pessoa.getValor() == null;
    }

    @Override
    public int hashCode() {
        int result = getId_pessoa();
        result = 31 * result + (getNome() != null ? getNome().hashCode() : 0);
        result = 31 * result + (getSobrenome() != null ? getSobrenome().hashCode() : 0);
        result = 31 * result + (getTipo() != null ? getTipo().hashCode() : 0);
        result = 31 * result + (getValor() != null ? getValor().hashCode() : 0);
        result = 31 * result + getPessoa_fk();
        return result;
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "id_pessoa=" + id_pessoa +
                ", nome='" + nome + '\'' +
                ", sobrenome='" + sobrenome + '\'' +
                ", tipo='" + tipo + '\'' +
                ", valor='" + valor + '\'' +
                ", pessoa_fk=" + pessoa_fk +
                '}';
    }
}
