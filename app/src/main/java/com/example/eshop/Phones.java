package com.example.eshop;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


public class Phones extends AppCompatActivity{

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.toptoolbar, menu);
        return true;

    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item){


        switch (item.getItemId())
        {
            case R.id.cart:
                Intent intent_cart = new Intent(getApplicationContext(), Cart.class);
                startActivity(intent_cart);
                break;
            case R.id.laptops:
                Intent intent_lap = new Intent(getApplicationContext(), Laptops.class);
                startActivity(intent_lap);
                break;
            case R.id.consoles:
                Intent intent_con = new Intent(getApplicationContext(), Consoles.class);
                startActivity(intent_con);
                break;
            case R.id.phones:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.phones);
        setSupportActionBar(findViewById(R.id.openMenu));
    }
}