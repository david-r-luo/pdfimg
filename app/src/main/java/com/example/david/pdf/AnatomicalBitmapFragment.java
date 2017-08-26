package com.example.david.pdf;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * Created by David on 7/10/2017.
 */

public class AnatomicalBitmapFragment extends Fragment {
    Bitmap bm1;
    Bitmap bm2;
    Bitmap bm3;
    Bitmap bm4;
    Bitmap bm5;
    Bitmap bm6;

    Bitmap bm7;
    Bitmap bm8;
    Bitmap bm9;
    Bitmap bm10;
    Bitmap bm11;
    Bitmap bm12;

    ImageView image1;
    ImageView image2;
    ImageView image3;
    ImageView image4;
    ImageView image5;
    ImageView image6;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_anatomical, container, false);
        image1 = (ImageView) view.findViewById(R.id.pdfImage);
        image2 = (ImageView) view.findViewById(R.id.pdfImage2);
        image3 = (ImageView) view.findViewById(R.id.pdfImage3);
        image4 = (ImageView) view.findViewById(R.id.pdfImage4);
        image5 = (ImageView) view.findViewById(R.id.pdfImage5);
        image6 = (ImageView) view.findViewById(R.id.pdfImage6);


        setImages2();


        return view;
    }

    public void getBitmap1(Bitmap b1, Bitmap b2, Bitmap b3, Bitmap b4, Bitmap b5, Bitmap b6) {
        bm1 = b1;
        bm2 = b2;
        bm3 = b3;
        bm4 = b4;
        bm5 = b5;
        bm6 = b6;

    }

    public void getBitmap2(Bitmap b1, Bitmap b2, Bitmap b3, Bitmap b4, Bitmap b5, Bitmap b6) {
        bm7 = b1;
        bm8 = b2;
        bm9 = b3;
        bm10 = b4;
        bm11 = b5;
        bm12 = b6;

    }

    public void setImages1() {
        image1.setImageBitmap(bm1);
        image2.setImageBitmap(bm2);
        image3.setImageBitmap(bm3);
        image4.setImageBitmap(bm4);
        image5.setImageBitmap(bm5);
        image6.setImageBitmap(bm6);
    }

    public void setImages2() {
        image1.setImageBitmap(bm7);
        image2.setImageBitmap(bm8);
        image3.setImageBitmap(bm9);
        image4.setImageBitmap(bm10);
        image5.setImageBitmap(bm11);
        image6.setImageBitmap(bm12);
    }
}
