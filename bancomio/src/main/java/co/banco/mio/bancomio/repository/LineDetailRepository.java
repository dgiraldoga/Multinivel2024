package co.banco.mio.bancomio.repository;

import co.banco.mio.bancomio.domain.LineDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LineDetailRepository extends JpaRepository<LineDetail, Integer> {

}
