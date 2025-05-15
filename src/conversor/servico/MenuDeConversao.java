package conversor.servico;

import conversor.modelo.ExchangeRateResposta;

import java.util.Scanner;

public class MenuDeConversao {

    public static void inicia (ExchangeRateResposta dados) {
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;

        while (continuar) {
            System.out.println("\n=== Conversor de Moedas ===");
            System.out.println("1. USD → BRL");
            System.out.println("2. BRL → ARS");
            System.out.println("3. BOB → CLP");
            System.out.println("4. CLP → COP");
            System.out.println("5. COP → USD");
            System.out.println("6. ARS → BOB");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();

            if (opcao == 0) {
                continuar = false;
                System.out.println("Encerrando o programa...");
                continue;
            }

            System.out.print("Digite o valor que deseja converter: ");
            double valor = scanner.nextDouble();

            String moedaOrigem = "";
            String moedaDestino = "";

            switch (opcao) {
                case 1 -> { moedaOrigem = "USD"; moedaDestino = "BRL"; }
                case 2 -> { moedaOrigem = "BRL"; moedaDestino = "ARS"; }
                case 3 -> { moedaOrigem = "BOB"; moedaDestino = "CLP"; }
                case 4 -> { moedaOrigem = "CLP"; moedaDestino = "COP"; }
                case 5 -> { moedaOrigem = "COP"; moedaDestino = "USD"; }
                case 6 -> { moedaOrigem = "ARS"; moedaDestino = "BOB"; }
                default -> {
                    System.out.println("Opção inválida.");
                    continue;
                }
            }

            try {
                double resultado = ConversorDeMoedas.converte(
                        valor, moedaOrigem, moedaDestino, dados.getConversion_rates());

                System.out.printf("Resultado: %.2f %s = %.2f %s%n",
                        valor, moedaOrigem, resultado, moedaDestino);
            } catch (IllegalArgumentException | IllegalAccessException e) {
                System.out.println("Erro na conversão: " + e.getMessage());
            }
        }

        scanner.close();
    }
}
