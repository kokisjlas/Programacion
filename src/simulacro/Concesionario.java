package simulacro;

import java.util.ArrayList;
import java.util.TreeMap;

public class Concesionario {

	private ArrayList<Coche> listaCoches = new ArrayList<Coche>();

	private TreeMap<String, Cliente> listaClientes = new TreeMap<String, Cliente>();

	public Concesionario(ArrayList listaCoches, TreeMap listaClientes) {
		this.listaCoches = listaCoches;
		this.listaClientes = listaClientes;
	}

	public ArrayList<Coche> getListaCoches() {
		return listaCoches;
	}

	public void setListaCoches(ArrayList<Coche> listaCoches) {
		this.listaCoches = listaCoches;
	}

	public TreeMap<String, Cliente> getListaClientes() {
		return listaClientes;
	}

	public void setListaClientes(TreeMap<String, Cliente> listaClientes) {
		this.listaClientes = listaClientes;
	}

	public void comprarCoche(String matricula) {
		CocheVenta c = buscarCocheVenta(matricula);
		c.setVendido(true);
		System.out.println("Coche vendido");

	}

	public CocheAlquiler buscarCocheAlquiler(String matricula) {
		for (Coche c : listaCoches) {
			if (c.getMatricula().equals(matricula)) {
				if (c instanceof CocheAlquiler) {
					CocheAlquiler cochealquiler = (CocheAlquiler) c;
					System.out.println("Coche para alquilar encontrado");
					return cochealquiler;
				} else {
					System.out.println("El Coche no es para ALQUILAR");
				}
			}
		}
		return null;
	}

	public CocheVenta buscarCocheVenta(String matricula) {
		for (Coche c : listaCoches) {
			if (c.getMatricula().equals(matricula)) {
				if (c instanceof CocheVenta) {
					CocheVenta cocheventa = (CocheVenta) c;
					return cocheventa;
				} else {
					System.out.println("El Coche no es para VENDER");
				}
			}
		}
		return null;
	}

	public void alquilarCoche(String matricula, Cliente cliente, int numDias) {
		CocheAlquiler c = buscarCocheAlquiler(matricula);
		if (c != null) {

			if (c.getCliente() != null) {
				c.alquilar(cliente, numDias);
				System.out.println("Cliente añadido a la cola de espera");
			} else {
				c.setCliente(cliente);
				c.setNumDias(numDias);
				System.out.println("Alquiler Exitoso");
			}
		}

	}

	public Cliente buscarClientePorDNI(String dni) {

		Cliente cliente = listaClientes.get(dni);

		System.out.println("Cliente encontrado");

		return cliente;

	}

	public Cliente altaCliente(String dni, String nombre) {

		Cliente nuevocliente = new Cliente(dni, nombre);
		listaClientes.put(nombre, nuevocliente);
		System.out.println("Cliente dado de alta");
		return nuevocliente;

	}


	@Override
	public String toString() {
		return "Concesionario [listaCoches=" + listaCoches + ", listaClientes=" + listaClientes + "]";
	}

}
