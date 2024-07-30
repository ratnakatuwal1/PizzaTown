package com.ratna.pizzatown;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

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
        backButton =  findViewById(R.id.buttonBack);
        confirmButton = findViewById(R.id.buttonConfirm);
        typeSpinner = findViewById(R.id.pizzaSize);
        quantitySpinner = findViewById(R.id.pizzaQuantity);
        registerForContextMenu(confirmButton);

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

        ArrayAdapter<String> adapter = new ArrayAdapter<>(OrderActivity.this, android.R.layout.simple_spinner_item, quantity);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        quantitySpinner.setAdapter(adapter);

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
            showPopUpMenu(view);
        });
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.confirm_context_menu, menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.single:
                typeSpinner.setSelection(0);
                quantitySpinner.setSelection(1);
                return true;

            case R.id.homeParty:
                typeSpinner.setSelection(2);
                quantitySpinner.setSelection(3);
                return true;

            case R.id.officeLunch:
                typeSpinner.setSelection(4);
                quantitySpinner.setSelection(2);
                return true;
        }
        return super.onContextItemSelected(item);
    }

    public void showPopUpMenu(View view) {
        PopupMenu popupMenu = new PopupMenu(OrderActivity.this, view);
        popupMenu.inflate(R.menu.confirm_popup_menu);
        popupMenu.setOnMenuItemClickListener(menuItem -> {
            switch (menuItem.getItemId()) {
                case R.id.dineIn:
                    Toast.makeText(OrderActivity.this, "Your order has been successfully placed food dine in", Toast.LENGTH_SHORT).show();
                    return true;
                case R.id.takeAway:
                    Toast.makeText(OrderActivity.this, "Your order has been successfully placed food take away", Toast.LENGTH_SHORT).show();
                    return true;
            }
            return false;
        });
        popupMenu.show();
    }

    void renderIngredients() {
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