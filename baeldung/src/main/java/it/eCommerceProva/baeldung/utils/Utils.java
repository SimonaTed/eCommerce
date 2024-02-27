package it.eCommerceProva.baeldung.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;



public class Utils {
	
	
	 public static byte[] readFileToByteArray(File file) throws IOException {
	        InputStream in = openInputStream(file);
	        Throwable var2 = null;

	        byte[] var5;
	        try {
	            long fileLength = file.length();
	            var5 = fileLength > 0L ? IOUtils.toByteArray(in, fileLength) : IOUtils.toByteArray(in);
	        } catch (Throwable var14) {
	            var2 = var14;
	            throw var14;
	        } finally {
	            if (in != null) {
	                if (var2 != null) {
	                    try {
	                        in.close();
	                    } catch (Throwable var13) {
	                        var2.addSuppressed(var13);
	                    }
	                } else {
	                    in.close();
	                }
	            }

	        }

	        return var5;
	    }
	
	 public static FileInputStream openInputStream(File file) throws IOException {
	        if (file.exists()) {
	            if (file.isDirectory()) {
	                throw new IOException("File '" + file + "' exists but is a directory");
	            } else if (!file.canRead()) {
	                throw new IOException("File '" + file + "' cannot be read");
	            } else {
	                return new FileInputStream(file);
	            }
	        } else {
	            throw new FileNotFoundException("File '" + file + "' does not exist");
	        }
	    }
	 
	 public static byte[] toByteArray(InputStream input, long size) throws IOException {
	        if (size > 2147483647L) {
	            throw new IllegalArgumentException("Size cannot be greater than Integer max value: " + size);
	        } else {
	            return toByteArray(input, (int)size);
	        }
	    }

}
