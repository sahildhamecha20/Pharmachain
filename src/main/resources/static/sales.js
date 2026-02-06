function makeSale(e) {
    e.preventDefault();

    fetch("http://localhost:8080/api/sales", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({
            inventoryBatchId: batchId.value,
            quantitySold: qtySold.value,
            sellingPrice: price.value
        })
    })
    .then(res => res.json())
    .then(() => alert("Sale Done"));
}