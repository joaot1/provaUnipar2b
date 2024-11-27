import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class sistemaBancario extends JFrame {
    private JLabel lblSaldo;
    private JTextField txtValorSaque;
    private JTextField txtValorDeposito;
    private JButton btnSaque;
    private JButton btnDeposito;
    private JTextArea txtMensagem;
    private JButton btnLimpar;
    private JPanel mainPanel;
    public double saldo;

    public sistemaBancario(){
        saldo = 500.00;
        lblSaldo.setText(String.valueOf(saldo));

        btnSaque.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (String.valueOf(txtValorSaque.getText()).isEmpty()) {
                    txtMensagem.setText("Favor informar valor de saque");
                } else {

                    double valorSaque = Double.parseDouble(txtValorSaque.getText());
                    if (valorSaque > 0) {

                        if (valorSaque > saldo) {
                            txtMensagem.setText("Saldo Insuficiente");
                            txtValorSaque.setText("");
                        } else if (valorSaque <= saldo) {
                            saldo -= valorSaque;
                            lblSaldo.setText(String.valueOf(saldo));
                            txtMensagem.setText("Saque de " + valorSaque + " realizado com sucesso");
                            txtValorSaque.setText("");
                        }

                    } else if(valorSaque < 0) {
                        txtMensagem.setText("Valor negativo não é liberado");
                        txtValorSaque.setText("");
                    }else{
                        txtMensagem.setText("não é possivel colocar o valor 0");
                        txtValorSaque.setText("");
                    }
                }
            }
        });

        btnDeposito.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (String.valueOf(txtValorDeposito.getText()).isEmpty()) {
                    txtMensagem.setText("coloque um valor valido");
                }else {

                    double valorDeposito = Double.parseDouble(txtValorDeposito.getText());
                    if (valorDeposito < 0) {
                        txtMensagem.setText("Valores negativos não são permitidos");
                        txtValorDeposito.setText("");
                    } else {

                        if (valorDeposito > 1000) {
                            txtMensagem.setText("o valor desejado não será possivel pois não há limite possivel ");
                        } else if (valorDeposito <= 1000) {
                            saldo += valorDeposito;
                            lblSaldo.setText(String.valueOf(saldo));
                            txtValorDeposito.setText("");
                            txtMensagem.setText("Deposito de " + valorDeposito + " realizado com sucesso");
                        }

                    }
                }

            }
        });

        btnLimpar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                txtMensagem.setText("");
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Sistema Bancario Tombini");
        frame.setContentPane(new sistemaBancario().mainPanel);
        frame.setSize(500,500);
        frame.setVisible(true);
    }
}