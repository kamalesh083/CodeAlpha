const lightbox = document.getElementById("lightbox");
const lightboxImg = document.getElementById("lightbox-img");
const images = document.querySelectorAll(".gallery-img");
const closeBtn = document.querySelector(".close");
let currentIndex = 0;

function openLightbox(index) {
  currentIndex = index;
  lightbox.style.display = "flex";
  lightboxImg.src = images[index].src;
}

images.forEach((img, index) => {
  img.addEventListener("click", () => openLightbox(index));
});

document.getElementById("prev").onclick = () => {
  currentIndex = (currentIndex - 1 + images.length) % images.length;
  lightboxImg.src = images[currentIndex].src;
};

document.getElementById("next").onclick = () => {
  currentIndex = (currentIndex + 1) % images.length;
  lightboxImg.src = images[currentIndex].src;
};

closeBtn.onclick = () => {
  lightbox.style.display = "none";
};
