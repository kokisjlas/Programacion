package simulacro;

public class Coche {
	private String matricula;
	private String modelo;
	private int annoMatriculacion;
	private int precioVenta;
	private boolean estado;

	public Coche(String matricula, String modelo, int annoMatriculacion, int precioVenta) {
		this.matricula = matricula;
		this.modelo = modelo;
		this.annoMatriculacion = annoMatriculacion;
		this.precioVenta = precioVenta;
		this.estado=true;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public int getAnnoMatriculacion() {
		return annoMatriculacion;
	}

	public void setAnnoMatriculacion(int annoMatriculacion) {
		this.annoMatriculacion = annoMatriculacion;
	}

	public int getPrecioVenta() {
		return precioVenta;
	}

	public void setPrecioVenta(int precioVenta) {
		this.precioVenta = precioVenta;
	}

	@Override
	public String toString() {
		return "Coche [matricula=" + matricula + ", modelo=" + modelo + ", annoMatriculacion=" + annoMatriculacion
				+ ", precioVenta=" + precioVenta + "]";
	}
	

}
