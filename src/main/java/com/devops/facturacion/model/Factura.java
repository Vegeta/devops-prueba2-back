package com.devops.facturacion.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "factura")
@Getter
@Setter
public class Factura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    // id: number = 0;
    //  invoiceDate: Date;
    //  biller: string = "";
    //  amount: number = 0;
    //  description: string = "";

    private String invoiceDate;
    private String biller;
    @Column(name = "amount", length = 10, precision = 2)
    private Double amount;

    private String descripcion;

    public Factura() {
    }

    public Factura(long id, String invoiceDate, String biller, Double amount, String descripcion) {
        this.id = id;
        this.invoiceDate = invoiceDate;
        this.biller = biller;
        this.amount = amount;
        this.descripcion = descripcion;
    }
}
