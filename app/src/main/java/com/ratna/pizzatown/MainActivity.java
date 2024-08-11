package com.ratna.pizzatown;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.MenuBuilder;

public class MainActivity extends AppCompatActivity {
    ImageView cheeseImage, mushroomImage, tomatoImage, oliveImage, basilImage, pineappleImage;
    CheckBox cheeseCheckBox, mushroomCheckBox, tomatoCheckBox, oliveCheckBox, basilCheckBox, pineappleCheckBox;
    Button orderButton;
    boolean isCheeseChecked = false, isMushroomChecked = false, isTomatoChecked = false, isOliveChecked = false, isBasilChecked = false, isPineappleChecked = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        cheeseImage = findViewById(R.id.cheese);
        mushroomImage = findViewById(R.id.mushroom);
        tomatoImage = findViewById(R.id.tomato);
        oliveImage = findViewById(R.id.olive);
        basilImage = findViewById(R.id.basil);
        pineappleImage = findViewById(R.id.pineapple);
        cheeseCheckBox = findViewById(R.id.checkCheese);
        mushroomCheckBox = findViewById(R.id.checkMushroom);
        tomatoCheckBox = findViewById(R.id.checkTomato);
        oliveCheckBox = findViewById(R.id.checkOlive);
        basilCheckBox = findViewById(R.id.checkBasil);
        pineappleCheckBox = findViewById(R.id.checkPineapple);
        orderButton = findViewById(R.id.proceed);

        cheeseCheckBox.setOnCheckedChangeListener((compoundButton, isChecked) -> {
            isCheeseChecked = isChecked;
            if (isChecked) {
                cheeseImage.setVisibility(View.VISIBLE);
            } else {
                cheeseImage.setVisibility(View.GONE);
            }
        });

        mushroomCheckBox.setOnCheckedChangeListener((compoundButton, isChecked) -> {
            isMushroomChecked = isChecked;
            if (isChecked) {
                mushroomImage.setVisibility(View.VISIBLE);
            } else {
                mushroomImage.setVisibility(View.GONE);
            }
        });

        tomatoCheckBox.setOnCheckedChangeListener((compoundButton, isChecked) -> {
            isTomatoChecked = isChecked;
            if (isChecked) {
                tomatoImage.setVisibility(View.VISIBLE);
            } else {
                tomatoImage.setVisibility(View.GONE);
            }
        });

        oliveCheckBox.setOnCheckedChangeListener((compoundButton, isChecked) -> {
            isOliveChecked = isChecked;
            if (isChecked) {
                oliveImage.setVisibility(View.VISIBLE);
            } else {
                oliveImage.setVisibility(View.GONE);
            }
        });

        basilCheckBox.setOnCheckedChangeListener((compoundButton, isChecked) -> {
            isBasilChecked = isChecked;
            if (isChecked) {
                basilImage.setVisibility(View.VISIBLE);
            } else {
                basilImage.setVisibility(View.GONE);
            }
        });

        pineappleCheckBox.setOnCheckedChangeListener((compoundButton, isChecked) -> {
            isPineappleChecked = isChecked;
            if (isChecked) {
                pineappleImage.setVisibility(View.VISIBLE);
            } else {
                pineappleImage.setVisibility(View.GONE);
            }
        });

        orderButton.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, OrderActivity.class);
            intent.putExtra("cheese", isCheeseChecked);
            intent.putExtra("mushroom", isMushroomChecked);
            intent.putExtra("tomato", isTomatoChecked);
            intent.putExtra("olive", isOliveChecked);
            intent.putExtra("basil", isBasilChecked);
            intent.putExtra("pineapple", isPineappleChecked);
            startActivity(intent);
        });
    }
    @SuppressLint("RestrictedApi")
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if (menu instanceof  MenuBuilder){
           MenuBuilder menuBuilder = (MenuBuilder) menu;
           menuBuilder.setOptionalIconsVisible(true);
        }

        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.option_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.margarita:
                cheeseCheckBox.setChecked(true);
                tomatoCheckBox.setChecked(true);
                basilCheckBox.setChecked(true);
                pineappleCheckBox.setChecked(false);
                oliveCheckBox.setChecked(false);
                mushroomCheckBox.setChecked(false);
                return true;

            case R.id.mushroom:
                cheeseCheckBox.setChecked(true);
                tomatoCheckBox.setChecked(true);
                basilCheckBox.setChecked(false);
                pineappleCheckBox.setChecked(false);
                oliveCheckBox.setChecked(true);
                mushroomCheckBox.setChecked(true);
                return true;

            case R.id.newyork:
                cheeseCheckBox.setChecked(true);
                tomatoCheckBox.setChecked(true);
                basilCheckBox.setChecked(true);
                pineappleCheckBox.setChecked(true);
                oliveCheckBox.setChecked(true);
                mushroomCheckBox.setChecked(true);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}