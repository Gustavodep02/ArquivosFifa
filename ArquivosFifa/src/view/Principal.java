package view;

import java.io.IOException;

import controller.FifaController;
import entity.Lista;
import model.Pilha;

public class Principal {
	public static void main(String[] args) {

		FifaController controller = new FifaController();
		Pilha pilha = new Pilha();
		Lista<String> lista = new Lista<String>();
		try {
			pilha = controller.empilhaBrasileiros("C:\\TEMP", "data.csv");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
            controller.desmpilhaBonsBrasileiros(pilha);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

		try {
			lista = controller.listaRevelacoes("C:\\TEMP", "data.csv");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
            controller.buscaListaBonsJovens(lista);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
	}
}
