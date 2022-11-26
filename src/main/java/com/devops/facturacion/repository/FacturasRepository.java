package com.devops.facturacion.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devops.facturacion.model.Factura;

public interface FacturasRepository extends JpaRepository<Factura, Long>{
    
}
