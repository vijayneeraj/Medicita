package com.medicitadocter.doctor.dialogs;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.medicitadocter.R;

/**
 * Created by br on 11/8/17.
 */

public class DetailsDialog extends Dialog implements View.OnClickListener {

    private Context context;
    private ImageView ivCancel;
    private TextView tvPrev;
    private TextView tvOne;
    private TextView tvTwo;
    private TextView tvThree;
    private TextView tvFour;
    private TextView tvFive;
    private TextView tvNext;

    public DetailsDialog(Context context) {
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
        View layout = inflate.inflate(R.layout.doc_rx_details, null);

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
        tvPrev = (TextView) layout.findViewById(R.id.tvPrev);
        tvOne = (TextView) layout.findViewById(R.id.tvOne);
        tvTwo = (TextView) layout.findViewById(R.id.tvTwo);
        tvThree = (TextView) layout.findViewById(R.id.tvThree);
        tvFour = (TextView) layout.findViewById(R.id.tvFour);
        tvFive = (TextView) layout.findViewById(R.id.tvFive);
        tvNext = (TextView) layout.findViewById(R.id.tvNext);

        ivCancel.setOnClickListener(this);
        tvNext.setOnClickListener(this);
        tvPrev.setOnClickListener(this);
        tvOne.setOnClickListener(this);
        tvTwo.setOnClickListener(this);
        tvThree.setOnClickListener(this);
        tvFour.setOnClickListener(this);
        tvFive.setOnClickListener(this);

        setData();
    }

    private void setData() {
//        tvOne.setBackground(context.getResources().getDrawable(R.drawable.solid_circular_primary_dark));
//        tvOne.setTextColor(context.getResources().getColor(R.color.white));
//        tvOne.setTag("1");
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
            case R.id.tvNext:
            {

                break;
            }
            case R.id.tvPrev:
            {

                break;
            }
            case R.id.tvOne:
            {
                tvOne.setTag(1);
                selectPage(tvOne);
                break;
            }
            case R.id.tvTwo:
            {
                tvTwo.setTag(2);
                selectPage(tvTwo);
                break;
            }
            case R.id.tvThree:
            {
                tvThree.setTag(3);
                selectPage(tvThree);
                break;
            }
            case R.id.tvFour:
            {
                tvFour.setTag(4);
                selectPage(tvFour);
                break;
            }
            case R.id.tvFive:
            {
                tvFive.setTag(5);
                selectPage(tvFive);
                break;
            }
        }
    }

    private void selectPage(TextView textView)
    {
        int TAG = (int) textView.getTag();
        switch (TAG)
        {
            case 1:
            {
                tvOne.setBackground(context.getResources().getDrawable(R.drawable.solid_circular_primary_dark));
                tvOne.setTextColor(context.getResources().getColor(R.color.white));
                tvOne.setTag("");
                tvTwo.setTag("");
                tvThree.setTag("");
                tvFour.setTag("");
                tvFive.setTag("");
                tvTwo.setBackground(null);
                tvThree.setBackground(null);
                tvFour.setBackground(null);
                tvFive.setBackground(null);
                tvTwo.setTextColor(context.getResources().getColor(R.color.black_color));
                tvThree.setTextColor(context.getResources().getColor(R.color.black_color));
                tvFour.setTextColor(context.getResources().getColor(R.color.black_color));
                tvFive.setTextColor(context.getResources().getColor(R.color.black_color));
                break;
            }
            case 2:
            {
                tvTwo.setBackground(context.getResources().getDrawable(R.drawable.solid_circular_primary_dark));
                tvTwo.setTextColor(context.getResources().getColor(R.color.white));
                tvTwo.setTag("");
                tvOne.setTag("");
                tvThree.setTag("");
                tvFour.setTag("");
                tvFive.setTag("");
                tvOne.setBackground(null);
                tvThree.setBackground(null);
                tvFour.setBackground(null);
                tvFive.setBackground(null);
                tvOne.setTextColor(context.getResources().getColor(R.color.black_color));
                tvThree.setTextColor(context.getResources().getColor(R.color.black_color));
                tvFour.setTextColor(context.getResources().getColor(R.color.black_color));
                tvFive.setTextColor(context.getResources().getColor(R.color.black_color));
                break;
            }
            case 3:
            {
                tvThree.setBackground(context.getResources().getDrawable(R.drawable.solid_circular_primary_dark));
                tvThree.setTextColor(context.getResources().getColor(R.color.white));
                tvThree.setTag("");
                tvOne.setTag("");
                tvTwo.setTag("");
                tvFour.setTag("");
                tvFive.setTag("");
                tvTwo.setBackground(null);
                tvOne.setBackground(null);
                tvFour.setBackground(null);
                tvFive.setBackground(null);
                tvOne.setTextColor(context.getResources().getColor(R.color.black_color));
                tvTwo.setTextColor(context.getResources().getColor(R.color.black_color));
                tvFour.setTextColor(context.getResources().getColor(R.color.black_color));
                tvFive.setTextColor(context.getResources().getColor(R.color.black_color));
                break;
            }
            case 4:
            {
                tvFour.setBackground(context.getResources().getDrawable(R.drawable.solid_circular_primary_dark));
                tvFour.setTextColor(context.getResources().getColor(R.color.white));
                tvFour.setTag("");
                tvOne.setTag("");
                tvTwo.setTag("");
                tvThree.setTag("");
                tvFive.setTag("");
                tvTwo.setBackground(null);
                tvThree.setBackground(null);
                tvOne.setBackground(null);
                tvFive.setBackground(null);
                tvOne.setTextColor(context.getResources().getColor(R.color.black_color));
                tvTwo.setTextColor(context.getResources().getColor(R.color.black_color));
                tvThree.setTextColor(context.getResources().getColor(R.color.black_color));
                tvFive.setTextColor(context.getResources().getColor(R.color.black_color));
                break;
            }
            case 5:
            {
                tvFive.setBackground(context.getResources().getDrawable(R.drawable.solid_circular_primary_dark));
                tvFive.setTextColor(context.getResources().getColor(R.color.white));
                tvFive.setTag("");
                tvOne.setTag("");
                tvTwo.setTag("");
                tvFour.setTag("");
                tvThree.setTag("");
                tvTwo.setBackground(null);
                tvThree.setBackground(null);
                tvFour.setBackground(null);
                tvOne.setBackground(null);
                tvOne.setTextColor(context.getResources().getColor(R.color.black_color));
                tvTwo.setTextColor(context.getResources().getColor(R.color.black_color));
                tvFour.setTextColor(context.getResources().getColor(R.color.black_color));
                tvThree.setTextColor(context.getResources().getColor(R.color.black_color));
                break;
            }
        }
    }
}

