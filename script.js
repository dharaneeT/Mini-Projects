"use strict";

const taskInput = document.querySelector(".task-input");
const priorityInput = document.querySelector(".priority-options");
const dueDateInput = document.querySelector(".date-input");
const addBtn = document.querySelector(".add-btn");
const toggleBtn = document.querySelector(".toggle-btn");
const dltBtn = document.querySelector(".dlt-btn");
const taskContainer = document.querySelector(".inner-task-container");
const cardContainer = document.querySelector(".grid-container");
const card = document.querySelector(".card-content");

let arr = [];

function displayRefresher() {
  taskInput.value = "";
  priorityInput.value = "low";
  dueDateInput.value = "";
}

function pushInput() {
  arr.push({
    task: taskInput.value,
    priority: priorityInput.value,
    duedate: dueDateInput.value,
    completed: false,
  });
}

function displayTask() {
  const lastTask = arr[arr.length - 1];
  //   console.log(arr);
  let html = "";
  arr.forEach((item, index) => {
    html += `  <div class="card-container">
    <div class="card-content ${item.priority}">
      <h2>Task ${index + 1}</h2>
      <p>${item.task}</p>
      <p>${item.duedate}</p>
       ${
         !item.completed
           ? `<button class="btn toggle-btn ${item.priority === "low" ? "low-btn" : ""}" onclick="completeTask(${index})">Incomplete</button>`
           : `<span class="completed-text">Completed ✔</span>`
       }
      <button class="btn dlt-btn"  onclick="dltTask(${index})">Delete</button>
    </div>
    </div>`;
  });

  cardContainer.innerHTML = html;
  html = "";
  taskContainer.classList.remove("hidden");
}

function dltTask(i) {
  arr.splice(i, 1);
  displayTask();

  if (arr.length === 0) {
    taskContainer.classList.add("hidden");
  }
}

function completeTask(i) {
  arr[i].priority = "complete";
  arr[i].completed = true;
  displayTask();
}

//Event handling
addBtn.addEventListener("click", function (e) {
  e.preventDefault();
  if (
    taskInput.value.trim() === "" ||
    priorityInput.value === "" ||
    dueDateInput.value === ""
  ) {
    alert("task should be filled");
    return;
  }
  pushInput();
  displayTask();
  displayRefresher();
  taskContainer.scrollIntoView({
    behavior: "smooth",
  });
});
