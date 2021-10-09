package testesUnitarios;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import controller.DadosController;

class dadosControllerTeste {
	DadosController d = new DadosController();
	String[] pastelInfo = {"0", "20", "Pastel de queijo", "4.50", "queijo e massa", "false"};
	String[] pastelInfo1 = {"Pastel de queijo", "queijo e massa"};
	int pos;
	@Test
	void testEditAddPastel() {
		assertTrue(d.editAddPastel(pastelInfo));
		pastelInfo = null;
		assertFalse(d.editAddPastel(pastelInfo1));
	}

	@Test
	void testDeletePastel() {
		pos = 1;
		assertTrue(d.deletePastel(pos));
		pos = -1;
		assertFalse(d.deletePastel(pos));
	}
	
	@Test
	void testDeletePedido() {
		pos = 1;
		assertTrue(d.deletePastel(pos));
		pos = -1;
		assertFalse(d.deletePastel(pos));
	}

}
