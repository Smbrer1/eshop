package com.example.eshop;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


public class Laptops extends AppCompatActivity {
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

    public void addToCartLaptop(View view) {
        String idString = view.getResources().getResourceEntryName(view.getId());
        String nameId = "ltitle" + idString.charAt(1);
        String priceId = "lprice" + idString.charAt(1);
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
        setContentView(R.layout.laptops);
        setSupportActionBar(findViewById(R.id.openMenu));
    }
}
