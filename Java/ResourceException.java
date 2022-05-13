

public class ResourceException extends Exception{
	private int codiError;
	
	public ResourceException(int codiError) {
		super();
		this.codiError=codiError;
	}
	@Override
	public String getMessage() {
		if (this.codiError==1) {
			return "No dispones de suficientes recursos como para actualizar tu tecnologia de ataque";
		}
		else if (this.codiError==2) {
			return "No dispones de suficientes recursos como para actualizar tu tecnologia de defensa";
		}
		return "";
	}
}
