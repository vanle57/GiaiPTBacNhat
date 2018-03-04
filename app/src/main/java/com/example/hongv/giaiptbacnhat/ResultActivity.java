package com.example.hongv.giaiptbacnhat;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {
    TextView txtResult;
    int a=0, b=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        initView();
        getData();
    }
    //anh xa
    public void initView() {
        txtResult = (TextView) findViewById(R.id.result_tv);
    }
    //lay du lieu tu Main Activity
    public void getData () {
        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra("myPackage");
        a = bundle.getInt("key_a");
        b = bundle.getInt("key_b");
        giaiPTBacNhat(a, b);
    }
    //giai phuong trinh bac 1
    private void giaiPTBacNhat(int a, int b) {
        if (a==0) {
            if (b!=0) {
                txtResult.setText("Phuong trinh vo nghiem");
                return;
            }
            else {
                txtResult.setText("Phuong trinh vo so nghiem");
                return;
            }
        }
        else  {
            float c = -b/a;
            System.out.println(c);
            txtResult.setText(Float.toString(c));
            return;
        }
    }
    //xu ly su kien nut bam "Quay lai"
    public  void doBack (View view) {
//        Intent intent = new Intent(ResultActivity.this, MainActivity.class);
//        Bundle bundle = new Bundle();
//        bundle.putInt("key_aBack", a);
//        bundle.putInt("key_bBack", b);
//        intent.putExtra("myPackageBack", bundle);
//        startActivity(intent);
        finish();
    }
}
