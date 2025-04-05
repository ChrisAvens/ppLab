package Lab04.Ex01;

import Lab03.Aluno;
import Lab04.FiltroAluno;

import java.util.Comparator;
import java.util.List;

public class TesteLambda {
    // Defining an static filter using a lambda expression
    public static final FiltroAluno filtroPorId = aluno -> aluno.getId() > 14000;

    public static void run(List<Aluno> alunos) {
        // In 1 instruction:
        // 1. Convert the list to stream
        // 2. Filter by ID > 14000
        // 3. Order by name descending
        // 4. Print the result
        alunos.stream()
                .filter(aluno -> aluno.getId() > 14000)
                .sorted(Comparator.comparing(Aluno::getNome).reversed())
                .forEach(aluno -> System.out.println(aluno));
    }
}