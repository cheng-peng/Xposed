package com.cxp.xposed;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void clickLis(View view) {
        Toast.makeText(this, toastMessage(), Toast.LENGTH_SHORT).show();
    }

    private String toastMessage(){
        return "我未被劫持";
    }
}
