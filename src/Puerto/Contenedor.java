package Puerto;

public class Contenedor {
    private final int id;
    private int peso;
    private String pais;
    private boolean inspeccionado;
    private int prioridad;
    private String contenido;
    private String nombreEnvia;
    private String nombreRecibe;
    //---------------------------------------------CONSTRUCTORES----------------------------------------------------------
    public Contenedor(int id) {
        this.prioridad = 3; //3 será la prioridad por defecto
        this.id = id; //id no puede ser null en ninguna circunstancia por eso este es el constructor más pequeño que se puede hacer
    }
    public Contenedor(int id, int peso, String pais, boolean inspeccionado, int prioridad, String contenido, String nombreEnvia, String nombreRecibe) {
        this(id);
        this.peso = peso;
        this.pais = pais;
        this.inspeccionado = inspeccionado;
        this.prioridad = prioridad;
        this.contenido = contenido;
        this.nombreEnvia = nombreEnvia;
        this.nombreRecibe = nombreRecibe;
    }
    //---------------------------------------------GETTERS--SETTERS---------------------------------------------------------------
    public int getId() { //para id no habrá setter pues es final
        return this.id;
    }
    public void setPeso(int peso) { if(peso>0) this.peso = peso; }
    public int getPeso(){
        return peso;
    }
    public void setPais(String pais){
        this.pais = pais;
    }
    public String getPais(){
        return pais;
    }
    public boolean isInspeccionado(){ return this.inspeccionado; }
    public void setPrioridad (int prioridad){
        if(prioridad>=1 && prioridad<=3){
            this.prioridad = prioridad;
        }else{
            System.out.println("No se ha podido establecer prioridad " + prioridad +" ya que esta sólo puede adoptar los valores 1, 2 o 3");
        }
    }
    public int getPrioridad (){
        return prioridad;
    }
    public void setContenido (String contenido){
        this.contenido = contenido;
    }
    public String getContenido (){
        return contenido;
    }
    public void setNombreEnvia (String nombreEnvia){
        this.nombreEnvia = nombreEnvia;
    }
    public String getNombreEnvia(){
        return nombreEnvia;
    }
    public void setNombreRecibe (String nombreRecibe){
        this.nombreRecibe = nombreRecibe;
    }
    public String getNombreRecibe(){
        return nombreRecibe;
    }
    //------------------------------------------------------------------------------------------------------------------------
    public String toString (){
        String str = "ID: " + id + ", Peso: " + peso + ", País procedencia: " + pais;
        if(inspeccionado) str += ", Ya ha sido inspeccionado";
        if(!inspeccionado) str += ", En espera de inspección";
        str += ", Prioridad: " + prioridad + ", Contenido: " + contenido + ", Remitente: " + nombreEnvia + ", Destinatario: " + nombreRecibe;
        return str;
    }

}