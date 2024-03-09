
package ejercicio.jonathan.gelvez;

import java.util.ArrayList;
import java.util.List;


public class Docente {

   private String identificacion;
    private String nombre;
    private char titulo;
    private String disciplina;
    private List<Curso> cursos;

    public List<Curso> getCursos() {
        return cursos;
    }

    public void setCursos(List<Curso> cursos) {
        this.cursos = cursos;
    }
    
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
    
    public void mostrarInformacionConCursos() {
        System.out.println("Información del Docente:");
        System.out.println("Identificación: " + identificacion);
        System.out.println("Nombre: " + nombre);
        System.out.println("Título: " + titulo);
        System.out.println("Disciplina: " + disciplina);

        if (!cursos.isEmpty()) {
            System.out.println("Cursos:");
            for (Curso curso : cursos) {
                System.out.println("   Código: " + curso.getCodigoCurso() + ", Fecha: " + curso.getFechaCurso() + ", Salón: " + curso.getSalonCurso());
            }
        } else {
            System.out.println("El docente no tiene cursos asignados.");
        }

        System.out.println("-----------------------------------------------------------");
    }
    
    public Docente(String identificacion, String nombre, char titulo, String disciplina){
        this.identificacion = identificacion;
        this.nombre = nombre;
        this.titulo = titulo;
        this.disciplina = disciplina;
        this.cursos=new ArrayList<>();
    } 

    public void agregarCurso(Curso curso) {
        cursos.add(curso);
    }
    
    private boolean compararDocentesPorId(Docente docente1, Docente docente2) {
        return docente1.getIdentificacion().compareTo(docente2.getIdentificacion()) > 0;
    }
}
