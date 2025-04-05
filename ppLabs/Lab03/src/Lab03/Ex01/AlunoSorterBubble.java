package Lab03.Ex01;

import Lab03.Aluno;
import java.util.Collections;
import java.util.List;

public class AlunoSorterBubble {
    /**
     * Sorts the list of students by name in lexicographical order using Bubble Sort.
     *
     * @param alunos The list of students to be sorted.
     */
    public static void bubbleSortPorNomeLex(List<Aluno> alunos) {
        if (alunos == null || alunos.isEmpty() || alunos.size() == 1) {
            return;
        }

        boolean swapped;
        for (int i = 0; i < alunos.size() - 1; i++) {
            swapped = false;
            for (int j = 0; j < alunos.size() - 1 - i; j++) {
                if (alunos.get(j).getNome().compareTo(alunos.get(j + 1).getNome()) > 0) {
                    Collections.swap(alunos, j, j + 1);
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
    }

    /**
     * Sorts the list of students by name length in ascending order using Bubble Sort.
     *
     * @param alunos The list of students to be sorted.
     */
    public static void bubbleSortPorNomeLen(List<Aluno> alunos) {
        if (alunos == null || alunos.isEmpty() || alunos.size() == 1) {
            return;
        }

        boolean swapped;
        for (int i = 0; i < alunos.size() - 1; i++) {
            swapped = false;
            for (int j = 0; j < alunos.size() - 1 - i; j++) {
                if (alunos.get(j).getNome().length() > alunos.get(j + 1).getNome().length()) {
                    Collections.swap(alunos, j, j + 1);
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
    }

    /**
     * Sorts the list of students by grade in ascending order using Bubble Sort.
     *
     * @param alunos The list of students to be sorted.
     */
    public static void bubbleSortPorNota(List<Aluno> alunos) {
        if (alunos == null || alunos.isEmpty() || alunos.size() == 1) {
            return;
        }

        boolean swapped;
        for (int i = 0; i < alunos.size() - 1; i++) {
            swapped = false;
            for (int j = 0; j < alunos.size() - 1 - i; j++) {
                if (alunos.get(j).getNota() > alunos.get(j + 1).getNota()) {
                    Collections.swap(alunos, j, j + 1);
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
    }
}