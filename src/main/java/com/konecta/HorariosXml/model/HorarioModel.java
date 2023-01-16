
package com.konecta.HorariosXml.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author yeison
 */

@Entity
@Table(name = "clientes")
@Getter
@Setter
public class HorarioModel {
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String cliente;
    private String servidor;
    private String ruta;
    
    
}
