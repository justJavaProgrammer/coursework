package edu.odeyalo.college.coursework.service.storage.impl;

import edu.odeyalo.college.coursework.entity.StudentCard;
import edu.odeyalo.college.coursework.entity.address.Address;
import edu.odeyalo.college.coursework.exception.StudentCardNotFoundException;
import edu.odeyalo.college.coursework.repository.StudentCardRepository;
import edu.odeyalo.college.coursework.service.storage.AddressService;
import edu.odeyalo.college.coursework.service.storage.StudentCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RepositoryStudentCardService implements StudentCardService {

    private final StudentCardRepository studentCardRepository;
    private final AddressService addressService;

    @Autowired
    public RepositoryStudentCardService(StudentCardRepository studentCardRepository, AddressService addressService) {
        this.studentCardRepository = studentCardRepository;
        this.addressService = addressService;
    }

    @Override
    public StudentCard getStudentCardById(Long id) throws StudentCardNotFoundException {
        return studentCardRepository.findById(id)
                .orElseThrow(() -> new StudentCardNotFoundException("Student card not found for id: " + id));
    }

    @Override
    public List<StudentCard> getAllStudentCards() {
        return studentCardRepository.findAll();
    }

    @Override
    public StudentCard createStudentCard(StudentCard studentCard) {
        Address parentsAddress = studentCard.getParentsAddress();
        addressService.saveAddress(parentsAddress);
        return studentCardRepository.save(studentCard);
    }

    @Override
    public void updateStudentCard(StudentCard studentCard) throws StudentCardNotFoundException {
        Long id = studentCard.getId();
        Optional<StudentCard> studentCardOptional = studentCardRepository.findById(id);
        if (studentCardOptional.isEmpty()) {
            throw new StudentCardNotFoundException("Student card not found for id: " + id);
        }
        studentCard.setId(id);
        studentCardRepository.save(studentCard);
    }

    @Override
    public void deleteStudentCard(Long id) {
        studentCardRepository.deleteById(id);
    }
}
