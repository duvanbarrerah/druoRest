package com.druo.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.druo.model.entity.Cliente;
import com.druo.model.services.IClienteService;



@RestController
@RequestMapping("/cliente")
public class ClienteController 
{
	@Autowired
	private IClienteService clienteService;
	
	@GetMapping()
	public ResponseEntity<?> listaClientes()
	{
		List<Cliente> listaClientes = null;
		try
		{
			listaClientes = clienteService.findAll();
			if(listaClientes.isEmpty() || listaClientes == null)
				listaClientes=new ArrayList<Cliente>();
			return new ResponseEntity<List<Cliente>>(listaClientes, HttpStatus.OK);
			
		}
		catch(DataAccessException e)
		{
			return new ResponseEntity<String>("Error interno en la base de datos", HttpStatus.CONFLICT);
		}
		catch(Exception e)
		{
			return new ResponseEntity<String>("Error interno en el servidor", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@PostMapping()
	public ResponseEntity<?> crearCliente(@RequestBody Cliente cliente)
	{
		try
		{
			return new ResponseEntity<Cliente>(clienteService.guardarCliente(cliente),HttpStatus.OK);
		}catch(DataAccessException e)
		{
			return new ResponseEntity<String>("Error interno en la base de datos", HttpStatus.CONFLICT);
		}catch(Exception e)
		{
			return new ResponseEntity<String>("Error interno en el servidor "+ e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
