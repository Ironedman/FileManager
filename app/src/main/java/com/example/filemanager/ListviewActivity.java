package com.example.filemanager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.io.File;

public class ListviewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);

        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        TextView noFilesText = findViewById(R.id.noFile);

        String path = getIntent().getStringExtra("path");

        File root = new File(path);
        File[] filesAndFolders = root.listFiles();

        if(filesAndFolders == null || filesAndFolders.length == 0){
            noFilesText.setVisibility(View.VISIBLE);
            return;
        }
        noFilesText.setVisibility(View.VISIBLE);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new myadapter(getApplicationContext(),filesAndFolders));

    }
}