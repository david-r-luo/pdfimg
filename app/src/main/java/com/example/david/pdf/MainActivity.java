package com.example.david.pdf;

import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.CountDownTimer;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;

public class MainActivity extends AppCompatActivity {

    FragmentManager manager;

    PDFView view;

    Bitmap conventional;
    Bitmap dti;

    Bitmap graphs;
    Bitmap functional;
    Bitmap loreta;

    Bitmap img1;
    Bitmap img2;
    Bitmap img3;
    Bitmap img4;
    Bitmap img5;
    Bitmap img6;

    Bitmap img7;
    Bitmap img8;
    Bitmap img9;
    Bitmap img10;
    Bitmap img11;
    Bitmap img12;

    private boolean permissionToReadAccepted = false;
    private String[] permissionRead = {"android.permission.READ_EXTERNAL_STORAGE"};
    PDFBitmapFragment frag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        int requestCode = 200;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            requestPermissions(permissionRead, requestCode);
        }

        manager = getSupportFragmentManager();


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loadBitmap1();


    }

    public void loadBitmap1() {
        frag = new PDFBitmapFragment();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.mainActivity, frag);
        transaction.commit();

        final CountDownTimer timer2 = new CountDownTimer(1000, 1000) {
            @Override
            public void onTick(long l) {}
            @Override
            public void onFinish() {
                dti = frag.loadBitmapFromView(frag.pdfView);
                cropImagesA2();
//                startImageView();
                //TODO
                loadBitmap2();
            }
        };


        new CountDownTimer(1000, 1000) {
            @Override
            public void onTick(long l) {}
            @Override
            public void onFinish() {
                conventional = frag.loadBitmapFromView(frag.pdfView);
                cropImagesA1();
                frag.loadPage2();
                timer2.start();
            }
        }.start();

    }

    public void cropImagesA1() {
        img1 = Bitmap.createBitmap(conventional, 329, 139, 122, 142);
        img2 = Bitmap.createBitmap(conventional, 82, 139, 122, 142);
        img3 = Bitmap.createBitmap(conventional, 330, 452, 122, 142);
        img4 = Bitmap.createBitmap(conventional, 204, 452, 122, 142);

    }

    public void cropImagesA2() {
        img5 = Bitmap.createBitmap(dti, 199, 419, 122, 142);
        img6 = Bitmap.createBitmap(dti, 320, 419, 122, 142);

    }

    public void loadBitmap2() {
        frag.loadPage3();
        final CountDownTimer timer3 = new CountDownTimer(1000, 1000) {
            @Override
            public void onTick(long l) {}
            @Override
            public void onFinish() {
                loreta = frag.loadBitmapFromView(frag.pdfView);
                cropImagesB3();
                startImageView2();
            }
        };

        final CountDownTimer timer2 = new CountDownTimer(1000, 1000) {
            @Override
            public void onTick(long l) {}
            @Override
            public void onFinish() {
                functional = frag.loadBitmapFromView(frag.pdfView);
                cropImagesB2();
                frag.loadPage5();
                timer3.start();
            }
        };


        new CountDownTimer(1000, 1000) {
            @Override
            public void onTick(long l) {}
            @Override
            public void onFinish() {
                graphs = frag.loadBitmapFromView(frag.pdfView);
                cropImagesB1();
                frag.loadPage4();
                timer2.start();
            }
        }.start();

    }

    public void cropImagesB1() {
        img7 = Bitmap.createBitmap(graphs, 132, 226, 222, 179);
        img8 = Bitmap.createBitmap(graphs, 127, 505, 235, 137);

    }

    public void cropImagesB2() {
        img9 = Bitmap.createBitmap(functional, 114, 164, 135, 148);
        img10 = Bitmap.createBitmap(functional, 249, 164, 135, 148);

    }

    public void cropImagesB3() {
        img11 = Bitmap.createBitmap(loreta, 70, 89, 190, 195);
        img12 = Bitmap.createBitmap(loreta, 265, 116, 230, 171);

    }





    public void startImageView1() {
        AnatomicalBitmapFragment frag = new AnatomicalBitmapFragment();
        frag.getBitmap1(img1, img2, img3, img4, img5, img6);
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.mainActivity, frag);
        transaction.commit();
    }

    public void startImageView2() {
        AnatomicalBitmapFragment frag = new AnatomicalBitmapFragment();
        frag.getBitmap2(img7, img8, img9, img10, img11, img12);
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.mainActivity, frag);
        transaction.commit();
    }





//        view.fromAsset("facility anatomical imaging.pdf").load();
//        new RetrievePDFStream().execute("http://ancestralauthor.com/download/sample.pdf");




//    class RetrievePDFStream extends AsyncTask<String, Void, InputStream> {
//
//        @Override
//        protected InputStream doInBackground(String... strings) {
//            InputStream inputStream = null;
//
//
//            try {
//                URL url = new URL(strings[0]);
//                HttpURLConnection urlConnection = (HttpURLConnection)url.openConnection();
//                if (urlConnection.getResponseCode() == 200) {
//                    inputStream = new BufferedInputStream(urlConnection.getInputStream());
//                }
//            } catch (IOException e) {
//                return null;
//            }
//            return inputStream;
//
//
//
//
//        }
//
//        @Override
//        protected void onPostExecute(InputStream inputStream) {
//            super.onPostExecute(inputStream);
//            view.fromStream(inputStream).load();
//        }
//    }



    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode){
            case 200:
                permissionToReadAccepted  = grantResults[0] == PackageManager.PERMISSION_GRANTED;
                break;
        }
        if (!permissionToReadAccepted ) MainActivity.super.finish();

    }


}
