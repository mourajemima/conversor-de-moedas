package conversor.servico;

import java.util.Map;

public class ConversorDeMoedas {

    public static double converte(double valor, String moedaOrigem, String moedaDestino, Map<String, Double> taxas) throws IllegalAccessException {
        Double taxaOrigem = taxas.get(moedaOrigem);
        Double taxaDestino = taxas.get(moedaDestino);

        if (taxaOrigem == null || taxaDestino == null) {
            throw new IllegalAccessException("Moeda inválida: " + moedaOrigem + " ou " + moedaDestino);
        }

        return valor * (taxaDestino / taxaOrigem);
    }
}
