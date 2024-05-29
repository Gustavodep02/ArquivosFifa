package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import entity.Lista;
import model.Pilha;

public class FifaController implements IFifaController {

	public Pilha empilhaBrasileiros(String caminho, String nome) throws IOException {
		Pilha pilha = new Pilha();
		File arq = new File(caminho, nome);
		if (arq.exists() && arq.isFile()) {
			FileInputStream fluxo = new FileInputStream(arq);
			InputStreamReader leitor = new InputStreamReader(fluxo);
			BufferedReader buffer = new BufferedReader(leitor);
			String linha = buffer.readLine();
			linha = buffer.readLine();
			while (linha != null) {
				String[] dados = linha.split(",");
				if (dados[5].equals("Brazil")) {
					pilha.push(linha);
				}
				linha = buffer.readLine();
			}
		} else {
			throw new IOException("Arquivo inexistente");
		}
		return pilha;
	}

	public void desmpilhaBonsBrasileiros(Pilha pilha) throws IOException {
		while (!pilha.isEmpty()) {
			String[] dados;
			try {
				dados = pilha.pop().split(",");
				if (Integer.parseInt(dados[7]) > 80) {
					System.out.println(dados[2] + " " + dados[7]);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}
	
	public Lista<String> listaRevelacoes(String caminho, String nome) throws IOException {
        Lista<String> lista = new Lista<String>();
        File arq = new File(caminho, nome);
        if (arq.exists() && arq.isFile()) {
            FileInputStream fluxo = new FileInputStream(arq);
            InputStreamReader leitor = new InputStreamReader(fluxo);
            BufferedReader buffer = new BufferedReader(leitor);
            String linha = buffer.readLine();
            linha = buffer.readLine();
            while (linha != null) {
                String[] dados = linha.split(",");
                if (Integer.parseInt(dados[3]) <= 20) {
                    try {
						lista.addLast(linha);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
                }
                linha = buffer.readLine();
            }
        } else {
            throw new IOException("Arquivo inexistente");
        }
        return lista;
    }
	
	public void buscaListaBonsJovens(Lista<String> lista) throws IOException {
		for (int tamanho = lista.size();tamanho > 0; tamanho--) {
            String[] dados;
			try {
				dados = lista.get(tamanho-1).split(",");
				if (Integer.parseInt(dados[7]) > 80) {
	                System.out.println(dados[2] +" "+dados[3]+ " " + dados[7]);
	            }
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            
        }
    }
}
