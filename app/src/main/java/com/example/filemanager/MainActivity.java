package com.example.filemanager;

import static android.Manifest.permission.WRITE_EXTERNAL_STORAGE;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MaterialButton storageBtn = findViewById(R.id.storage_btn);

        storageBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               if (checKPermission()){
                   Intent intent = new Intent(MainActivity.this, ListviewActivity.class);
                   String path = Environment.getExternalStorageDirectory().getPath();
                   intent.putExtra("path",path);
                   startActivity(intent);
                   //permision granted(punya izin)
               }else {
                   requestPermission();
                   //minta izin terus
               }
            }

        });

    }

    public boolean checKPermission() {
        int result = ContextCompat.checkSelfPermission(MainActivity.this, WRITE_EXTERNAL_STORAGE);
        if (result == PackageManager.PERMISSION_GRANTED){
            return true;
        } else
            return false;
    }

    private void requestPermission(){
        if(ActivityCompat.shouldShowRequestPermissionRationale(MainActivity.this, WRITE_EXTERNAL_STORAGE)){
            Toast.makeText(MainActivity.this, "storage permission is required", Toast.LENGTH_SHORT).show();
        }else
        ActivityCompat.requestPermissions(MainActivity.this,new String[] {WRITE_EXTERNAL_STORAGE},111);
    }
}