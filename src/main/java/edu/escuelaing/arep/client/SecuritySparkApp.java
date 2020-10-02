package edu.escuelaing.arep.client;
import org.json.JSONException;
import org.json.JSONObject;

import static spark.Spark.*;
import org.apache.commons.codec.digest.DigestUtils;


/**
 * Hello world!
 *
 */
public class SecuritySparkApp
{
    private static final String username = "andres@gmail.com";
    private static final String password = "c09008453752e135107a75bc99759eda9853cc58";

    public static void main( String[] args )
    {
        staticFileLocation("/static");
        port(getPort());
        secure("keyStores/ecikeystore.p12", "123456",  null,null);
        get("/hellow", (req, res) -> "Hellow Security");

        get("/", (req,res) -> {
            res.redirect("index.html");
            return null;
        });
        get("/getData",(req,res) -> getResponse());
        post("/login",(req, res) -> verificarData(new JSONObject(req.body())));
    }

    private static Object getResponse() throws JSONException {
        String res = "";
        JSONObject data = null;
        try{
            res += HttpServer.readURL("https://ec2-184-72-124-74.compute-1.amazonaws.com:4567/getRanking");
            data = new JSONObject(res);
        }catch (Exception e){
            data = new JSONObject("Error en la conexión con el Servidor");
        }

        return data;
    }

    private static JSONObject verificarData(JSONObject data) throws JSONException {
        System.out.println(data);
        JSONObject response = new JSONObject();
        try {
            String user = data.get("user").toString();
            String pass = data.get("pass").toString();

            String hashPass = DigestUtils.sha1Hex(pass);
            if(user.equals(username) && hashPass.equals(password)){
                response.put("response","Datos correctos");
            }
            else
                response.put("response","Datos incorrectos");

        } catch (JSONException e) {
            e.printStackTrace();
            response.put("response","Error en la verificación");
        }
        System.out.println(response);
        return response;
    }

    /**
     * Método enccargado de definir el puerto por donde corre el programa
     *
     * @return variable de tipo int
     */
    public static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4500;
    }
}
