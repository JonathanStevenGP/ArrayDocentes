

package ejercicio.jonathan.gelvez;

public class DocenteArray {
    
    private Docente[] docentes;
    private int cantidadDocentes;
    
    public DocenteArray(int capacidad) {
        this.docentes = new Docente[capacidad];
        this.cantidadDocentes = 0;
    }
    
public void agregarDocente(Docente docente) {
        if (cantidadDocentes < docentes.length) {
            docentes[cantidadDocentes] = docente;
            cantidadDocentes++;
            System.out.println("Docente agregado Correctamente");
            System.out.println("----------------------------------------------------------");
        } 
        else {
            System.out.println("No se puede agregar más docentes. La capacidad está llena.");
            System.out.println("----------------------------------------------------------");
        }
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
                System.out.println("-----------------------------------------------");
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
    
      public void mostrarInformacionDocentesConCursos() {
        System.out.println("Información de Todos los Docentes:");

        for (int i = 0; i < cantidadDocentes; i++) {
            docentes[i].mostrarInformacionConCursos();
        }
    }
    
 public void ordenarDocentesPorNombre() {
        if (docentes == null) {
            System.out.println("La lista de docentes es nula. Asegúrate de inicializarla antes de ordenar.");
            return;
        }

        int n = docentes.length;

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                // Verificar si los elementos no son nulos antes de comparar nombres
                if (docentes[j] != null && docentes[j + 1] != null &&
                    docentes[j].getNombre() != null && docentes[j + 1].getNombre() != null) {
                    // Comparar nombres de docentes y realizar el intercambio si es necesario
                    if (docentes[j].getNombre().compareTo(docentes[j + 1].getNombre()) > 0) {
                        // Realizar el intercambio
                        Docente temp = docentes[j];
                        docentes[j] = docentes[j + 1];
                        docentes[j + 1] = temp;
                    }
                }
            }
        }
    }

    public void ordenarDocentesPorNombreMetodoIndirectoShell() {
    int n = docentes.length;

    for (int brecha = n / 2; brecha > 0; brecha /= 2) {
        for (int i = brecha; i < n; i += 1) {
            Docente temp = docentes[i];
            int j;
            for (j = i; j >= brecha && compararDocentesPorId(obtenerDocenteEnIndice(j - brecha), temp); j -= brecha) {
                docentes[j] = docentes[j - brecha];
            }
            docentes[j] = temp;
        }
    }
}

private boolean compararDocentesPorId(Docente docente1, Docente docente2) {
    if (docente1 == null || docente2 == null) {
        return false;
    }
    return docente1.getIdentificacion().compareTo(docente2.getIdentificacion()) > 0;
}

private Docente obtenerDocenteEnIndice(int indice) {
    if (indice >= 0 && indice < docentes.length) {
        return docentes[indice];
    }
    return null;
}

}

