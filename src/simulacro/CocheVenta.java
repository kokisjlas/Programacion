package simulacro;

public class CocheVenta extends Coche {
	private boolean vendido;

	public CocheVenta(String matricula, String modelo, int annoMatriculacion, int precioVenta) {
		super(matricula, modelo, annoMatriculacion, precioVenta);
		this.vendido = false;
	}

	public boolean isVendido() {
		return vendido;
	}

	public void setVendido(boolean vendido) {
		this.vendido = vendido;
	}

	@Override
	public String toString() {
		return super.toString() + "CocheVenta [vendido=" + vendido + "]";
	}

}
