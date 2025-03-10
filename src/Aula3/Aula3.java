package Aula3;

import java.util.Scanner;

public class Aula3 {
    public static void main(String[] args) {

        //Passo 1 - Executar o metodo capturarNota e o obter os valores de nota1, nota2 e notaTrabalho
        double retornoNota1 = capturarNota("Informar valor da nota 1: ");
        double retornoNota2 = capturarNota("Informar valor da nota 2: ");
        double retornoNotaTrabalho = capturarNota("Informar valor da nota do trabalho: ");

        //Passo2 - Executar o metodo calcularMediaSemestral e obter o valor da Média Semestral do aluno(a)
        double retornoCalcularMediaSemestral = calcularMediaSemestral(retornoNota1, retornoNota2, retornoNotaTrabalho);

        //Passo 3 - Validar Média Semestral do Aluno(a) - MS >= 7
        //Desvio Condicional Composto
        if(retornoCalcularMediaSemestral >= 7) {
            System.out.print("Aluno(a) aprovado(a) na disciplina. A média semestral é: " + retornoCalcularMediaSemestral);
        }else{
            System.out.print("Aluno(a) deverá realizar exame da disciplina. A média semestral é:" + retornoCalcularMediaSemestral);

            //Passo 4
            double retornoCalcularNotaCorte = calcularNotaCorte(retornoCalcularMediaSemestral);
            System.out.print("A nota de corte para aprovação na disciplina é: " + retornoCalcularNotaCorte);

            //Passo 5 - Capturar o valor da nota do exame
            double retornoNotaExame = capturarNota("Informar valor da nota do exame: ");

            //Passo 6 - Calcular Média do Exame
            //retornoCalcularMediaSemestral = mediaSemestral
            //retornoNotaExame = notaExame
            double retornoCalcularMediaExame = calcularMediaExame(retornoCalcularMediaSemestral, retornoNotaExame);

            //Passo 7 - Validar Média do Exame do Aluno(a) - ME >= 5
            //Desvio Condicional Composto
            if(retornoCalcularMediaExame >= 5){
                System.out.print("Aluno(a) aprovado no exame da disciplina");
            }else{
                System.out.print("Aluno(a) reprovado no exame da disciplina");
            }
        }
    }

    //O metodo calcularMediaExame será responsável por realizar o cálculo da média do exame do aluno(a)
    private static double calcularMediaExame(double mediaSemestral, double notaExame){
        double mediaExame = (mediaSemestral + notaExame) / 2;
        return mediaExame;
    }
    //O metodo calcularNotaCorte será responsável para obter o valor minimo de nota para aprovação no exame
    private static double calcularNotaCorte(double mediaSemestral){
        double notaCorte = (10 - mediaSemestral);
        return notaCorte;
    }
    // O metodo calcularMediaSemestral será responsável por realizar o Cálculo de Média Semestral do Aluno(a)
    private static double calcularMediaSemestral(double nota1, double nota2, double notaTrabalho) {
        double mediaSemestral = ((nota1 * 0.4) + (nota2 * 0.4) + (notaTrabalho * 0.2));
        return mediaSemestral;
    }
    //O metodo capturarNota será responsável por caputar a nota1, nota2, notaTrabalho e notaExame
    private static double capturarNota(String notaInput){
        Scanner scanner = new Scanner(System.in);
        System.out.print(notaInput);
        double nota= scanner.nextDouble();
        scanner.close();
        return nota;
    }
}