package com.enigma.reimbursment.online.services;

import com.enigma.reimbursment.online.entities.AbstractEntity;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.*;

@Service
public class FileServiceImpl implements FileService{
    @Value("${application.data-dir}")
    private String dataDir;

    @Override
    public void upload(AbstractEntity entity, InputStream in) throws IOException {
        File dir = new File(dataDir,entity.getClass().getSimpleName().toLowerCase());
        if(!dir.exists()){
            dir.mkdirs();
        }

        File file = new File(dir, entity.getId().toString() +".png");
        try (OutputStream out = new FileOutputStream(file)) {
            byte[] data = new byte[8192];
            int length;
            while((length = in.read(data) ) > -1) {
                out.write(data,0, length);
            }

        }
    }

    @Override
    public void download(AbstractEntity entity, OutputStream out) throws IOException {
        File dir = new File(dataDir,entity.getClass().getSimpleName().toLowerCase());
        File file = new File(dir, entity.getId().toString()+".png");

        try (InputStream in = new FileInputStream(file)){
            int length;
            byte[] data = new byte[8192];
            while ((length = in.read(data)) > - 1) {
                out.write(data,0,length);
            }

        }
        out.close();
    }
}
