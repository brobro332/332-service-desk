function showLoadingSpinner() {
    const spinner = document.createElement('div');
    spinner.id = 'loading-spinner';

    const spinnerInner = document.createElement('div');
    spinnerInner.className = 'spinner';

    spinner.appendChild(spinnerInner);
    document.body.appendChild(spinner);

    document.getElementById('loading-spinner').style.visibility = 'visible';
}

function hideLoadingSpinner() {
    const spinner = document.getElementById('loading-spinner');
    if (spinner) {
        spinner.style.visibility = 'hidden';
        document.body.removeChild(spinner);
    }
}