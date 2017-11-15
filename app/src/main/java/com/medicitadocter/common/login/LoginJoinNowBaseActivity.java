package com.medicitadocter.common.login;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.medicitadocter.R;
import com.medicitadocter.base.BaseActivity;
import com.medicitadocter.common.singandjoin.LoginFragment;

public class LoginJoinNowBaseActivity extends BaseActivity {

    private ImageView imvBackArrow;
    private TextView tvJoinNowTitle;

    private String LOGINAS = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int getLayoutResourceView() {
        return R.layout.c_activity_login_join;
    }

    @Override
    protected void findView() {
        LOGINAS = getIntent().getExtras().getString("LOGINAS");
        imvBackArrow = (ImageView) findViewById(R.id.imvBackArrow);
        imvBackArrow.setOnClickListener(this);
        tvJoinNowTitle = (TextView) findViewById(R.id.tvJoinNowTitle);
    }

    @Override
    protected void init() {
        LoginFragment loginFragment = new LoginFragment();
        Bundle bundle = new Bundle();
        bundle.putString("LOGINAS",LOGINAS);
        loginFragment.setArguments(bundle);
        setFragments(R.id.flLoginJoin, loginFragment, false);
    }

    @Override
    public void setTitle(final CharSequence title) {
        Log.e("Title", String.valueOf(title));
        tvJoinNowTitle.setText(title.toString());
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        if (imvBackArrow == v) {
            onBackPressed();
        }
    }
}
