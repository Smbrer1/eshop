package com.example.eshop;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class HomeActivity extends AppCompatActivity {


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
                Intent intent_pho = new Intent(getApplicationContext(), Phones.class);
                startActivity(intent_pho);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setSupportActionBar(findViewById(R.id.openMenu));
    }
}