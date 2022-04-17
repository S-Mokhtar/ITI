const taskInput = document.getElementById("task");
const addTaskBtn = document.getElementById("addTaskBtn");
const todoListContainer = document.getElementById('todo-list');
const createTodo = (todo) => {
  return `<div class="todo flex">
                <div>${todo}</div>
                <button class="success"><i class="fa fa-check"></i></button>
                <button class="error"><i class="fa fa-remove"></i></button>
            </div>`;
};
const addTask = (e) => {
  e.preventDefault();
  const newTask = taskInput.value;
  if (newTask !== '') {
    taskInput.value = '';
    const todosCount = todoListContainer.getElementsByClassName('todo').length;
    if (todosCount === 0) {
      todoListContainer.innerHTML = '';
    }
      todoListContainer.innerHTML += createTodo(newTask);
  }
};
const handleTodoAction = e => {
  e.preventDefault();
  let target = e.target;
  if (target.nodeName.toLowerCase() === 'i') {
    target = target.parentElement;
  }
  const className = target.className;
  if (className === 'success' || className === 'error') {
    const parent = target.parentNode;
    if (className === 'success') {
      parent.className += ' checked';
      target.setAttribute('disabled', 'disabled');
    } else {
      todoListContainer.removeChild(parent);
      if (todoListContainer.childElementCount === 0) {
        todoListContainer.innerHTML = '<div class="flex">No items in the list</div>';
      }
    }
  }
};
addTaskBtn.addEventListener("click", addTask);
document.addEventListener("click", handleTodoAction);
