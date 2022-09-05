package br.com.up.listapresentesprof;

import androidx.appcompat.app.AppCompatActivity;
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

        recyclerViewGifts.setAdapter(new GiftAdapter());

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

        if(gifts.isEmpty()){

        }
    }
}