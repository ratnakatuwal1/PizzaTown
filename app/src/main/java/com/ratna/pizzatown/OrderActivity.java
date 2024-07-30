package com.ratna.pizzatown;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class OrderActivity extends AppCompatActivity {
    TextView cheeseText, mushroomText, tomatoText, oliveText, basilText, pineappleText;
    Button backButton, confirmButton;
    Intent intent;
    String[] quantity = {"one", "two", "three", "four", "five"};
    Spinner typeSpinner, quantitySpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_order);
        cheeseText = findViewById(R.id.textCheese);
        mushroomText = findViewById(R.id.textMushroom);
        tomatoText = findViewById(R.id.textTomato);
        oliveText = findViewById(R.id.textOlive);
        basilText = findViewById(R.id.textBasil);
        pineappleText = findViewById(R.id.textPineapple);
        backButton.findViewById(R.id.buttonBack);
        confirmButton.findViewById(R.id.buttonConfirm);
        typeSpinner = findViewById(R.id.pizzaType);
        quantitySpinner = findViewById(R.id.pizzaQuantity);


        typeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String type = parent.getItemAtPosition(position).toString();
                Toast.makeText(OrderActivity.this, type, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        ArrayAdapter adpater = new ArrayAdapter(OrderActivity.this, android.R.layout.simple_spinner_item, quantity);
        adpater.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        quantitySpinner.setAdapter(adpater);

        quantitySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String type = parent.getItemAtPosition(position).toString();
                Toast.makeText(OrderActivity.this, type, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        renderIngredients();

        backButton.setOnClickListener(view -> {
            finish();
        });

        confirmButton.setOnClickListener(view -> {
            // code here for popup menu
        });
    }

    private void renderIngredients() {
        intent = getIntent();
        boolean isCheese = intent.getBooleanExtra("cheese", false);
        if (isCheese) {
            cheeseText.setVisibility(View.VISIBLE);
        }
        boolean isMushroom = intent.getBooleanExtra("mushroom", false);

        if (isMushroom) {
            mushroomText.setVisibility(View.VISIBLE);
        }
        boolean isTomato = intent.getBooleanExtra("tomato", false);

        if (isTomato) {
            tomatoText.setVisibility(View.VISIBLE);
        }
        boolean isOlive = intent.getBooleanExtra("olive", false);

        if (isOlive) {
            oliveText.setVisibility(View.VISIBLE);
        }
        boolean isBasil = intent.getBooleanExtra("basil", false);

        if (isBasil) {
            basilText.setVisibility(View.VISIBLE);
        }
        boolean isPineapple = intent.getBooleanExtra("pineapple", false);

        if (isPineapple) {
            pineappleText.setVisibility(View.VISIBLE);
        }
    }
}