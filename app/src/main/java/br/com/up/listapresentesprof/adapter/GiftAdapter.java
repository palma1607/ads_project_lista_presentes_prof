package br.com.up.listapresentesprof.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import br.com.up.listapresentesprof.R;
import br.com.up.listapresentesprof.model.Gift;

public class GiftAdapter extends
        RecyclerView.Adapter<GiftAdapter.GiftViewHolder>{

    private ArrayList<Gift> gifts;

    public GiftAdapter(ArrayList<Gift> gifts){
        this.gifts = gifts;
    }

    @NonNull
    @Override
    public GiftViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View layout = inflater.inflate(R.layout.view_item_gift, parent, false);
        return new GiftViewHolder(layout);
    }

    @Override
    public void onBindViewHolder(@NonNull GiftViewHolder holder,
                                 int position) {

        Gift gift = gifts.get(position);

        TextView textViewName = holder.itemView.findViewById(R.id.text_name);
        TextView textViewGift = holder.itemView.findViewById(R.id.text_gift);
        TextView textViewDescription = holder.itemView.findViewById(R.id.text_description);

        textViewName.setText(gift.getName());
        textViewGift.setText(gift.getGift());
        textViewDescription.setText(gift.getDescription());

    }

    @Override
    public int getItemCount() {
        return gifts.size();
    }

    public static class GiftViewHolder
            extends RecyclerView.ViewHolder{

        public GiftViewHolder(View view){
            super(view);
        }
    }
}
