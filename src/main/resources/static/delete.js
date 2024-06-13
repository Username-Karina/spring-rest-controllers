document.getElementById("modalDeleteUserForm").addEventListener("submit", deleteUser)

function deleteUser(event){
    event.preventDefault();

    let id = document.getElementById("deleteId").value;

    fetch("api/admin/delete/" + id,{
        method: "DELETE",
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json;charset=utf-8'
        },
        body: JSON.stringify({
            id: id
        })
    })
        .catch(err => console.log(err))
        .finally(()=>{
            $("#modalDelete").modal('hide')
            getAllUsers();
        })

}

function modalDelete(id) {
    document.getElementById("deleteId").value = id;
    document.getElementById("deleteName").value = $("#name" + id).text();
    document.getElementById("deleteSurname").value = $("#surname" + id).text();
    document.getElementById("deleteAge").value = $("#age" + id).text();
    document.getElementById("deleteEmail").value = $("#email" + id).text();
    document.getElementById("deletePassword").value = $("#password" + id).text();
    document.getElementById("deleteRole").value = $("#roles" + id).text();
}
