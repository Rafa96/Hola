
public class Jarra {

	private int capacidad;
	private int cantidad;
	private static int totalAguaConsumida=0;
	

	public Jarra(int capacidadNueva) throws JarraException {
		setCapacidad(capacidadNueva);
		this.cantidad=0;
	}


	public int getCapacidad() {
		return capacidad;
	}

	private void setCapacidad(int capacidad) throws JarraException {
		if (capacidad <=0)
			throw new JarraException("No se puede crear la jarra con esa capacidad");
		this.capacidad = capacidad;
	}

	public int getCantidad() {
		return cantidad;
	}

	

	public static int getTotalAguaConsumida() {
		return totalAguaConsumida;
	}

	

	

	public void llenarJarra() throws JarraException {

		int aguaConsumida;
		
		if (cantidad == capacidad) {
			throw new JarraException("Error, no se puede llenar por que ya esta llena");
		} 

		aguaConsumida = capacidad - cantidad;
		totalAguaConsumida=totalAguaConsumida+aguaConsumida;
		cantidad=capacidad;

	}

	public void vaciarJarra() throws JarraException {

		if (cantidad == 0) {
			throw new JarraException("Error, La jarra ya se encuentra vacia");
		} 
		
		this.cantidad = 0;
		

	}
	/**
	 * La jarra this se vuelca en la jarra otro
	 * @param otro jarra sobre la que se volcará
	 * @throws JarraException
	 */
	public void volcarJarra(Jarra otro) throws JarraException{
		
		int cantidadLibreOtro;
		
		if(otro.cantidad==otro.capacidad){
			throw new JarraException("Error, No se puede volcar la jarra por que ya se encuentra llena");
		}
	
		if(this.cantidad==0){
			throw new JarraException("Error, no se puede volcar la jarra por que se encuentra vacia");
		}
		
		cantidadLibreOtro=otro.capacidad-otro.cantidad;
		
		if(this.cantidad<= cantidadLibreOtro){ // la jarra se vuelca completa
			
			otro.cantidad=otro.cantidad+this.cantidad;
			this.cantidad=0;
			
		}else{ //la jarra no se vuelca completa, no cabe
			
			this.cantidad=this.cantidad-cantidadLibreOtro;
			otro.cantidad=otro.capacidad;
		}
		
	}
	
	public String toString(){
		String informacion;
		informacion= "Jarra con capacidad " + capacidad + 
		
				" y con " + cantidad + " cantidad de agua";
		
		return informacion;
		
	}
	
	public boolean equals(Jarra otra){
		boolean iguales=false;
		
		if ( this.capacidad== otra.capacidad){
			iguales=true;
		}
		
		return iguales;
	}
	
	
	
	
	
	
	
	
	
	

}
