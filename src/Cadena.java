public class Cadena {
    private String cadena;
    private boolean esAceptada;

    public Cadena(String cadena, boolean esAceptada) {
        this.cadena = cadena;
        this.esAceptada = esAceptada;
    }

    public Cadena() {
        this.cadena="";
        this.esAceptada=false;
    }

    public String getCadena() {
        return cadena;
    }

    public void setCadena(String cadena) {
        this.cadena = cadena;
    }

    public boolean isEsAceptada() {
        return esAceptada;
    }

    public void setEsAceptada(boolean esAceptada) {
        this.esAceptada = esAceptada;
    }
}
