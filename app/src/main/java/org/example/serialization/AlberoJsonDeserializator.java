package org.example.serialization;

import java.lang.reflect.Type;
import java.util.List;

import org.example.model.Albero;
import org.example.utility.ResourceReader;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class AlberoJsonDeserializator extends ResourceReader {
    public List<Albero> deserialize(){
        try {
            String json = readFile("alberi.json");
            Gson gson = new Gson();
            Type listType = new TypeToken<List<Albero>>(){}.getType();
            return gson.fromJson(json, listType);
        } catch (RuntimeException e) {
            throw new SerializationException("Errore nella lettura del file alberi.json: " + e.getMessage());
        }
    }
}
