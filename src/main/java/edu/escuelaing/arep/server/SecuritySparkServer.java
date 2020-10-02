package edu.escuelaing.arep.server;

import edu.escuelaing.arep.server.model.Team;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.LinkedList;
import java.util.List;

import static spark.Spark.*;

public class SecuritySparkServer {

    public static void main(String[] args) {
        port(getPort());
        secure("keyStores/ecikeystore.p12", "123456",  null,null);
        get("/",(req,res) -> "Welcome to Server container");
        get("/getRanking",(req,res) -> getRankig());

    }

    private static JSONObject getRankig() throws JSONException {
        JSONObject response = new JSONObject();
        Ranking ranking = new Ranking();
        List<Team> teams = ranking.getTeams();
        List<JSONObject> data = new LinkedList<JSONObject>();
        try{
            for(Team iterator: teams){
                JSONObject json = new JSONObject();
                json.put("name",iterator.getName());
                json.put("country",iterator.getCountry());
                json.put("league",iterator.getLeague());
                data.add(json);
            }
            response.put("response",data);
        } catch (JSONException e){
            e.printStackTrace();
            response = new JSONObject();
            response.put("response","Error al cargar los datos");
        }
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
        return 4567;
    }

}
