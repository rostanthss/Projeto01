package Lab5;

import java.util.Collections;

public class Caixa {
	
	private int caixa;
	private double taxa;
	
	public Caixa() {
		
	}
	
	public void inicia(int caixa, double taxa) {
		this.taxa = taxa;
		this.caixa = caixa;
	}
	
	public void retiraDinheiro() {
		caixa = (int) (caixa - (caixa / taxa));
	}
	
	public int getCaixa() {
		return caixa;
	}
	
	public double getTaxa() {
		return taxa;
	}
	
	public void AdicionaCaixa(int dinheiro) {
		this.caixa += dinheiro;
	}
	
	public void retiraDinheiroBonus(int bonus) {
	caixa = caixa - bonus;

	}
}
