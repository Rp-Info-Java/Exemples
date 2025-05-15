package br.com.rpinfo.exemples.metodos;

import java.util.Scanner;

public class ExercicioDois {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            int numero = solicitarNumero(scanner);
            String romano = converterParaRomano(numero);
            System.out.println("Número romano: " + romano);
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Erro inesperado: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }

    public static int solicitarNumero(Scanner scanner) {
        System.out.print("Digite um número entre 1 e 3999: ");
        if (!scanner.hasNextInt()) {
            throw new IllegalArgumentException("Entrada inválida. Por favor, insira um número inteiro.");
        }
        int numero = scanner.nextInt();
        if (numero < 1 || numero > 3999) {
            throw new IllegalArgumentException("Número fora do intervalo permitido (1-3999).");
        }
        return numero;
    }

    public static String converterParaRomano(int numero) {
        String resultado = "";
        int[] valores = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] simbolos = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        for (int i = 0; i < valores.length; i++) {
            while (numero >= valores[i]) {
                resultado += simbolos[i];
                numero -= valores[i];
            }
        }
        return resultado;
    }

}
