package com.example.codingbooks;

import androidx.appcompat.app.AppCompatActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import android.annotation.SuppressLint;
import android.app.DownloadManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.widget.Toast;

import com.github.barteksc.pdfviewer.PDFView;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;

public class PdfActivity extends AppCompatActivity {

    PDFView pdfview;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf);

        pdfview = findViewById(R.id.pdfview);

        Intent intent = getIntent();
        String link = intent.getStringExtra("gs://codingbooks-54103.appspot.com");

        downloadPdf(link);
    }

    private void downloadPdf(String pdfUrl) {
        DownloadManager.Request request = new DownloadManager.Request(Uri.parse(pdfUrl));
        request.setTitle("Downloading PDF");
        request.setDescription("Please wait while the PDF is being downloaded");
        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
        request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, "sample.pdf");

        DownloadManager downloadManager = (DownloadManager) getSystemService(DOWNLOAD_SERVICE);
        long downloadId = downloadManager.enqueue(request);

        // Listen for download completion
        registerReceiver(onComplete, new IntentFilter(DownloadManager.ACTION_DOWNLOAD_COMPLETE));
    }

    private BroadcastReceiver onComplete = new BroadcastReceiver() {
        public void onReceive(Context ctxt, Intent intent) {
            // PDF download is complete; you can now open the downloaded file.
            String filePath = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS) + "/sample.pdf";
            Toast.makeText(ctxt, "WORKING", Toast.LENGTH_SHORT).show();
            loadPdfFromUri(filePath);

            // Unregister the receiver to avoid memory leaks
            unregisterReceiver(this);
        }
    };

    //    private void loadPdfFromAsset(String link) {
//        Toast.makeText(this, "Working", Toast.LENGTH_SHORT).show();
//        pdfview.fromAsset(link).load();
//    }
    private void loadPdfFromUri(String link) {
        Toast.makeText(this, link, Toast.LENGTH_SHORT).show();
        pdfview.fromUri(Uri.parse("file://" + link)).load();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // Unregister the receiver in case the activity is destroyed before download completion
        unregisterReceiver(onComplete);
    }

}
