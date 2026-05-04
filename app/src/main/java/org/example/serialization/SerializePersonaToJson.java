package org.example.serialization;

import java.util.List;

import org.example.model.Persona;

import com.google.gson.Gson;

public class SerializePersonaToJson {
    public String serialize(List<Persona> persone){
        Gson gson = new Gson();
        return gson.toJson(persone);
    }
}
