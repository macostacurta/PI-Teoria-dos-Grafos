package iesb.tg2024.devlab6;

public class Vertice {

	private String rotulo;
	private int grau;
	
	public Vertice(String rotulo) throws Exception{
		
		boolean isRotuloNullOrBranco = rotulo == null || rotulo != null && "".equals(rotulo.trim());
		
		if (isRotuloNullOrBranco) {
			throw new Exception("Não podemos criar Vértices sem rótulos! ");
		}
		
		this.rotulo = rotulo;
	}
	
	public void adicionarGrau() {
		this.grau++;
	}

	public String getRotulo() {
		return rotulo;
	}

	public void setRotulo(String rotulo) {
		this.rotulo = rotulo;
	}

	public int getGrau() {
		return grau;
	}

	public void setGrau(int grau) {
		this.grau = grau;
	}
	
	
}
