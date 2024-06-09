$(document).ready(function (){
    getCurrentUser()
    getPrincipal()
    getAllUsers()
    rolesToString()
    getRoles()
    stringToRoles()

});

function getCurrentUser() {
    fetch("http://localhost:8080/principal")
        .then((response) => response.json())
        .then((user) => {
            document.getElementById("currentUserEmail").innerHTML = `${user.email}`;
            document.getElementById("currentUserRoles").innerHTML = ` with roles: ${rolesToString(user.roles)}`;
        })
        .catch(err => console.log(err))
}

function getAllUsers() {
    fetch("http://localhost:8080/all", {
        method: 'GET',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json;charset=utf-8'
        }})
        .then((response) => response.json())
        .then((all) => {
            let output = '';
            all.forEach(user =>{
                output += `<tr>
                       <td id="id${user.id}">${user.id}</td>
                       <td id="name${user.id}">${user.name}</td> 
                       <td id="surname${user.id}">${user.surname}</td>
                       <td id="age${user.id}">${user.age}</td>
                       <td id="email${user.id}">${user.email}</td>
                       <td id="password${user.id}">${user.password}</td>
                       <td id="roles${user.id}">${rolesToString(user.roles)}</td>
                       <td><button type="button" 
                       class="btn btn-primary"
                       data-toggle="modal"
                       data-target ="#modalEdit" id ="edit" 
                       onclick="modalEdit(${user.id})">Edit</button></td>
                       <td><button type="button"
                       class="btn btn-danger" 
                       data-toggle="modal" 
                       data-target="#modalDelete" id="delete"
                       onclick="modalDelete(${user.id})">Delete</button></td>
                    </tr>`;
            });
            document.getElementById("all-users-table").innerHTML = output;
        })
        .catch(err => console.log(err))
}

function rolesToString(roles) {
    let arrayRoles = [];
    $.each(roles, function (i, role) {
        arrayRoles[i] = role.role;
    })
    return arrayRoles.join(', ');
}

function getRoles(){
    fetch("http://localhost:8080/roles",{
        method: "GET",
        headers:{
            'Accept': 'application/json',
            'Content-Type': 'application/json;charset=utf-8'
        }
    }).then((response) => response.json())
        .then((all) =>{
            let output = '';
            all.forEach(role =>{
                output +=
                    `<option>${role.role}</option>`;
            });
            document.getElementById("roleName").innerHTML = output;
            document.getElementById("editRole").innerHTML = output;
            document.getElementById("deleteRole").innerHTML = output;
        })
        .catch(err => console.log(err))
}

function stringToRoles(Roles) {
    let roles = [];
    if (Roles.indexOf("ROLE_USER") >= 0) {
        roles.push({"id": 2});
    }
    if (Roles.indexOf("ROLE_ADMIN") >= 0) {
        roles.push({"id": 1});
    }
    return roles;
}