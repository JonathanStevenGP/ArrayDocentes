

package ejercicio.jonathan.gelvez;

public class DocenteArray {
    
    private Docente[] docentes;
    
    public DocenteArray(int tamaño) {
        docentes = new Docente[tamaño];
    }
    
public void agregarDocente(Docente docente) {
        for (int i = 0; i < docentes.length; i++) {
            if (docentes[i] == null) {
                docentes[i] = docente;
                System.out.println("Docente agregado correctamente.");
                return;
            }
        }
        System.out.println("No se pudo agregar el docente. El array está lleno.");
    }

    public boolean eliminarDocentePorId(String idEliminar) {
        for (int i = 0; i < docentes.length; i++) {
            if (docentes[i] != null && docentes[i].getIdentificacion().equals(idEliminar)) {
                docentes[i] = null;
                compactarArray(); // Eliminar el espacio nulo
                return true;
            }
        }
        return false;
    }

    private void compactarArray() {
        Docente[] nuevoArray = new Docente[docentes.length];
        int indiceNuevoArray = 0;

        for (Docente docente : docentes) {
            if (docente != null) {
                nuevoArray[indiceNuevoArray] = docente;
                indiceNuevoArray++;
            }
        }

        docentes = nuevoArray;
    }

    public void mostrarInformacionDocentes() {
        for (Docente docente : docentes) {
            if (docente != null) {
                System.out.println("Identificación: " + docente.getIdentificacion());
                System.out.println("Nombre: " + docente.getNombre());
                System.out.println("Título: " + docente.getTitulo());
                System.out.println("Disciplina: " + docente.getDisciplina());
                System.out.println("-------------------------");
            }
        }
    }
    
    public Docente buscarDocentePorId(String idBuscada){
        for (Docente docente : docentes) {
            if (docente != null && docente.getIdentificacion().equals(idBuscada)){
                return docente;
            }
        }
        return null;
    }
    
}