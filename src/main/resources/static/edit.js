document.getElementById("modalEditUserForm").addEventListener("submit", editUser)

function editUser(event){
    event.preventDefault();

    let id = document.getElementById("editId").value;
    let name = document.getElementById("editName").value;
    let surname = document.getElementById("editSurname").value;
    let age = document.getElementById("editAge").value;
    let email = document.getElementById("editEmail").value;
    let password = document.getElementById("editPassword").value;
    let roles = Array.from(document.getElementById("editRole").selectedOptions)
        .map(option => option.value);
    fetch("api/admin/edit/" + id, {
        method: "PUT",
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json;charset=utf-8'
        },
        body: JSON.stringify({
            id: id,
            name: name,
            lastName: surname,
            age: age,
            email: email,
            password: password,
            roles: stringToRoles(roles)
        })
    }).catch(err => console.log(err))
        .finally( () => {
            $("#modalEdit").modal('hide');
            getAllUsers();
        })


}

function modalEdit(id) {
    document.getElementById("editId").value = id;
    document.getElementById("editName").value = $("#name" + id).text();
    document.getElementById("editSurname").value = $("#surname" + id).text();
    document.getElementById("editAge").value = $("#age" + id).text();
    document.getElementById("editEmail").value = $("#email" + id).text();
    document.getElementById("editPassword").value = $("#password" + id).text();
    document.getElementById("editRole").value = $("#roles" + id).text();
}