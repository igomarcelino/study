package exercicios.pooClasses;

public class PredadorVsPresa {

    private Animal animal;
    private boolean resultado ;

    public PredadorVsPresa() {}

    public PredadorVsPresa(Animal tipo, boolean resultado) {
        this.animal = tipo;
        this.resultado = resultado;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public boolean isResultado() {
        return resultado;
    }

    public void setResultado(boolean resultado) {
        this.resultado = resultado;
    }

    public boolean cacada(Animal cacador ,Animal presa ){

        if ( cacador.getVelocidade() > presa.getVelocidade()){
            return true;
        }else {
            return false;
        }
    }


}
