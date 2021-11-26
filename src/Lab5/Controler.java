
package Lab5;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

class cenarioNomeComparator implements Comparator<Cenarios> {

	@Override
	public int compare(Cenarios o1, Cenarios o2) {		
		return 0;
	}
	
}
public class Controler {

	private ArrayList<Cenarios> listcenarios;
	private Caixa dinheiro;
	private Cenarios cenarios;
	private CenarioBonus cenarioBonus;
	
	public Controler() {
		listcenarios = new ArrayList<>();
		dinheiro = new Caixa();

	}

	public void InicializaCaixa(int caixa, double taxa) {
		if (caixa < 0) {
			throw new IllegalArgumentException("Erro na inicializacao: Caixa nao pode ser inferior a 0");
		}

		if (taxa <= 0) {
			throw new IllegalArgumentException("Erro na inicializacao: Taxa nao pode ser inferior a 0");
		}
		dinheiro.inicia(caixa, taxa);

	}

	public int RecuperaValorCaixa() {
		return dinheiro.getCaixa();
	}

	public int CadastrarCenarios(String descricao) {
		cenarios = new Cenarios(descricao);
		listcenarios.add(cenarios);
		return listcenarios.size();
	}

	public String ApresentaCenario(int cenario) {
		
		if (cenario <= 0) {
			throw new IllegalArgumentException("Erro na consulta de cenario: Cenario invalido");
		}
		if (cenario >listcenarios.size()) {
			throw new IllegalArgumentException("Erro na consulta de cenario: Cenario nao cadastrado");
		}
		return cenario + " - " + this.listcenarios.get(cenario -1).toString();
	}

	public int ApresentaNumApostas(int cenario) {
		return this.listcenarios.get(cenario - 1).getNumApostas();
	}

	public int ApresentaValorAposta(int cenario) {
		return this.listcenarios.get(cenario - 1).getValorApostas();
	}

	public String RetornaCenariosCadastrados() {
		String saida = "";

		for (Cenarios C : this.listcenarios) {
			saida += C.toString() + "\n";
		}
		return saida;
	}

	public String ApresentaApostas(int cenario) {
		return this.listcenarios.get(cenario - 1).RetornaApostas();

	}

	public void CadastraAposta(int cenario, String apostador, int valor, String previsao) {
		
		if (apostador == null || apostador.trim().isEmpty()) {
			throw new IllegalArgumentException("Erro no cadastro de aposta: Apostador nao pode ser vazio ou nulo");
		}
		
		if(cenario<=0 || cenario < listcenarios.size()) {
			throw new IllegalArgumentException("Erro na consulta do valor total de apostas: Cenario invalido");
		}

		listcenarios.get(cenario - 1).CadastraAposta(apostador, valor, previsao);
	}

	public void EncerraCenarios(int cenario, boolean ocorreu) {
		dinheiro.retiraDinheiro(listcenarios.get(cenario - 1).EncerraCenarios(ocorreu));
		
	}

	public double getTotalRateioCenario(int cenario) {
		int rateio = this.listcenarios.get(cenario).getTotalRateioCenario();
		return rateio - rateio * dinheiro.getTaxa();
	}

	public int getCaixaCenario(int cenario) {
		dinheiro.AdicionaCaixa(this.listcenarios.get(cenario).getTotalRateioCenario());
		return dinheiro.getCaixa();
	}
	
	public String listaCenarios() {
		String saida = "";
		
		for(Cenarios C: listcenarios) {
			saida += C.toString() + "\n";
		}
		return saida;
	}
	
	public void alteraOrdenacao(String ordem) {
		
	}
	public int cadastrarCenario(String descricao, int bonus) {
		cenarioBonus = new CenarioBonus(descricao, bonus);
		listcenarios.add(cenarioBonus);
		return listcenarios.size();
		
	}
	
	public void alteraOrdem(String ordem) {
		if (ordem.equals("cadastro")) {
			Collections.sort(listcenarios);
		}
	}
	
	public void cadastrarApostaSeguraValor(int cenario, String apostador, int valor, String previsao, int valorSeguro, int custo) {
		listcenarios.get(cenario - 1).CadastraAposta(apostador, valor, previsao, valorSeguro, custo);
	}
	
	public void cadastrarApostaSeguraTaxa(int cenario, String apostador, int valor, String previsao, int valorSeguro, double taxa) {
		listcenarios.get(cenario - 1).CadastraAposta(apostador, valor, previsao, valorSeguro, taxa);
	}

}
