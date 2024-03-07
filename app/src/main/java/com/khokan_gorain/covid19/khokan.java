package com.khokan_gorain.covid19;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.khokan_gorain.covid19.R;

public class khokan extends AppCompatActivity {
    TextView textView;
    private static final int REQUEST_CALL = 1;
    private TextView tvcall;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_khokan);
        this.setTitle("Developer");
//        textView = (TextView) findViewById(R.id.googlelink);
//        textView.setMovementMethod(LinkMovementMethod.getInstance());
//        tvcall = findViewById(R.id.tvcall);

    }

//    public void call(View view) {
//        callButton();
//
//    }
//
//    private void callButton() {
//        String number = "6299013991";
//        if (number.trim().length() > 0) {
//            if (ContextCompat.checkSelfPermission(khokan.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
//                ActivityCompat.requestPermissions(khokan.this, new String[]{Manifest.permission.CALL_PHONE}, REQUEST_CALL);
//            } else {
//                String dial = "tel:" + number;
//                startActivity(new Intent(Intent.ACTION_CALL, Uri.parse(dial)));
//            }
//
//        }
//    }
//
//    @Override
//    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
//        if (requestCode == REQUEST_CALL) {
//            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
//                callButton();
//            } else {
//                Toast.makeText(this, "Permission Denied", Toast.LENGTH_SHORT).show();
//            }
//        }
//    }
//
//    public void img(View view) {
//        Toast.makeText(this, "Please click help line", Toast.LENGTH_SHORT).show();
//    }
}
