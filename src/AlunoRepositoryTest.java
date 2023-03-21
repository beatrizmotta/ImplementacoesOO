package src;

import Domain.Aluno;
import Domain.Responsavel;
import Repository.AlunoRepository;

public class AlunoRepositoryTest {

    public static void main(String[] args) {
        Aluno aluno = new Aluno();
//        aluno.setSuspenso(false);
//        aluno.setEnsino("FUNDAMENTAL");
//        aluno.setSerie((long) 9);
//        aluno.setMensalidade("R$ 124.50");
//        aluno.setTurno("MATUTINO");
//        aluno.setDiaDeVencimento(12);
//        aluno.setCpf(1372892340);
//        aluno.setDataNasc("05/05/2001");
//        aluno.setNumeroDeMatricula(123123);
//        Responsavel responsavel = new Responsavel("Tylper Perry", "82982117444");
//        aluno.addResponsavel(responsavel);

        // Getting arquivo

        AlunoRepository alunoRepository = new AlunoRepository();
//        alunoRepository.saveInfo(aluno);
        aluno = alunoRepository.getInfo("123123");
        System.out.println(aluno.toString());
    }



}
