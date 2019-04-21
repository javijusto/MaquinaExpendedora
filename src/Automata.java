import java.util.ArrayList;

public class Automata {
    private int tamAlfabeto;
    private ArrayList<String> alfabeto;
    private int numEstados;
    private ArrayList<Estado> estados;
    private float saldo;
    private ArrayList<Estado> actual;
    private boolean devolver;


    public Automata() {
    }

    public int getTamAlfabeto() {
        return tamAlfabeto;
    }

    public void setTamAlfabeto(int tamAlfabeto) {
        this.tamAlfabeto = tamAlfabeto;
    }

    public ArrayList<String> getAlfabeto() {
        return alfabeto;
    }

    public void setAlfabeto(ArrayList<String> alfabeto) {
        this.alfabeto = alfabeto;
    }

    public int getNumEstados() {
        return numEstados;
    }

    public void setNumEstados(int numEstados) {
        this.numEstados = numEstados;
    }

    public ArrayList<Estado> getEstados() {
        return estados;
    }

    public void setEstados(ArrayList<Estado> estados) {
        this.estados = estados;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public ArrayList<Estado> getActual() {
        return actual;
    }

    public void setActual(ArrayList<Estado> actual) {
        this.actual = actual;
    }

    public boolean isDevolver() {
        return devolver;
    }

    public void setDevolver(boolean devolver) {
        this.devolver = devolver;
    }

    public void getSiguienteTransicion(String b){

        int indice=0;
        ArrayList<Estado> cambio = new ArrayList<>(); //array auxiliar

        for(int i=0; i<this.getActual().size(); i++){
            indice = this.getAlfabeto().indexOf(b);
             //busca donde esta la transicion con ese caracter

            for(int j=0; j<this.getActual().get(i).getTransiciones().get(indice).length(); j++){
                cambio.add(this.StringEstado(Character.toString(getActual().get(i).getTransiciones().get(indice).charAt(j)))); //añade nuevos estados al array auxiliar
            }
        }

        this.getActual().clear();
        this.setActual(cambio);//guardamos nuevos estados actuales en el arraylist de estados actuales
    }

    public void getSiguienteEstado(String b){

        int indice=0;
        ArrayList<Estado> cambio = new ArrayList<>(); //array auxiliar

        for(int i=0; i<this.getActual().size(); i++){
            indice = this.getAlfabeto().indexOf(b);
            //busca donde esta la transicion con ese caracter
            for(int j=0; j<this.getActual().get(i).getTransiciones().get(indice).length(); j+=3){
                cambio.add(this.StringEstado(getActual().get(i).getTransiciones().get(indice).substring(j,j+3))); //añade nuevos estados al array auxiliar
            }
        }

        this.getActual().clear();
        this.setActual(cambio);//guardamos nuevos estados actuales en el arraylist de estados actuales
    }

    public Estado StringEstado(String b){ //pasa string a estado
        for(int i=0; i< this.getEstados().size(); i++){
            if(this.getEstados().get(i).getNombre().equalsIgnoreCase(b)){
                return this.getEstados().get(i); //nombre de estado a estado
            }
        }
        return null;
    }

    public boolean comprobacion(String vs){ //comprueba si el caracter pertenece al alfabeto
        boolean a=false;
        for (int i = 0; i < vs.length(); i++) {
            for (int j = 0; j < this.getAlfabeto().size(); j++) {
                if ((this.getAlfabeto().get(j).contains(String.valueOf(vs.charAt(i))))) {  //comprueba caracter
                    a=true;
                }
            }
        }
        return a;
    }
}

