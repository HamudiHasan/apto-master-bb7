package com.rh_navana_sorrento_am.ModelClass;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

/**
 * Created by hhson on 7/3/2016.
 */

@Table(name = "Notices")
public class Notices extends Model {

    @Column(name = "noticeTitle")
    public String noticeTitle;

    @Column(name = "noticeTime")
    public String noticeTime;

    @Column(name = "noticeDetails")
    public String noticeDetails;

    public Notices() {
    }

    public Notices(String noticeTitle, String noticeTime, String noticeDetails) {
        this.noticeTitle = noticeTitle;
        this.noticeTime = noticeTime;
        this.noticeDetails = noticeDetails;
    }
}
