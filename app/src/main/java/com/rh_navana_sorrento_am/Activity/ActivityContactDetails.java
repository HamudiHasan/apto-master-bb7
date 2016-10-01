package com.rh_navana_sorrento_am.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.rh_navana_sorrento_am.R;

public class ActivityContactDetails extends AppCompatActivity {

    TextView name;
    TextView designation;
    TextView phone;
    TextView email;
    TextView address;
    TextView services;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_contact_details);

        name = (TextView) findViewById(R.id.tv_contact_person_name);
        designation = (TextView) findViewById(R.id.tv_person_designation);
        phone = (TextView) findViewById(R.id.tv_person_phone);
        email = (TextView) findViewById(R.id.tv_person_email);
        address = (TextView) findViewById(R.id.tv_person_address);
        services = (TextView) findViewById(R.id.tv_service_details);

        Bundle bundle = getIntent().getExtras();

        name.setText(bundle.getString("fullName"));
        designation.setText(bundle.getString("designation"));
        phone.setText(bundle.getString("mobile"));
        address.setText(bundle.getString("address"));
        services.setText(bundle.getString("responsibility"));
        email.setText(bundle.getString("emaiID"));
    }
}
