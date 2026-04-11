package Pharmachain.service.impl;

import Pharmachain.entity.Medicine;
import Pharmachain.repository.MedicineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class
MedicineServiceImpl implements MedicineService {

    @Autowired
    private MedicineRepository medicineRepository;

    @Override
    public Medicine saveMedicine(Medicine medicine) {
        return medicineRepository.save(medicine);
    }

    @Override
    public List<Medicine> getAllMedicines() {
        return medicineRepository.findAll();
    }

    @Override
    public List<Medicine> getActiveMedicines() {
        return medicineRepository.findByActiveTrue();
    }

    @Override
    public Medicine getMedicineById(Long id) {
        return medicineRepository.findById(id).orElse(null);
    }

    @Override
    public void updateStock(Long id, int quantity) {
        Medicine med = medicineRepository.findById(id).orElseThrow(() -> new RuntimeException("Medicine not found"));
        med.setQuantity(quantity);
        medicineRepository.save(med);
    }

    @Override
    public void deleteMedicine(Long id) {
        Medicine med = medicineRepository.findById(id).orElseThrow(() -> new RuntimeException("Medicine not found"));
        med.setActive(false); // Hard delete ki jagah soft delete (active = false) recommend hai
        medicineRepository.save(med);
    }
}