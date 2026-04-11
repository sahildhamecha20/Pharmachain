// 1. Search Medicine
async function searchMedicine() {
    const term = document.getElementById('searchMed').value;
    if (term.length < 2) return;

    const res = await fetch(`/api/medicines/search?name=${term}`);
    const meds = await res.json();

    let html = '';
    meds.forEach(m => {
        html += `<li class="list-group-item list-group-item-action"
                    onclick="selectMed(${m.id}, '${m.medicineName}', ${m.price})">
                    ${m.medicineName} - Batch: ${m.batchNumber} (Stock: ${m.quantity})
                 </li>`;
    });
    document.getElementById('searchResult').innerHTML = html;
}

let cart = [];
function selectMed(id, name, price) {
    document.getElementById('searchMed').value = name;
    document.getElementById('searchResult').innerHTML = '';
    // Temporary global variable to hold selected med price
    window.selectedMed = { id, name, price };
}

function addToCart() {
    const qty = parseInt(document.getElementById('saleQty').value);
    if (!window.selectedMed) return alert("Pehle medicine select karo!");

    const item = {
        batchId: window.selectedMed.id,
        name: window.selectedMed.name,
        price: window.selectedMed.price,
        quantity: qty,
        total: window.selectedMed.price * qty
    };
    cart.push(item);
    updateCartTable();
}

function updateCartTable() {
    let html = '';
    let grandTotal = 0;
    cart.forEach((item, index) => {
        html += `<tr><td>${item.name}</td><td>${item.quantity}</td><td>${item.price}</td><td>${item.total}</td>
                 <td><button class="btn btn-sm btn-danger" onclick="cart.splice(${index},1);updateCartTable();">X</button></td></tr>`;
        grandTotal += item.total;
    });
    document.getElementById('cartBody').innerHTML = html;
    document.getElementById('grandTotal').innerText = grandTotal;
}

async function processSale() {
    const requestData = {
        customerName: document.getElementById('custName').value,
        customerPhone: document.getElementById('custPhone').value,
        paymentMode: "CASH",
        items: cart.map(i => ({ batchId: i.batchId, quantity: i.quantity }))
    };

    const res = await fetch('/api/sales/process', {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(requestData)
    });

    if (res.ok) {
        alert("Sale Successful! Jai Sitaram.");
        document.getElementById('afterSaveButtons').style.display = 'block';
    } else {
        alert("Error in processing sale.");
    }
}