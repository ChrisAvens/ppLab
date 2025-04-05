package Lab04;

import Lab03.Aluno;
import java.util.function.Predicate;

@FunctionalInterface
public interface FiltroAluno extends Predicate<Aluno> {
    boolean aceita(Aluno a);

    @Override
    default boolean test(Aluno a) {
        return aceita(a);
    }
}