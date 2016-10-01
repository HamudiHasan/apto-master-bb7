package com.rh_navana_sorrento_am.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.rh_navana_sorrento_am.R;

public class ActivityMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    public void onNotice(View view) {
        startActivity(new Intent(ActivityMenu.this,ActivityNotice.class));
    }

    public void onServiceCharges(View view) {
        startActivity(new Intent(ActivityMenu.this,ActivityServiceCharges.class));
    }

    public void onPhonebook(View view) {
        startActivity(new Intent(ActivityMenu.this,ActivityPhonebook.class));
    }

    public void onRulesBook(View view) {
        startActivity(new Intent(ActivityMenu.this,ActivityRoleBook.class));
    }

    public void onServicePerson(View view) {
        startActivity(new Intent(ActivityMenu.this,ActivityServicePerson.class));
    }

    public void onDevelopment(View view) {
        startActivity(new Intent(ActivityMenu.this,ActivityDevelopment.class));
    }

    public void onEmergency(View view) {
        startActivity(new Intent(ActivityMenu.this,ActivityEmergency.class));
    }

    public void onWhoWeAre(View view) {
        startActivity(new Intent(ActivityMenu.this,ActivityWhoWeAre.class));
    }
}
