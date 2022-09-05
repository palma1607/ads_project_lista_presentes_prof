package br.com.up.listapresentesprof.repository;

import java.util.ArrayList;

import br.com.up.listapresentesprof.model.Gift;

public class GiftRepository {

    private static GiftRepository giftRepository;

    private ArrayList<Gift> gifts = new ArrayList<>();

    public static GiftRepository getInstance(){
        if(giftRepository == null){
            giftRepository = new GiftRepository();
        }
        return giftRepository;
    }

    private GiftRepository(){ }

    public Gift getByIndex(int index){
        return gifts.get(index);
    }
    public ArrayList<Gift> get(){
        return gifts;
    }
    public void save(Gift gift){
        gifts.add(gift);
    }
    public void delete(Gift gift){
        gifts.remove(gift);
    }
    public void update(int index, Gift gift){
        gifts.set(index,gift);
    }
}
