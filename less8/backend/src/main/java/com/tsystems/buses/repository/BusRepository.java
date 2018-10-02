package com.tsystems.buses.repository;

import com.tsystems.buses.model.Bus;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
@Transactional
public interface BusRepository extends CrudRepository<Bus, Long> {

    @Query("select b from Bus b where b.bus_model = ?1")
    Bus getBusByModel(String bus_model);

}
