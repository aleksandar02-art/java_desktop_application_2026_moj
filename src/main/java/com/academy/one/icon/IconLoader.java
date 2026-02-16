package com.academy.one.icon;

import javax.swing.*;
import java.net.URL;

public class IconLoader {

    private final Class<?> clazz;

    public IconLoader(Class<?> clazz) {
        this.clazz = clazz;
    }

    public Icon loadIcon(String pathToIcon){
        ClassLoader classLoader = clazz.getClassLoader();
        URL url = classLoader.getResource(pathToIcon);
        if (url == null){
            System.err.println("Icon resource not found: " + pathToIcon);
            return null;
        }
        return new ImageIcon(url);
    }

}
