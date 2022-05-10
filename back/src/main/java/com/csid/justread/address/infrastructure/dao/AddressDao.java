package com.csid.justread.address.infrastructure.dao;

import com.csid.justread.address.infrastructure.entity.AddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.UUID;

@Repository
public interface AddressDao extends JpaRepository<AddressEntity, UUID> {
}
