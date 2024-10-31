package co.banco.mio.bancomio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.banco.mio.bancomio.domain.Aplication;

@Repository
public interface AplicationRepository extends JpaRepository<Aplication, Integer> {

}
