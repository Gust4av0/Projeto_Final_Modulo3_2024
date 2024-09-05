package jogo;

import com.google.gson.Gson;
import modelo.Save;
import repositorio.SaveDAO;
import spark.Spark;

import java.sql.SQLException;

public class Main {
    private static final Gson Gson = new Gson();
    public static void main(String[] args) {
        try{
            Save save = SaveDAO.novoJogo();
            String saveJson = Gson.toJson(save);
            Spark.get("/", (req,res) -> saveJson);

        } catch (Exception e){
            throw new RuntimeException(e);
        }

    }
}
