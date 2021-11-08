package com.inf.ufg.controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PainelFornecedorTest {

	@Test
	void testBuscaPosicaoNegativa() {
		int i = -80;
		int index = PainelFornecedor.buscaPosicao(i);
		assertEquals(-1, index);
	}

}
