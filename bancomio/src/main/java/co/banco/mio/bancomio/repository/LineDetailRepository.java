package co.banco.mio.bancomio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LineDetailRepository extends JpaRepository<LineDetailRepository, Integer> {

}
