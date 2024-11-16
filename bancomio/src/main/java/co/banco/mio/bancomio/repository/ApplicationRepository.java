package co.banco.mio.bancomio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.banco.mio.bancomio.domain.Application;

@Repository
public interface ApplicationRepository extends JpaRepository<Application, Integer>{

    Boolean existsByAppIdOrAppDscAndAppStatus(Integer appId, String AppDesc, Character appStatus);

}
