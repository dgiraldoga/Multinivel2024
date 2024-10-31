package co.banco.mio.bancomio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import co.banco.mio.bancomio.domain.CardUsage;

@Repository
public interface CardUsageRepository extends JpaRepository<CardUsage, Integer> {

}
