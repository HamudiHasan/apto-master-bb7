package com.rh_navana_sorrento_am.Activity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import com.rh_navana_sorrento_am.R;

public class ActivityEmergency extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emergency);
    }

    public void onImmediate(View view) {
        //
        showDialog();
    }

    public void onFire(View view) {
        Toast.makeText(ActivityEmergency.this, "Calling Emergency Fire Department", Toast.LENGTH_SHORT).show();
    }

    public void onAmbulance(View view) {
        Toast.makeText(ActivityEmergency.this, "Calling Emergency Ambulance Service", Toast.LENGTH_SHORT).show();
    }

    public void onPolice(View view) {
        Toast.makeText(ActivityEmergency.this, "Calling Emergency Police Department", Toast.LENGTH_SHORT).show();
    }

    public void onCaretaker(View view) {
        Toast.makeText(ActivityEmergency.this, "Calling Caretaker Emergency", Toast.LENGTH_SHORT).show();
    }

    public void showDialog() {
        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.layout_emergency_dialog);
        WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
        Window window = dialog.getWindow();
        lp.copyFrom(window.getAttributes());
        lp.width = WindowManager.LayoutParams.MATCH_PARENT;
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
        window.setAttributes(lp);


        Button popBtnCancel = (Button) dialog.findViewById(R.id.btn_emergency_cancel);
        Button popBtnOk = (Button) dialog.findViewById(R.id.btn_emergency_ok);


        popBtnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        popBtnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });


        if (dialog != null)
            dialog.show();
    }
}
