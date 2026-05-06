import javax.swing.*; // Importa a biblioteca Swing para criar interface gráfica

public class CalculadoraAtrito {

    public static void main(String[] args) {

        // Criação da janela principal
        JFrame tela = new JFrame("Calculadora de Atrito");
        tela.setSize(420, 480); // Define o tamanho da janela
        tela.setLayout(null); // Permite posicionamento manual dos componentes

        // ===== CAMPOS DE ENTRADA =====

        // Label e campo para massa
        JLabel massaLabel = new JLabel("Massa (kg):");
        massaLabel.setBounds(20, 20, 120, 25);
        JTextField massaField = new JTextField();
        massaField.setBounds(150, 20, 200, 25);

        // Label e campo para força
        JLabel forcaLabel = new JLabel("Força (N):");
        forcaLabel.setBounds(20, 60, 120, 25);
        JTextField forcaField = new JTextField();
        forcaField.setBounds(150, 60, 200, 25);

        // Label e campo para ângulo
        JLabel anguloLabel = new JLabel("Ângulo (°):");
        anguloLabel.setBounds(20, 100, 120, 25);
        JTextField anguloField = new JTextField();
        anguloField.setBounds(150, 100, 200, 25);

        // Label e campo para coeficiente de atrito
        JLabel atritoLabel = new JLabel("Coef. Atrito:");
        atritoLabel.setBounds(20, 140, 120, 25);
        JTextField atritoField = new JTextField();
        atritoField.setBounds(150, 140, 200, 25);

        // Label e campo para gravidade (já com valor padrão)
        JLabel gLabel = new JLabel("Gravidade:");
        gLabel.setBounds(20, 180, 120, 25);
        JTextField gField = new JTextField("9.8");
        gField.setBounds(150, 180, 200, 25);

        // ===== TIPO DE ATRITO =====

        // Botão de seleção para atrito estático
        JRadioButton estatico = new JRadioButton("Estático");
        estatico.setBounds(80, 220, 100, 25);

        // Botão de seleção para atrito cinético
        JRadioButton cinetico = new JRadioButton("Cinético");
        cinetico.setBounds(200, 220, 100, 25);

        // Agrupa os botões para permitir apenas uma escolha
        ButtonGroup grupo = new ButtonGroup();
        grupo.add(estatico);
        grupo.add(cinetico);

        // ===== BOTÕES =====

        // Botão que realiza os cálculos
        JButton calcular = new JButton("CALCULAR");
        calcular.setBounds(80, 260, 110, 35);

        // Botão que limpa os campos
        JButton reset = new JButton("RESET");
        reset.setBounds(210, 260, 110, 35);

        // ===== SAÍDA DE RESULTADOS =====

        JLabel normal = new JLabel("Força Normal:");
        normal.setBounds(20, 320, 350, 25);

        JLabel atrito = new JLabel("Força de Atrito:");
        atrito.setBounds(20, 350, 350, 25);

        JLabel aceleracao = new JLabel("Aceleração:");
        aceleracao.setBounds(20, 380, 350, 25);

        JLabel situacao = new JLabel("Situação:");
        situacao.setBounds(20, 410, 350, 25);

        // ===== AÇÃO DO BOTÃO CALCULAR =====

        calcular.addActionListener(e -> {
            try {
                // Captura os valores digitados pelo usuário
                double m = Double.parseDouble(massaField.getText());
                double F = Double.parseDouble(forcaField.getText());
                double ang = Math.toRadians(Double.parseDouble(anguloField.getText())); // converte para radianos
                double mu = Double.parseDouble(atritoField.getText());
                double g = Double.parseDouble(gField.getText());

                // ===== CÁLCULOS FÍSICOS =====

                double N = m * g - F * Math.sin(ang); // força normal
                double f = mu * N; // força de atrito
                double Fx = F * Math.cos(ang); // componente horizontal da força

                double a; // aceleração
                String s; // situação (repouso ou movimento)

                // Verifica se o bloco se move ou não
                if (estatico.isSelected() && Fx <= f) {
                    a = 0;
                    s = "Repouso";
                } else {
                    a = (Fx - f) / m;
                    s = "Movimento";
                }

                // Exibe os resultados na tela
                normal.setText("Força Normal: " + String.format("%.2f", N) + " N");
                atrito.setText("Força de Atrito: " + String.format("%.2f", f) + " N");
                aceleracao.setText("Aceleração: " + String.format("%.2f", a) + " m/s²");
                situacao.setText("Situação: " + s);

            } catch (Exception ex) {
                // Caso haja erro (campo vazio ou valor inválido)
                JOptionPane.showMessageDialog(null, "Preencha todos os campos corretamente!");
            }
        });

        // ===== AÇÃO DO BOTÃO RESET =====

        reset.addActionListener(e -> {
            // Limpa todos os campos de entrada
            massaField.setText("");
            forcaField.setText("");
            anguloField.setText("");
            atritoField.setText("");
            gField.setText("9.8");

            // Reseta os resultados exibidos
            normal.setText("Força Normal:");
            atrito.setText("Força de Atrito:");
            aceleracao.setText("Aceleração:");
            situacao.setText("Situação:");
        });

        // ===== ADICIONA TODOS OS COMPONENTES NA TELA =====

        tela.add(massaLabel);
        tela.add(massaField);
        tela.add(forcaLabel);
        tela.add(forcaField);
        tela.add(anguloLabel);
        tela.add(anguloField);
        tela.add(atritoLabel);
        tela.add(atritoField);
        tela.add(gLabel);
        tela.add(gField);
        tela.add(estatico);
        tela.add(cinetico);
        tela.add(calcular);
        tela.add(reset);
        tela.add(normal);
        tela.add(atrito);
        tela.add(aceleracao);
        tela.add(situacao);

        // Configuração final da janela
        tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Fecha o programa ao fechar a janela
        tela.setVisible(true); // Torna a janela visível
    }
}