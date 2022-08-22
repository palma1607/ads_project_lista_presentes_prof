package br.com.up.listapresentesprof;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import br.com.up.listapresentesprof.model.Gift;
import br.com.up.listapresentesprof.repository.GiftRepository;

public class AddGiftActivity extends AppCompatActivity {

    private TextInputLayout inputLayoutGift;
    private TextInputLayout inputLayoutName;
    private TextInputLayout inputLayoutDescription;

    private TextInputEditText inputTextGift;
    private TextInputEditText inputTextName;
    private TextInputEditText inputTextDescription;

    private Button buttonAddGift;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_gift);

        inputLayoutGift = findViewById(R.id.input_layout_gift);
        inputLayoutName = findViewById(R.id.input_layout_name);
        inputLayoutDescription = findViewById(R.id.input_layout_description);

        inputTextGift = findViewById(R.id.input_text_gift);
        inputTextName = findViewById(R.id.input_text_name);
        inputTextDescription = findViewById(R.id.input_text_description);

        buttonAddGift = findViewById(R.id.button_add_gift);

        buttonAddGift.setOnClickListener(
                new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveGift();
            }
        });
    }

    private void saveGift(){

        String giftName = inputTextGift.getText().toString();
        String name = inputTextName.getText().toString();
        String description = inputTextDescription.getText().toString();

        if(giftName.isEmpty()){
            inputLayoutGift
                    .setError("Favor inserir o presente");
            return;
        }

        if(name.isEmpty()){
            inputLayoutName
                    .setError("Favor inserir o nome");
            return;
        }

        Gift gift = new Gift(
                giftName,
                name,
                description
        );

        GiftRepository.getInstance().save(gift);
    }
}