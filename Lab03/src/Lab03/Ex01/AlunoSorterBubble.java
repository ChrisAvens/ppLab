package Lab03.Ex01;

import Lab03.Aluno;
import java.util.Collections;
import java.util.List;

public class AlunoSorterBubble {
    /**
     * Sorts the list of students by name in lexicographical order.
     * @param alunos The list of students to be sorted.
     */
    public static void bubbleSortPorNomeLex(List<Aluno> alunos) {
        if (alunos == null || alunos.isEmpty()) return;

        int n = alunos.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (alunos.get(j).getNome().compareTo(alunos.get(j + 1).getNome()) > 0) {
                    Collections.swap(alunos, j, j + 1);
                }
            }
        }
    }

    /**
     * Sorts the list of students by name length in ascending order.
     * @param alunos The list of students to be sorted.
     */
    public static void bubbleSortPorNomeLen(List<Aluno> alunos) {
        if (alunos == null || alunos.isEmpty()) return;

        int n = alunos.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (alunos.get(j).getNome().length() > alunos.get(j + 1).getNome().length()) {
                    Collections.swap(alunos, j, j + 1);
                }
            }
        }
    }

    /**
     * Sorts the list of students by grade in ascending order.
     *
     * @param alunos The list of students to be sorted.
     */
    public static void bubbleSortPorNota(List<Aluno> alunos) {
        if (alunos == null || alunos.isEmpty()) return;

        int n = alunos.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (alunos.get(j).getNota() > alunos.get(j + 1).getNota()) {
                    Collections.swap(alunos, j, j + 1);
                }
            }
        }
    }
}