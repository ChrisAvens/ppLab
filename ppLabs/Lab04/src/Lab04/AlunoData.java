package Lab04;

import Lab03.Aluno;
import Lab04.Ex01.TesteLambda;
import Lab04.Ex02.TesteReferencia;

import java.util.ArrayList;
import java.util.List;

public class AlunoData {
    public static List<Aluno> criarListaAlunos() {
        List<Aluno> db = new ArrayList<>();
        db.add(new Aluno(12011, "Bernardo", "Santos", 11));
        db.add(new Aluno(12015, "Alice", "Teixeira", 11));
        db.add(new Aluno(12348, "Miguel", "Silva", 13));
        db.add(new Aluno(13001, "Artur", "Lima", 18));
        db.add(new Aluno(13001, "Julia", "Cavalcante", 11));
        db.add(new Aluno(13109, "Henrique", "Sérgio", 18));
        db.add(new Aluno(13124, "Ana", "Almeida", 18));
        db.add(new Aluno(14045, "Gabriela", "Sousa", 10));
        db.add(new Aluno(14101, "Sofia", "Pereira", 18));
        db.add(new Aluno(14632, "Carlos", "Alexandre", 11));
        db.add(new Aluno(14234, "David", "Coelho", 11));
        return db;
    }

    public static void main(String[] args) {
        List<Aluno> alunos = criarListaAlunos();

        System.out.println("--- Exercise 1: Lambda ---");
        TesteLambda.run(alunos);

        System.out.println("\n--- Exercise 2: Method References ---");
        TesteReferencia.run(alunos);
    }
}