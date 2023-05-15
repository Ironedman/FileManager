package com.example.filemanager;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

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
        View view= LayoutInflater.from(context).inflate(R.layout.recycler_item,parent,false);
        return new Viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder holder, int position) {
        File selectedFile = filesAndFolders[position];
        holder.textView.setText(selectedFile.getName());

        if (selectedFile.isDirectory()){
            holder.imageView.setImageResource(R.drawable.baseline_folder_24);
        }else{
            holder.imageView.setImageResource(R.drawable.baseline_insert_drive_file_24);
        }
    }

    @Override
    public int getItemCount() {

        return filesAndFolders.length;
    }

    public class Viewholder extends RecyclerView.ViewHolder{

        TextView textView;
        ImageView imageView;

        public Viewholder(View itemView) {
            super(itemView);
            textView= itemView.findViewById(R.id.text_view);
            imageView= itemView.findViewById(R.id.icon_view);
        }
    }
}
