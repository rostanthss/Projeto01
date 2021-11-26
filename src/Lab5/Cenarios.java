package Lab5;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Cenarios implements Comparable<Cenarios> {

	protected ArrayList<Aposta> apostas;
	protected int numCenario;
	protected String estado = "Nao finalizado";
	private String previsao;
	protected int numApostas;
	protected int valorTotalAposta;
	protected int valorDinheiro;

	public Cenarios(String previsao) {
		
		if (previsao == null || previsao.trim().equals("")) {
			throw new IllegalArgumentException("Erro no cadastro de cenario: Descricao nao pode ser vazia");
		}
		apostas = new ArrayList<>();
		this.previsao = previsao;
	}

	public int EncerraCenarios(boolean conclusão) {
		int seguro = 0;
		estado = "finalizado";
		int dinheiro = 0;

		if (conclusão == true) {
			estado += " (ocorreu)";

		} else {
			estado += " (não ocorreu)";
		}

		if (conclusão == true) {
			for (Aposta A : apostas) {
				if (A.getPrevisao().equals("N VAI ACONTECER") && A.getSeguo() == 0) {
					dinheiro += A.getValotAposta();
					
				} else if (A.getPrevisao().equals("N VAI ACONTECER") && A.getSeguo() > 0 && A.getCusto() > 0) {
					seguro += A.getCusto();
					
				} else if (A.getPrevisao().equals("N VAI ACONTECER") && A.getSeguo() > 0 && A.getTaxa() > 0) {
					seguro += A.getTaxa() * A.getValotAposta();
				}

			}

		} else {
			for (Aposta B : apostas) {
				if (B.getPrevisao().equals("VAI ACONTECER")) {
					dinheiro += B.getValotAposta();
				}
			}
		}
		this.valorDinheiro = dinheiro;
		
		return seguro;
	}

	public String getRetornaNumCenarios() {
		return Integer.toString(numCenario);
	}

	public void CadastraAposta(String apostador, int valor, String previsao) {
		this.valorTotalAposta += valor;
		Aposta aposta = new Aposta(apostador, valor, previsao);
		apostas.add(aposta);
		
	}
	
	public void CadastraAposta(String apostador, int valor, String previsao, int seguro, double taxa) {
		this.valorTotalAposta += valor;
		Aposta aposta = new Aposta(apostador, valor, previsao, seguro, taxa);
		apostas.add(aposta);
		
	}
	
	public void CadastraAposta(String apostador, int valor, String previsao,  int seguro, int custo) {
		this.valorTotalAposta += valor;
		Aposta aposta = new Aposta(apostador, valor, previsao, seguro, custo);
		apostas.add(aposta);
		
	}

	public int getNumApostas() {
		return apostas.size();
	}

	public int getValorApostas() {
		int soma = 0;
		for (Aposta d : apostas) {
			soma += d.getValotAposta();
		}
		return soma;
	}

	public String RetornaApostas() {
		String saida = "";

		for (Aposta a : apostas) {
			saida += a.toString() + "\n";
		}
		return saida;
	}
	
	

	public int getTotalRateioCenario() {
		return valorDinheiro;
	}
	
	@Override
	public int compareTo(Cenarios outroObjeto) {
		if(this.numCenario < outroObjeto.numCenario) {
			return -1;
		} 
		
		if (this.numCenario > outroObjeto.numCenario) {
			return 1;
		}
		return 0;
	}
	@Override
	public String toString() {
		return  previsao + " - " + estado;
	}

}
