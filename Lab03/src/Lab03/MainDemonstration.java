package Lab03;

import Lab03.Ex01.AlunoSorterBubble;
import Lab03.Ex02.AlunoSorterLambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainDemonstration {
    public static void main(String[] args) {
        // Create a list of students for testing
        List<Aluno> alunos = new ArrayList<>(Arrays.asList(
                new Aluno(1, "Ana-Maria", "Silva", 18),
                new Aluno(2, "João", "Carlos", 15),
                new Aluno(3, "Maria", "Santos", 12),
                new Aluno(4, "Pedro", "Oliveira", 20),
                new Aluno(5, "Lucas", "Ferreira", 17)
        ));

        System.out.println("Original list:");
        alunos.forEach(System.out::println);

        // BubbleSort demonstration
        System.out.println("\n--- BubbleSort Demonstration ---");

        List<Aluno> alunosCopyBubble1 = new ArrayList<>(alunos);
        AlunoSorterBubble.bubbleSortPorNomeLex(alunosCopyBubble1);
        System.out.println("\nSort by name (BubbleSort):");
        alunosCopyBubble1.forEach(System.out::println);

        List<Aluno> alunosCopyBubble2 = new ArrayList<>(alunos);
        AlunoSorterBubble.bubbleSortPorNomeLen(alunosCopyBubble2);
        System.out.println("\nSort by name length (BubbleSort):");
        alunosCopyBubble2.forEach(System.out::println);

        List<Aluno> alunosCopyBubble3 = new ArrayList<>(alunos);
        AlunoSorterBubble.bubbleSortPorNota(alunosCopyBubble3);
        System.out.println("\nSort by grade (BubbleSort):");
        alunosCopyBubble3.forEach(System.out::println);

        // Lambda demonstration
        System.out.println("\n--- Lambda Sort Demonstration ---");

        List<Aluno> alunosCopyLambda1 = new ArrayList<>(alunos);
        AlunoSorterLambda.sortByNameLex(alunosCopyLambda1);

        List<Aluno> alunosCopyLambda2 = new ArrayList<>(alunos);
        AlunoSorterLambda.sortByNameLength(alunosCopyLambda2);

        List<Aluno> alunosCopyLambda3 = new ArrayList<>(alunos);
        AlunoSorterLambda.sortByNota(alunosCopyLambda3);

        // Performance comparison
        System.out.println("\n--- Performance Test ---");

        // Create a larger list for performance testing
        List<Aluno> alunosGrande = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            alunosGrande.add(new Aluno(i, "Aluno" + i, "Sobrenome" + i, (int)(Math.random() * 20)));
        }

        // Test BubbleSort
        List<Aluno> alunosGrandeCopy1 = new ArrayList<>(alunosGrande);
        long startTimeBubble = System.nanoTime();
        AlunoSorterBubble.bubbleSortPorNota(alunosGrandeCopy1);
        long endTimeBubble = System.nanoTime();

        // Test Lambda
        List<Aluno> alunosGrandeCopy2 = new ArrayList<>(alunosGrande);
        long startTimeLambda = System.nanoTime();
        AlunoSorterLambda.sortByNota(alunosGrandeCopy2);
        long endTimeLambda = System.nanoTime();

        System.out.println("BubbleSort Time: " + (endTimeBubble - startTimeBubble) / 1000000.0 + " ms");
        System.out.println("Lambda Sort Time: " + (endTimeLambda - startTimeLambda) / 1000000.0 + " ms");
    }
}