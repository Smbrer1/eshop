package com.example.eshop;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;


public class Cart extends AppCompatActivity {

    public void buy(View view) {
        Snackbar mySnackbar = Snackbar.make(view, "Our manager will contact you soon", 10000);
        mySnackbar.show();

    }



    public static class Product {
        public final String name;
        public final int price;
        public int amount = 0;

        public Product(String name, String price) {
            this.name = name;
            StringBuilder sb = new StringBuilder(price);
            price = sb.deleteCharAt(sb.length() - 1).toString();

            this.price = Integer.parseInt(price);  this.amount += 1;
        }

        public void add() {
            this.amount += 1;
        }

        public void remove() {
            this.amount -= 1;
        }

        public String getName() {
            return name;
        }
    }

    static ArrayList<Product> ProductList = new ArrayList<>();

    public static void addToCart(String name, String price) {
        AtomicBoolean nameFlag = new AtomicBoolean(false);
        if (ProductList.size()!=0) {
            ProductList.forEach(product -> {
                if (Objects.equals(name, product.getName())) {
                    product.add();
                    nameFlag.set(true);
                }
            });

        }
        if (ProductList.size()==0 || !nameFlag.get()) {
            ProductList.add(new Product(name, price));
        }
    }


    public void deleteAll(View view){
        if (ProductList != null) {
            ProductList.removeAll(ProductList);
            this.recreate();
        }
    }
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
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cart);
        setSupportActionBar(findViewById(R.id.openMenu));

        LinearLayout lin = findViewById(R.id.cartlayout);
        lin.removeAllViews();
        if (ProductList != null) {
            AtomicInteger total = new AtomicInteger();
            ProductList.forEach((product) -> {
                TextView txtName = new TextView(Cart.this);
                txtName.setId(ProductList.size());
                String str = "Product: " + product.name + "                    Price: " + product.price + "$                 Amount: " + product.amount;
                txtName.setText(str);
                lin.addView(txtName);
                total.addAndGet(product.price * product.amount);

            });
            TextView totalPrice = findViewById(R.id.totalPrice);
            totalPrice.append(total.toString());
        }
    }
}