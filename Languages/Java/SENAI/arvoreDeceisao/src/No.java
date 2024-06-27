public class No {
    String pergunta;
    No verdadeiro;
    No falso;
    String decisao;

    No(String pergunta){
        this.pergunta = pergunta;
    }
    No(String pergunta , String decisao){
        this.pergunta = pergunta;
        this.decisao = decisao;
    }

    void definirFIlhos(No verdadeiro, No falso){
        this.verdadeiro=verdadeiro;
        this.falso = falso;
    }


}
