package apresentacao;

import negocio.Veiculo;
import persistencia.ControlaVeiculo;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Principal extends JFrame {
    private JTextField tfdMarca;
    private JButton btnSalvar;
    private JTextField tfdNome;
    private JButton btnVerTodos;
    private JButton btnSair;

    ControlaVeiculo cv = new ControlaVeiculo();

    public Principal() {
        btnSair.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        btnSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Veiculo veiculo = new Veiculo();

                veiculo.setNome(tfdNome.getText());
                veiculo.setMarca(tfdMarca.getText());

                if(cv.salvar(veiculo)){
                    JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
                    tfdNome.setText("");
                    tfdMarca.setText("");
                    tfdNome.requestFocus();
                }else {
                    JOptionPane.showMessageDialog(null, "Erro ao Salvar!");
                }

            }
        });
        btnVerTodos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DlgMostraVeiculos dlg =new DlgMostraVeiculos(cv);
                dlg.setVisible(true);
            }
        });
    }
}
