const questionsData = [
  { q: "HTML stands for?", options: ["Hyper Text Markup Language", "High Text Machine Language", "Hyperlink Text Language", "Home Tool Markup Language"] },
  { q: "CSS is used for?", options: ["Styling", "Logic", "Database", "Networking"] },
  { q: "JavaScript runs in?", options: ["Browser", "Compiler", "OS", "Database"] },
  { q: "Which tag creates a link?", options: ["&lt;a&gt;", "&lt;div&gt;", "&lt;img&gt;", "&lt;span&gt;"] },
  { q: "Which is a CSS unit?", options: ["px", "kg", "km", "byte"] },

  { q: "Which tag is semantic?", options: ["&lt;header&gt;", "&lt;div&gt;", "&lt;span&gt;", "&lt;b&gt;"] },
  { q: "JS keyword to declare variable?", options: ["let", "define", "int", "varible"] },
  { q: "Flexbox is used for?", options: ["Layout", "Database", "Security", "Compiler"] },
  { q: "Which is JS framework?", options: ["React", "MySQL", "HTML", "CSS"] },
  { q: "HTML file extension?", options: [".html", ".css", ".js", ".exe"] },

  { q: "CSS stands for?", options: ["Cascading Style Sheets", "Creative Style System", "Color Style Sheet", "Computer Style Sheet"] },
  { q: "JavaScript is?", options: ["Programming language", "Markup language", "Database", "OS"] },
  { q: "Which property changes text color?", options: ["color", "font-size", "margin", "padding"] },
  { q: "Which tag creates unordered list?", options: ["&lt;ul&gt;", "&lt;ol&gt;", "&lt;li&gt;", "&lt;list&gt;"] },
  { q: "Which is NOT CSS property?", options: ["console", "margin", "padding", "border"] },

  { q: "JavaScript is used for?", options: ["Interactivity", "Styling", "Database", "Server"] },
  { q: "HTML is a?", options: ["Markup language", "Programming language", "Database", "Framework"] },
  { q: "CSS property for inner spacing?", options: ["padding", "margin", "border", "gap"] },
  { q: "JavaScript file extension?", options: [".js", ".java", ".json", ".jsx"] },
  { q: "Which tag displays image?", options: ["&lt;img&gt;", "&lt;image&gt;", "&lt;pic&gt;", "&lt;src&gt;"] }
];

const questionsPerPage = 5;
let currentPage = 0;

const questionsDiv = document.getElementById("questions");
const progressBar = document.getElementById("progressBar");
const prevBtn = document.getElementById("prevBtn");
const nextBtn = document.getElementById("nextBtn");

function loadQuestions() {
  questionsDiv.innerHTML = "";

  const start = currentPage * questionsPerPage;
  const end = start + questionsPerPage;
  const pageQuestions = questionsData.slice(start, end);

  pageQuestions.forEach((item, index) => {
    const div = document.createElement("div");
    div.className = "question";

    div.innerHTML = `
      <h4>${start + index + 1}. ${item.q}</h4>
      ${item.options.map(opt => `
        <label>
          <input type="radio" name="q${start + index}">
          ${opt}
        </label>
      `).join("")}
    `;

    questionsDiv.appendChild(div);
  });

  updateProgress();
}

function updateProgress() {
  const progress = ((currentPage + 1) * questionsPerPage / questionsData.length) * 100;
  progressBar.style.width = progress + "%";
}

prevBtn.addEventListener("click", () => {
  if (currentPage > 0) {
    currentPage--;
    loadQuestions();
  }
});

nextBtn.addEventListener("click", () => {
  if ((currentPage + 1) * questionsPerPage < questionsData.length) {
    currentPage++;
    loadQuestions();
  } else {
    alert("Test completed!");
  }
});

function loadQuestions() {
  questionsDiv.innerHTML = "";

  const start = currentPage * questionsPerPage;
  const end = start + questionsPerPage;
  const pageQuestions = questionsData.slice(start, end);

  pageQuestions.forEach((item, index) => {
    const div = document.createElement("div");
    div.className = "question";

    div.innerHTML = `
      <h4>${start + index + 1}. ${item.q}</h4>
      ${item.options.map(opt => `
        <label>
          <input type="radio" name="q${start + index}">
          ${opt}
        </label>
      `).join("")}
    `;

    questionsDiv.appendChild(div);
  });

  // 🔴 PUT BUTTON LOGIC HERE (BOTTOM OF FUNCTION)
  prevBtn.disabled = currentPage === 0;

  nextBtn.textContent =
    (currentPage + 1) * questionsPerPage >= questionsData.length
      ? "Finish"
      : "Next";

  updateProgress();
}

