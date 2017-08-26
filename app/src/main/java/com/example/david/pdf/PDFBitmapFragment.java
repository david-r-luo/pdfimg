package com.example.david.pdf;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.github.barteksc.pdfviewer.PDFView;

import java.io.File;

/**
 * Created by David on 7/10/2017.
 */

public class PDFBitmapFragment extends Fragment {
    PDFView pdfView;
    Bitmap bitmap;
    File file;
    File file2;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pdfbitmap, container, false);
        pdfView = (PDFView) view.findViewById(R.id.viewPDF);
        ImageView img = (ImageView) view.findViewById(R.id.imageView);
        img.bringToFront();


        file = new File(Environment.getExternalStorageDirectory() + "/img.pdf");
        file2 = new File(Environment.getExternalStorageDirectory() + "/functional.pdf");
        loadPage1();



        return view;
    }

    public void loadPage1() {
        pdfView.fromFile(file).pages(1).load();
    }

    public void loadPage2() {
        pdfView.fromFile(file).pages(2).load();
    }

    public void loadPage3() {
        pdfView.fromFile(file2).pages(18).load();
    }

    public void loadPage4() {
        pdfView.fromFile(file2).pages(15).load();
    }

    public void loadPage5() {
        pdfView.fromFile(file2).pages(9).load();
    }





    public static Bitmap loadBitmapFromView(View v) {
        int w = v.getWidth();
        int h = v.getHeight();
        Bitmap b = Bitmap.createBitmap( w, h, Bitmap.Config.ARGB_8888);
        Canvas c = new Canvas(b);
        v.layout(0, 0, w, h);
        v.draw(c);
        return b;
    }

    public static Bitmap getBitmapFromView(View view) {
        //Define a bitmap with the same size as the view
        Bitmap returnedBitmap = Bitmap.createBitmap(200, 200,Bitmap.Config.ARGB_8888);
        //Bind a canvas to it
        Canvas canvas = new Canvas(returnedBitmap);
        //Get the view's background
        Drawable bgDrawable =view.getBackground();
        if (bgDrawable!=null) {
            //has background drawable, then draw it on the canvas
            bgDrawable.draw(canvas);
        } else {
            //does not have background drawable, then draw white background on the canvas
            canvas.drawColor(Color.BLACK);
        }
        // draw the view on the canvas
        view.draw(canvas);
        //return the bitmap
        return returnedBitmap;
    }

//    public Bitmap yetAnother(View v) {
//        Bitmap bitmap = Bitmap.createBitmap(300, 300,
//                Bitmap.Config.ARGB_8888);
//        Canvas canvas = new Canvas(bitmap);
//        v.draw(canvas);
//
//        return bitmap;
//    }


//    public static Bitmap takeScreenShot(View view) {
//
//        view.setDrawingCacheEnabled(true);
//
//        view.measure(MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED),
//                MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED));
//        view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
//
//        view.buildDrawingCache();
//
//        if(view.getDrawingCache() == null) return null;
//
//        Bitmap snapshot = Bitmap.createBitmap(view.getDrawingCache());
//        view.setDrawingCacheEnabled(false);
//
//        return snapshot;
//    }

}
