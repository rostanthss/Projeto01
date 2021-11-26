package Lab5;

import java.util.Collections;

public class CenarioBonus extends Cenarios {
	
	private String cenario;
	private int bonus;
	private Caixa caixa;
	
	public CenarioBonus(String cenario, int bonus) {
		super(cenario);
		this.bonus = bonus;
		caixa = new Caixa();
		caixa.retiraDinheiroBonus(bonus);
	}
	
	@Override
	public String toString() {
		
		return numCenario + "-" + cenario + "-" + estado + "-" + bonus;
	}

}
