package com.csid.justread.address.infrastructure;

import com.csid.justread.address.infrastructure.dao.AddressDao;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;

@Service
@Transactional
public class AddressRepository {

    public AddressRepository( AddressDao addressDao ) { this.addressDao = addressDao; }
    private final AddressDao addressDao;

}
