package com.devops.facturacion.controller;

import com.devops.facturacion.model.Factura;
import com.devops.facturacion.service.FacturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/facturas")
public class FacturasController {

	@Autowired
	private FacturaService facturaService;

	@PostMapping
	private ResponseEntity<Factura> guardar(@RequestBody Factura factura) {
		Factura factura2 = facturaService.guardar(factura);
		try {
			return ResponseEntity.created(new URI("/api/facturas" + factura2.getId())).body(factura2);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}

	@GetMapping
	private ResponseEntity<List<Factura>> lista() {
		return ResponseEntity.ok(facturaService.listaFacturas());

	}

	@DeleteMapping(value = "{id}")
	private ResponseEntity<Void> eliminarPorId(@PathVariable("id") Long id) {
		Factura p = facturaService.buscarId(id);
		facturaService.eliminar(p);
		return ResponseEntity.ok().build();
	}

	@GetMapping(value = "{id}")
	private ResponseEntity<Factura> buscarId(@PathVariable("id") Long id) {
		return ResponseEntity.ok(facturaService.buscarId(id));

	}

	@PutMapping(value = "{id}")
	public Factura editar(@PathVariable("id") Long id, @RequestBody Factura factura) {
		factura.setId(id);
		return facturaService.guardar(factura);
	}

}
