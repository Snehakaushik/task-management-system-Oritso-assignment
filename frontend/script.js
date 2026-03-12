const API = "http://localhost:8081/api/tasks";

function loadTasks(){

fetch(API)
.then(res => res.json())
.then(data => {

let rows="";

data.forEach(task=>{

rows += `
<tr>
<td>${task.id}</td>
<td>${task.taskTitle}</td>
<td>${task.taskStatus}</td>
<td>${task.taskDueDate}</td>

<td>

<button class="btn btn-warning btn-sm" onclick='editTask(${JSON.stringify(task)})'>Edit</button>

<button class="btn btn-danger btn-sm" onclick="deleteTask(${task.id})">Delete</button>

</td>
</tr>
`

})

document.getElementById("taskTable").innerHTML = rows

})

}



function saveTask(){

let id = document.getElementById("taskId").value

let task = {

taskTitle:document.getElementById("taskTitle").value,
taskDescription:document.getElementById("taskDescription").value,
taskDueDate:document.getElementById("taskDueDate").value,
taskStatus:document.getElementById("taskStatus").value,
taskRemarks:document.getElementById("taskRemarks").value,
createdBy:"Sneha",
lastUpdatedBy:"Sneha"

}

if(id){

fetch(API + "/update/" + id,{
method:"PUT",
headers:{
"Content-Type":"application/json"
},
body:JSON.stringify(task)
})
.then(()=>{

clearForm()
loadTasks()

})

}else{

fetch(API + "/createTask",{
method:"POST",
headers:{
"Content-Type":"application/json"
},
body:JSON.stringify(task)
})
.then(()=>{

clearForm()
loadTasks()

})

}

}



function editTask(task){

document.getElementById("taskId").value = task.id
document.getElementById("taskTitle").value = task.taskTitle
document.getElementById("taskDescription").value = task.taskDescription
document.getElementById("taskDueDate").value = task.taskDueDate
document.getElementById("taskStatus").value = task.taskStatus
document.getElementById("taskRemarks").value = task.taskRemarks

}



function deleteTask(id){

fetch(API + "/delete/" + id,{
method:"DELETE"
})
.then(()=>loadTasks())

}



function searchTasks(){

let keyword = document.getElementById("searchKeyword").value

fetch(API + "/search?keyword=" + keyword)
.then(res=>res.json())
.then(data=>{

let rows="";

data.forEach(task=>{

rows += `
<tr>

<td>${task.id}</td>
<td>${task.taskTitle}</td>
<td>${task.taskStatus}</td>
<td>${task.taskDueDate}</td>

<td>

<button class="btn btn-warning btn-sm" onclick='editTask(${JSON.stringify(task)})'>Edit</button>

<button class="btn btn-danger btn-sm" onclick="deleteTask(${task.id})">Delete</button>

</td>

</tr>
`

})

document.getElementById("taskTable").innerHTML = rows

})

}



function clearForm(){

document.getElementById("taskId").value=""
document.getElementById("taskTitle").value=""
document.getElementById("taskDescription").value=""
document.getElementById("taskDueDate").value=""
document.getElementById("taskRemarks").value=""

}

loadTasks()