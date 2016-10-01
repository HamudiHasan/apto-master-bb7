package com.rh_navana_sorrento_am.ModelClass;

/**
 * Created by hhson on 7/3/2016.
 */
public class Person {

    public Person() {
    }

    public  String type;
    public  String fullName;
    public  String designation;
    public  String address;
    public  String mobile;
    public  String emaiID;
    public  String responsibility;
    public  String dutyHours;
    public  String serviceDetail;

    public Person(String type, String fullName, String designation, String address, String mobile,
                  String emaiID, String responsibility, String dutyHours, String serviceDetail) {
        this.type = type;
        this.fullName = fullName;
        this.designation = designation;
        this.address = address;
        this.mobile = mobile;
        this.emaiID = emaiID;
        this.responsibility = responsibility;
        this.dutyHours = dutyHours;
        this.serviceDetail = serviceDetail;
    }
}
