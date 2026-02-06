package Pharmachain.service.impl;

import Pharmachain.entity.Medicine;
import java.util.List;

public interface MedicineService {

    Medicine addMedicine(Medicine medicine);

    List<Medicine> getAllMedicines();

    Medicine getMedicineById(Long id);

    Medicine updateMedicine(Long id, Medicine medicine);

    void deleteMedicine(Long id);

    List<Medicine> getExpiredMedicines();

    List<Medicine> getExpiringSoonMedicines();
}