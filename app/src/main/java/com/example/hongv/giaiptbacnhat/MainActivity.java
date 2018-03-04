package com.example.hongv.giaiptbacnhat;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText txta;
    EditText txtb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        //getData();
    }
    //anh xa
    public void initView() {
        txta =(EditText) findViewById(R.id.so_a);
        txtb =(EditText) findViewById(R.id.so_b);
    }
//    //lay du lieu tu Result Activity
//    public void getData () {
//        Intent intent = getIntent();
//        Bundle bundle = intent.getBundleExtra("myPackageBack");
//        if (!bundle.isEmpty()) {
//            int a = bundle.getInt("key_aBack");
//            int b = bundle.getInt("key_bBack");
//            Toast toast = Toast.makeText(MainActivity.this, "Wellcome back to MainActivity ! Your last edit text: a = " + a + " b = " + b, Toast.LENGTH_SHORT);
//            toast.show();
//        }
//    }

    //xu ly su kien nut bam "Ket qua"
    public void doResult (View view) {
        //kiem tra da nhap so a chua
        if (txta.getText().length()==0) {
            Toast toast = Toast.makeText(MainActivity.this, "Chưa nhập số a", Toast.LENGTH_SHORT);
            toast.show();
            return;
        }
        //kiem tra da nhap so b chua
        if (txtb.getText().length()==0) {
            Toast toast = Toast.makeText(MainActivity.this, "Chưa nhập số b", Toast.LENGTH_SHORT);
            toast.show();
            return;
        }
        int a=0, b=0;
        //kiem tra so a dung format chua
        try {
            a = Integer.parseInt(txta.getText().toString());
            System.out.println(a);
        } catch (NumberFormatException e) {
            Toast toast = Toast.makeText(MainActivity.this, "Số a sai định dạng", Toast.LENGTH_SHORT);
            toast.show();
            return;
        }
        //kiem tra so b dung format chua
        try {
            b = Integer.parseInt(txtb.getText().toString());
            System.out.println(b);
        } catch (NumberFormatException e) {
            Toast toast = Toast.makeText(MainActivity.this, "Số b sai định dạng", Toast.LENGTH_SHORT);
            toast.show();
            return;
        }
        //gui du lieu qua ResultActivity
        Intent intent = new Intent(MainActivity.this, ResultActivity.class);
        Bundle bundle = new Bundle();
        bundle.putInt("key_a", a);
        bundle.putInt("key_b", b);
        intent.putExtra("myPackage", bundle);
        startActivity(intent);
    }
}
