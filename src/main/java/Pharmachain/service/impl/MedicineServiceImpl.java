package Pharmachain.service.impl;

import Pharmachain.entity.Medicine;
import Pharmachain.repository.MedicineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class MedicineServiceImpl implements MedicineService {

    @Autowired
    private MedicineRepository medicineRepository;

    @Override
    public Medicine addMedicine(Medicine medicine) {
        return medicineRepository.save(medicine);
    }

    @Override
    public List<Medicine> getAllMedicines() {
        return medicineRepository.findAll();
    }

    @Override
    public Medicine getMedicineById(Long id) {
        return medicineRepository.findById(id).orElse(null);
    }

    @Override
    public Medicine updateMedicine(Long id, Medicine medicine) {
        Medicine existing = medicineRepository.findById(id).orElse(null);
        if (existing != null) {
            existing.setName(medicine.getName());
            existing.setCompany(medicine.getCompany());
            existing.setPrice(medicine.getPrice());
            existing.setQuantity(medicine.getQuantity());
            existing.setExpiryDate(medicine.getExpiryDate());
            return medicineRepository.save(existing);
        }
        return null;
    }

    @Override
    public void deleteMedicine(Long id) {
        medicineRepository.deleteById(id);
    }

    @Override
    public List<Medicine> getExpiredMedicines() {
        return medicineRepository.findByExpiryDateBefore(LocalDate.now());
    }

    @Override
    public List<Medicine> getExpiringSoonMedicines() {
        return medicineRepository.findByExpiryDateBetween(
                LocalDate.now(),
                LocalDate.now().plusDays(30)
        );
    }
}