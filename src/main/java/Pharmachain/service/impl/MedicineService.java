package Pharmachain.service.impl;

import Pharmachain.entity.Medicine;
import java.util.List;

public interface MedicineService {
    Medicine saveMedicine(Medicine medicine);
    List<Medicine> getAllMedicines();
    List<Medicine> getActiveMedicines();
    Medicine getMedicineById(Long id);
    void updateStock(Long id, int quantity);
    void deleteMedicine(Long id);
}