function getPrincipal() {

    fetch("api/user/principal/",{
        method: "GET",
        headers:{
            'Accept': 'application/json',
            'Content-Type': 'application/json;charset=utf-8'
        }
    }).then((response) => response.json())
        .then((principal) =>{
            let output = '';
            output +=
                `<tr>
                    <td>${principal.id}</td>
                    <td>${principal.name}</td>
                    <td>${principal.surname}</td>
                    <td>${principal.age}</td>
                    <td>${principal.email}</td>
                    <td>${principal.password}</td>
                    <td>${rolesToString(principal.roles)}</td>
                    </tr>`;
            document.getElementById("single-user-table").innerHTML = output;
        })
        .catch(err => console.log(err))
}

