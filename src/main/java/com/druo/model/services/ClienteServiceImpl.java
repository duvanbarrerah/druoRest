package com.druo.model.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.druo.model.entity.Cliente;
import com.druo.model.repository.IClienteRepository;

@Service
public class ClienteServiceImpl implements IClienteService
{
	@Autowired
	private IClienteRepository clienteRepository;
	
	/**
	 * Busca todos los clientes guardados en la base de datos
	 * @return Lista con los clientes de la base de datos
	 * @autor duvan barrera
	 */
	public List<Cliente> findAll() 
	{
		return (List<Cliente>) clienteRepository.findAll();
	}
	/**
	 * Guarda el cliente enviado 
	 * @param Cliente cliente a guardar o actualizar
	 * @author Duvan Barrera
	 */
	public Cliente guardarCliente(Cliente cliente) {
		return clienteRepository.save(cliente);
	}
}
