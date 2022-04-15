package com.csid.justread.address.api;

import com.csid.justread.address.infrastructure.AddressRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/address")
public class AddressController {

    private final AddressRepository addressRepository;
    public AddressController ( AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

}
