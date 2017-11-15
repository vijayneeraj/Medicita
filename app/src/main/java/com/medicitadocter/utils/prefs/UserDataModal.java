package com.medicitadocter.utils.prefs;

/**
 * Created by br on 27/7/17.
 */

public class UserDataModal {

    //SIGNIN
    String LOGINAS = "";
    String LOGIN_EMAIL = "";
    String LOGIN_PASSWORD = "";
    boolean KEEP_ME_SIGNED_IN = false;

    //JOIN
    boolean REGISTER_GROUP = false;
    boolean REGISTER_INDIVIDUAL = false;
    String SIGNUPAS = "";
    String SIGNUP_EMAIL = "";
    String SIGNUP_PASSWORD = "";
    String SIGNUP_CONFIRM_PASSWORD = "";
    String SIGNUP_FIRST_NAME = "";
    String SIGNUP_LAST_NAME = "";
    String SIGNUP_DOB_MM_DD_YYYY = "";
    String SIGNUP_SEX = "";


    //Getter
    public String getLOGINAS() {
        return LOGINAS;
    }

    public String getLOGIN_EMAIL() {
        return LOGIN_EMAIL;
    }

    public String getLOGIN_PASSWORD() {
        return LOGIN_PASSWORD;
    }

    public boolean isKEEP_ME_SIGNED_IN() {
        return KEEP_ME_SIGNED_IN;
    }

    public boolean isREGISTER_GROUP() {
        return REGISTER_GROUP;
    }

    public boolean isREGISTER_INDIVIDUAL() {
        return REGISTER_INDIVIDUAL;
    }

    public String getSIGNUPAS() {
        return SIGNUPAS;
    }

    public String getSIGNUP_EMAIL() {
        return SIGNUP_EMAIL;
    }

    public String getSIGNUP_PASSWORD() {
        return SIGNUP_PASSWORD;
    }

    public String getSIGNUP_CONFIRM_PASSWORD() {
        return SIGNUP_CONFIRM_PASSWORD;
    }

    public String getSIGNUP_FIRST_NAME() {
        return SIGNUP_FIRST_NAME;
    }

    public String getSIGNUP_LAST_NAME() {
        return SIGNUP_LAST_NAME;
    }

    public String getSIGNUP_DOB_MM_DD_YYYY() {
        return SIGNUP_DOB_MM_DD_YYYY;
    }

    public String getSIGNUP_SEX() {
        return SIGNUP_SEX;
    }



    //Setter
    public void setLOGINAS(String LOGINAS) {
        this.LOGINAS = LOGINAS;
    }

    public void setLOGIN_EMAIL(String LOGIN_EMAIL) {
        this.LOGIN_EMAIL = LOGIN_EMAIL;
    }

    public void setLOGIN_PASSWORD(String LOGIN_PASSWORD) {
        this.LOGIN_PASSWORD = LOGIN_PASSWORD;
    }

    public void setKEEP_ME_SIGNED_IN(boolean KEEP_ME_SIGNED_IN) {
        this.KEEP_ME_SIGNED_IN = KEEP_ME_SIGNED_IN;
    }

    public void setREGISTER_GROUP(boolean REGISTER_GROUP) {
        this.REGISTER_GROUP = REGISTER_GROUP;
    }

    public void setREGISTER_INDIVIDUAL(boolean REGISTER_INDIVIDUAL) {
        this.REGISTER_INDIVIDUAL = REGISTER_INDIVIDUAL;
    }

    public void setSIGNUPAS(String SIGNUPAS) {
        this.SIGNUPAS = SIGNUPAS;
    }

    public void setSIGNUP_EMAIL(String SIGNUP_EMAIL) {
        this.SIGNUP_EMAIL = SIGNUP_EMAIL;
    }

    public void setSIGNUP_PASSWORD(String SIGNUP_PASSWORD) {
        this.SIGNUP_PASSWORD = SIGNUP_PASSWORD;
    }

    public void setSIGNUP_CONFIRM_PASSWORD(String SIGNUP_CONFIRM_PASSWORD) {
        this.SIGNUP_CONFIRM_PASSWORD = SIGNUP_CONFIRM_PASSWORD;
    }

    public void setSIGNUP_FIRST_NAME(String SIGNUP_FIRST_NAME) {
        this.SIGNUP_FIRST_NAME = SIGNUP_FIRST_NAME;
    }

    public void setSIGNUP_LAST_NAME(String SIGNUP_LAST_NAME) {
        this.SIGNUP_LAST_NAME = SIGNUP_LAST_NAME;
    }

    public void setSIGNUP_DOB_MM_DD_YYYY(String SIGNUP_DOB_MM_DD_YYYY) {
        this.SIGNUP_DOB_MM_DD_YYYY = SIGNUP_DOB_MM_DD_YYYY;
    }

    public void setSIGNUP_SEX(String SIGNUP_SEX) {
        this.SIGNUP_SEX = SIGNUP_SEX;
    }
}
