
document.querySelectorAll('.spoiler-button').forEach(button => {
    button.addEventListener('click', () => {
        const spoilerContent = button.nextElementSibling;
        if (spoilerContent.style.display === 'block') {
            spoilerContent.style.display = 'none';
        } else {
            spoilerContent.style.display = 'block';
        }
    });
});
