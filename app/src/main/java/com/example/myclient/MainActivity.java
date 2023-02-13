package com.example.myclient;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.List;
import SepratePackage.aidlInterface;

public class MainActivity extends AppCompatActivity {
    aidlInterface aidlObject;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent aidlIntent = new Intent("connect_to_aidl_service");
        bindService(convertImplicitIntentToExplicitIntent(aidlIntent),serviceConnection,BIND_AUTO_CREATE);

    }
    public Intent convertImplicitIntentToExplicitIntent(Intent implicitIntent) {
        PackageManager packageManager = this.getPackageManager();
        List<ResolveInfo> resolveInfoList = packageManager.queryIntentServices( implicitIntent, 0);
        if (resolveInfoList == null || resolveInfoList.size() != 1) {
            return null;
        }
        ResolveInfo serviceInfo = resolveInfoList.get( 0 );
        ComponentName component = new ComponentName( serviceInfo.serviceInfo.packageName, serviceInfo.serviceInfo.name );
        Intent explicitIntent = new Intent( implicitIntent );
        explicitIntent.setComponent( component );
        return explicitIntent;
    }

        ServiceConnection serviceConnection =new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {

             aidlObject = aidlInterface.Stub.asInterface( iBinder);

        }
        @Override
        public void onServiceDisconnected(ComponentName componentName) {

        }
    };

        public void  add(View view) throws RemoteException {
            EditText text1 = findViewById(R.id.edt_enter_first_value);
            EditText text2 = findViewById(R.id.edt_enter_second_value);

            int value1 = Integer.parseInt(text1.getText().toString());
            int value2 = Integer.parseInt(text2.getText().toString());

            int result = aidlObject.add(value1,value2);
            TextView textview = findViewById(R.id.display_result);
            textview.setText(""+result);

        }
    public void  subtract(View view) throws RemoteException {
        EditText text1 = findViewById(R.id.edt_enter_first_value);
        EditText text2 = findViewById(R.id.edt_enter_second_value);

        int value1 = Integer.parseInt(text1.getText().toString());
        int value2 = Integer.parseInt(text2.getText().toString());

        int result = aidlObject.subtract(value1,value2);
        TextView textview = findViewById(R.id.display_result);
        textview.setText(""+result);


    }
    public void  multiplication(View view) throws RemoteException {
        EditText text1 = findViewById(R.id.edt_enter_first_value);
        EditText text2 = findViewById(R.id.edt_enter_second_value);

        int value1 = Integer.parseInt(text1.getText().toString());
        int value2 = Integer.parseInt(text2.getText().toString());

        int result = aidlObject.multiply(value1,value2);
        TextView textview = findViewById(R.id.display_result);
        textview.setText(""+result);

    }
    public void  division(View view) throws RemoteException {
        EditText text1 = findViewById(R.id.edt_enter_first_value);
        EditText text2 = findViewById(R.id.edt_enter_second_value);

        int value1 = Integer.parseInt(text1.getText().toString());
        int value2 = Integer.parseInt(text2.getText().toString());

        int result = aidlObject.division(value1,value2);
        TextView textview = findViewById(R.id.display_result);
        textview.setText(""+result);

    }
    public void  mod(View view) throws RemoteException {
        EditText text1 = findViewById(R.id.edt_enter_first_value);
        EditText text2 = findViewById(R.id.edt_enter_second_value);

        int value1 = Integer.parseInt(text1.getText().toString());
        int value2 = Integer.parseInt(text2.getText().toString());

        int result = aidlObject.modulus(value1,value2);
        TextView textview = findViewById(R.id.display_result);
        textview.setText(""+result);

    }
    public void  power(View view) throws RemoteException {
        EditText text1 = findViewById(R.id.edt_enter_first_value);
        EditText text2 = findViewById(R.id.edt_enter_second_value);

        int value1 = Integer.parseInt(text1.getText().toString());
        int value2 = Integer.parseInt(text2.getText().toString());

        int result = aidlObject.power(value1,value2);
        TextView textview = findViewById(R.id.display_result);
        textview.setText(""+result);

    }
}