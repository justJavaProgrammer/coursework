package edu.odeyalo.college.coursework.service.storage.impl;

import edu.odeyalo.college.coursework.entity.address.Address;
import edu.odeyalo.college.coursework.exception.AddressNotFoundException;
import edu.odeyalo.college.coursework.repository.AddressRepository;
import edu.odeyalo.college.coursework.service.storage.AddressService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RepositoryAddressService implements AddressService {
    private final AddressRepository addressRepository;

    public RepositoryAddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Override
    public Address getAddressById(Long id) throws AddressNotFoundException {
        return addressRepository.findById(id)
                .orElseThrow(() -> new AddressNotFoundException("Address not found for id: " + id));
    }

    @Override
    public List<Address> getAllAddresses() {
        return addressRepository.findAll();
    }

    @Override
    public void saveAddress(Address address) {
        addressRepository.save(address);
    }

    @Override
    public void updateAddress(Address address) throws AddressNotFoundException {
        if (!addressRepository.existsById(address.getId())) {
            throw new AddressNotFoundException("Address not found for id: " + address.getId());
        }
        addressRepository.save(address);
    }

    @Override
    public void deleteAddress(Long id) throws AddressNotFoundException {
        if (!addressRepository.existsById(id)) {
            throw new AddressNotFoundException("Address not found for id: " + id);
        }
        addressRepository.deleteById(id);
    }
}

