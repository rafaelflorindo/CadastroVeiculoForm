package apresentacao;

import negocio.Veiculo;
import persistencia.ControlaVeiculo;

import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

public class DlgMostraVeiculos extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTable tblVeiculos;

    ControlaVeiculo cv;
    public DlgMostraVeiculos(ControlaVeiculo cv) {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        this.cv = cv;
        exibeInformacoes();
    }
    private void exibeInformacoes(){
        ArrayList<Veiculo> veiculos = cv.retornarTodos();

        //limpar tabela
        for (int i = 0; i < veiculos.size(); i++){
            tblVeiculos.setValueAt("",i,0);
            tblVeiculos.setValueAt("",i,1);
        }
        for (int i = 0; i < veiculos.size(); i++){
            tblVeiculos.setValueAt(veiculos.get(i).getNome(),i,0);
            tblVeiculos.setValueAt(veiculos.get(i).getMarca(),i,1);
        }
    }
    public DlgMostraVeiculos() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
        buttonCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                this.dispose();
            }

            private void dispose() {
            }
        });
    }

    private void onOK() {
        // add your code here
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public static void main(String[] args) {
        DlgMostraVeiculos dialog = new DlgMostraVeiculos();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
