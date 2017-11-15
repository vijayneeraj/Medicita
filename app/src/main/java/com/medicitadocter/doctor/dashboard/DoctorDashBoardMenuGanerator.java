package com.medicitadocter.doctor.dashboard;

import android.content.Context;

import com.medicitadocter.R;
import com.medicitadocter.doctor.model.DashBoardDoctorMenuModal;

import java.util.ArrayList;

/**
 * Created by ubuntu on 26/6/17.
 */

public class DoctorDashBoardMenuGanerator {

    public static final int DASHBOARD_DASHBOARD=0X1;
    public static final int DASHBOARD_WAITING_ROOM=0X2;
    public static final int DASHBOARD_PATIENT=0X3;
    public static final int DASHBOARD_VISIT_HISTORY=0X4;
    public static final int DASHBOARD_SCHEDULE=0X5;

    public static ArrayList<DashBoardDoctorMenuModal> getMenuGanerator(Context context)
    {
        ArrayList<DashBoardDoctorMenuModal> menuList=new ArrayList<>();
        menuList.add(new DashBoardDoctorMenuModal(DASHBOARD_DASHBOARD, R.mipmap.dashboard_d_dashboard,context.getResources().getString(R.string.doctor_dashboard)));
        menuList.add(new DashBoardDoctorMenuModal(DASHBOARD_WAITING_ROOM, R.mipmap.dashboard_d_waiting_room,context.getResources().getString(R.string.doctor_waiting_room)));
        menuList.add(new DashBoardDoctorMenuModal(DASHBOARD_PATIENT, R.mipmap.dashboard_d_patient,context.getResources().getString(R.string.doctor_patient)));
        menuList.add(new DashBoardDoctorMenuModal(DASHBOARD_VISIT_HISTORY, R.mipmap.dashboard_d_visit_history,context.getResources().getString(R.string.doctor_visit_history)));
        menuList.add(new DashBoardDoctorMenuModal(DASHBOARD_SCHEDULE, R.mipmap.dashboard_d_scheduling,context.getResources().getString(R.string.doctor_Scheduling)));

        return menuList;
    }

}
