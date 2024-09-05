import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import java.io.IOException;



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
        public static List<FaturamentoDiario> lerXML(String filePath) {
            List<FaturamentoDiario> faturamentoDiarioList = new ArrayList<>();
            
            try {
                File file = new File(filePath);
                DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
                DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
                Document document = documentBuilder.parse(file);
                document.getDocumentElement().normalize();
                NodeList nodeList = document.getElementsByTagName("row");
                
                for (int i = 0; i < nodeList.getLength(); i++) {
                    Node node = nodeList.item(i);
                    
                    if (node.getNodeType() == Node.ELEMENT_NODE) {
                        Element element = (Element) node;
                        int dia = Integer.parseInt(element.getElementsByTagName("dia").item(0).getTextContent());
                        double valor = Double.parseDouble(element.getElementsByTagName("valor").item(0).getTextContent());
                        faturamentoDiarioList.add(new FaturamentoDiario(dia, valor));
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
    
            return faturamentoDiarioList;
        }
        
        static void dadosFaturamento() {
            List<FaturamentoDiario> faturamentoDiarioList = lerXML("dados.xml");
            double menor = faturamentoDiarioList.get(0).getValor();
            double maior = faturamentoDiarioList.get(0).getValor();
            int count = 0;
            double soma = 0;
            int tamanho = 0; // Para contar o tamanho da lista sem os valores zerados

            for (FaturamentoDiario item : faturamentoDiarioList) {
                if (item.getValor() == 0.0000) {
                    continue; // Pula os dias de feriados ou finais de semana com valor de faturamento igual a 0
                }

                if (item.getValor() < menor) {
                    menor = item.getValor();
                }

                if (item.getValor() > maior) {
                    maior = item.getValor();
                }

                soma += item.getValor();
                tamanho++;
            }

            double media = soma / tamanho;

            for (FaturamentoDiario item : faturamentoDiarioList) {
                if (item.getValor() == 0.0000) {
                    continue; 
                }

                if (item.getValor() > media) {
                    count++;
                }
            }

            System.out.println("O menor valor de faturamento ocorrido em um dia do mês é: " + menor);
            System.out.println("O maior valor de faturamento ocorrido em um dia do mês é: " + maior);
            System.out.println(String.format("A média de faturamento mensal é: %.2f", media));
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
        
        dadosFaturamento();

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