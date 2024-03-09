
package ejercicio.jonathan.gelvez;


public class Curso {
    private String codigoCurso;
    private String fechaCurso;
    private String salonCurso;

    public Curso(String codigoCurso, String fechaCurso, String salonCurso) {
        this.codigoCurso = codigoCurso;
        this.fechaCurso = fechaCurso;
        this.salonCurso = salonCurso;
    }

    public String getCodigoCurso() {
        return codigoCurso;
    }

    public void setCodigoCurso(String codigoCurso) {
        this.codigoCurso = codigoCurso;
    }

    public String getFechaCurso() {
        return fechaCurso;
    }

    public void setFechaCurso(String fechaCurso) {
        this.fechaCurso = fechaCurso;
    }

    public String getSalonCurso() {
        return salonCurso;
    }

    public void setSalonCurso(String salonCurso) {
        this.salonCurso = salonCurso;
    }

}
