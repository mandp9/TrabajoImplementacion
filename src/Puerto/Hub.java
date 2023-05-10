package Puerto;
public class Hub {
    private Contenedor[][] cc;

    public Hub() {
        this.cc = new Contenedor[10][12]; //el hub tiene 10 filas y 12 columnas por defecto
    }

    public Contenedor[][] getArrayCont() {
        return cc;
    }

    public void setArrayCont(Contenedor[][] cc) {
        this.cc = cc;
    }

    public String toString() {
        String s = "";
        for (int i = 0; i < cc.length; i++) {
            for (int j = 0; j < cc[i].length; j++) {
                if (cc[i][j] == null) {
                    s += "[Null]";
                } else {
                    s += "[C" + cc[i][j].getId() + "]";
                }
            }//m[i][j].getId()
            s += "\n";
        }
        return s;
    }
    public boolean apilar (Contenedor c) {
        boolean stop = false;
        if (c != null) {
            int n = c.getPrioridad();
            int col = n - 1;
            for (int i = cc.length - 1; i >= 0 && !stop; i--) {
                if (cc[i][col] == null) {
                    cc[i][col] = c;
                    stop = true;
                }
            }
            if (n == 3 && !stop) {
                for (int i = cc.length - 1; i >= 0; i--) {
                    for (int j = 3; j < cc[i].length && !stop; j++) {
                        if (cc[i][j] == null) {
                            cc[i][j] = c;
                            stop = true;
                        }
                    }
                }
            }
        }
        return stop;
    }
    public boolean desapilar(int columna) {
        boolean desapilado = false;
        int num;
        String s = "";
        int contador = 0;
        if (columna >= 0) {
            for (int i=0; i<cc.length; i++) {
                //recorre el hub buscando los contenedores de esa columna que no estén vacíos.
                if (cc[i][columna] != null) {
                    cc[i][columna] = null;
                    desapilado = true;
                    break;
                }
            }
            System.out.println("Se han encontrado los siguientes contenedores llenos en la filas: " + s + ". Procedemos a vaciarlos.");
            System.out.println("Se han vaciado un total de: " + contador + " contenedores");
        }
        return desapilado;
    }
    public Contenedor datosContenedor (int id){
        Contenedor cAux = new Contenedor(0);
        boolean encontrado = false;
        if(id>0) {
            for (int i = 0; i < cc.length; i++) {
                for (int j = 0; j < cc[i].length && !encontrado; j++) {
                    if (cc[i][j] != null && cc[i][j].getId() == id) {
                        cAux = cc[i][j];
                        encontrado = true;
                    }
                }
            }
        }
        return cAux;
    }
    public int cantidadContPais (String pais){
        int contador = 0;
        for (int i = 0; i < cc.length; i++) {
            for (int j = 0; j < cc[i].length; j++) {
                if(cc[i][j] != null)
                {
                    if(cc[i][j].getPais()==pais){
                        contador++;
                    }
                }
            }
        }
        return contador;
    }

}