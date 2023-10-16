package binarios05Facade;

public class Consumidor {
	public static void main(String[] args) {
		Cliente cliente=new Cliente(1, "javierito", true, 12.5f);
		Articulo art=new Articulo(3,"brocha");
		Fachada fachada=new Fachada();
		fachada.graba(cliente);
		fachada.graba(art);
		
	}
}
