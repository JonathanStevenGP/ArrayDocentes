
package ejercicio.jonathan.gelvez;


class CursoArray {
    
private Curso[][] cursos;

    public CursoArray(int filas, int columnas) {
        cursos = new Curso[filas][columnas];
    }

    public void agregarCurso(Curso curso) {
        for (int i = 0; i < cursos.length; i++) {
            for (int j = 0; j < cursos[i].length; j++) {
                if (cursos[i][j] == null) {
                    cursos[i][j] = curso;
                    System.out.println("Curso agregado correctamente.");
                    return;
                }
            }
        }
        System.out.println("No se pudo agregar el curso. El array está lleno.");
    }

    public boolean eliminarCursoPorCodigo(String codigoEliminar) {
        for (int i = 0; i < cursos.length; i++) {
            for (int j = 0; j < cursos[i].length; j++) {
                if (cursos[i][j] != null && cursos[i][j].getCodigoCurso().equals(codigoEliminar)) {
                    cursos[i][j] = null;
                    compactarArray(); // Eliminar el espacio nulo
                    return true;
                }
            }
        }
        return false;
    }

    private void compactarArray() {
        Curso[][] nuevoArray = new Curso[cursos.length][cursos[0].length];
        int indiceNuevoArrayI = 0;
        int indiceNuevoArrayJ = 0;

        for (Curso[] fila : cursos) {
            for (Curso curso : fila) {
                if (curso != null) {
                    nuevoArray[indiceNuevoArrayI][indiceNuevoArrayJ] = curso;
                    indiceNuevoArrayJ++;
                }
            }
            indiceNuevoArrayI++;
            indiceNuevoArrayJ = 0;
        }

        cursos = nuevoArray;
    }

    public void mostrarInformacionCursos() {
        for (Curso[] fila : cursos) {
            for (Curso curso : fila) {
                if (curso != null) {
                    System.out.println("Código del Curso: " + curso.getCodigoCurso());
                    System.out.println("Fecha del Curso: " + curso.getFechaCurso());
                    System.out.println("Salón del Curso: " + curso.getSalonCurso());
                    System.out.println("-------------------------");
                }
            }
        }
    }
    public Curso buscarCursoPorCodigo(String codigoBuscar) {
        for (Curso[] fila : cursos) {
            for (Curso curso : fila) {
                if (curso != null && curso.getCodigoCurso().equals(codigoBuscar)) {
                    return curso;
                }
            }
        }
        return null;
    }
}