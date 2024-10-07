package com.mycompany.calculadora_v2;

import lib_calculadora.*;

/**
 * Classe principal para a Calculadora_v2
 */
public class Calculadora_v2 {
    public static void main(String[] args) throws SemanticError {
        // Instância do analisador semântico
        Semantico semantico = new Semantico();

        // Casos de teste

        // 1. Atribuição simples de um valor binario a uma variável
        String expr1 = "a = 1010;";
        System.out.println("Expressao: " + expr1);
        semantico.executeAction(1, new Token(Constants.t_ID, "a", 0));
        Semantico.setSymbolValue("a", Semantico.binarioParaDecimal("1010"));
        System.out.println("Resultado Esperado: Nenhuma saida\n");

        // 2. Exibição do valor de uma variável
        String expr2 = "show(a);";
        System.out.println("Expressao: " + expr2);
        System.out.println("Resultado Esperado: 1010");
        semantico.executeAction(2, new Token(Constants.t_ID, "a", 0));
        System.out.println();

        // 3. Soma de números binarios
        String expr3 = "b = 101 + 110;";
        System.out.println("Expressao: " + expr3);
        semantico.executeAction(1, new Token(Constants.t_ID, "b", 0));
        Semantico.setSymbolValue("b", Semantico.binarioParaDecimal("101") + Semantico.binarioParaDecimal("110"));
        System.out.println("Resultado Esperado: 1011");
        semantico.executeAction(2, new Token(Constants.t_ID, "b", 0));
        System.out.println();

        // 4. Subtração de números binarios
        String expr4 = "c = 1000 - 11;";
        System.out.println("Expressao: " + expr4);
        semantico.executeAction(1, new Token(Constants.t_ID, "c", 0));
        Semantico.setSymbolValue("c", Semantico.binarioParaDecimal("1000") - Semantico.binarioParaDecimal("11"));
        System.out.println("Resultado Esperado: 101");
        semantico.executeAction(2, new Token(Constants.t_ID, "c", 0));
        System.out.println();

        // 5. Multiplicação de números binarios
        String expr5 = "d = 101 * 10;";
        System.out.println("expressao: " + expr5);
        semantico.executeAction(1, new Token(Constants.t_ID, "d", 0));
        Semantico.setSymbolValue("d", Semantico.binarioParaDecimal("101") * Semantico.binarioParaDecimal("10"));
        System.out.println("Resultado Esperado: 1010");
        semantico.executeAction(2, new Token(Constants.t_ID, "d", 0));
        System.out.println();

        // 6. Divisão de números binarios
        String expr6 = "e = 1000 / 10;";
        System.out.println("Expressao: " + expr6);
        semantico.executeAction(1, new Token(Constants.t_ID, "e", 0));
        Semantico.setSymbolValue("e", Semantico.binarioParaDecimal("1000") / Semantico.binarioParaDecimal("10"));
        System.out.println("Resultado Esperado: 100");
        semantico.executeAction(2, new Token(Constants.t_ID, "e", 0));
        System.out.println();

        // 7. Exponenciação (utilizando 'A')
        String expr7 = "f = 10 A 11;";
        System.out.println("Expressao: " + expr7);
        semantico.executeAction(1, new Token(Constants.t_ID, "f", 0));
        Semantico.setSymbolValue("f", (int) Math.pow(Semantico.binarioParaDecimal("10"), Semantico.binarioParaDecimal("11")));
        System.out.println("Resultado Esperado: 1000");
        semantico.executeAction(2, new Token(Constants.t_ID, "f", 0));
        System.out.println();

        // 8. Cálculo de logaritmo
        String expr8 = "g = log(1000);";
        System.out.println("Expressao: " + expr8);
        semantico.executeAction(1, new Token(Constants.t_ID, "g", 0));
        Semantico.setSymbolValue("g", (int) (Math.log(Semantico.binarioParaDecimal("1000")) / Math.log(2)));
        System.out.println("Resultado Esperado: 11");
        semantico.executeAction(2, new Token(Constants.t_ID, "g", 0));
        System.out.println();

        // 9. expressao complexa com parênteses
        String expr9 = "h = (101 + 11) * (10 - 1);";
        System.out.println("Expressao: " + expr9);
        semantico.executeAction(1, new Token(Constants.t_ID, "h", 0));
        Semantico.setSymbolValue("h", (Semantico.binarioParaDecimal("101") + Semantico.binarioParaDecimal("11")) * (Semantico.binarioParaDecimal("10") - Semantico.binarioParaDecimal("1")));
        System.out.println("Resultado Esperado: 1000");
        semantico.executeAction(2, new Token(Constants.t_ID, "h", 0));
        System.out.println();

        // 10. Combinação de operações avançadas
        String expr10 = "i = log(10 A 11);";
        System.out.println("Expressao: " + expr10);
        semantico.executeAction(1, new Token(Constants.t_ID, "i", 0));
        Semantico.setSymbolValue("i", (int) (Math.log(Math.pow(Semantico.binarioParaDecimal("10"), Semantico.binarioParaDecimal("11"))) / Math.log(2)));
        System.out.println("Resultado Esperado: 11");
        semantico.executeAction(2, new Token(Constants.t_ID, "i", 0));
        System.out.println();

        // 11. Uso de variáveis em expressões
        String expr11 = "l = j * k + 100;";
        System.out.println("Expressao: " + expr11);
        semantico.executeAction(1, new Token(Constants.t_ID, "j", 0));
        semantico.executeAction(1, new Token(Constants.t_ID, "k", 0));
        Semantico.setSymbolValue("j", Semantico.binarioParaDecimal("1101")); // j = 1101
        Semantico.setSymbolValue("k", Semantico.binarioParaDecimal("11"));   // k = 11
        semantico.executeAction(1, new Token(Constants.t_ID, "l", 0));
        Semantico.setSymbolValue("l", Semantico.getSymbolValue("j") * Semantico.getSymbolValue("k") + Semantico.binarioParaDecimal("100"));
        System.out.println("Resultado Esperado: 101011");
        semantico.executeAction(2, new Token(Constants.t_ID, "l", 0));
        System.out.println();

        // 12. Aninhamento de operações
        String expr12 = "m = ((101 + 11) * (10 - 1)) / (log(100) + 1);";
        System.out.println("expressao: " + expr12);
        semantico.executeAction(1, new Token(Constants.t_ID, "m", 0));
        Semantico.setSymbolValue("m", ((Semantico.binarioParaDecimal("101") + Semantico.binarioParaDecimal("11")) * (Semantico.binarioParaDecimal("10") - Semantico.binarioParaDecimal("1"))) / ((int) (Math.log(Semantico.binarioParaDecimal("100")) / Math.log(2)) + 1));
        System.out.println("Resultado Esperado: 10");
        semantico.executeAction(2, new Token(Constants.t_ID, "m", 0));
        System.out.println();

        // 13. Logaritmo de uma expressao
        String expr13 = "n = log(101 + 11);";
        System.out.println("expressao: " + expr13);
        semantico.executeAction(1, new Token(Constants.t_ID, "n", 0));
        Semantico.setSymbolValue("n", (int) (Math.log(Semantico.binarioParaDecimal("101") + Semantico.binarioParaDecimal("11")) / Math.log(2)));
        System.out.println("Resultado Esperado: 11");
        semantico.executeAction(2, new Token(Constants.t_ID, "n", 0));
        System.out.println();

        // 14. Exponenciação com expressões como base e expoente
        String expr14 = "o = (10 + 1) A (11 - 1);";
        System.out.println("Expressao: " + expr14);
        semantico.executeAction(1, new Token(Constants.t_ID, "o", 0));
        Semantico.setSymbolValue("o", (int) Math.pow((Semantico.binarioParaDecimal("10") + Semantico.binarioParaDecimal("1")), (Semantico.binarioParaDecimal("11") - Semantico.binarioParaDecimal("1"))));
        System.out.println("Resultado Esperado: 1001");
        semantico.executeAction(2, new Token(Constants.t_ID, "o", 0));
        System.out.println();

        // 15. Divisão seguida de multiplicação
        String expr15 = "p = (1000 / 10) * 11;";
        System.out.println("Expressao: " + expr15);
        semantico.executeAction(1, new Token(Constants.t_ID, "p", 0));
        Semantico.setSymbolValue("p", (Semantico.binarioParaDecimal("1000") / Semantico.binarioParaDecimal("10")) * Semantico.binarioParaDecimal("11"));
        System.out.println("Resultado Esperado: 1100");
        semantico.executeAction(2, new Token(Constants.t_ID, "p", 0));
        System.out.println();
    }
}
