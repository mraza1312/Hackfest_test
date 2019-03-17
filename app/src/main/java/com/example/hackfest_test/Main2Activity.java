package com.example.hackfest_test;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {


  Button scan,delete;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        scan=findViewById(R.id.scan);
        delete=findViewById(R.id.delete);
        scan.setOnClickListener(newclicklistner);
        delete.setOnClickListener(newdelete);

    }

    private View.OnClickListener newclicklistner=new View.OnClickListener(){

      @Override public void onClick(View v) {
          Intent intent=new Intent(getApplicationContext(),MainActivity.class);
          startActivity(intent);
      }
    };

    private View.OnClickListener newdelete= new View.OnClickListener() {
      @Override public void onClick(View v) {
         final String address = "20:15:10:29:02:90";
        BluetoothThread btt;
        Handler writeHandler;

        btt = new BluetoothThread(address, new Handler() {

          @Override
          public void handleMessage(Message message) {


            for(int a=0;a<100000;a++);
            Toast.makeText(getApplicationContext(),"Connected",Toast.LENGTH_LONG).show();

          }
        });

        // Get the handler that is used to send messages
        writeHandler = btt.getWriteHandler();

        // Run the thread
        btt.start();

        String data = "g";
        Message msg = Message.obtain();
        msg.obj = data;
        writeHandler.sendMessage(msg);
      }
    };
}
