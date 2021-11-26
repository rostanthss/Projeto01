package Lab5;

public class Aposta {

	private String nome;
	private int valor;
	private String previsao;
	private Caixa caixa;
	private int seguro;
	private double taxa;
	private int custo;

	public Aposta(String apostador, int valor, String previsao) {
		this.nome = apostador;
		this.valor = valor;
		this.previsao = previsao;

	}

	public Aposta(String apostador, int valor, String previsao, int Seguro, int custo) {
		this.nome = apostador;
		this.valor = valor;
		this.previsao = previsao;
		this.seguro = seguro;
		this.custo = custo;
	}

	public Aposta(String apostador, int valor, String previsao, int Seguro, double taxa) {
		this.nome = apostador;
		this.valor = valor;
		this.previsao = previsao;
		this.seguro = seguro;
		this.taxa = taxa;
	}

	public void alteraSeguroValor(int apostaAssegurada, int valor) {
		this.valor = valor;
		this.taxa = 0;
		this.seguro = apostaAssegurada;
	}

	public void alterarSeguroTaxa(int apostaAssegurada, double taxa) {
		this.taxa = taxa;
		this.valor = 0;
		this.seguro = apostaAssegurada;
	}

	public int getValotAposta() {
		return valor;
	}

	public String getPrevisao() {
		return previsao;
	}

	public int getSeguo() {
		return seguro;
	}

	public int getCusto() {
		return custo;
	}

	public double getTaxa() {
		return taxa;
	}

	public String toString() {
		if (seguro > 0 && custo > 0) {
			return nome + " - " + valor + " - " + previsao + " - ASSEGURADA (VALOR) - R$ " + valor;

		} else if (seguro > 0 && taxa > 0) {
			return nome + " - " + valor + " - " + previsao + " - ASSEGURADA (TAXA) - R$ " + taxa + "%";
		}

		return nome + " - " + valor + " - " + previsao;
	}
}
