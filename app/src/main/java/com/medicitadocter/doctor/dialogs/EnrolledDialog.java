package com.medicitadocter.doctor.dialogs;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.medicitadocter.R;

/**
 * Created by br on 10/8/17.
 */

public class EnrolledDialog extends Dialog implements View.OnClickListener {

    private Context context;
    private ImageView ivCancel;
    private EditText etSearch;
    private TextView tvClear,tvSearch;
    private LinearLayout llStatusSpinner,llActivitySpinner;
    private Spinner spStatus,spActivity;

    public EnrolledDialog(Context context) {
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
        View layout = inflate.inflate(R.layout.doc_enrolled_layout, null);
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

        llStatusSpinner = (LinearLayout) layout.findViewById(R.id.llStatusSpinner);
        llActivitySpinner = (LinearLayout) layout.findViewById(R.id.llActivitySpinner);
        spStatus = (Spinner) layout.findViewById(R.id.spStatus);
        spActivity = (Spinner) layout.findViewById(R.id.spActivity);
        ivCancel = (ImageView) layout.findViewById(R.id.ivCancel);
        tvSearch = (TextView) layout.findViewById(R.id.tvSearch);
        tvClear = (TextView) layout.findViewById(R.id.tvClear);
        etSearch = (EditText) layout.findViewById(R.id.etSearch);


        llActivitySpinner.setOnClickListener(this);
        llStatusSpinner.setOnClickListener(this);
        tvClear.setOnClickListener(this);
        tvSearch.setOnClickListener(this);
        ivCancel.setOnClickListener(this);

        setData();


    }

    private void setData() {

    }

    @Override
    public void onClick(View view) {
        int vId = view.getId();
        switch (vId) {
            case R.id.ivCancel:
            {
                this.dismiss();
             break;
            }
        }
    }
}
