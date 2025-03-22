package Lab03;

import Lab03.Ex01.AlunoSorterBubble;
import Lab03.Ex02.AlunoSorterLambda;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
                new Aluno(3, "Emilia", "Medellin", 17),
                new Aluno(4, "Paola", "Martinez", 16),
                new Aluno(5, "Maria", "Santos", 12)
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

        assertEquals("Ana-Maria", alunosForBubbleSort.get(0).getNome());
        assertEquals("João", alunosForBubbleSort.get(1).getNome());
        assertEquals("Maria", alunosForBubbleSort.get(2).getNome());

        // Verify that both methods produce the same result
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

        assertEquals("João", alunosForBubbleSort.get(0).getNome());       // Length 4
        assertEquals("Maria", alunosForBubbleSort.get(1).getNome());      // Length 5
        assertEquals("Ana-Maria", alunosForBubbleSort.get(2).getNome());  // Length 9

        // Verify that both methods produce the same result
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

        assertEquals(12, alunosForBubbleSort.get(0).getNota());
        assertEquals(15, alunosForBubbleSort.get(1).getNota());
        assertEquals(18, alunosForBubbleSort.get(2).getNota());

        // Verify that both methods produce the same result
        for (int i = 0; i < alunosForLambdaSort.size(); i++) {
            assertEquals(alunosForLambdaSort.get(i).getNota(), alunosForBubbleSort.get(i).getNota());
        }
    }

    @Test
    void testSortEmptyList() {
        List<Aluno> emptyAlunos = new ArrayList<>();
        List<Aluno> emptyAlunosForBubble = new ArrayList<>();

        AlunoSorterLambda.sortByNameLex(emptyAlunos);
        AlunoSorterBubble.bubbleSortPorNomeLex(emptyAlunosForBubble);

        assertTrue(emptyAlunos.isEmpty());
        assertTrue(emptyAlunosForBubble.isEmpty());
    }

    @Test
    void testSortNullList() {
        // Should not throw exception
        AlunoSorterLambda.sortByNameLex(null);
        AlunoSorterBubble.bubbleSortPorNomeLex(null);
        // If we got here, the test passed
        assertTrue(true);
    }

    @Test
    void testSortSingleElement() {
        List<Aluno> singleAlunoForLambda = new ArrayList<>(Arrays.asList(
                new Aluno(1, "Ana-Maria", "Silva", 18)
        ));
        List<Aluno> singleAlunoForBubble = new ArrayList<>(Arrays.asList(
                new Aluno(1, "Ana-Maria", "Silva", 18)
        ));

        AlunoSorterLambda.sortByNota(singleAlunoForLambda);
        AlunoSorterBubble.bubbleSortPorNota(singleAlunoForBubble);

        assertEquals(1, singleAlunoForLambda.size());
        assertEquals(1, singleAlunoForBubble.size());
        assertEquals("Ana-Maria", singleAlunoForLambda.get(0).getNome());
        assertEquals("Ana-Maria", singleAlunoForBubble.get(0).getNome());
    }

    @Test
    void testSortAlreadySorted() {
        List<Aluno> sortedList = new ArrayList<>(Arrays.asList(
                new Aluno(3, "Ana", "Silva", 10),
                new Aluno(2, "Bernardo", "Pereira", 15),
                new Aluno(1, "Carla", "Santos", 20)
        ));

        List<Aluno> sortedListCopy = getFreshAlunosCopy(sortedList);

        AlunoSorterLambda.sortByNameLex(sortedList);
        AlunoSorterBubble.bubbleSortPorNomeLex(sortedListCopy);

        // Verify that the order was maintained
        for (int i = 0; i < sortedList.size(); i++) {
            assertEquals(sortedList.get(i).getNome(), sortedListCopy.get(i).getNome());
        }
    }

    @Test
    void testSortWithDuplicates() {
        List<Aluno> alunosWithDuplicates = new ArrayList<>(Arrays.asList(
                new Aluno(1, "João", "Silva", 15),
                new Aluno(2, "Maria", "Santos", 15),
                new Aluno(3, "João", "Pereira", 18)
        ));

        List<Aluno> alunosWithDuplicatesCopy = getFreshAlunosCopy(alunosWithDuplicates);

        AlunoSorterLambda.sortByNota(alunosWithDuplicates);
        AlunoSorterBubble.bubbleSortPorNota(alunosWithDuplicatesCopy);

        // Verify that elements with equal grades are kept together
        assertEquals(alunosWithDuplicates.get(0).getNota(), alunosWithDuplicatesCopy.get(0).getNota());
        assertEquals(alunosWithDuplicates.get(1).getNota(), alunosWithDuplicatesCopy.get(1).getNota());
    }

    private List<Aluno> getFreshAlunosCopy(List<Aluno> original) {
        List<Aluno> freshList = new ArrayList<>();
        for (Aluno aluno : original) {
            freshList.add(new Aluno(aluno.getId(), aluno.getNome(), aluno.getApelido(), aluno.getNota()));
        }
        return freshList;
    }
}