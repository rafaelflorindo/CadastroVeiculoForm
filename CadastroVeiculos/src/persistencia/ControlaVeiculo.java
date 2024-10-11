package persistencia;

import negocio.Veiculo;

import java.util.ArrayList;

public class ControlaVeiculo {
    private ArrayList<Veiculo> veiculos = new ArrayList<>();

    public boolean salvar(Veiculo v){
        if(v != null){
            veiculos.add(v);
            return true;
        }else {
            return false;
        }
    }

    public ArrayList<Veiculo> retornarTodos() {
        return veiculos;
    }
}
