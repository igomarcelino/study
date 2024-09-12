package Lambda.ConceitosLambda;

public class Ordem {
    private int id;
    private String servico;
    private double valor;
    private boolean ativacao;

    public Ordem() {
    }

    public Ordem(int id, String servico, double valor, boolean ativacao) {
        this.id = id;
        this.servico = servico;
        this.valor = valor;
        this.ativacao = ativacao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getServico() {
        return servico;
    }

    public void setServico(String servico) {
        this.servico = servico;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public boolean isAtivacao() {
        return ativacao;
    }

    public void setAtivacao(boolean ativacao) {
        this.ativacao = ativacao;
    }

    @Override
    public String toString() {
        return "Ordem{" +
                "id=" + id +
                ", servico='" + servico + '\'' +
                ", valor=" + valor +
                ", ativacao=" + ativacao +
                '}';
    }
}
