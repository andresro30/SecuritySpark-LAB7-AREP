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



    
    function callOtherDomain() {
        var invocation = new XMLHttpRequest();
        var url = 'https://ec2-184-72-124-74.compute-1.amazonaws.com:4567/getRanking';
        if(invocation) {   
            invocation.responseType = 'json'; 
            invocation.open('GET', url, true);
            //invocation.onreadystatechange = addTable(invocation.responseText);
            invocation.onload = addTable(JSON.stringify(invocation.responseURL));
        }
    };

    function addTable(lista){
        console.log(lista);
        var data = lista["data"]["response"];
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

    return{
        login: login,
        sendValues: sendValues,
        answerLogin: answerLogin,
        getTeamsValues: getTeamsValues,
        addTable: addTable,
        callOtherDomain: callOtherDomain

    };
})();
