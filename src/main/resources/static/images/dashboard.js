async function updateDashboardData() {
    try {
        const res = await fetch('/api/dashboard/summary');
        const data = await res.json();

        // Update UI IDs matching the cards in index.html
        document.getElementById('totalMedCount').innerText = data.totalMedicines;
        document.getElementById('todaySaleAmt').innerText = "Rs. " + data.todaySales.toFixed(2);

        // Agar outOfStock endpoint hai toh, nahi toh manually count karo low quantity batches
        document.getElementById('lowStockCount').innerText = "5"; // Placeholder, logic later

    } catch (error) {
        console.error("Dashboard error:", error);
    }
}
window.onload = updateDashboardData;