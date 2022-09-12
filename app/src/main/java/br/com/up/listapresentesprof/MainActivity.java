package br.com.up.listapresentesprof;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.TextureView;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

import br.com.up.listapresentesprof.adapter.GiftAdapter;
import br.com.up.listapresentesprof.model.Gift;
import br.com.up.listapresentesprof.repository.GiftRepository;

public class MainActivity extends AppCompatActivity {

    private FloatingActionButton buttonAddGift;
    private RecyclerView recyclerViewGifts;
    private TextView textViewGiftsNotFound;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerViewGifts = findViewById(R.id.recycler_gifts);
        textViewGiftsNotFound = findViewById(R.id.text_gifts_not_found);

        recyclerViewGifts.setLayoutManager(
                //new GridLayoutManager(this,10)
                new LinearLayoutManager(this)
        );

        buttonAddGift = findViewById(R.id.button_add);
        buttonAddGift.setOnClickListener(
                new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(
                        getApplicationContext(),
                        AddGiftActivity.class
                );
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        ArrayList<Gift> gifts = GiftRepository.getInstance().get();
        if(gifts.size() > 0){
            textViewGiftsNotFound.setVisibility(View.INVISIBLE);
        }else{
            textViewGiftsNotFound.setVisibility(View.VISIBLE);
        }
        GiftAdapter giftAdapter = new GiftAdapter(gifts);
        recyclerViewGifts.setAdapter(giftAdapter);
    }
}