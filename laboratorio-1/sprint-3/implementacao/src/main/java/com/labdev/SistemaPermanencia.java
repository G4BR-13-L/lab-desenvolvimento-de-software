package com.labdev;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SistemaPermanencia<Type> {
    private final List<Type> items;
    private final String nomeArquivo;

    public SistemaPermanencia(String nomeArquivo) {
        this.items = new ArrayList<>();
        this.nomeArquivo = nomeArquivo;
    }

    public void carregar() {
        try {
            var fileInputStream = new FileInputStream(this.nomeArquivo);
            var objectInputStream = new ObjectInputStream(fileInputStream);

            Object object;
            while ((object = objectInputStream.readObject()) != null) {
                this.items.add((Type) object);
            }

            objectInputStream.close();
            fileInputStream.close();
        } catch (EOFException e) {
            System.out.println("Dados carregados com sucesso!");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void adicionar(Type item) {
        this.items.add(item);
    }

    public List<Type> getItems() {
        return items;
    }

    public void salvar() {
        try {
            var fileOutputStream = new FileOutputStream(this.nomeArquivo);
            var objectOutputStream = new ObjectOutputStream(fileOutputStream);

            for(var item : this.items)
                objectOutputStream.writeObject(item);

            objectOutputStream.close();
            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
