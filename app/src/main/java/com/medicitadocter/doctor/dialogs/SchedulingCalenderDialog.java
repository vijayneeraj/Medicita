package com.medicitadocter.doctor.dialogs;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.CalendarView;
import android.widget.ImageView;

import com.medicitadocter.R;
import com.medicitadocter.doctor.adapter.ScheduleViewPagerAdapter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by br on 18/8/17.
 */

public class SchedulingCalenderDialog extends Dialog implements View.OnClickListener, TabLayout.OnTabSelectedListener {

    private Context context;
    private ImageView ivCancel;
    private TabLayout TabLayoutCalenderSchedulingDialog;
    private ViewPager ViewPagerCalenderSchedulingDialog;
    private CalendarView CalenderView;

    private String inputString2;
    private String inputString1;
    private long day;
    private Calendar cal;

    public SchedulingCalenderDialog(Context context) {
        super(context);
        this.context = context;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        getWindow().setBackgroundDrawableResource(R.color.transparent);
        LayoutInflater inflate = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View layout = inflate.inflate(R.layout.doc_scheduling_calender_dialog, null);
//        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
//        layoutParams.setMargins(40, 20, 40, 20);
//        layout.setLayoutParams(layoutParams);

        setContentView(layout);

        WindowManager.LayoutParams wlmp = getWindow().getAttributes();
        wlmp.windowAnimations = R.style.DialogStyle;
        wlmp.gravity = Gravity.CENTER;

        setTitle(null);
        setCancelable(false);
        setCanceledOnTouchOutside(true);
        setOnCancelListener(null);

        ivCancel = (ImageView) layout.findViewById(R.id.ivCancel);
        TabLayoutCalenderSchedulingDialog = (TabLayout) layout.findViewById(R.id.TabLayoutCalenderSchedulingDialog);
        ViewPagerCalenderSchedulingDialog = (ViewPager) layout.findViewById(R.id.ViewPagerCalenderSchedulingDialog);
        CalenderView = (CalendarView) layout.findViewById(R.id.CalenderView);

        ivCancel.setOnClickListener(this);
        TabLayoutCalenderSchedulingDialog.addOnTabSelectedListener(this);

        setData();
    }

    private void setData() {
        //Adding the tabs using addTab() method
        TabLayoutCalenderSchedulingDialog.addTab(TabLayoutCalenderSchedulingDialog.newTab().setText("DAY"));
        TabLayoutCalenderSchedulingDialog.addTab(TabLayoutCalenderSchedulingDialog.newTab().setText("WEEK"));
        TabLayoutCalenderSchedulingDialog.addTab(TabLayoutCalenderSchedulingDialog.newTab().setText("AGENDA"));
        TabLayoutCalenderSchedulingDialog.setTabGravity(TabLayout.GRAVITY_FILL);

        //Creating our pager adapter
        ScheduleViewPagerAdapter scheduleViewPagerAdapter = new ScheduleViewPagerAdapter(null, TabLayoutCalenderSchedulingDialog.getTabCount());

        //Adding adapter to pager
        ViewPagerCalenderSchedulingDialog.setAdapter(scheduleViewPagerAdapter);

        cal = Calendar.getInstance();
        //highlighlighting the holidays in a month taking the static dates
        ArrayList<String> dates = new ArrayList<String>();
        dates.add("08/02/2017");
        dates.add("08/05/2017");
        dates.add("08/09/2017");
        dates.add("08/11/2017");
        dates.add("08/15/2017");
        dates.add("08/20/2017");
        dates.add("08/22/2017");
        dates.add("08/28/2017");

        SimpleDateFormat myFormat = new SimpleDateFormat("dd/mm/yyyy");
        Date date = new Date();
        for (int i = 1; i < dates.size(); i++) {
            inputString2 = dates.get(i);
            inputString1 = myFormat.format(date);
        }

        try {
            //Converting String format to date format
            Date date1 = myFormat.parse(inputString1);
            Date date2 = myFormat.parse(inputString2);
            //Calculating number of days from two dates
            long diff = date2.getTime() - date1.getTime();
            long datee = diff / (1000 * 60 * 60 * 24);
            //Converting long type to int type
            day = (int) datee;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        cal = Calendar.getInstance();
        cal.add(Calendar.DATE, (int) day);


    }

    @Override
    public void onClick(View view) {
        int vId = view.getId();
        switch (vId) {
            case R.id.ivCancel: {
                Log.d("rahul"," : selected date : "+CalenderView.getDate()); // get selected date in milliseconds
                this.dismiss();
                break;
            }
        }
    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        //ViewPagerSchedule.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }
}
