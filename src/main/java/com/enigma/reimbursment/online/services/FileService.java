package com.enigma.reimbursment.online.services;

import com.enigma.reimbursment.online.entities.AbstractEntity;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;


public interface FileService {
   void upload (AbstractEntity<?> entity, InputStream in) throws IOException;
   void download (AbstractEntity<?> entity, OutputStream out) throws IOException;
}
