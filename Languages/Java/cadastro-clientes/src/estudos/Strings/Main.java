package estudos.Strings;

public class Main {

    static String frase = "Frase aleatoria para teste";


    public static void main(String[] args) {


        tamanhoDaString();
        characterNaPosicao();
        subStrings();
        subStringInicioEFim();
        indexDaLetra();
        caixaAlta();
        caixaBaixa();
        tirarEspacosEmBranco();
        alterarCamposdeString();
        aStringEParecida();
        comecaCom();
        separarStrings();

    }

    public static void tamanhoDaString(){
        int tamanho = frase.length();
        System.out.println("Tamanho da String = "+ tamanho);
    }

    public static void characterNaPosicao(){
        char charNaPosicao = frase.charAt(1);
        System.out.println("Char na posicao 1 = " + charNaPosicao);
    }

    public static void subStrings(){
        String novaFrase = frase.substring(2);
        System.out.println("A substring de frase a partir do index 2 e: " + novaFrase);
    }

    public static void indexDaLetra(){
        int indice = frase.indexOf("a");
        System.out.println("Index da letra a : " + indice);
    }

    public static void subStringInicioEFim(){
        String novaFrase = frase.substring(2,frase.length() - 1 );
        System.out.println("A subString de frase comecando do index 2 e indo ate o penultimo index e : " + novaFrase);
    }

    public static void caixaAlta(){
        System.out.println("String em caixas alta: " + frase.toUpperCase());
    }

    public static void caixaBaixa(){
        System.out.println("String em caixa baixa: " + frase.toLowerCase());
    }

    public static void tirarEspacosEmBranco(){
        String frase = "    Essa e a nova frase";
        System.out.println("String sem o trim: " + frase);
        System.out.println("String com o trim: " + frase.trim());
    }

    public static void alterarCamposdeString(){
        System.out.println(frase.replace(" ",""));
        System.out.println("String frase original: " + frase);
    }

    public static void aStringEParecida(){
        String palavra1 = "ola";
        String palavra2 = "ola";

        System.out.println("A string palavra1 e palavra2 sao parecidas?: "+ palavra1.equalsIgnoreCase(palavra2));

    }

    public static void comecaCom(){
        String [] nomes = {"Joao","Luiz","Carlos"};
        String contain =null;
        for (String c : nomes){
            if(c.startsWith("C")){
                contain = c;
            }
        }
        System.out.println(contain);
    }

    public static void separarStrings(){
        String frase = "Olha essa frase";
        String[] novaFrase = frase.split("");
        for (String f : novaFrase){
            System.out.println(f+"index: "+f.indexOf(f));
        }
    }
}
