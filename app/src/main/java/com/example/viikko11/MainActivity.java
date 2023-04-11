package com.example.viikko11;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Collections;
import java.util.Comparator;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private Storage storage;
    TextView NameInput;
    ImageView imageSortTime, imageSortAlpha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        storage = Storage.getInstance();


        recyclerView = findViewById(R.id.rvShoppingList);
        imageSortAlpha = findViewById(R.id.imageSortAlpha);
        imageSortTime = findViewById(R.id.imageSortTime);

        NameInput = findViewById(R.id.txtItemInput);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new ItemListAdapter(getApplicationContext(), storage.getItems()));
    }

    public void addItem(View view) {
        int id = storage.getItems().size();
        storage.getItems().add(new Item(NameInput.getText().toString(), id));
        int position = storage.getItems().size() - 1;
        recyclerView.getAdapter().notifyItemInserted(position);
        recyclerView.scrollToPosition(position);
    }

    public void sortAlpha(View view) {
        Collections.sort(Storage.getInstance().getItems());
        recyclerView.getAdapter().notifyDataSetChanged();
    }

    public void sortByTime(View view){
        Storage.getInstance().getItems().sort(Comparator.comparing(Item::getId));
        recyclerView.getAdapter().notifyDataSetChanged();
    }

}
