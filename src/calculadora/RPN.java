package calculadora;

public class RPN {
	private String commando;
	private NodoPila arriba;
	
	public void pushPila(double nuevo_dato) {
		NodoPila nuevo_nodo = new NodoPila(nuevo_dato, arriba);
		arriba = nuevo_nodo;
	}
	public double popPila( ) {
		double dato_arriba = arriba.dato;
		arriba = arriba.abajo;
		return dato_arriba;
	}
	public RPN(String commando) {
		arriba = null;
		this.commando = commando;
	}
	//Refac_2 Extraer operaciones en metodos
	public void suma() {
		double b = popPila( );
		double a = popPila( );
		pushPila(a + b);
	}
	public void resta() {
		double b = popPila( );
		double a = popPila( );
		pushPila(a - b);
	}
	public void multi() {
		double b = popPila( );
		double a = popPila( );
		pushPila(a * b);
	}
	public void divi() {
		double b = popPila( );
		double a = popPila( );
		pushPila(a / b);
	}
	public void expo() {
		double b = popPila( );
		double a = popPila( );
		pushPila(Math.pow(a, b));
	}
	public void per() {
		double b = popPila( );
		double a = popPila( );
		pushPila(a%b);;
	}
	public double resultado( ) {
		double a, b;
		int j;
		for(int i = 0; i < commando.length(); i++) {
			// si es un digito
			if(Character.isDigit(commando.charAt(i))) {
				double numero;
				// obtener un string a partir del numero
				String temp = "";
				for(j = 0; (j < 100) && (Character.isDigit(
						commando.charAt(i)) || (commando.charAt(i) == '.')); j++, i++) {
					temp = temp + String.valueOf(commando.
							charAt(i));
				}
				// convertir a double y añadir a la pila
				numero = Double.parseDouble(temp);
				pushPila(numero);
			} else if(commando.charAt(i) == '+') {
				suma();
			} else if(commando.charAt(i) == '-') {
				resta();
			} else if(commando.charAt(i) == '*') {
				multi();
			} else if(commando.charAt(i) == '/') {
				divi();
			}else if(commando.charAt(i) == '^') {
				expo();
			}else if(commando.charAt(i) == '%') {
				per();
			} else if(commando.charAt(i) != ' ') {
				throw new IllegalArgumentException( );
			}
		}
		double val = popPila( );
		if(arriba != null) {
			throw new IllegalArgumentException( );
		}
		return val;
	}
	
}