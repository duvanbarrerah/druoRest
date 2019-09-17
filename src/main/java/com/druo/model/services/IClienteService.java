package com.druo.model.services;

import java.util.List;

import com.druo.model.entity.Cliente;

public interface IClienteService 
{
	public List<Cliente> findAll();
	public Cliente guardarCliente(Cliente cliente);
}
