// Insertion de la date du jour dans le header
document.addEventListener('DOMContentLoaded', function() {
    const dateElement = document.getElementById('today-date');
    if (dateElement) {
        const today = new Date();
        const formattedDate = today.getDate().toString().padStart(2, '0') + '/' +
            (today.getMonth() + 1).toString().padStart(2, '0') + '/' +
            today.getFullYear();
        dateElement.textContent = "Date du jour : " + formattedDate;
    }
});