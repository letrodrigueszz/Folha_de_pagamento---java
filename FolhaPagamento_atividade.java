
import java.util.Scanner;
import java.text.DecimalFormat;

public class FolhaPagamento {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("#,##0.00");

        System.out.print("Digite o valor da sua hora de trabalho (R$): ");
        double valorHora = scanner.nextDouble();
        
        System.out.print("Digite a quantidade de horas trabalhadas no mês: ");
        double horasTrabalhadas = scanner.nextDouble();

        double salarioBruto = valorHora * horasTrabalhadas;
        double descontoIR = calcularIR(salarioBruto);
        double descontoINSS = salarioBruto * 0.10;
        double fgts = salarioBruto * 0.11;
        double totalDescontos = descontoIR + descontoINSS;
        double salarioLiquido = salarioBruto - totalDescontos;

        System.out.println("\nFolha de Pagamento");
        System.out.println("----------------------------------");
        System.out.println("Salário Bruto (" + valorHora + " * " + horasTrabalhadas + ")\t: R$ " + df.format(salarioBruto));
        System.out.println("(-) IR (" + getPercentualIR(salarioBruto) + "%)\t\t: R$ " + df.format(descontoIR));
        System.out.println("(-) INSS (10%)\t\t\t: R$ " + df.format(descontoINSS));
        System.out.println("FGTS (11%)\t\t\t: R$ " + df.format(fgts));
        System.out.println("Total de descontos\t\t: R$ " + df.format(totalDescontos));
        System.out.println("Salário Líquido\t\t\t: R$ " + df.format(salarioLiquido));
    }

    public static double calcularIR(double salarioBruto) {
        if (salarioBruto <= 900) {
            return 0;
        } else if (salarioBruto <= 1500) {
            return salarioBruto * 0.05;
        } else if (salarioBruto <= 2500) {
            return salarioBruto * 0.10;
        } else {
            return salarioBruto * 0.20;
        }
    }

    public static String getPercentualIR(double salarioBruto) {
        if (salarioBruto <= 900) {
            return "Isento";
        } else if (salarioBruto <= 1500) {
            return "5";
        } else if (salarioBruto <= 2500) {
            return "10";
        } else {
            return "20";
        }
    }
}
