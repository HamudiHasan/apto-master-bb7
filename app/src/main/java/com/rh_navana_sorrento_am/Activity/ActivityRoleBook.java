package com.rh_navana_sorrento_am.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.rh_navana_sorrento_am.R;

public class ActivityRoleBook extends AppCompatActivity {

    View visibal,hidden;
    ImageButton imageButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_role_book);

        visibal = findViewById(R.id.layout_rules);
        hidden = findViewById(R.id.layout_hidden);

        imageButton = (ImageButton) findViewById(R.id.ib_rule_toggle);

        visibal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(hidden.getVisibility()==View.GONE){
                    imageButton.setImageResource(R.drawable.ic_rule_visible);
                    hidden.setVisibility(View.VISIBLE);
                }


                else if(hidden.getVisibility()==View.VISIBLE){
                    imageButton.setImageResource(R.drawable.ic_rule_gone);
                    hidden.setVisibility(View.GONE);
                }

            }
        });
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(hidden.getVisibility()==View.GONE){
                    imageButton.setImageResource(R.drawable.ic_rule_visible);
                    hidden.setVisibility(View.VISIBLE);
                }


                else if(hidden.getVisibility()==View.VISIBLE){
                    imageButton.setImageResource(R.drawable.ic_rule_gone);
                    hidden.setVisibility(View.GONE);
                }

            }
        });
    }
}
