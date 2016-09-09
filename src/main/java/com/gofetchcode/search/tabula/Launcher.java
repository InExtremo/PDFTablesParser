package com.gofetchcode.search.tabula;

import com.gofetchcode.search.tabula.utils.TableParserUtils;
import com.google.gson.JsonSyntaxException;

import java.io.IOException;


/**
 * Main launcher.
 */
public class Launcher {

    /**
     * Launch method.
     *
     * @param args need 2 params: 1) Path to PDF file 2) json object as string
     * @throws IllegalArgumentException if args is null
     * @throws IOException              if cant read file
     * @throws JsonSyntaxException      if json is not valid
     */
    public static void main(String[] args) {
        String json = "";
        if (args.length == 0) {
            throw new IllegalArgumentException("wrong args");
        }
        try {
            json = TableParserUtils.getHtmlFromJson(args[0], args[1]);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(json);
    }
}
