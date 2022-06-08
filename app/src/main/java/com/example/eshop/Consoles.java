package com.example.eshop;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewParent;
import android.widget.AbsoluteLayout;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;


public class Consoles extends AppCompatActivity {
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.toptoolbar, menu);
        return true;

    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {


        switch (item.getItemId()) {
            case R.id.cart:
                Intent intent_cart = new Intent(getApplicationContext(), Cart.class);
                startActivity(intent_cart);
                break;
            case R.id.laptops:
                Intent intent_lap = new Intent(getApplicationContext(), Laptops.class);
                startActivity(intent_lap);
                break;
            case R.id.consoles:
                break;
            case R.id.phones:
                Intent intent_pho = new Intent(getApplicationContext(), Phones.class);
                startActivity(intent_pho);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    public void addToCartConsole(View view) {
        String idString = view.getResources().getResourceEntryName(view.getId());
        String nameId = "ctitle" + idString.charAt(1);
        String priceId = "cprice" + idString.charAt(1);
        TextView name = findViewById(
                getResources().getIdentifier(nameId,
                "id", getPackageName()));
        TextView price = findViewById(
                getResources().getIdentifier(priceId,
                        "id", getPackageName()));
        String strName = name.getText().toString();
        String strPrice = price.getText().toString();
        Cart.addToCart(strName, strPrice);
    }


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.consoles);
        setSupportActionBar(findViewById(R.id.openMenu));
    }
}