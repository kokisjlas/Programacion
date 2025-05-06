package simulacro;

import java.util.LinkedList;

public class CocheAlquiler extends Coche {
	private double precioXdia;
	private Cliente cliente;
	private int numDias;

	// COLA DE ESPERA
	LinkedList<Cliente> cola = new LinkedList<>();

	public CocheAlquiler(String matricula, String modelo, int annoMatriculacion, int precioVenta, double precioXdia) {
		super(matricula, modelo, annoMatriculacion, precioVenta);
		this.precioXdia = precioXdia;
		this.cliente = null;
		this.numDias = 0;

	}

	// METODO PARA AGREGAR A UN CLIENTE A LA COLA DE ESPERA
	public void alquilar(Cliente cliente, int numDias) {
		if (this.cliente != null) {
			cola.addFirst(cliente);
			System.out.println("Cliente :" + cliente + " añadido a la cola de espera");
			System.out.println("Primero en la cola: " + cola.getLast());
		} else {
			this.cliente=cliente;
			this.numDias=numDias;
		}
	}

	public void devolver() {
		if(cola.size()==0) {
			cliente=null;
		}else {
			cliente=cola.getLast();
		}
		
	}
	public double getPrecioXdia() {
		return precioXdia;
	}

	public void setPrecioXdia(double precioXdia) {
		this.precioXdia = precioXdia;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public int getNumDias() {
		return numDias;
	}

	public void setNumDias(int numDias) {
		this.numDias = numDias;
	}

	@Override
	public String toString() {
		return super.toString() + "CocheAlquiler [precioXdia=" + precioXdia + ", cliente=" + cliente + ", numDias="
				+ numDias + "]";
	}

}
