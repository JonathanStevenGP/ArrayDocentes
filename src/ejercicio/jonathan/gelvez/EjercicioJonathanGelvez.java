    

package ejercicio.jonathan.gelvez;

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
            System.out.println("4. Agregar Curso");
            System.out.println("5. Eliminar Curso");
            System.out.println("6. Ver Curso");
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

                    docenteArray.agregarDocente(new Docente(identificacion, nombre, titulo, disciplina));
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
                    
                    System.out.println("\nIngrese los datos para el nuevo Curso:");
                    System.out.print("Código del Curso: ");
                    String codigoCurso = scanner.nextLine();

                    System.out.print("Fecha del Curso: ");
                    String fechaCurso = scanner.nextLine();

                    System.out.print("Salón del Curso: ");
                    String salonCurso = scanner.nextLine();

                    cursoArray.agregarCurso(new Curso(codigoCurso, fechaCurso, salonCurso));
                    break;
                    
                case 5:
                    
                    System.out.print("\nIngrese el código del curso a eliminar: ");
                    String codigoEliminarCurso = scanner.nextLine();
                    boolean eliminadoCurso = cursoArray.eliminarCursoPorCodigo(codigoEliminarCurso);

                    if (eliminadoCurso) {
                        System.out.println("Curso eliminado correctamente.");
                    } else {
                        System.out.println("No se encontró un curso con el código proporcionado.");
                    }
                    break;
                    
                case 6:
                    
                    System.out.print("\nIngrese el código del curso a mostrar: ");
                    String codigoMostrarCurso = scanner.nextLine();
                    Curso cursoMostrar = cursoArray.buscarCursoPorCodigo(codigoMostrarCurso);

                    if (cursoMostrar != null) {
                        System.out.println("\nInformación del Curso:");
                        System.out.println("Código del Curso: " + cursoMostrar.getCodigoCurso());
                        System.out.println("Fecha del Curso: " + cursoMostrar.getFechaCurso());
                        System.out.println("Salón del Curso: " + cursoMostrar.getSalonCurso());
                        System.out.println("----------------------------------------------------------------------");
                    } else {
                        System.out.println("No se encontró un curso con el código proporcionado.");
                    }
                    break;

                case 7:
                    // Salir
                        System.out.println("Saliendo del programa. ¡Hasta luego!");
                    break;

                default:
                        System.out.println("Opción no válida. Por favor, ingrese un número del 1 al 7.");
            }

        } while (opcion != 7);
    }
}