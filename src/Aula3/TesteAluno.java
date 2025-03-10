package Aula3;

public class TesteAluno {
    public static void main(String[] args) {

        // Instanciando o objeto

        CalculadoraDeNotas aluno = new CalculadoraDeNotas();

        aluno.calcularMediaSemestral(8, 9, 6, 7);
        aluno.calcularMediaAnual();

        System.out.println("Média do aluno(a): " + aluno.mediaSemestral1 + " e " + aluno.mediaSemestral2);
        System.out.println("Média anual do aluno(a): " + aluno.mediaAnual);
    }
}
