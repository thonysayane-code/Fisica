import java.util.Scanner; // Importa a classe Scanner para entrada de dados pelo teclado

public class Main {

    public static void main(String[] args) {

        // Cria o objeto Scanner para ler os dados digitados pelo usuário
       Scanner sc = new Scanner(System.in).useLocale(java.util.Locale.US);

        // ===== ENTRADA DE DADOS =====

        // Solicita e lê a massa do bloco
        System.out.print("Massa (kg): ");
        double m = sc.nextDouble();

        // Solicita e lê a força aplicada
        System.out.print("Força (N): ");
        double F = sc.nextDouble();

        // Solicita e lê o ângulo (em graus) e converte para radianos
        System.out.print("Ângulo (graus): ");
        double angulo = Math.toRadians(sc.nextDouble());

        // Solicita e lê o coeficiente de atrito
        System.out.print("Coeficiente de atrito: ");
        double mu = sc.nextDouble();

        // Solicita e lê o valor da gravidade
        System.out.print("Gravidade: ");
        double g = sc.nextDouble();

        // Solicita o tipo de atrito (1 = estático, 2 = cinético)
        System.out.print("Tipo de atrito (1 = Estático, 2 = Cinético): ");
        int tipo = sc.nextInt();

        // ===== CÁLCULOS FÍSICOS =====

        // Calcula a força normal (N = mg - Fy)
        double N = m * g - F * Math.sin(angulo);

        // Calcula a força de atrito (f = μ * N)
        double f = mu * N;

        // Calcula a componente horizontal da força (Fx)
        double Fx = F * Math.cos(angulo);

        double a; // variável para armazenar a aceleração
        String situacao; // variável para armazenar a situação do bloco

        // ===== VERIFICAÇÃO DO MOVIMENTO =====

        // Se for atrito estático e a força não vence o atrito → repouso
        if (tipo == 1 && Fx <= f) {
            a = 0;
            situacao = "Repouso";
        } else {
            // Caso contrário, o bloco entra em movimento
            a = (Fx - f) / m;
            situacao = "Movimento";
        }

        // ===== SAÍDA DE RESULTADOS =====

        System.out.println("\n--- RESULTADOS ---");

        // Exibe a força normal com duas casas decimais
        System.out.printf("Força Normal: %.2f N\n", N);

        // Exibe a força de atrito
        System.out.printf("Força de Atrito: %.2f N\n", f);

        // Exibe a aceleração
        System.out.printf("Aceleração: %.2f m/s²\n", a);

        // Exibe a situação do bloco
        System.out.println("Situação: " + situacao);

        // Fecha o Scanner
        sc.close();
    }
}