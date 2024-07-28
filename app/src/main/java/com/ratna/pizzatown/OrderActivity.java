package com.ratna.pizzatown;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class OrderActivity extends AppCompatActivity {
    TextView cheeseText, mushroomText, tomatoText, oliveText, basilText, pineappleText;
    Button backButton, confirmButton;
    Intent intent;

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