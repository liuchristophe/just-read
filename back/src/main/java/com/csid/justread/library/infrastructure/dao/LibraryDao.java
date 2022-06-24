package com.csid.justread.library.infrastructure.dao;

import com.csid.justread.library.infrastructure.entity.LibraryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface LibraryDao extends JpaRepository<LibraryEntity,UUID> {

    //(=ACOS(SIN(RADIANS(latitudeA))SIN(RADIANS(latitudeB))+COS(RADIANS(latitudeA))COS(RADIANS(latitude B))COS(RADIANS(longitude A-Longitude B)))6371
    @Query("select l from library l, address a where l.address = a and ACOS(SIN(RADIANS(?3))*SIN(RADIANS(a.latitude))+COS(RADIANS(?3))*COS(RADIANS(a.latitude))*COS(RADIANS(?2-a.longitude)))*6371<?1")
    List<LibraryEntity> getLibrariesNearby(double rayon, float longitude, float latitude);
}
