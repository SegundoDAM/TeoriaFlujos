package binarios05Facade;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class FachadaTest {

	@Test
	void test() {
		Fachada fachada=new Fachada();
		Cliente cliente=new Cliente(1, "luis", true,0f);
		fachada.graba(cliente);
	}

}
