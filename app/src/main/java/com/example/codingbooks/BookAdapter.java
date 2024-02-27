package com.example.codingbooks;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.github.barteksc.pdfviewer.PDFView;

import java.util.ArrayList;

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.BookViewHolder> {


    Context context;
    ArrayList<Book> books;


    public BookAdapter(Context context, ArrayList<Book> books) {
        this.context = context;
        this.books = books;
    }

    //    ADAPTER METHODS


    @NonNull
    @Override
    public BookViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.sample, parent, false);
        return new BookViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BookViewHolder holder, int position) {

        Book book = books.get(position);
        holder.coverimage.setImageResource(book.getCoverimage());
        holder.booktitle.setText(book.getBooktitle());
        holder.itemView.setOnClickListener(view -> {
            Intent intent = new Intent(context, PdfActivity.class);
            intent.putExtra("gs://codingbooks-54103.appspot.com", book.getLink()); //Optional parameters
            context.startActivity(intent);
        });

    }

    @Override
    public int getItemCount() {

        return books.size();
    }


    //   VIEW HOLDER
    public class BookViewHolder extends RecyclerView.ViewHolder {

        ImageView coverimage;
        TextView booktitle;

        public BookViewHolder(@NonNull View itemView) {
            super(itemView);

            coverimage = itemView.findViewById(R.id.coverimage);
            booktitle = itemView.findViewById(R.id.booktitle);


        }


    }
}
