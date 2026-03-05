// 1. Inventory Load Function
function loadInventory() {
    fetch("/api/inventory/batch?page=0&size=10") // Azure path fix
        .then(res => res.json())
        .then(data => {
            let html = "";
            data.content.forEach(b => {
                // Expiry Check Logic
                let d = daysLeft(b.expiryDate);
                let expiryClass = "";
                if (d <= 30) expiryClass = "expiry-red";
                else if (d <= 60) expiryClass = "expiry-orange";

                // Stock Check Logic
                let stockClass = "";
                if (b.quantity < 10) stockClass = "stock-urgent";
                else if (b.quantity < 20) stockClass = "stock-low";

                html += `
                  <tr class="${expiryClass} ${stockClass}">
                    <td>${b.id}</td>
                    <td>${b.medicineName}</td>
                    <td>${b.batchNumber}</td>
                    <td>${b.quantity}</td>
                    <td>${b.expiryDate}</td>
                    <td>${b.purchasePrice}</td>
                    <td>${b.sellingPrice}</td>
                  </tr>`;
            });
            document.getElementById("data").innerHTML = html;
        });
}

// 2. Add Inventory Function
function addInventory(event) {
    event.preventDefault();
    const payload = {
        medicineId: document.getElementById("medicineId").value,
        batchNumber: document.getElementById("batchNumber").value,
        quantity: document.getElementById("quantity").value,
        expiryDate: document.getElementById("expiryDate").value,
        purchasePrice: document.getElementById("purchasePrice").value,
        sellingPrice: document.getElementById("sellingPrice").value
    };

    fetch("/api/inventory/batch", { // Azure path fix
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(payload)
    })
    .then(res => res.json())
    .then(() => {
        event.target.reset();
        loadInventory();
    });
}


function loadMedicines() {
    fetch("/api/medicines")
        .then(res => res.json())
        .then(data => {
            let ddl = document.getElementById("medicineId");
            ddl.innerHTML = '<option value="">Select Medicine</option>';
            data.forEach(m => {
                ddl.innerHTML += `<option value="${m.id}">${m.name}</option>`;
            });
        });
}


loadInventory();
loadMedicines();

function daysLeft(expiryDate) {
    const today = new Date();
    const exp = new Date(expiryDate);
    return Math.ceil((exp - today) / (1000 * 60 * 60 * 24));
}