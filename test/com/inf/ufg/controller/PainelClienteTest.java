package com.inf.ufg.controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.inf.ufg.Principal;

class PainelClienteTest {

	@Test
	void testCriarCliente() {
		PainelCliente.createCliente();
		assertEquals(1, Principal.clientes.size());
	}

}
