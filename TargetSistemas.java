import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Scanner;
public class TargetSistemas{

        /*
        * 2) Dado a sequência de Fibonacci, onde se inicia por 0 e 1 e o próximo valor sempre será a soma dos 2 valores anteriores
        * (exemplo: 0, 1, 1, 2, 3, 5, 8, 13, 21, 34...), escreva um programa na linguagem que desejar onde, informado um número,
        * ele calcule a sequência de Fibonacci e retorne uma mensagem avisando se o número informado pertence ou não a sequência.
        */
        static ArrayList<Integer> fibonacci(int n, ArrayList<Integer> lista) throws Exception{
            if (n < 0) {
                throw new Exception("Número inválido");
            }
            if (n == 0) {
                lista.add(0);
                return lista;
            }
            if (n == 1) {
                lista.add(0);
                lista.add(1);
                return lista;
            }
    
            fibonacci(n - 1, lista);
            int size = lista.size();
            lista.add(lista.get(size - 1) + lista.get(size - 2));
            return lista;
        }
        
        static void pertenceFibonacci(int n) throws Exception {
            ArrayList<Integer> listaFibonacci = fibonacci(n, new ArrayList<Integer>());
            if (listaFibonacci.contains(n)) {
                System.out.println("Pertence a sequência de Fibonacci");
            } else {
                System.out.println("Não pertence a sequência de Fibonacci");
            }
        }

        /*
         * 3) Dado um vetor que guarda o valor de faturamento diário de uma distribuidora, faça um programa, na linguagem que desejar, que calcule e retorne:
         * • O menor valor de faturamento ocorrido em um dia do mês;
         * • O maior valor de faturamento ocorrido em um dia do mês;
         * • Número de dias no mês em que o valor de faturamento diário foi superior à média mensal.
        */
        static void dadosFaturamento(ArrayList<Double> lista){
            double menor = lista.get(0);
            for(int i = 0; i < lista.size(); i++){
                if(lista.get(i) < menor){
                    menor = lista.get(i);
                }
            }

            System.out.println("O menor valor de faturamento ocorrido em um dia do mês é: " + menor);

            double maior = lista.get(0);
            for(int j = 0; j < lista.size(); j++){
                if(lista.get(j) > maior){
                    maior = lista.get(j);
                }
            }
            System.out.println("O maior valor de faturamento ocorrido em um dia do mês é: " + maior);

            double media = 0;
            for(int k= 0; k < lista.size(); k++){
                media += lista.get(k);
            }
            media = media / lista.size();

            System.out.println(String.format("A média de faturamento mensal é: %.2f", media));

            int count = 0;
            for(int l = 0; l < lista.size(); l++){
                if(lista.get(l) > media){
                    count++;
                }
            }
            System.out.println("Número de dias no mês em que o valor de faturamento diário foi superior à média mensal é: " + count);
        }
        
        /*
         * 4) Dado o valor de faturamento mensal de uma distribuidora, detalhado por estado:
            • SP – R$67.836,43
            • RJ – R$36.678,66
            • MG – R$29.229,88
            • ES – R$27.165,48
            • Outros – R$19.849,53

            Escreva um programa na linguagem que desejar onde calcule o percentual de representação que cada estado teve dentro do valor total mensal da distribuidora.
         */
        static void percentualCadaEstado(HashMap<String, Double> faturamento)
        {
        int faturamentoTotal = 0;
        for (double valor: faturamento.values()) {
            faturamentoTotal += valor;
        }
        
        for (Map.Entry<String, Double> entry : faturamento.entrySet()) {
            double percentual = (entry.getValue() / faturamentoTotal) * 100;
            System.out.println(String.format("O estado %s teve %.2f%% de representação no faturamento total", entry.getKey(), percentual));
        }
    
        }

        //5) Escreva um programa que inverta os caracteres de um string.
        static String inverteCaracter(String palavra){
            if(palavra.length() == 0){
                return palavra;
            }
            return inverteCaracter(palavra.substring(1)) + palavra.charAt(0);
        }
        
    public static void main(String[] args) throws Exception {
        Scanner t = new Scanner(System.in);
        System.out.println("Digite a posição que deseja seu Fibonacci");
        int num = t.nextInt();
        pertenceFibonacci(num);

        System.out.println("==============================================");
        ArrayList<Double> faturamentoMensal = new ArrayList<>();
        faturamentoMensal.add(1800.25);
        faturamentoMensal.add(1000.8);
        faturamentoMensal.add(1800.75);
        faturamentoMensal.add(2150.0);
        faturamentoMensal.add(1900.25);
        faturamentoMensal.add(2900.0);
        faturamentoMensal.add(3900.0);
        dadosFaturamento(faturamentoMensal);

        System.out.println("==============================================");
        
        HashMap<String,Double> faturamento = new HashMap<String,Double>();
        faturamento.put("SP",67836.43);
        faturamento.put("RJ",36678.66);
        faturamento.put("MG",29229.88);
        faturamento.put("ES",27165.48);
        faturamento.put("Outros",19849.53);
        percentualCadaEstado(faturamento);
        System.out.println("==============================================");
        
        System.out.println("A palavra invertida é: " + inverteCaracter("Target Sistemas"));
    }
}