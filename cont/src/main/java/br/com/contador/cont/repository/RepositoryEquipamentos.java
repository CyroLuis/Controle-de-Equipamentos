package br.com.contador.cont.repository;

import br.com.contador.cont.model.Equipamentos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryEquipamentos extends JpaRepository<Equipamentos,Long> {

}
