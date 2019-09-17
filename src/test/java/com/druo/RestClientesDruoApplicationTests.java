package com.druo;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.druo.model.entity.Cliente;
import com.druo.model.services.IClienteService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RestClientesDruoApplicationTests {
	@Autowired
	IClienteService clienteService;
	
	@Test
	public void validarGeneracionId() {
		Cliente cliente=new Cliente("nuevo","123","nuevo@druo.com");
		cliente=clienteService.guardarCliente(cliente);
		Assert.assertTrue(cliente.getId()!=0);
	}
	@Test
	public void conClientes() {
		Cliente cliente=new Cliente("nuevo","123","nuevo@druo.com");
		cliente=clienteService.guardarCliente(cliente);
		Assert.assertTrue(!clienteService.findAll().isEmpty());
	}
	@Test
	public void validarnombreGuardado() {
		String nombreEnviado="Sergio";
		Cliente cliente=new Cliente("Sergio","123","nuevo@druo.com");
		cliente=clienteService.guardarCliente(cliente);
		Assert.assertEquals(nombreEnviado, cliente.getName());
	}
	@Test
	public void clienteNuloExcepcion() {
		
		Cliente cliente=null;
		try
		{
			cliente=clienteService.guardarCliente(cliente);
			Assert.fail();
		}catch(Exception e) {
			Assert.assertNull(cliente);
		}
		
		
	}

}
