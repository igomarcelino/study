package estudos.record;

public record PessoaRecord(String name, String cpf) {
    public String cpfSemFormat(){
        return this.cpf.replace("."+"-","");
    }
}
