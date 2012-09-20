package com.vplus;

import com.vplus.zip.Zipper;
import java.io.File;
/**
 *
 * @author Valentin
 */
public class Demo {
    public static void main(String[] args) {
        File f = new File(".");
        Zipper zi = new Zipper();
        zi.zip(f, "myZipFile", "C:/book/Generic_User_Guide.pdf");
    }
}
