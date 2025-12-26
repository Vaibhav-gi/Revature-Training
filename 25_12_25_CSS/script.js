// SIGN UP FUNCTIONALITY
document.getElementById("signupForm")?.addEventListener("submit", function (e) {
  e.preventDefault();

  const reader = new FileReader();
  const file = document.getElementById("photo").files[0];

  reader.onload = function () {
    const user = {
      fname: fname.value,
      lname: lname.value,
      email: email.value,
      phone: phone.value,
      photo: reader.result
    };

    localStorage.setItem("user", JSON.stringify(user));
    alert("Registration successful. Now login.");
  };

  reader.readAsDataURL(file);
});

// SIGN IN FUNCTIONALITY
document.getElementById("signinForm")?.addEventListener("submit", function (e) {
  e.preventDefault();

  const storedUser = JSON.parse(localStorage.getItem("user"));
  if (!storedUser) {
    alert("No user registered.");
    return;
  }

  if (loginEmail.value === storedUser.email) {
    localStorage.setItem("loggedIn", "true");
    window.location.href = "dashboard.html";
  } else {
    alert("Invalid email");
  }
});

// DASHBOARD LOAD FUNCTIONALITY
if (window.location.pathname.includes("dashboard")) {
  if (localStorage.getItem("loggedIn") !== "true") {
    window.location.href = "index.html";
  }

  const user = JSON.parse(localStorage.getItem("user"));
  name.textContent = user.fname + " " + user.lname;
  email.textContent = user.email;
  phone.textContent = user.phone;
  profilePic.src = user.photo;
}

// LOGOUT FUNCTION
function logout() {
  localStorage.removeItem("loggedIn");
  window.location.href = "index.html";
}
