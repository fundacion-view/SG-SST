package org.fundacionview.SGSST.repositorios;

import java.util.Optional;

import org.fundacionview.SGSST.modelos.SalariosMinimos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioSalariosMinimos extends JpaRepository<SalariosMinimos, Integer>  {

    Optional<SalariosMinimos> findByValor(Integer valor);

}
