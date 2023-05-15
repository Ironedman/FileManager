package com.example.filemanager;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.io.File;

public class myadapter extends RecyclerView.Adapter<myadapter.Viewholder>{

    Context context;
    File[] filesAndFolders;

    public myadapter(Context context, File[] fileAndFolders){
        this.context = context;
        this.filesAndFolders = fileAndFolders;
    }


    @Override
    public Viewholder onCreateViewHolder( ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class Viewholder extends RecyclerView.ViewHolder{

        public Viewholder(View itemView) {
            super(itemView);
        }
    }
}
