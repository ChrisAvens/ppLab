package Lab03.Ex02;

import Lab03.Aluno;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class AlunoSorterLambda {

    /**
     * Sorts the list of students based on the provided Comparator.
     *
     * @param alunos     The list of students to be sorted.
     * @param comparator The Comparator that defines the sort order.
     */
    public static void sort(List<Aluno> alunos, Comparator<Aluno> comparator) {
        if (alunos != null) {
            alunos.sort(comparator);
        }
    }

    /**
     * Prints the list of students with a header message.
     *
     * @param message Header message.
     * @param alunos  List of students to be printed.
     */
    public static void printAlunos(String message, List<Aluno> alunos) {
        System.out.println("\n" + message);
        alunos.forEach(System.out::println);
    }

    /**
     * Sorts the list of students by name in lexicographical order.
     *
     * @param alunos The list of students to be sorted.
     */
    public static void sortByNameLex(List<Aluno> alunos) {
        Comparator<Aluno> byNameLex = Comparator.comparing(Aluno::getNome);
        sort(alunos, byNameLex);
        printAlunos("Sort by Name (Lexicographical Order)", alunos);
    }

    /**
     * Sorts the list of students by name length in ascending order.
     *
     * @param alunos The list of students to be sorted.
     */
    public static void sortByNameLength(List<Aluno> alunos) {
        Comparator<Aluno> byNameLength = Comparator.comparing(a -> a.getNome().length());
        sort(alunos, byNameLength);
        printAlunos("Sort by Name Length", alunos);
    }

    /**
     * Sorts the list of students by grade in ascending order.
     *
     * @param alunos The list of students to be sorted.
     */
    public static void sortByNota(List<Aluno> alunos) {
        Comparator<Aluno> byNota = Comparator.comparing(Aluno::getNota);
        sort(alunos, byNota);
        printAlunos("Sort by Grade", alunos);
    }

    /**
     * Executes the sort methods and prints the results.
     *
     * @param args Command line arguments.
     */
    public static void main(String[] args) {
        long startTime = System.nanoTime();

        List<Aluno> alunos = Arrays.asList(
                new Aluno(1, "Ana-Maria", "Silva", 18),
                new Aluno(2, "João", "Carlos", 15),
                new Aluno(3, "Maria", "Santos", 12)
        );

        sortByNameLex(alunos);
        sortByNameLength(alunos);
        sortByNota(alunos);

        long endTime = System.nanoTime();
        long duration = endTime - startTime;
        System.out.println("Sort Time: " + duration + " ns");
    }
}