document.getElementById("newUser").addEventListener("submit", newUser)

function newUser(event){
    event.preventDefault();

    let name = document.getElementById("name").value;
    let surname = document.getElementById("surname").value;
    let age = document.getElementById("age").value;
    let email = document.getElementById("email").value;
    let password = document.getElementById("password").value;
    let roles = Array.from(document.getElementById("roleName").selectedOptions)
        .map(option => option.value)
    let body = JSON.stringify({
        name : name,
        lastName : surname,
        age : age,
        email : email,
        password : password,
        roles : stringToRoles(roles)
    })

    fetch("api/admin/new",{
        method : "POST",
        headers : {
            'Accept': 'application/json',
            'Content-Type': 'application/json;charset=utf-8'
        },
        body : body
    }).then(response => console.log(response))
        .finally(() => {
            document.getElementById("admin-tab").click();
            document.getElementById("newUser").reset();
            getAllUsers();
        })

}