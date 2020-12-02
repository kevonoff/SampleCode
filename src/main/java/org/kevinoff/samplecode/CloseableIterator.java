/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.kevinoff.samplecode;

import com.fasterxml.jackson.core.JsonProcessingException;
import java.io.Closeable;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author kevin.off
 * @param <T> The type of object that next is supposed to return
 */
public interface CloseableIterator<T> extends Closeable{

    public boolean hasNext();
    public T next() throws IOException, JsonProcessingException;
    public List<T> toList()throws IOException, JsonProcessingException;
    
}
