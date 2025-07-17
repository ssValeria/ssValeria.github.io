// Obtener todos los elementos con la clase "product"
const products = document.querySelectorAll('.product');

// Iterar sobre cada producto y agregar eventos de mouseover y mouseout
products.forEach(product => {
    const originalImage = product.getAttribute('data-original-image');
    const altImage = product.getAttribute('data-alt-image');
    const productImage = product.querySelector('img');

    product.addEventListener('mouseover', function() {
        productImage.setAttribute('src', altImage);
    });

    product.addEventListener('mouseout', function() {
        productImage.setAttribute('src', originalImage);
    });
});
