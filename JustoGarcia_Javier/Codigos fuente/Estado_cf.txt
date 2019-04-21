import java.lang.reflect.Array;
import java.util.ArrayList;

public class Estado extends ArrayList<Estado> {
    private String nombre;
    private ArrayList<String> transiciones;
    private boolean esInicial;
    private boolean esFinal;
    private float credito;


    public Estado(String nombre, ArrayList<String> transiciones, boolean esInicial, boolean esFinal, float credito) {
        this.nombre = nombre;
        this.transiciones = transiciones;
        this.esInicial = esInicial;
        this.esFinal = esFinal;
        this.credito = credito;
    }

    public Estado(String nombre) {
        this.nombre = nombre;
        this.transiciones = new ArrayList<>();
        this.esInicial = false;
        this.esFinal = false;
        this.credito = 0;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<String> getTransiciones() {
        return transiciones;
    }

    public void setTransiciones(ArrayList<String> transiciones) {
        this.transiciones = transiciones;
    }

    public boolean isEsInicial() {
        return esInicial;
    }

    public void setEsInicial(boolean esInicial) {
        this.esInicial = esInicial;
    }

    public boolean isEsFinal() {
        return esFinal;
    }

    public void setEsFinal(boolean esFinal) {
        this.esFinal = esFinal;
    }

    public float getcredito() {
        return credito;
    }

    public void setcredito(float credito) {
        this.credito = credito;
    }
}
