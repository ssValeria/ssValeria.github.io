let list = document.querySelector('.slider .list');
let items = document.querySelectorAll('.slider .list .item');
let dots = document.querySelectorAll('.slider .dots li');
let prev = document.getElementById('prev');
let next = document.getElementById('next');

let active = 0;
let totalItems = items.length;

next.onclick = function() {
    active = (active + 1) % totalItems;
    reloadSlider();
}

prev.onclick = function() {
    active = (active - 1 + totalItems) % totalItems;
    reloadSlider();
}

dots.forEach((dot, index) => {
    dot.onclick = function() {
        active = index;
        reloadSlider();
    }
});

function reloadSlider() {
    let itemWidth = items[0].clientWidth;
    list.style.transform = 'translateX(' + (-itemWidth * active) + 'px)';
    updateDots();
}

function updateDots() {
    dots.forEach(dot => dot.classList.remove('active'));
    dots[active].classList.add('active');
}

// Iniciar el slider
reloadSlider();
