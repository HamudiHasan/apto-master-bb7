package com.rh_navana_sorrento_am.Activity;

import android.nfc.Tag;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.activeandroid.query.Select;
import com.google.firebase.iid.FirebaseInstanceId;
import com.rh_navana_sorrento_am.Adapter.NoticeAdapter;
import com.rh_navana_sorrento_am.Adapter.RecyleAdapter;
import com.rh_navana_sorrento_am.ModelClass.Notices;
import com.rh_navana_sorrento_am.ModelClass.Person;
import com.rh_navana_sorrento_am.R;

import java.util.ArrayList;
import java.util.List;

public class ActivityNotice extends AppCompatActivity {
    private List<Notices> notices = new ArrayList<Notices>();
    private static final String TAG = "ActivityNotice";
    RecyclerView recyclerView;
    NoticeAdapter noticeAdapter;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notice);

        addNotice();

        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String token = FirebaseInstanceId.getInstance().getToken();
                Log.d(TAG, "Token :" + token);
                Toast.makeText(ActivityNotice.this, token, Toast.LENGTH_SHORT).show();
            }
        });
        recyclerView = (RecyclerView) findViewById(R.id.rv_notices);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setItemAnimator(new DefaultItemAnimator());


        noticeAdapter = new NoticeAdapter(notices, getApplicationContext());
        recyclerView.setAdapter(noticeAdapter);
    }

    private void addNotice() {

        // AA get all data from db
        List<Notices> noticesList = new Select().from(Notices.class).execute();
        notices.addAll(noticesList);
    }
}
