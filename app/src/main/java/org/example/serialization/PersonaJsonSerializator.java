package org.example.serialization;

import java.util.List;

import org.example.model.Persona;

import com.google.gson.Gson;

public class PersonaJsonSerializator {
    public String serialize(List<Persona> persone){
        try {
            Gson gson = new Gson();
            return gson.toJson(persone);
        } catch (RuntimeException e) {
            throw new SerializationException("Errore durante la serializzazione: " + e.getMessage());
        }
    }
}
