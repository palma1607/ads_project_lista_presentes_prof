package br.com.up.listapresentesprof.repository;

import java.util.ArrayList;

import br.com.up.listapresentesprof.model.Gift;

public class GiftRepository {

    private static GiftRepository giftRepository;

    public static GiftRepository getInstance(){
        if(giftRepository == null){
            giftRepository = new GiftRepository();
        }
        return giftRepository;
    }

    private GiftRepository(){ }

    public Gift getByIndex(int index){

    }
    public ArrayList<Gift> get(){

    }
    public void save(Gift gift){

    }
    public void delete(Gift gift){

    }

}
