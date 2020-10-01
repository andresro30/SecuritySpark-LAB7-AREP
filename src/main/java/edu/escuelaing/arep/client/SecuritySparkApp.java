package edu.escuelaing.arep.client;
import edu.escuelaing.arep.server.model.Team;
import edu.escuelaing.arep.server.Ranking;
import org.json.JSONException;
import org.json.JSONObject;

import static spark.Spark.*;
import org.apache.commons.codec.digest.DigestUtils;

import java.util.LinkedList;
import java.util.List;

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
//        get("/getRanking",(req,res) -> getRankig());
        post("/login",(req, res) -> verificarData(new JSONObject(req.body())));


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

//    private static JSONObject getRankig() throws JSONException {
//        JSONObject response = new JSONObject();
//        Ranking ranking = new Ranking();
//        List<Team> teams = ranking.getTeams();
//        List<JSONObject> data = new LinkedList<JSONObject>();
//        try{
//           for(Team iterator: teams){
//               JSONObject json = new JSONObject();
//               json.put("name",iterator.getName());
//               json.put("country",iterator.getCountry());
//               json.put("league",iterator.getLeague());
//               data.add(json);
//           }
//            response.put("response",data);
//        } catch (JSONException e){
//            e.printStackTrace();
//            response = new JSONObject();
//            response.put("response","Error al cargar los datos");
//        }
//        System.out.println(response);
//        return response;
//    }

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
