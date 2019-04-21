import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class lecturaFichero {
    public static void muestraContenido(String archivo) throws FileNotFoundException, IOException {
        String cadena;
        FileReader f = new FileReader(archivo);
        BufferedReader b = new BufferedReader(f);
        while((cadena = b.readLine())!=null) {
            System.out.println(cadena);
        }
        b.close();
    }

    public Automata guardaContenido(String archivo) throws FileNotFoundException, IOException {
      //Leer fichero y construir clases
        String cadena;
        Integer contador=0;
        char numEstados, tamAlfabeto;
        FileReader f = new FileReader(archivo);
        BufferedReader b = new BufferedReader(f);
        String [] parts;
        ArrayList<Estado> arrayEstados= new ArrayList<>();
        ArrayList<String> arrayAlfabeto= new ArrayList<>();
        ArrayList<String> arrayTransiciones= new ArrayList<>();
        Automata auto = new Automata(); //Construcion automata
        while((cadena = b.readLine())!= null) {
            //arrayTransiciones.clear();
            switch (contador){
                case 0:
                    parts = cadena.split(" ");
                    numEstados = StringEntero(parts[0]);
                    auto.setNumEstados(numEstados);
                    for(int i=1; i<parts.length; i++) {
                        arrayEstados.add(new Estado(parts[i]));
                        auto.setEstados(arrayEstados);//Construccion estados
                        /*if(i==1){
                            arrayEstados.get(0).setEsInicial(true);
                        }*/
                    }
                    break;
                case 1:
                    parts = cadena.split(" ");
                    for(int i=1; i<parts.length; i++) {
                        for(int j=0; j<auto.getEstados().size(); j++) {
                            if (parts[i].equals(auto.getEstados().get(j).getNombre())) {
                                auto.getEstados().get(j).setEsFinal(true);
                            }
                        }
                    }
                    break;
                case 2:
                    parts = cadena.split(" ");
                    tamAlfabeto = StringEntero(parts[0]);
                    auto.setTamAlfabeto(tamAlfabeto);
                    for(int i=1; i<parts.length; i++){
                        arrayAlfabeto.add(parts[i].replaceAll("\\s",""));
                    }
                    arrayAlfabeto.add(" ");
                    auto.setAlfabeto(arrayAlfabeto);
                    break;
                case 3:
                    if(cadena.startsWith("-")) {
                    }
                    else System.out.println("Fichero con formato incorrecto!");
                    break;
                default:
                    parts = cadena.split("#");
                    for(int i=0; i<parts.length; i++){
                        auto.getEstados().get(contador-4).getTransiciones().add(parts[i].replaceAll("\\s",""));
                    }
                    break;
            }
            ++contador;
        }
        b.close();
        return auto;
    }

    public static char StringEntero(String cadena){
        return cadena.charAt(1);
    }
}
