import java.util.ArrayList;
import java.util.List;

public class Cadastro {
    private List<Pessoa> pessoasList;

    public Cadastro(){
        this.pessoasList = new ArrayList<>();
    }

    public void cadastrarPessoa(Pessoa pessoa){
        this.pessoasList.add(pessoa);
    }
    public List<Pessoa> listarPessoas(){
        return pessoasList;
    }
}
