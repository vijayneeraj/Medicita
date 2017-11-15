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

public class VisitNotesDialog extends Dialog implements View.OnClickListener {

    private Context context;
    private ImageView ivCancel;
    private TextView tvSignNote;

    public VisitNotesDialog(Context context) {
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
        View layout = inflate.inflate(R.layout.doc_visit_history_notes, null);
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

        tvSignNote = (TextView) layout.findViewById(R.id.tvSignNote);
        ivCancel = (ImageView) layout.findViewById(R.id.ivCancel);

        tvSignNote.setOnClickListener(this);
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
            case R.id.tvSignNote:
            {
                this.dismiss();
                break;
            }
        }
    }

}
