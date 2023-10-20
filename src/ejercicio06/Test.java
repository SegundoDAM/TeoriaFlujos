package ejercicio06;

import static org.junit.jupiter.api.Assertions.*;

class Test {

	@org.junit.jupiter.api.Test
	void test() {
		Articulo articulo=new Articulo(3, "tornillo");
		AdaptadorSerializadoMapeable<String, Articulo> adaptadorSerializadoMapeable=new AdaptadorSerializadoMapeable<>("articulos.dat", "mapa.dat");
	}

}
