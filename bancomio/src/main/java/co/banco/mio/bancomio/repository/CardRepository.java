package co.banco.mio.bancomio.repository;

import co.banco.mio.bancomio.domain.Application;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import co.banco.mio.bancomio.domain.Card;

import java.util.List;

@Repository
public interface CardRepository extends JpaRepository<Card, Integer> {
    Boolean existsByApplicationAndSerialCardAndCardStatus(Application application, Integer serialCard, Character cardStatus);

    List <Card> findCardByApplication (Application application);

    void deleteCardByApplication (Application application);

}
