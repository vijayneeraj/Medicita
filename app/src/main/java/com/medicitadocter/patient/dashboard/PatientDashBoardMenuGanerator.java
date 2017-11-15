package com.medicitadocter.patient.dashboard;

import android.content.Context;

import com.medicitadocter.R;
import com.medicitadocter.patient.model.DashBoardPatientMenuModal;

import java.util.ArrayList;

/**
 * Created by ubuntu on 26/6/17.
 */

public class PatientDashBoardMenuGanerator {

    public static final int DASHBOARD_SETTING=0X1;
    public static final int  DASHBOARD_MASSAGE=0X2;
    public static final int DASHBOARD_CONSULT=0X3;
    public static final int DASHBOARD_REMAINDER=0X4;
    public static final int DASHBOARD_APPOINMENT=0X5;
    public static final int DASHBOARD_HEALTH=0X6;


    public static ArrayList<DashBoardPatientMenuModal> getMenuGanerator(Context context)
    {
        ArrayList<DashBoardPatientMenuModal> menuList=new ArrayList<>();
        menuList.add(new DashBoardPatientMenuModal(DASHBOARD_SETTING, R.mipmap.dashboard_p_setting_icon,context.getResources().getString(R.string.petient_settings)));
        menuList.add(new DashBoardPatientMenuModal(DASHBOARD_MASSAGE, R.mipmap.dashboard_p_message_icon,context.getResources().getString(R.string.petient_massage)));
        menuList.add(new DashBoardPatientMenuModal(DASHBOARD_CONSULT, R.mipmap.dashboard_p_consult_icon,context.getResources().getString(R.string.petient_consult)));
        menuList.add(new DashBoardPatientMenuModal(DASHBOARD_REMAINDER, R.mipmap.dashboard_p_reminder_icon,context.getResources().getString(R.string.petient_remainder)));
        menuList.add(new DashBoardPatientMenuModal(DASHBOARD_APPOINMENT, R.mipmap.dashboard_p_appointment_icon,context.getResources().getString(R.string.petient_appointment)));
        menuList.add(new DashBoardPatientMenuModal(DASHBOARD_HEALTH, R.mipmap.dashboard_p_health_icon,context.getResources().getString(R.string.petient_health)));

        return menuList;

    }

}
