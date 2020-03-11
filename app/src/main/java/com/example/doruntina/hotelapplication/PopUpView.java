package com.example.doruntina.hotelapplication;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.SimpleDateFormat;

import androidmads.library.qrgenearator.QRGContents;
import androidmads.library.qrgenearator.QRGEncoder;

/**
 * Created by Doruntina on 3/10/2020.
 */

public class PopUpView extends Activity{

    Bitmap bmp;
    QRGEncoder qrgEncoder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.popupview);

        ImageView qrImage = (ImageView) findViewById(R.id.imgQrCode);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int x = dm.widthPixels;
        int y = dm.heightPixels;

        getWindow().setLayout((int)(x*.8),(int)(y*.8));

        String encodedText = "www.tripadvisor.com";
        int smallDims;
        WindowManager manager = (WindowManager)getSystemService(WINDOW_SERVICE);
        Display display = manager.getDefaultDisplay();
        Point point = new Point();
        display.getSize(point);
        int w = point.x;
        int h = point.y;
        int smallDim = w<h ? w:h;
        smallDims=smallDim*3/4;



        qrgEncoder = new QRGEncoder(encodedText ,null, QRGContents.Type.TEXT,smallDims);

        try {
            bmp = qrgEncoder.getBitmap();
            qrImage.setImageBitmap(bmp);
        }
        catch (Exception e) {

        }


    }
}
