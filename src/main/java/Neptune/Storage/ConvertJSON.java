package Neptune.Storage;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.internal.LinkedTreeMap;

import java.lang.reflect.Type;

public abstract class ConvertJSON {
    public String toJSON(LinkedTreeMap<String, Object> data){
        Gson gson = new GsonBuilder().create();
        return gson.toJson(data);
    }
    public LinkedTreeMap<String, Object> fromJSON(String json){
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        Type typeOfHashMap = new TypeToken<LinkedTreeMap<String, Object>>() { }.getType();
        return gson.fromJson(json, typeOfHashMap);
    }
}
