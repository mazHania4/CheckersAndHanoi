package com.ipc1.cah.utilities.file_management;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SerializationManager {

    private String src;

    public SerializationManager(String src){
        this.src = src;
    }

    public void writeSerialization(Serializable instance, String name) throws FileNotFoundException{
        ObjectOutputStream tmp = null;
        try {
            tmp = new ObjectOutputStream( new FileOutputStream(src + name + ".bin") );
            tmp.writeObject(instance);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                tmp.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public Serializable readSerialization(String name) throws IOException, ClassNotFoundException{
        ObjectInputStream tm = new ObjectInputStream( new FileInputStream(src + name + ".bin") );
        Serializable tmp = (Serializable) tm.readObject();
        tm.close();
        return tmp;
    }
    
    
}
