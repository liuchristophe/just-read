package com.csid.justread.address.api;

import com.csid.justread.address.service.AddressService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/api/address")
public class AddressController {

    private final AddressService addressService;
    public AddressController ( AddressService addressService) {
        this.addressService = addressService;
    }

}
