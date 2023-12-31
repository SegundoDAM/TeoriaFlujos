package ejercicio06;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;

import org.junit.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestAdaptador {
	String articulosPath = "articulos.dat", mapaPath = "mapa.dat", posicionPath = "posicion.dat";
	Articulo articulo;
	AdaptadorSerializadoMapeable<String, Articulo> adaptadorSerializadoMapeable;

	@BeforeEach
	void Before() {
		articulo = new Articulo(3, "tornillo");
		adaptadorSerializadoMapeable = new AdaptadorSerializadoMapeable<>(articulosPath, mapaPath, posicionPath);
		adaptadorSerializadoMapeable.grabar(articulo);
	}

	@Test
	void test() {
		Articulo leer = adaptadorSerializadoMapeable.leer(articulo.getKey());
		assertEquals(articulo, leer);
	}

	@Test
	void testRepetido() {
		articulo = new Articulo(3, "tornillo");
		assertFalse(adaptadorSerializadoMapeable.grabar(articulo));
	}

	@Test
	void testBorrar() {
		Articulo articuloDos = new Articulo(4, "tuerca");
		adaptadorSerializadoMapeable.grabar(articuloDos);
		Articulo leer = adaptadorSerializadoMapeable.leer(articulo.getKey());
		adaptadorSerializadoMapeable.borrar(leer.getKey());
		assertNull(adaptadorSerializadoMapeable.leer(leer.getKey()));
	}

	@Test
	void testBorrarDos() {
		Articulo articuloDos = new Articulo(4, "tuerca");
		adaptadorSerializadoMapeable.grabar(articuloDos);
		adaptadorSerializadoMapeable.borrar(articuloDos.getKey());
		assertNull(adaptadorSerializadoMapeable.leer(articuloDos.getKey()));
		Articulo articuloTres = new Articulo(5, "brida");
		adaptadorSerializadoMapeable.grabar(articuloTres);
		assertEquals(articuloTres, adaptadorSerializadoMapeable.leer(articuloTres.getKey()));
	}

	@Test
	void testBorrarTres() {
		Articulo articuloDos = new Articulo(4, "tuerca");
		adaptadorSerializadoMapeable.grabar(articuloDos);
		adaptadorSerializadoMapeable.borrar(articuloDos.getKey());
		adaptadorSerializadoMapeable = new AdaptadorSerializadoMapeable<>(articulosPath, mapaPath, posicionPath);
		assertNull(adaptadorSerializadoMapeable.leer(articuloDos.getKey()));
		Articulo articuloTres = new Articulo(5, "brida");
		adaptadorSerializadoMapeable.grabar(articuloTres);
		assertEquals(articuloTres, adaptadorSerializadoMapeable.leer(articuloTres.getKey()));
	}

	@AfterEach
	void after() {
		new File(articulosPath).delete();
		new File(mapaPath).delete();
		new File(posicionPath).delete();
	}

}
