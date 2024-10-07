package lib_calculadora;

import java.util.HashMap;
import java.util.Map;

public class Semantico implements Constants {

    // Tabela de símbolos para armazenar variáveis e seus valores binários (inteiros)
    private static Map<String, Integer> symbolTable = new HashMap<>();

    // Função chamada para cada ação semântica definida na gramática
    public void executeAction(int action, Token token) throws SemanticError {
        String varName = token.getLexeme(); // Nome da variável

        switch (action) {
            case 1: // Atribuição
                // Atribuição não envolve conversão para binário, isso é tratado diretamente pela setSymbolValue
                break;

            case 2: // Comando Show
                if (symbolTable.containsKey(varName)) {
                    int valueToShow = symbolTable.get(varName);
                    System.out.println("Valor de " + varName + " (em binário): " + decimalParaBinario(valueToShow));
                } else {
                    System.out.println("Erro: Variável " + varName + " não definida.");
                }
                break;

            default:
                throw new SemanticError("Ação semântica desconhecida: " + action);
        }
    }

    // Método para definir o valor de uma variável na tabela de símbolos
    public static void setSymbolValue(String varName, int value) {
        symbolTable.put(varName, value);
    }

    // Método para obter o valor de uma variável da tabela de símbolos
    public static int getSymbolValue(String varName) {
        return symbolTable.getOrDefault(varName, 0);
    }

    // Método para converter números binários para decimais
    public static int binarioParaDecimal(String binario) {
        return Integer.parseInt(binario, 2);
    }

    // Método para converter números decimais para binários
    public static String decimalParaBinario(int decimal) {
        return Integer.toBinaryString(decimal);
    }
}
