package com.medicitadocter.doctor.model;

/**
 * Created by ubuntu on 26/6/17.
 */

public class DashBoardDoctorMenuModal {

    int id;

    public int getId() {
        return id;
    }

    public int getImgSrc() {
        return imgSrc;
    }

    public String getMenutital() {
        return menutital;
    }

    int imgSrc;
    String menutital;


    public DashBoardDoctorMenuModal(int id, int imgSrc, String menutital) {
        this.id = id;
        this.imgSrc = imgSrc;
        this.menutital = menutital;
    }
}
