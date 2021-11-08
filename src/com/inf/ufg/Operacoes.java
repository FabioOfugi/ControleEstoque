package com.inf.ufg;

public interface Operacoes<T>{
	void inserir(T object);
	void alterar(T object, int index);
	void excluir(T object);
}
