package com.ratna.pizzatown;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

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
            Intent intent = new Intent(this, OrderActivity.class);
            intent.putExtra("cheese", isCheeseChecked);
            intent.putExtra("mushroom", isMushroomChecked);
            intent.putExtra("tomato", isTomatoChecked);
            intent.putExtra("olive", isOliveChecked);
            intent.putExtra("basil", isBasilChecked);
            intent.putExtra("pineapple", isPineappleChecked);
            startActivity(intent);
        });
    }

    public Boolean OnCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.firstmenu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.magarita:
                cheeseCheckBox.setSelected(true);
                tomatoCheckBox.setSelected(true);
                basilCheckBox.setSelected(true);

                pineappleCheckBox.setSelected(false);
                oliveCheckBox.setSelected(false);
                mushroomCheckBox.setSelected(false);
                return true;

                case R.id.mushroom:
                    cheeseCheckBox.setSelected(true);
                    tomatoCheckBox.setSelected(true);
                    basilCheckBox.setSelected(false);

                    pineappleCheckBox.setSelected(false);
                    oliveCheckBox.setSelected(true);
                    mushroomCheckBox.setSelected(true);
                    return true;

                    case R.id.newyork:
                        cheeseCheckBox.setSelected(true);
                        tomatoCheckBox.setSelected(true);
                        basilCheckBox.setSelected(true);

                        pineappleCheckBox.setSelected(true);
                        oliveCheckBox.setSelected(true);
                        mushroomCheckBox.setSelected(true);
                        return true;

                        default:
                        return super.onOptionsItemSelected(item);
        }

    }
}