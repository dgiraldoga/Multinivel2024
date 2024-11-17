package co.banco.mio.bancomio.repository;

import co.banco.mio.bancomio.domain.Application;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import co.banco.mio.bancomio.domain.Card;

import java.util.List;

@Repository
public interface CardRepository extends JpaRepository<Card, Integer> {
    Boolean existsBySerialCardAndCardStatusAndApplication(int serialCard, char cardStatus, Application application);

    List <Card> findCardByApplication (Application application);
}
