package Aula3;

public class CalculadoraDeNotas {
    // Atributos
    String nome;
    double PCCF = 0.4;
    double GS = 0.6;
    double mediaSemestral1;
    double mediaSemestral2;
    double mediaAnual;


    // Métodos
    void calcularMediaSemestral(double nota1, double nota2, double nota3, double nota4) {
        mediaSemestral1 = (nota1 * PCCF) + (nota2 * GS);
        mediaSemestral2 = (nota3 * PCCF) + (nota4 * GS);
    }

    void calcularMediaAnual() {
        mediaAnual = (mediaSemestral1 * 0.4) + (mediaSemestral2 * 0.6);
    }
}


