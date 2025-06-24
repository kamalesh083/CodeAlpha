let display = document.getElementById("display");

function append(value) {
  display.value += value;
}

function clearDisplay() {
  display.value = "";
}

function backspace() {
  display.value = display.value.slice(0, -1);
}

function calculate() {
  try {
    display.value = eval(display.value.replace("%", "/100"));
  } catch {
    display.value = "Error";
  }
}

document.addEventListener("keydown", (e) => {
  const key = e.key;
  if ("0123456789+-*/.%".includes(key)) {
    append(key);
  } else if (key === "Enter") {
    calculate();
  } else if (key === "Backspace") {
    backspace();
  } else if (key === "Escape") {
    clearDisplay();
  }
});

function toggleTheme() {
  document.body.classList.toggle("dark");
}
