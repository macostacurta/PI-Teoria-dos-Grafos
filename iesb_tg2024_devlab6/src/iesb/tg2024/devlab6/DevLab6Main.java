package iesb.tg2024.devlab6;

public class DevLab6Main {

	public static void main(String[] args) {
		
		//gerar um grafo do tipo G = (V,E)

		Grafo grafo = new Grafo(9);
		try {
			grafo.adicionarVertices("DF");
			grafo.adicionarVertices("CR");
			grafo.adicionarVertices("CT");
			grafo.adicionarVertices("UA");
			grafo.adicionarVertices("UB");
			grafo.adicionarVertices("RP");
			grafo.adicionarVertices("SC");
			grafo.adicionarVertices("LM");
			grafo.adicionarVertices("CP");
			
			System.out.println(">> O G(V,E) possui os seguintes vertices: \n");
			for (Vertice vertice : grafo.getVertices()) {
				System.out.println("- vertices: "+ vertice.getRotulo());
			}
			
			grafo.conectarVertices("DF", "CR");
			grafo.conectarVertices("CR", "CT");
			grafo.conectarVertices("CT", "UA");
			grafo.conectarVertices("UA", "UB");
			
			System.out.println(">> Grau do vertice DF: " + grafo.getVertice("DF").getGrau());
			
			System.out.println(">> O vertice DF possui as seguintes Adjacencias: ");
			for(Vertice vertice : grafo.getGrafoAdjacencias("DF")) {
				System.out.println(vertice.getRotulo() + "");
			}
			
		}catch(Exception e){
			System.err.println(e);
		}
		
	}

}
