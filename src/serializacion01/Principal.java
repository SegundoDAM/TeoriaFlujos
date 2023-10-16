package serializacion01;


public class Principal {
	public static void main(String[] args) {
		Cliente federico=new Cliente(10, "fede", true, 34f);
		Cliente current=null;
		Almacen almacen=new Almacen("fede.data");
		if(almacen.isEstado()){
//			almacen.almacena(federico);
			current=(Cliente) almacen.recuperar();
			System.out.println(current.getNombre());
			System.out.println(current.vivo);
		}
	}
}
