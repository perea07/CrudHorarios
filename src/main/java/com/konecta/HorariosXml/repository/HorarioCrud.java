package com.konecta.HorariosXml.repository;

import com.konecta.HorariosXml.model.HorarioModel;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

/**
 *
 * @author yeison
 */
public interface HorarioCrud extends JpaRepositoryImplementation<HorarioModel, Long> {

    @Query(value = "SELECT * FROM clientes WHERE id = 1", nativeQuery = true)
    List<HorarioModel> buscarCliente();

    //Querys personalizados
    @Query(value = "SELECT u.id, u.cliente FROM clientes u", nativeQuery = true)
    List<String> clientesAll();
    
     //Querys personalizados
    @Query(value = "SELECT u.ruta, u.servidor FROM clientes u WHERE u.id = ?", nativeQuery = true)
    List<String> clientRoute(String id);
}
