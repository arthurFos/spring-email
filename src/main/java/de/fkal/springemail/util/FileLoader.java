package de.fkal.springemail.util;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public class FileLoader {
    private final static String VELOCITY_DOC_NAME = "velocity-templates";
    private final static String SLASH = "/";
    public static  File getFileFromResources(String filename) {
        File file = null;
        try {
            String url = VELOCITY_DOC_NAME + SLASH + filename;
            String filePath = FileLoader.class.getClassLoader().getResource(url).getFile();
            String decodedUrl = URLDecoder.decode(filePath, "UTF-8");
            file = new File(decodedUrl);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return file;
    }
}
