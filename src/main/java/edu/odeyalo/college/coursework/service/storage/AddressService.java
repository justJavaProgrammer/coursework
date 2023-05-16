package edu.odeyalo.college.coursework.service.storage;

import edu.odeyalo.college.coursework.entity.address.Address;
import edu.odeyalo.college.coursework.exception.AddressNotFoundException;

import java.util.List;

/**
 * Wrap the calls to DB and provide custom exception throwing
 */
public interface AddressService {


    Address getAddressById(Long id) throws AddressNotFoundException;

    List<Address> getAllAddresses();

    void saveAddress(Address address);

    void updateAddress(Address address) throws AddressNotFoundException;

    void deleteAddress(Long id) throws AddressNotFoundException;
}
