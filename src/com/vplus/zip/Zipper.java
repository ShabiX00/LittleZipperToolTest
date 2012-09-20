package com.vplus.zip;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.file.Path;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * @author vplus
 */
public class Zipper {
    private final int BUFFER;
    
    public Zipper() {
        BUFFER = 2048;
    }
    
    public void zip(File file, String name, String src) {
        FileOutputStream dest;
        try {
            
            dest = new FileOutputStream(name + ".zip");
            BufferedOutputStream bdest = new BufferedOutputStream(dest);
            ZipOutputStream out = new ZipOutputStream(bdest);
            byte data[] = new byte[BUFFER];
            File f = new File(".");
            String files[] = f.list();
            for (int i=0; i < files.length; i++) {
                if (files[i].contains(".") && !files[i].equals(name + ".zip")) {
                System.out.println("Adding: " + files[i]);
                FileInputStream fi = new FileInputStream(files[i]);
                BufferedInputStream origin = new BufferedInputStream(fi, BUFFER);
                ZipEntry entry = new ZipEntry(files[i]);
                out.putNextEntry(entry);
                int count;
                while((count = origin.read(data, 0, 
                    BUFFER)) != -1) {
                    out.write(data, 0, count);
                }
                origin.close();
                }
             }
             out.close();
        } catch (Exception ex) {
            Logger.getLogger(Zipper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
