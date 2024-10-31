package co.banco.mio.bancomio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import co.banco.mio.bancomio.domain.Card;

@Repository
public interface CardRepository extends JpaRepository<Card, Integer> {

}