package com.medicitadocter.patient.model;

/**
 * Created by ubuntu on 26/6/17.
 */

public class DashBoardPatientMenuModal {

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


    public DashBoardPatientMenuModal(int id, int imgSrc, String menutital) {
        this.id = id;
        this.imgSrc = imgSrc;
        this.menutital = menutital;
    }
}
