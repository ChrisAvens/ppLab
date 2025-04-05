package Lab04.Ex02;

import Lab03.Aluno;
import Lab04.FiltroAluno;

import java.util.Comparator;
import java.util.List;

public class TesteReferencia {
    // Define a static filter
    public static final FiltroAluno filtroPorId = TesteReferencia::filtrarPorId;

    // Método estático que implementa la lógica de filtrado
    public static boolean filtrarPorId(Aluno aluno) {
        return aluno.getId() > 14000;
    }

    public static void run(List<Aluno> alunos) {
        // In 1 instruction using method reference:
        // 1. Convert the list to stream
        // 2. Filtramos usando la referencia de método
        // 3. Ordenamos usando referencias de método
        // 4. Imprimimos usando referencia de método
        alunos.stream()
                .filter(filtroPorId::aceita)
                .sorted(Comparator.comparing(Aluno::getNome).reversed())
                .forEach(System.out::println);
    }
}