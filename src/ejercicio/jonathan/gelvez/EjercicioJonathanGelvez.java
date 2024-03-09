    package ejercicio.jonathan.gelvez;

import java.util.InputMismatchException;
import java.util.Scanner;

public class EjercicioJonathanGelvez {

    public static void main(String[] args) {
        
        DocenteArray docenteArray = new DocenteArray(5);
        CursoArray cursoArray = new CursoArray(5, 5);
        
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\nMenú:");
            System.out.println("1. Agregar Docente");
            System.out.println("2. Eliminar Docente");
            System.out.println("3. Ver Docentes");
            System.out.println("4. Ver Docentes y Sus Cursos");
            System.out.println("5. Ver Todos los Docentes Ordenamiento Directo");
            System.out.println("6. Ver Todos los Docentes Ordenamiento Indirecto");
            System.out.println("7. Salir");
            System.out.print("Ingrese su opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea después de leer el número
      
            switch (opcion) {
                    
                case 1:
                    // Agregar Docente
            System.out.println("\nIngrese los datos para el nuevo Docente:");
            System.out.print("Identificación: ");
            String identificacion = scanner.nextLine();

            System.out.print("Nombre: ");
            String nombre = scanner.nextLine();

            System.out.print("Título (D/M/E/I): ");
            char titulo = scanner.nextLine().toUpperCase().charAt(0);

            System.out.print("Disciplina: ");
            String disciplina = scanner.nextLine();

                                    // Crear un nuevo Docente
            Docente nuevoDocente = new Docente(identificacion, nombre, titulo, disciplina);

                                    // Ingresar la cantidad de cursos a agregar al docente
            System.out.println("Ingrese la cantidad de cursos a agregar al docente:");
            int cantidadCursos = scanner.nextInt();
            scanner.nextLine();  // Consumir el salto de línea pendiente

                for (int i = 0; i < cantidadCursos; i++) {
            System.out.println("Ingrese código del curso:");
            String codigo = scanner.nextLine();
            System.out.println("Ingrese fecha del curso:");
            String fecha = scanner.nextLine();
            System.out.println("Ingrese salón del curso:");
            String salon = scanner.nextLine();

    // Crear el Curso y agregarlo al nuevo Docente
    Curso curso = new Curso(codigo, fecha, salon);
    nuevoDocente.agregarCurso(curso);
}

// Agregar el nuevo Docente al DocenteArray
docenteArray.agregarDocente(nuevoDocente);
    break;

                case 2:
                    // Eliminar Docente
                    System.out.print("\nIngrese la identificación del docente a eliminar: ");
                    String idEliminar = scanner.nextLine();
                    boolean eliminado = docenteArray.eliminarDocentePorId(idEliminar);

                    if (eliminado) {
                        System.out.println("Docente eliminado correctamente.");
                    } else {
                        System.out.println("No se encontró un docente con la identificación proporcionada.");
                    }
                    break;

                case 3:
                    // Ver Docentes
                      System.out.print("\nIngrese la identificación del docente a mostrar: ");
    String idMostrar = scanner.nextLine();
    Docente docenteMostrar = docenteArray.buscarDocentePorId(idMostrar);

    if (docenteMostrar != null) {
        System.out.println("\nInformación del Docente:");
        System.out.println("Identificación: " + docenteMostrar.getIdentificacion());
        System.out.println("Nombre: " + docenteMostrar.getNombre());
        System.out.println("Título: " + docenteMostrar.getTitulo());
        System.out.println("Disciplina: " + docenteMostrar.getDisciplina());
        System.out.println("-------------------------------------------------------------------------");
    } else {
        System.out.println("No se encontró un docente con la identificación proporcionada.");
    }

    break;
                case 4:
            System.out.println("Todos Los Docentes Con sus Cursos: ");
            docenteArray.mostrarInformacionDocentesConCursos();
        break;
                case 5:
                    
                   System.out.println("\nTodos los docentes ordenados por nombre (metodo Directo): ");
                    docenteArray.ordenarDocentesPorNombre();
                    docenteArray.mostrarInformacionDocentesConCursos();
                    break;
                    
                case 6:
    System.out.println("\nTodos los docentes ordenados por ID (Metodo Indirecto - Shell): ");
    docenteArray.ordenarDocentesPorNombreMetodoIndirectoShell();
    docenteArray.mostrarInformacionDocentesConCursos();
    break;


                    
                case 7:
                    // Salir
                        System.out.println("Saliendo del programa. ¡Hasta luego!");
                    break;

                default:
                    System.out.println("Error: Por favor, ingrese un número del 1 al 7.");
            }

        } while (opcion != 7);

        // Cerrar el Scanner
        scanner.close();
    }
    private static int leerEnteroConValidacion(Scanner scanner, String mensaje) {
    while (true) {
        try {
            System.out.print(mensaje);
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Error: Por favor, ingrese un número válido.");
            // Imprimir detalles de la excepción para depuración
            e.printStackTrace();
        }
    }
}
        
}