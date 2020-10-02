var app = ( function() {

    function login(){
        var  email = document.getElementById('correo');
        var  pass = document.getElementById('pass');
        console.log(email+" "+pass);
        if(email !== null && pass !== null){
            console.log("Haz iniciado sesión");
            sendValues(email.value,pass.value);
        }
        else
            alert("Datos incorrectos");
    };

    function sendValues(email,pass){
        axios.post("/login",
            {user:email,pass: pass})
            .then(res => {
                console.log(res);
                answerLogin(res);
            })
            .catch(error => console.log(error));
    };

    function answerLogin(res){
        var response = res["data"]["response"];
        if(response === "Datos correctos"){
            window.location.href = "/menu.html";
            console.log("vamos para la otra vista");
        }
        else if(response === "Datos incorrectos")
            alert("Datos incorrectos");
        else
            alert("Hubo un error en la aplicación");
    };

    function getTeamsValues(){
        var url = "/getData"
        axios.get(url)
            .then(res => {
                console.log(res);
                addTable(res);
            })
            .catch(error => console.log(error));
    };


    function addTable(lista){
        console.log(lista);
        var data = lista["data"]["response"];
        
        if(data === "Error en la conexión con el Servidor"){
            $("#table > tbody").empty();
            alert("Error en la conexión con el Servidor");
        }
        else{
            var cont = 0;
            $("#table > tbody").empty();
            for(var iterator in data){
                var team = data[iterator];
                if(team !== "Error al cargar los datos"){
                    var fila = "<tr>"+
                    "<td>"+team["name"]+"</td>"+
                    "<td>"+team["country"]+"</td>"+
                    "<td>"+team["league"]+"</td>"+
                    "</tr>";
                    $("#table > tbody").append(fila);
                    console.log(fila);
                }
            }
        }
    }

    return{
        login: login,
        sendValues: sendValues,
        answerLogin: answerLogin,
        getTeamsValues: getTeamsValues,
        addTable: addTable
    };
})();
