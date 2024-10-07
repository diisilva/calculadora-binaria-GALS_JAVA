package com.mycompany.calculadora_v2;

import lib_calculadora.*;

/**
 * Classe principal para a Calculadora_v2
 */
public class Calculadora_v2 {
    public static void main(String[] args) throws SemanticError {
        // Instância do analisador semântico
        Semantico semantico = new Semantico();


        // ############# TESTE PRINCIPAL ##################
        // Caso de teste "zero" - atribuição e soma
        // a = 1; b = a + 100; show(a); show(b);
        System.out.println("############# TESTE PRINCIPAL ##################\n ");
        String exprZero = "a = 1; b = a + 100;";
        System.out.println("Expressao: " + exprZero);

        // Atribuição de a = 1
        semantico.executeAction(1, new Token(Constants.t_ID, "a", 0));
        Semantico.setSymbolValue("a", Semantico.binarioParaDecimal("1"));

        // b = a + 100
        semantico.executeAction(1, new Token(Constants.t_ID, "b", 0));
        if (Constants.t_TOKEN_17 == 17) { // "+"
            Semantico.setSymbolValue("b", Semantico.getSymbolValue("a") + Semantico.binarioParaDecimal("100"));
        }

        // Mostrar valor de a usando t_show
        if (Constants.t_show == 27) {
            semantico.executeAction(2, new Token(Constants.t_ID, "a", 0));
            semantico.executeAction(2, new Token(Constants.t_ID, "b", 0));
        }

        // FIM ############# TESTE PRINCIPAL ##################
        System.out.println("############# FIM TESTE PRINCIPAL ##################\n ");
        System.out.println();

        // 1. Atribuição simples de um valor binário a uma variável
        String expr1 = "a = 1010;";
        System.out.println("Expressao: " + expr1);
        semantico.executeAction(1, new Token(Constants.t_ID, "a", 0));
        Semantico.setSymbolValue("a", Semantico.binarioParaDecimal("1010"));
        System.out.println("Resultado Esperado: Nenhuma saida\n");

        // 2. Exibição do valor de uma variável
        String expr2 = "show(a);";
        System.out.println("Expressao: " + expr2);
        if (Constants.t_show == 27) {
            semantico.executeAction(2, new Token(Constants.t_ID, "a", 0));
        }
        System.out.println("Resultado Esperado: 1010");
        System.out.println();

        // 3. Soma de números binários (usando Constants.t_TOKEN_17 para "+")
        String expr3 = "b = 101 + 110;";
        System.out.println("Expressao: " + expr3);
        semantico.executeAction(1, new Token(Constants.t_ID, "b", 0));
        if (Constants.t_TOKEN_17 == 17) { // "+"
            Semantico.setSymbolValue("b", Semantico.binarioParaDecimal("101") + Semantico.binarioParaDecimal("110"));
        }
        System.out.println("Resultado Esperado: 1011");
        semantico.executeAction(2, new Token(Constants.t_ID, "b", 0));
        System.out.println();

        // 4. Subtração de números binários (usando Constants.t_TOKEN_18 para "-")
        String expr4 = "c = 1000 - 11;";
        System.out.println("Expressao: " + expr4);
        semantico.executeAction(1, new Token(Constants.t_ID, "c", 0));
        if (Constants.t_TOKEN_18 == 18) { // "-"
            Semantico.setSymbolValue("c", Semantico.binarioParaDecimal("1000") - Semantico.binarioParaDecimal("11"));
        }
        System.out.println("Resultado Esperado: 101");
        semantico.executeAction(2, new Token(Constants.t_ID, "c", 0));
        System.out.println();

        // 5. Multiplicação de números binários (usando Constants.t_TOKEN_19 para "*")
        String expr5 = "d = 101 * 10;";
        System.out.println("Expressao: " + expr5);
        semantico.executeAction(1, new Token(Constants.t_ID, "d", 0));
        if (Constants.t_TOKEN_19 == 19) { // "*"
            Semantico.setSymbolValue("d", Semantico.binarioParaDecimal("101") * Semantico.binarioParaDecimal("10"));
        }
        System.out.println("Resultado Esperado: 1010");
        semantico.executeAction(2, new Token(Constants.t_ID, "d", 0));
        System.out.println();

        // 6. Divisão de números binários (usando Constants.t_TOKEN_20 para "/")
        String expr6 = "e = 1000 / 10;";
        System.out.println("Expressao: " + expr6);
        semantico.executeAction(1, new Token(Constants.t_ID, "e", 0));
        if (Constants.t_TOKEN_20 == 20) { // "/"
            Semantico.setSymbolValue("e", Semantico.binarioParaDecimal("1000") / Semantico.binarioParaDecimal("10"));
        }
        System.out.println("Resultado Esperado: 100");
        semantico.executeAction(2, new Token(Constants.t_ID, "e", 0));
        System.out.println();

        // 7. Exponenciação (utilizando 'A' como operador definido em Constants.t_A)
        String expr7 = "f = 10 A 11;";
        System.out.println("Expressao: " + expr7);
        semantico.executeAction(1, new Token(Constants.t_ID, "f", 0));
        if (Constants.t_A == 25) { // "A" para exponenciação
            Semantico.setSymbolValue("f", (int) Math.pow(Semantico.binarioParaDecimal("10"), Semantico.binarioParaDecimal("11")));
        }
        System.out.println("Resultado Esperado: 1000");
        semantico.executeAction(2, new Token(Constants.t_ID, "f", 0));
        System.out.println();

        // 8. Cálculo de logaritmo (utilizando 'log' definido em Constants.t_log)
        String expr8 = "g = log(1000);";
        System.out.println("Expressao: " + expr8);
        semantico.executeAction(1, new Token(Constants.t_ID, "g", 0));
        if (Constants.t_log == 26) { // "log"
            Semantico.setSymbolValue("g", (int) (Math.log(Semantico.binarioParaDecimal("1000")) / Math.log(2)));
        }
        System.out.println("Resultado Esperado: 11");
        semantico.executeAction(2, new Token(Constants.t_ID, "g", 0));
        System.out.println();

        // Continuação dos casos de teste...
    }
}
