package com.market.server.dao;

import com.market.server.model.Magazine;

import java.util.List;

public interface MagazineDao {

    Magazine getMagazineById(Long id);
    List<Magazine> getAllMagazines();
    void saveMagazine(Magazine magazine);
    void deleteMagazine(Long id);
}
