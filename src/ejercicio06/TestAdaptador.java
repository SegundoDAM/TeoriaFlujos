package ejercicio06;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;

import org.junit.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestAdaptador {
	String articulosPath = "articulos.dat", mapaPath = "mapa.dat";
	Articulo articulo;
	AdaptadorSerializadoMapeable<String, Articulo> adaptadorSerializadoMapeable ;
	
	@BeforeEach
	void Before() {
		articulo = new Articulo(3, "tornillo");
		adaptadorSerializadoMapeable = new AdaptadorSerializadoMapeable<>(
				articulosPath, mapaPath);
		adaptadorSerializadoMapeable.grabar(articulo);
	}
	
	@Test
	void test() {
		Articulo leer = adaptadorSerializadoMapeable.leer(articulo.getKey());
		assertEquals(articulo, leer);
	}
	@Test
	void testBorrar() {
		Articulo articuloDos = new Articulo(4, "tuerca");
		adaptadorSerializadoMapeable.grabar(articuloDos);
		Articulo leer = adaptadorSerializadoMapeable.leer(articulo.getKey());
		adaptadorSerializadoMapeable.borrar(leer.getKey());
		assertNull(adaptadorSerializadoMapeable.leer(leer.getKey()));
	}
	@AfterEach
	void after() {
		new File(articulosPath).delete();
		new File(mapaPath).delete();
	}

}
