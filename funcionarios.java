import java.util.Scanner;

class Funcionario {
    private String nome;
    private double salario;
    private String cargo;
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public double getSalario() {
        return salario;
    }


    public void setSalario(double salario) {
        if (salario >= 0) {
            this.salario = salario;
        } else {
            System.out.println("Erro: O valor do salário não pode ser negativo.");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Funcionario funcionario = new Funcionario();

        System.out.println("Registo de Novo funcionário");
        System.out.print("Digite o nome do funcionário: ");
        String nomeInput = scanner.nextLine();
        System.out.print("Digite o cargo do funcionário: ");
        String cargoInput = scanner.nextLine();
        System.out.print("Digite o salário do funcionário: ");
        double salarioInput = scanner.nextDouble();


        funcionario.setNome(nomeInput);
        funcionario.setCargo(cargoInput);
        funcionario.setSalario(salarioInput);

        System.out.println("Holetire da Empresa");
        System.out.println("Nome: " + funcionario.getNome());
        System.out.println("Cargo: " + funcionario.getCargo());
        System.out.printf("Salário Base: %.2f%n", funcionario.getSalario());

        scanner.close();
    }
}