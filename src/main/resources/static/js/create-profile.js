document.getElementById("create-profile-form").addEventListener("submit", function(event) {
    const password = document.getElementById("mot-de-passe").value;
    const confirmationPassword = document.getElementById("confirmation").value;

    if (password !== confirmationPassword) {
        event.preventDefault(); // Empêche la soumission si les mots de passe ne correspondent pas
        alert("Les mots de passe ne correspondent pas."); // Affiche un message rapide
    }
})