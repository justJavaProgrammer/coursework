package edu.odeyalo.college.coursework.service.storage.impl;

import edu.odeyalo.college.coursework.entity.Dormitory;
import edu.odeyalo.college.coursework.exception.DormitoryNotFoundException;
import edu.odeyalo.college.coursework.repository.DormitoryRepository;
import edu.odeyalo.college.coursework.service.storage.AddressService;
import edu.odeyalo.college.coursework.service.storage.DormitoryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RepositoryDormitoryService implements DormitoryService {

    private final DormitoryRepository dormitoryRepository;
    private final AddressService addressService;

    public RepositoryDormitoryService(DormitoryRepository dormitoryRepository, AddressService addressService) {
        this.dormitoryRepository = dormitoryRepository;
        this.addressService = addressService;
    }

    @Override
    public Dormitory getDormitoryById(Long id) throws DormitoryNotFoundException {
        return dormitoryRepository.findById(id).orElseThrow(
                () -> new DormitoryNotFoundException("Dormitory not found for id: " + id)
        );
    }

    @Override
    public List<Dormitory> getAllDormitories() {
        return dormitoryRepository.findAll();
    }

    @Override
    public void saveDormitory(Dormitory dormitory) {
        addressService.saveAddress(dormitory.getAddress());
        dormitoryRepository.save(dormitory);
    }

    @Override
    public void updateDormitory(Dormitory dormitory) throws DormitoryNotFoundException {
        Long id = dormitory.getId();
        Optional<Dormitory> optional = dormitoryRepository.findById(id);

        if (optional.isEmpty()) {
            throw new DormitoryNotFoundException("Dormitory with id: " + id + " not found");
        }
        dormitoryRepository.save(dormitory);
    }

    @Override
    public void deleteDormitory(Long id) throws DormitoryNotFoundException {
        Dormitory dormitory = getDormitoryById(id);
        dormitoryRepository.delete(dormitory);
    }
}

