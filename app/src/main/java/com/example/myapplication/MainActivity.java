package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText etp,etd,eta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
    }

    private  void findViews(){
        etp = (EditText) findViewById(R.id.editText);
        etd = (EditText) findViewById(R.id.editText2);
        eta = (EditText) findViewById(R.id.editText3);
    }

    private boolean isValid(EditText editText){
        String pattern = "1[0]{2}|[0-9]{1,2}";
        String text = editText.getText().toString();
        if(!text.matches(pattern)){
            editText.setError("0~100");
            return false;
        }
        else{
            return true;
        }
    }

    public void onSubmitClick(View view){
        boolean isValid = isValid(etp) & isValid(etd) & isValid(eta);
        if(!isValid){
            return;
        }
        int p = Integer.parseInt(etp.getText().toString());
        int d = Integer.parseInt(etd.getText().toString());
        int a = Integer.parseInt(eta.getText().toString());
        Intent intent = new Intent(MainActivity.this,page2.class);
        Bundle bundle = new Bundle();
        bundle.putInt("programming",p);
        bundle.putInt("dataStructure",d);
        bundle.putInt("algorithm",a);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}
