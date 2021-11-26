package Lab5;

import java.util.Collections;

import easyaccept.EasyAccept;

public class Facade {

	private Controler controler;

	public Facade() {
		controler = new Controler();
	}

	public void inicializa(int caixa, double taxa) {
		controler.InicializaCaixa(caixa, taxa);

	}

	public int getCaixa() {
		return controler.RecuperaValorCaixa();
	}

	public int cadastrarCenario(String descricao) {
		return controler.CadastrarCenarios(descricao);
	}

	public String exibirCenario(int cenario) {
		return controler.ApresentaCenario(cenario);
	}

	public String cenariosCadastrados() {
		return controler.RetornaCenariosCadastrados();
	}

	public void cadastrarAposta(int cenario, String apostador, int valor, String previsao) {
		controler.CadastraAposta(cenario, apostador, valor, previsao);
	}

	public int totalDeApostas(int cenario) {
		return controler.ApresentaNumApostas(cenario);
	}

	public int RetornaValorAposta(int cenario) {
		return controler.ApresentaValorAposta(cenario);
	}

	public String ApresentaApostas(int cenario) {
		return controler.ApresentaApostas(cenario);
	}

	public void EncerraCenario(int cenario, boolean ocorreu) {
		controler.EncerraCenarios(cenario, ocorreu);
	}

	public int getCaixaCenario(int cenario) {
		return controler.getCaixaCenario(cenario);
	}

	public double getTotalRateioCenario(int cenario) {
		return controler.getTotalRateioCenario(cenario);
	}
	
	public int cadastrarCenario(String descricao, int bonus) {
		return controler.cadastrarCenario(descricao, bonus);
	}
	
	public void cadastrarApostaSeguraValor(int cenario, String apostador, int valor, String previsao, int valorSeguro, int custo) {
		controler.cadastrarApostaSeguraValor(cenario, apostador, valor, previsao, valorSeguro, custo);
		
	}
	
	public void cadastrarApostaSeguraTaxa(int cenario, String apostador, int valor, String previsao, int valorSeguro, double taxa) {
		controler.cadastrarApostaSeguraTaxa(cenario, apostador, valor, previsao, valorSeguro, taxa);
	}
	
	public void alteraOrdem(String ordem) {
		
	}

	public static void main(String[] args) {
		args = new String[] { "Lab5.Facade", "easyaccept/us1_test.txt", "easyaccept/us2_test.txt","easyaccept/us3_test.txt" };
		EasyAccept.main(args);
	}
}
