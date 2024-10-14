package iesb.tg2024.devlab6;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Grafo {
	
	private int qtdMaximaVertices;
	private int qtdAtualVertices = 0;
	private boolean isQtdMaximaDefinida;
	
	// G = (V,E)

	private List<Vertice> vertices = new ArrayList<Vertice>();
	private Map<String, Integer> rotulosEmIndices = new HashMap<String, Integer>();
	
	private MatrizAdjacencia matrizAdjacencia = null;
	
	//metodo construtor
	public Grafo (int qtdMaximaVertices) {
		this.qtdMaximaVertices = qtdMaximaVertices;
	}
	
	public void adicionarVertices(String rotulo) throws Exception {
		if(this.qtdAtualVertices <= this.qtdMaximaVertices - 1) {
			
			Vertice vertice = new Vertice(rotulo);
			this.vertices.add(vertice);
			this.rotulosEmIndices.put(rotulo, qtdAtualVertices);
			qtdAtualVertices++;
			
			
			
		} else {
			throw new Exception("A Quantidade Maxima de vertices ja foi alcançada " + this.qtdMaximaVertices + " foi exedida");
		}
	}
	
	public List<Vertice> getVertices(){
		return this.vertices;
	}
	
	
	
	public void conectarVertices(String rotuloVerticeInicial, String rotuloVerticeFinal) throws Exception {
		
		if (!isExisteVertice(rotuloVerticeInicial) || !isExisteVertice(rotuloVerticeFinal)) {
			throw new Exception("Para adicionar uma aresta ambos os vertices devem existir. ");
		}
		
		// matriz criado e inicalizada
		this.criarMatrizAdjacencia();
		int indiceVerticeIncial = this.rotulosEmIndices.get(rotuloVerticeInicial);
		int IndiceVerticeFinal = this.rotulosEmIndices.get(rotuloVerticeFinal);
		
		this.matrizAdjacencia.adicionarAresta(indiceVerticeIncial, IndiceVerticeFinal);
	}
	
	
	private void criarMatrizAdjacencia() {
		if (this.matrizAdjacencia == null) {
			this.matrizAdjacencia = new MatrizAdjacencia(new ArrayList<Vertice>(this.vertices));
		}
	}
	
	
	private boolean isExisteVertice(String rotuloVertice) {
		int indice = this.rotulosEmIndices.get(rotuloVertice);
		boolean isVerticeAusente = this.vertices.get(indice) != null ? true : false;
		
		
		return isVerticeAusente;
	}
	
	
	public Vertice getVertice(String rotulo) {
		this.isExisteVertice(rotulo);
		int indice = this.rotulosEmIndices.get(rotulo);
		return this.vertices.get(indice);
	}
	
	public List<Vertice> getGrafoAdjacencias(String vertice){
		int indiceVertice = this.rotulosEmIndices.get(vertice);
		
		return this.matrizAdjacencia.getAdjacencias(indiceVertice);
	}
	
	
}
