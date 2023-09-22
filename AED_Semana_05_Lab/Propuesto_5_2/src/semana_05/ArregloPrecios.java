package semana_05;

public class ArregloPrecios {
	
	private double precio[] = {240.5, 350.2, 80.4, 100.3, 470.1, 60.0, 330.8, 260.6, 510.9, 200.7};
	
	public int tamanio() {
		return precio.length;
	}
	
	public double obtener(int i) {
		return precio[i];
	}
	
	public double precioPromedio() {
		
		double suma = 0;
		
		for(int i=0; i<tamanio(); i++) {
			suma+=precio[i];
		}
		
		return suma/tamanio();
	}
	
	public double precioMayor() {
		
		double mayor = 0;
		
		for(int i=0; i<tamanio(); i++) {
			if(mayor < precio[i]) {
				mayor = precio[i];
			}
		}
		return mayor;
	}
	
	public double precioMenor() {
		
		double menor = precio[0];
		
		for(int i=1; i<tamanio(); i++) {
			if(menor > precio[i]) {
				menor = precio[i];
			}
		}
		return menor;
	}
	
	public int cantMayoresPrecioPromedio() {
		int contador = 0;
		
		for(int i=0; i<tamanio(); i++) {
			
			if(precio[i] >= precioPromedio()) {
				contador++;
			}
		}
		return contador;
	}
	
	public int cantMenoresPrecioPromedio() {
		int contador = 0;
		
		for(int i=0; i<tamanio(); i++) {
			
			if(precio[i] < precioPromedio()) {
				contador++;
			}
		}
		return contador;
	}
	
	public int posPrimerPrecioMayorAlSegundo() {
		
		for(int i=0; i<tamanio(); i++) {
			
			if(precio[i] > precio[1]) {
				return i;
			}
		}
		return -1;
	}
	
	public int posUltimoPrecioMenorAlPenultimo() {
		
		int penultima = tamanio()-2;
		
		for(int i= tamanio()-1; i>=0; i--) {
			
			if(precio[i] < precio[penultima]) {
				return i;
			}
		}
		return -1;
	}
	
	public void generarPrecios(){
		for(int i=tamanio()-1; i>=0;i--){ 
			precio[i] = aleatorio(99.9, 999.9);
		}
	}
	private double aleatorio(double min, double max) {
		 return (double)((max - min + 1) * Math.random()) + min;
		}
}