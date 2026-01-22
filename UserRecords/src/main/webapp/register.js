// Get form and popup elements
const form = document.getElementById('registerForm');
const popupOverlay = document.getElementById('popupOverlay');

// Handle form submission
form.addEventListener('submit', function(e) {
    e.preventDefault();
    
    // Show success popup
    popupOverlay.classList.add('active');
    
    // Optional: Submit form data to server after showing popup
    // Uncomment the lines below if you want to actually submit the form
    // setTimeout(() => {
    //     form.submit();
    // }, 2000);
});

// Close popup function
function closePopup() {
    popupOverlay.classList.remove('active');
    
    // Reset form after closing popup
    form.reset();
    
    // Redirect to login page
    window.location.href = 'index.html';
}