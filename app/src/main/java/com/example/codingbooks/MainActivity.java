package com.example.codingbooks;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.github.barteksc.pdfviewer.PDFView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    PDFView pdfView;
    View.OnClickListener clickListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycleview);
        ArrayList<Book> books = new ArrayList<>();

        books.add(new Book("JAVA", R.drawable.java, "https://www.africau.edu/images/default/sample.pdf"));
        books.add(new Book("JavaScript", R.drawable.javascript, "JavaScript.pdf"));
        books.add(new Book("JavaSript2", R.drawable.java_script2, "JavaScript2.pdf"));
        books.add(new Book("MATLAB", R.drawable.matlab, "Matlab.pdf"));
        books.add(new Book("Python", R.drawable.python , "Objective_C.pdf"));
        books.add(new Book("PHP", R.drawable.php, "PHP.pdf"));
        books.add(new Book("Objective_C", R.drawable.objective_c, "Python.pdf"));
        books.add(new Book("Swift", R.drawable.swift, "Swift.pdf"));


    BookAdapter adapter = new BookAdapter(this, books);

//        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(gridLayoutManager);

        recyclerView.setAdapter(adapter);

    }

}