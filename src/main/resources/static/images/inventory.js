async function initInventory() {
    const res = await fetch('/api/medicines/all'); // Backend endpoint check kar lena
    const data = await res.json();
    let html = '';
    data.forEach(m => {
        html += `<tr><td>${m.medicineName}</td><td>${m.batchNumber}</td><td>${m.expiryDate}</td>
                 <td>${m.quantity}</td><td>₹${m.price}</td></tr>`;
    });
    document.getElementById('inventoryTableBody').innerHTML = html;
}

async function saveMedicine() {
    const medData = {
        medicineName: document.getElementById('medName').value,
        batchNumber: document.getElementById('batchNo').value,
        expiryDate: document.getElementById('expDate').value,
        quantity: document.getElementById('qty').value,
        price: document.getElementById('price').value
    };

    await fetch('/api/medicines/add', {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(medData)
    });
    initInventory();
}