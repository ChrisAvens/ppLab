package Lab03;

import Lab03.Ex01.AlunoSorterBubble;
import Lab03.Ex02.AlunoSorterLambda;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;

public class TestAlunoSorters {

    private List<Aluno> originalAlunos;

    /**
     * Fixture setup method.
     * This method runs before each test, ensuring that each test starts
     * with a fresh copy of the original student list.
     */
    @BeforeEach
    void setUp() {
        originalAlunos = new ArrayList<>(Arrays.asList(
                new Aluno(1, "Ana-Maria", "Silva", 18),
                new Aluno(2, "João", "Carlos", 15),
                new Aluno(3, "Maria", "Santos", 12)
        ));
    }

    /**
     * Utility method to create a fresh copy of the originalAlunos list.
     *
     * @return A new List containing copies of the original Aluno objects.
     */
    private List<Aluno> getFreshAlunos() {
        // Deep copy to ensure each test works with a fresh list
        List<Aluno> freshList = new ArrayList<>();
        for (Aluno aluno : originalAlunos) {
            freshList.add(new Aluno(aluno.getId(), aluno.getNome(), aluno.getApelido(), aluno.getNota()));
        }
        return freshList;
    }

    @Test
    void testSortByNameLex() {
        List<Aluno> alunosForLambdaSort = getFreshAlunos();
        List<Aluno> alunosForBubbleSort = getFreshAlunos();

        AlunoSorterLambda.sortByNameLex(alunosForLambdaSort);
        AlunoSorterBubble.bubbleSortPorNomeLex(alunosForBubbleSort);

        assertEquals("Ana-Maria", alunosForLambdaSort.get(0).getNome());
        assertEquals("João", alunosForLambdaSort.get(1).getNome());
        assertEquals("Maria", alunosForLambdaSort.get(2).getNome());

        // Check that both sorting methods produce the same result
        for (int i = 0; i < alunosForLambdaSort.size(); i++) {
            assertEquals(alunosForLambdaSort.get(i).getNome(), alunosForBubbleSort.get(i).getNome());
        }
    }

    @Test
    void testSortByNameLength() {
        List<Aluno> alunosForLambdaSort = getFreshAlunos();
        List<Aluno> alunosForBubbleSort = getFreshAlunos();

        AlunoSorterLambda.sortByNameLength(alunosForLambdaSort);
        AlunoSorterBubble.bubbleSortPorNomeLen(alunosForBubbleSort);

        assertEquals("João", alunosForLambdaSort.get(0).getNome());      // Length 4
        assertEquals("Maria", alunosForLambdaSort.get(1).getNome());     // Length 5
        assertEquals("Ana-Maria", alunosForLambdaSort.get(2).getNome()); // Length 9

        // Check that both sorting methods produce the same result
        for (int i = 0; i < alunosForLambdaSort.size(); i++) {
            assertEquals(alunosForLambdaSort.get(i).getNome(), alunosForBubbleSort.get(i).getNome());
        }
    }

    @Test
    void testSortByGrade() {
        List<Aluno> alunosForLambdaSort = getFreshAlunos();
        List<Aluno> alunosForBubbleSort = getFreshAlunos();

        AlunoSorterLambda.sortByNota(alunosForLambdaSort);
        AlunoSorterBubble.bubbleSortPorNota(alunosForBubbleSort);

        assertEquals(12, alunosForLambdaSort.get(0).getNota());
        assertEquals(15, alunosForLambdaSort.get(1).getNota());
        assertEquals(18, alunosForLambdaSort.get(2).getNota());

        // Check that both sorting methods produce the same result
        for (int i = 0; i < alunosForLambdaSort.size(); i++) {
            assertEquals(alunosForLambdaSort.get(i).getNota(), alunosForBubbleSort.get(i).getNota());
        }
    }

    @Test
    void testSortEmptyList() {
        List<Aluno> emptyAlunos = new ArrayList<>();

        // Test lambda sorters
        AlunoSorterLambda.sortByNameLex(emptyAlunos);
        assertTrue(emptyAlunos.isEmpty());

        AlunoSorterLambda.sortByNameLength(emptyAlunos);
        assertTrue(emptyAlunos.isEmpty());

        AlunoSorterLambda.sortByNota(emptyAlunos);
        assertTrue(emptyAlunos.isEmpty());

        // Test bubble sorters
        AlunoSorterBubble.bubbleSortPorNomeLex(emptyAlunos);
        assertTrue(emptyAlunos.isEmpty());

        AlunoSorterBubble.bubbleSortPorNomeLen(emptyAlunos);
        assertTrue(emptyAlunos.isEmpty());

        AlunoSorterBubble.bubbleSortPorNota(emptyAlunos);
        assertTrue(emptyAlunos.isEmpty());
    }

    @Test
    void testSortNullList() {
        // Test lambda sorters - should not throw exception
        AlunoSorterLambda.sort(null, Comparator.comparing(Aluno::getNome));

        // Test bubble sorters - should not throw exception
        AlunoSorterBubble.bubbleSortPorNomeLex(null);
        AlunoSorterBubble.bubbleSortPorNomeLen(null);
        AlunoSorterBubble.bubbleSortPorNota(null);
    }

    @Test
    void testSortSingleElement() {
        List<Aluno> singleAluno = new ArrayList<>(Arrays.asList(
                new Aluno(1, "Ana-Maria", "Silva", 18)
        ));

        // Test bubble sorters
        AlunoSorterBubble.bubbleSortPorNomeLex(singleAluno);
        assertEquals(1, singleAluno.size());
        assertEquals("Ana-Maria", singleAluno.get(0).getNome());

        AlunoSorterBubble.bubbleSortPorNomeLen(singleAluno);
        assertEquals(1, singleAluno.size());
        assertEquals("Ana-Maria", singleAluno.get(0).getNome());

        AlunoSorterBubble.bubbleSortPorNota(singleAluno);
        assertEquals(1, singleAluno.size());
        assertEquals(18, singleAluno.get(0).getNota());

        // Test lambda sorters
        AlunoSorterLambda.sortByNameLex(singleAluno);
        assertEquals(1, singleAluno.size());
        assertEquals("Ana-Maria", singleAluno.get(0).getNome());

        AlunoSorterLambda.sortByNameLength(singleAluno);
        assertEquals(1, singleAluno.size());
        assertEquals("Ana-Maria", singleAluno.get(0).getNome());

        AlunoSorterLambda.sortByNota(singleAluno);
        assertEquals(1, singleAluno.size());
        assertEquals(18, singleAluno.get(0).getNota());
    }
}