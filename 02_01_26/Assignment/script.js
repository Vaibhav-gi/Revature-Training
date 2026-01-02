// PART 1: 15 Practice Exercise Questions


// 1. Call Stack & Event Loop

// A web page has a button that logs "Start", then uses setTimeout to log "Async Task", and finally logs "End".
//  Explain the execution order using Call Stack, Callback Queue, and Event Loop.
// Sol:
console.log("Start");

setTimeout(() => {
  console.log("Async Task");
}, 0);

console.log("End");

// Execution Order Explanation:
// 1. When the button is clicked, "Start" is logged first as it is a synchronous task and goes directly to the Call Stack.
// 2. The setTimeout function is called next, which sets up an asynchronous task to log "Async Task" after 0 milliseconds. This task is sent to the Web APIs and then to the Callback Queue once the timer expires.
// 3. "End" is logged next as it is also a synchronous task and goes directly to the Call Stack.
// 4. After all synchronous tasks are completed, the Event Loop checks the Call Stack. Since it is empty, it looks at the Callback Queue and finds the "Async Task" callback.
// 5. The "Async Task" callback is then pushed onto the Call Stack and executed, logging "Async Task".


// 2. Callback Queue

// You are loading ads after page load using setTimeout.
//  Why does the ad load after the main content even if the timeout is 0ms?

// 3. JSON.parse()

// You receive this API response as a string:

// '{"id":101,"name":"Laptop","price":50000}'


//  Convert it into a JavaScript object and access the name.

// 4. JSON.stringify()

// You want to store user details in localStorage.
//  Convert the following object into JSON string:

// { username: "admin", role: "manager" }

// 5. Array forEach – Real-Time Example

// You have a list of users and want to print a welcome message for each user.
//  Use forEach() to log messages.

// 6. Array map – Price Calculation

// An e-commerce site gives 10% discount on all prices.
//  Use map() to create a new discounted price list.

// 7. Array filter – Search Feature

// You want to show only available products from a product list.
//  Use filter() to return items with inStock === true.

// 8. Array reduce – Cart Total

// Calculate the total price of items in a shopping cart using reduce().

// 9. Function Declaration vs Arrow Function

// Create a function to calculate GST using:

// Function Declaration

// Arrow Function
//  Mention one key difference.

// 10. Closures – Secure Counter

// Create a counter function that cannot be directly modified from outside.

// 11. Callback Function – Login Validation

// You validate a user and then redirect them.
//  Implement validation using callback functions.

// 12. Callback Hell – Payment Processing

// A payment flow involves:

// Validate user

// Process payment

// Generate invoice
//  Explain why nested callbacks become difficult to manage.

// 13. Promises & async/await

// Convert this promise-based API call into async/await:

// fetch(url).then(res => res.json()).then(data => console.log(data));

// 14. DOM Manipulation – Dynamic UI

// You click a button and dynamically add a new list item to <ul>.
//  Which DOM methods will you use?

// 15. Event Listeners – Form Validation

// A form should display an error message when submitted without input.
//  Explain how addEventListener() helps.
