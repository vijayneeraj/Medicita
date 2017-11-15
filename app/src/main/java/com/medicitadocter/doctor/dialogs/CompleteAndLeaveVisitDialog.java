package com.medicitadocter.doctor.dialogs;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.medicitadocter.R;

/**
 * Created by br on 11/8/17.
 */

public class CompleteAndLeaveVisitDialog extends Dialog implements View.OnClickListener {

    private Context context;
    private TextView tvCompleteAndLeave;

    public CompleteAndLeaveVisitDialog(Context context) {
        super(context);
        this.context = context;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        getWindow().setBackgroundDrawableResource(R.color.transparent);
        LayoutInflater inflate = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View layout = inflate.inflate(R.layout.doc_visit_complete_feedback_dialog_at_video_call, null);
        setContentView(layout);

        WindowManager.LayoutParams wlmp = getWindow().getAttributes();
        wlmp.windowAnimations = R.style.DialogStyle;
        wlmp.gravity = Gravity.CENTER;

        tvCompleteAndLeave = (TextView) findViewById(R.id.tvCompleteAndLeave);
        tvCompleteAndLeave.setOnClickListener(this);

        setTitle(null);
        setCancelable(false);
        setCanceledOnTouchOutside(true);
        setOnCancelListener(null);

        setData();
    }

    private void setData() {

    }

    @Override
    public void onClick(View view) {
        int vId = view.getId();
        switch (vId) {
            case R.id.tvCompleteAndLeave:
            {
                this.dismiss();
                Log.d("rahul"," : mclicked ");
                break;
            }
        }
    }
}