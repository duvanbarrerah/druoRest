package com.druo.model.repository;

import org.springframework.data.repository.CrudRepository;

import com.druo.model.entity.Cliente;

public interface IClienteRepository  extends CrudRepository<Cliente, Long> 
{

}
