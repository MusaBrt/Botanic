package me.koply.botanic.util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;

public class LightYml {

    private boolean Ok = true;

    private final HashMap<String, String> attributes = new HashMap<>();
    public LightYml(final InputStream fileInputStream) {
         try {
             final InputStreamReader isreader = new InputStreamReader(fileInputStream);
             final BufferedReader reader = new BufferedReader(isreader);

             String line;
             while ((line = reader.readLine()) != null) {
                String[] sided = line.split(":");
                attributes.put(sided[0].trim(), sided[1].trim());
             }

         } catch (Exception e) {
             e.printStackTrace();
             Ok = false;
         }
    }

    public HashMap<String, String> getAttributes() {
        return attributes;
    }

    public boolean isOk() {
        return Ok && attributes.containsKey("main");
    }
}