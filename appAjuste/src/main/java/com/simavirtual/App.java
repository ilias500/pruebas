package com.simavirtual;

import java.io.*;

import co.simasoft.utils.*;

/**
 * Hello world!
 *
*/

public class App{

    private static String fileJar = "g.jar";

    public static void fileJarPrueba( String farchivo, String directory, String fileJar ) throws IOException {

       java.util.jar.JarFile jar = new java.util.jar.JarFile(fileJar);
       java.util.Enumeration otra = jar.entries();

       java.io.File f = new java.io.File(directory+farchivo);
       java.util.jar.JarEntry file = new java.util.jar.JarEntry(directory);

       while (otra.hasMoreElements()) {

         java.util.jar.JarEntry sfile = (java.util.jar.JarEntry) otra.nextElement();
         java.io.File ff  = new java.io.File(directory + sfile.getName());
         java.io.File fff = new java.io.File(directory + farchivo );

         if (ff.getName().equals(farchivo)){
            file = sfile;
            f = fff;
            System.out.println(directory+f.getName());
            break;
         }
       } // while

       java.io.InputStream is = jar.getInputStream(file); // get the input stream
       java.io.FileOutputStream fos = new java.io.FileOutputStream(f);

       while (is.available() > 0) {  // write contents of 'is' to 'fos'
          fos.write(is.read());
       }

       fos.close();
       is.close();

    }

    public static void main( String[] args ) throws IOException {
        System.out.println( "Hello World!" );

        Utils.mkDirs("hola.src.main.resources");

        Utils.fileJar("logo.jpg","hola\\src\\main\\resources\\",fileJar);

        fileJarPrueba("poma.xml","hola\\src\\main\\resources\\",fileJar);



    } // main

} // App
