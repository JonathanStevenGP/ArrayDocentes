
package ejercicio.jonathan.gelvez;


public class Docente {

   private String identificacion;
    private String nombre;
    private char titulo;
    private String disciplina;

    public String getIdentificacion() {
        return identificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public char getTitulo() {
        return titulo;
    }

    public String getDisciplina() {
        return disciplina;
    }
    
    
    public Docente(String identificacion, String nombre, char titulo, String disciplina){
        this.identificacion = identificacion;
        this.nombre = nombre;
        this.titulo = titulo;
        this.disciplina = disciplina;
    } 
}
