package com.simavirtual;

import java.io.*;
import java.util.jar.JarFile;
import java.util.jar.JarEntry;
import java.util.Enumeration;

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

System.out.println( "sfile ="+sfile );

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

    /**
     * This method will copy a file from inside a jar to an specified
     * directory(Tested only in Windows).
     *
     * @param sourcePath Path combined with the desired file to be found
     *                   inside the jar. Use '/' as path separator. If it
     *                   is null, it will be omitted.
     * @param desiredFile File required to copy from jar. Without extra
     *                    folders, in that case use sourcePath parameter.
     * @param outputFolder Directory where file(s) will be located. Use
     *                     '\\' for path separator.
     * @param jarFile Jar file name from which the desired file will be copied.
     */
    public static void copyFileFromJar(String sourcePath,
                                       String desiredFile,
                                       String outputFolder,
                                       String jarFile) throws IOException {

        // -------------- Validation PHASE -------------- //
        if (sourcePath == null) {
            sourcePath = "";
        }
        if (desiredFile == null || desiredFile.isEmpty()) {
            System.out.println("\nERROR: The desired file String is null/empty.");
            return;
        }
        if (desiredFile.split("/").length > 1) {
            System.out.println("\nERROR: Better to use the file path, with the sourcePath parameter, leave only the filename.");
            return;
        }
        if (outputFolder == null || outputFolder.isEmpty()) {
            System.out.println("\nERROR: The output folder String is null/empty.");
            return;
        }
        if (jarFile == null || jarFile.isEmpty()) {
            System.out.println("\nERROR: The jar file String is null/empty.");
            return;
        }

        File      copiedFile              = null;
        boolean   foundFlag               = false;
        JarEntry  jarEntryForOutputFolder = null;

        JarFile jar             = new JarFile(jarFile);
        Enumeration jarEntries  = jar.entries();

        while (jarEntries.hasMoreElements()) {

            // For files related to jar entries
            JarEntry jarEntryFileName = (JarEntry) jarEntries.nextElement();

            System.out.println("sfile = " + jarEntryFileName); // SHOW ME: FILES AND FOLDERS

            // Res = A resource that can be a File/Folder
            File path_AvailableRes = new File(outputFolder + jarEntryFileName.getName());
            File path_DesiredRes = new File(outputFolder + desiredFile);

            if (jarEntryFileName.toString().equals(sourcePath +"/"+ desiredFile)) {

                jarEntryForOutputFolder = jarEntryFileName;
                copiedFile = path_DesiredRes;

                System.out.println(outputFolder +desiredFile);

                foundFlag = true;
                break;
            } // end : if

        } // end : while

        if (!foundFlag) {
            System.out.println("ERROR: Not possible to find " + sourcePath + desiredFile + " inside the jar.\n");
            return;
        }

        // If case they don't exist, create new folders.                   //
        new File(outputFolder).mkdirs();

        // Proceed to copy the file //
        InputStream is = jar.getInputStream(jarEntryForOutputFolder);
        FileOutputStream fos = new FileOutputStream(copiedFile);

        while (is.available() > 0) {
            fos.write(is.read());
        }

        fos.flush();
        fos.close();
        is.close();
    } // end : copyFileFromJar Method


    public static void main( String[] args ) throws IOException {
        System.out.println( "Hello World!" );

        Utils.mkDirs("hola.src.main.resources");

        Utils.fileJar("logo.jpg","hola\\src\\main\\resources\\",fileJar);

        fileJarPrueba("pom.xml","hola\\src\\main\\resources\\",fileJar);

        copyFileFromJar("4","master.asciidoc", "hola\\src\\main\\resources\\", fileJar);





    } // main

} // App
