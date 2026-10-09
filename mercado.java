import java.util.Scanner;

class Supermercado {
    private String[] nomesProdutos;
    private double[] precos;
    private double[] descontos;
    private int quantidadeAtual = 0;

    public Supermercado(int capacidade) {
        nomesProdutos = new String[capacidade];
        precos = new double[capacidade];
        descontos = new double[capacidade];
    }

    public void adicionarProduto(String nome, double preco, double desconto) {
        if (quantidadeAtual < nomesProdutos.length) {
            nomesProdutos[quantidadeAtual] = nome;
            precos[quantidadeAtual] = preco;
            descontos[quantidadeAtual] = desconto;
            quantidadeAtual++;
        }
    }

    public void listarProdutos() {
        System.out.println("\nLista de Produtos");
        for (int i = 0; i < quantidadeAtual; i++) {
            double valorDesconto = precos[i] * (descontos[i] / 100.0);
            double precoFinal = precos[i] - valorDesconto;
            System.out.println((i + 1) + ". Produto: " + nomesProdutos[i] 
                + " | Preço Original: R$ " + precos[i] 
                + " | Desconto: " + descontos[i] + "%" 
                + " | Preço Final: R$ " + precoFinal);
        }
    }

    public double calcularTotalCompra() {
        double total = 0;
        for (int i = 0; i < quantidadeAtual; i++) {
            total += precos[i] - (precos[i] * (descontos[i] / 100.0));
        }
        return total;
    }

    public String produtoMaiorEconomia() {
        if (quantidadeAtual == 0) return "Nenhum produto cadastrado.";
        double maiorEconomia = 0;
        String produtoEconomico = "";

        for (int i = 0; i < quantidadeAtual; i++) {
            double economia = precos[i] * (descontos[i] / 100.0);
            if (economia >= maiorEconomia) {
                maiorEconomia = economia;
                produtoEconomico = nomesProdutos[i] + " (Economia de R$ " + maiorEconomia + ")";
            }
        }
        return produtoEconomico;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);

        System.out.print("Quantos produtos deseja cadastrar? ");
        int quantidade = leitor.nextInt();
        leitor.nextLine();

        Supermercado mercado = new Supermercado(quantidade);

        for (int i = 0; i < quantidade; i++) {
            System.out.println("\n--- Cadastro do Produto " + (i + 1) + " ---");
            
            System.out.print("Nome do produto: ");
            String nome = leitor.nextLine();

            System.out.print("Preço original (R$): ");
            double preco = leitor.nextDouble();

            System.out.print("Porcentagem de desconto (ex: 10 para 10%): ");
            double desconto = leitor.nextDouble();
            leitor.nextLine();

            mercado.adicionarProduto(nome, preco, desconto);
        }
        
        mercado.listarProdutos();
        System.out.println("\nTotal da compra com descontos: R$ " + mercado.calcularTotalCompra());
        System.out.println("Produto com maior economia: " + mercado.produtoMaiorEconomia());

        leitor.close();
    }
}
