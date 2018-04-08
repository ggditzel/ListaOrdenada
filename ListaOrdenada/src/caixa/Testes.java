package caixa;

public class Testes {
	

	public static void main(String[] args) {
		
		Caixa<Double> item1 = null;
		Caixa<Double> item2 = null;
		Caixa<Double> item3 = null;
		Caixa<Double> item4 = null;
		
		try {
			item1 = new Caixa<Double>(13.2);
			item2 = new Caixa<Double>(1.3);
			item3 = new Caixa<Double>(5.4);
			item4 = new Caixa<Double>(9.7);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.printf("valor: %.2f; proximo: %s; anterior: %s\n", item1.getValor(), item1.getProximo(), item1.getAnterior());
		System.out.printf("valor: %.2f; proximo: %s; anterior: %s\n", item2.getValor(), item2.getProximo(), item2.getAnterior());
		System.out.printf("valor: %.2f; proximo: %s; anterior: %s\n", item3.getValor(), item3.getProximo(), item3.getAnterior());
		System.out.printf("valor: %.2f; proximo: %s; anterior: %s\n", item4.getValor(), item4.getProximo(), item4.getAnterior());
		
	}

}
