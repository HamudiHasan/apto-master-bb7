package com.rh_navana_sorrento_am.Adapter;

import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.rh_navana_sorrento_am.ModelClass.Notices;
import com.rh_navana_sorrento_am.ModelClass.Person;
import com.rh_navana_sorrento_am.R;

import java.util.List;
import java.util.Random;

/**

 */
public class NoticeAdapter extends RecyclerView.Adapter<NoticeAdapter.ViewHolder> {

    private List<Notices> notices;
    private Context context;

    public NoticeAdapter(List<Notices> notices, Context context) {
        this.notices = notices;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.notice_view, parent, false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {

       Notices notice = notices.get(position);
        holder.noticeHader.setText(notice.noticeTitle);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
          //  holder.layout.getBackground().setTint(Color.rgb(randInt(),randInt(),randInt()));
        }

        if(notice.noticeTitle.toString().length() > 0)
        holder.noticeFirst.setText(notice.noticeTitle.toString().toUpperCase().charAt(0) + "");
        holder.noticeDate.setText(notice.noticeTime);
        holder.noticeDetails.setText(notice.noticeDetails);

        holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(holder.noticeDetails.getVisibility()==View.GONE){

                    holder.noticeDetails.setVisibility(View.VISIBLE);

                }else if(holder.noticeDetails.getVisibility()==View.VISIBLE){
                    holder.noticeDetails.setVisibility(View.GONE);
                }
            }
        });
    }
    public  int randInt() {


        Random rn = new Random();
        int answer = rn.nextInt(255) ;

        return answer;
    }

    @Override
    public int getItemCount() {
        return notices.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView noticeHader;
        public TextView noticeDate;
        public TextView noticeFirst;
        public TextView noticeDetails;

        View layout;

        public ViewHolder(View itemView) {
            super(itemView);

            layout = itemView.findViewById(R.id.name_layout_notice);
            noticeHader = (TextView) itemView.findViewById(R.id.notice_view_notice_header);
            noticeDate = (TextView) itemView.findViewById(R.id.notice_view_notice_time);
            noticeDetails = (TextView) itemView.findViewById(R.id.notice_view_notice_details);
            noticeFirst = (TextView) itemView.findViewById(R.id.view_header_notice);

        }
    }
}
