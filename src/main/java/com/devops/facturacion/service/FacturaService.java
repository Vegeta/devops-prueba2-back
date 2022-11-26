package com.devops.facturacion.service;


import com.devops.facturacion.model.Factura;
import com.devops.facturacion.repository.FacturasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacturaService {
    @Autowired
    private FacturasRepository personaRepository;

    public Factura guardar(Factura factura){
        return personaRepository.save(factura);
    }

    public List<Factura> listaFacturas(){
        return personaRepository.findAll();
    }

    public void eliminar(Factura factura){
        personaRepository.delete(factura);
    }


    public Factura buscarId(Long id){
        return personaRepository.findById(id).get();
    }
}
