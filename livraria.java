import java.util.Scanner;

class Livro {
    public String titulo;
    public String autor;
    public int anoPublicacao;
}

public class Main {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        Livro meuLivro = new Livro();

        System.out.println("Cadastro de Novo Livro");
        
        System.out.print("Digite o nome do livro: ");
        meuLivro.titulo = leitor.nextLine();
        System.out.print("Digite o nome do autor: ");
        meuLivro.autor = leitor.nextLine();
        System.out.print("Digite o ano de publicação: ");
        meuLivro.anoPublicacao = leitor.nextInt();

        System.out.println("\nLivro Cadastrado com Sucesso");
        System.out.println("Título: " + meuLivro.titulo);
        System.out.println("Autor: " + meuLivro.autor);
        System.out.println("Ano: " + meuLivro.anoPublicacao);
        
        leitor.close();
    }
}