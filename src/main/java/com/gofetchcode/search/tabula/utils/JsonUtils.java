package com.gofetchcode.search.tabula.utils;

import com.gofetchcode.search.tabula.bean.PageMeta;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

/**
 * Created by Max on 08.09.2016.
 */
public class JsonUtils {
    /**
     * return ArrayList of POJO from json
     *
     * @param jsonString json file for converting to POJO
     * @return ArrayList of POJO
     */
    public static ArrayList<PageMeta> getJsonCollection(String jsonString) {
        Gson gson = new Gson();
        Type collectionType = new TypeToken<ArrayList<PageMeta>>() {
        }.getType();
        return gson.fromJson(jsonString, collectionType);
    }
}
