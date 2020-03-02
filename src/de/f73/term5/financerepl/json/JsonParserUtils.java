package de.f73.term5.financerepl.json;

import java.util.Map;
import java.util.StringTokenizer;

public class JsonParserUtils {

    public static Map<String, Object> parseFromString(String jsonString) {

        System.out.println("Test");
        jsonString = jsonString.replace(" ", "");


        StringTokenizer stringTokenizer = new StringTokenizer(jsonString);
        stringTokenizer.nextToken("{");
        String s = stringTokenizer.nextToken(":");

        return null;
    }
}
