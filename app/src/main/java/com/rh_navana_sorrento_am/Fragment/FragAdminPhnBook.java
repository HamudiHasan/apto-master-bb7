package com.rh_navana_sorrento_am.Fragment;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.rh_navana_sorrento_am.Activity.ActivityContactDetails;
import com.rh_navana_sorrento_am.Activity.ActivityPhonebook;
import com.rh_navana_sorrento_am.Adapter.RecyleAdapter;
import com.rh_navana_sorrento_am.ModelClass.Person;
import com.rh_navana_sorrento_am.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hhson on 1/13/2016.
 */
public class FragAdminPhnBook extends Fragment {

    private List<Person> persons = new ArrayList<Person>();
    RecyleAdapter adapter;
    RecyclerView recyclerView;

    TextView textView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addItems();

    }

    private void addItems() {

/*        Person(String type, String fullName, String designation, String address, String mobile,
                String emaiID, String responsibility, String dutyHours, String serviceDetail) */
        persons.add(new Person("Admin", "Adil Nowshad", "Admin", "12/3 Dhanmondi", "8801715072281",
                "Adil@nh.rh.com", "H", "Hasan", "Dhaka"));

        persons.add(new Person("Admin", "Rokib Hasan", "Admin", "12/3 Dhanmondi", "8807286731182",
                "rokibhasan@nh.rh.com", "H", "Hasan", "Dhaka"));

        persons.add(new Person("Admin", "Tamim Hasan", "Admin", "12/3 Dhanmondi", "8801715072231",
                "Tamim@nh.rh.com", "H", "Hasan", "Dhaka"));

        persons.add(new Person("Admin", "Proloy Dev", "Admin", "12/3 Rampura", "8801715072231",
                "Proloy@nh.rh.com", "H", "Hasan", "Dhaka"));


    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_phone_book_admin, container, false);
        if (v != null) {

            textView = (TextView) v.findViewById(R.id.tv_hint_text);

            recyclerView = (RecyclerView) v.findViewById(R.id.rv_pb_admin);
            recyclerView.setLayoutManager(new LinearLayoutManager(v.getContext()));
            recyclerView.setItemAnimator(new DefaultItemAnimator());


            adapter = new RecyleAdapter(persons, v.getContext());
            recyclerView.setAdapter(adapter);

            recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
                @Override
                public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                    //super.onScrolled(recyclerView, dx, dy);
                    Person person = persons.get(recyclerView.getScrollState());
                    textView.setText(person.fullName.toString().toUpperCase().charAt(0) + "");
                }
            });


            recyclerView.addOnItemTouchListener(new RecyclerTouchListener(v.getContext(), recyclerView, new ClickListener() {
                @Override
                public void onClick(View view, int position) {

                    Person person = persons.get(position);
                    Intent intent = new Intent(view.getContext(), ActivityContactDetails.class);
                    intent.putExtra("fullName", person.fullName);
                    intent.putExtra("designation", person.designation);
                    intent.putExtra("mobile", person.mobile);
                    intent.putExtra("address", person.address);
                    intent.putExtra("responsibility", person.responsibility);
                    intent.putExtra("emaiID", person.emaiID);
                    startActivity(intent);

                }

                @Override
                public void onLongClick(View view, int position) {

                }
            }));

        }
        return v;
    }

    public interface ClickListener {
        void onClick(View view, int position);

        void onLongClick(View view, int position);
    }

    public static class RecyclerTouchListener implements RecyclerView.OnItemTouchListener {

        private GestureDetector gestureDetector;
        private FragAdminPhnBook.ClickListener clickListener;

        public RecyclerTouchListener(Context context, final RecyclerView recyclerView, final FragAdminPhnBook.ClickListener clickListener) {
            this.clickListener = clickListener;
            gestureDetector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() {
                @Override
                public boolean onSingleTapUp(MotionEvent e) {
                    return true;
                }

                @Override
                public void onLongPress(MotionEvent e) {
                    View child = recyclerView.findChildViewUnder(e.getX(), e.getY());
                    if (child != null && clickListener != null) {
                        clickListener.onLongClick(child, recyclerView.getChildPosition(child));
                    }
                }
            });
        }

        @Override
        public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {

            View child = rv.findChildViewUnder(e.getX(), e.getY());
            if (child != null && clickListener != null && gestureDetector.onTouchEvent(e)) {
                clickListener.onClick(child, rv.getChildPosition(child));
            }
            return false;
        }

        @Override
        public void onTouchEvent(RecyclerView rv, MotionEvent e) {
        }

        @Override
        public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    public void onResume() {
        super.onResume();

    }


    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getContext().getSystemService(getActivity().CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }


}
