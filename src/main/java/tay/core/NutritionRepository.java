package tay.core;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.google.common.base.Charsets;
import com.google.common.io.Resources;
import tay.api.Nutrition;

import java.io.IOException;
import java.net.URL;
import java.util.List;

/**
 * Created by yoseph on 4/22/17.
 */
public class NutritionRepository {
    private static final String DATA_SOURCE = "fake_data.json";

    public NutritionRepository() {

    }

    public List<Nutrition> findAll() throws IOException {
        // implement logic here to read from json file and return a List of all Nutrition
        URL url = Resources.getResource(DATA_SOURCE);
        String json = Resources.toString(url, Charsets.UTF_8);
        ObjectMapper mapper = new ObjectMapper();
        CollectionType type = mapper
                .getTypeFactory()
                .constructCollectionType(List.class, Nutrition.class);
        List<Nutrition> all = mapper.readValue(json, type);
        return all;
    }
}
