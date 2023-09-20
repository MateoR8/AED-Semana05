package semana_05;

public class ArregloSueldos {

	private double sueldo[] = { 2400.5, 800.4, 1500.2, 1000.3, 4700.1, 600.0,
			3300.8, 2600.6, 5100.9, 2000.7 };

	public int tamanio() {
		return sueldo.length;
	}

	public double obtener(int i) {
		return sueldo[i];
	}

	public double sueldoPromedio() {

		double suma = 0;

		for (int i = 0; i < tamanio(); i++) {
			suma += sueldo[i];
		}

		return suma / tamanio();
	}

	public double sueldoMayor() {

		double mayor = 0;

		for (int i = 0; i < tamanio(); i++) {
			if (mayor < sueldo[i]) {
				mayor = sueldo[i];
			}
		}
		return mayor;
	}

	public double sueldoMenor() {

		double menor = sueldo[0];

		for (int i = 1; i < tamanio(); i++) {
			if (menor > sueldo[i]) {
				menor = sueldo[i];
			}
		}
		return menor;
	}

	public int cantMayoresSueldoPromedio() {

		int contador = 0;

		for (int i = 0; i < tamanio(); i++) {

			if (sueldo[i] >= sueldoPromedio()) {
				contador++;
			}
		}

		return contador;
	}

	public int cantMenoresSueldoPromedio() {

		int contador = 0;

		for (int i = 0; i < tamanio(); i++) {

			if (sueldo[i] < sueldoPromedio()) {
				contador++;
			}
		}

		return contador;
	}

	public int posSegundoSueldoMayorAlMinimo() {
		int cont = 0;
		for (int i = 0; i < tamanio(); i++) {
			if (sueldo[i] > 850) {
				cont++;
			}
			if (cont == 2) {
				return i;
			}
		}
		return -1;
	}

	public int posUltimoSueldoMenorAlMinimo() {

		for (int i = tamanio() - 1; i >= 0; i--) {

			if (sueldo[i] < 850.0) {
				return i;
			}
		}
		return -1;
	}
	public void generarSueldos(){
		for(int i=tamanio()-1; i>=0;i--){ 
			sueldo[i] = aleatorio(799.9, 4999.9);
		}
	}
	private double aleatorio(double min, double max) {
		 return (double)((max - min + 1) * Math.random()) + min;
		}

}