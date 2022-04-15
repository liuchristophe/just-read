package com.csid.justread.address.service;

import com.csid.justread.address.infrastructure.dao.AddressDao;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class AddressService {

    private final AddressDao addressDao;

    public AddressService( AddressDao addressDao ) { this.addressDao = addressDao; }

}