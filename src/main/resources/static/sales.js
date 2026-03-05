// 1. Make Sale Function
function makeSale(e) {
    e.preventDefault();

    fetch("/api/sales", { // Azure path fix
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({
            inventoryBatchId: document.getElementById("batchId").value, // Fixed selector
            quantitySold: document.getElementById("qtySold").value,     // Fixed selector
            sellingPrice: document.getElementById("price").value       // Fixed selector
        })
    })
    .then(res => {
        if(!res.ok) throw new Error("Sale failed");
        return res.json();
    })
    .then(() => {
        alert("Sale Done");
        if(typeof loadInventory === "function") loadInventory(); // Refresh if on same page
    })
    .catch(err => alert("Error: " + err.message));
}