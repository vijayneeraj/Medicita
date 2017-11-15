package com.medicitadocter.base;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.medicitadocter.handler.NavigationHandler;


/**
 * Created by linux on 26/6/17.
 */

public abstract class BaseActivity extends AppCompatActivity implements View.OnClickListener, NavigationHandler {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResourceView());
        findView();
        init();
    }

    /**
     * Get Resource View
     *
     * @return int return layout view id
     */
    protected abstract int getLayoutResourceView();

    /**
     * Simple method i.e. just like a block of all view
     */
    protected abstract void findView();

    /**
     * Simple method block
     */
    protected abstract void init();

    /**
     * Create a view
     *
     * @param id  view id
     * @param pak view package
     * @return view
     */
    protected View findViewById(String id, String pak) {
        return findViewById(getResources().getIdentifier(id, null, pak));
    }

    /**
     * Call Next Activity using Intent without {@link #finish()}
     *
     * @param aClass next activity
     */
    public void StartActivity(Class aClass) {
        startActivity(new Intent(this, aClass));
    }

    /**
     * Call Next Activity using Intent with {@param Bundle bundle}
     *
     * @param aClass next activity
     */
    protected void StartActivityWithBundle(Class aClass,Bundle bundle) {
        startActivity(new Intent(this, aClass).putExtras(bundle));
    }

    /**
     * Call Next Activity using Intent with {@link #finish(), #Bundle}
     *
     * @param aClass next activity
     */
    protected void StartActivityWithBundleAndFinish(Class aClass,Bundle bundle) {
        startActivity(new Intent(this, aClass).putExtras(bundle));
        finish();
    }


    /**
     * Call Next Activity using Intent with {@link #finish()}
     *
     * @param aClass next activity
     */
    protected void StartActivityWithFinish(Class aClass) {
        startActivity(new Intent(this, aClass));
        finish();
    }


    public void setFragments(int resourceView, Fragment fragment, boolean backStackFlag) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        if (backStackFlag)
            transaction.addToBackStack(fragment.getClass().getSimpleName());
        transaction.add(resourceView, fragment);
        transaction.commit();
    }

    @Override
    public void onBackPressed() {
        int count = getSupportFragmentManager().getBackStackEntryCount();
        if (count > 0) {
            getSupportFragmentManager().popBackStack();
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public void setTitle(final CharSequence title) {

    }

    @Override
    public void toolbarVisibility(Boolean value)
    {

    }

    @Override
    public void showAndHideIcons(Boolean drawer, Boolean logo, Boolean search) {

    }

    @Override
    public void changeMenuIcon(Drawable image) {

    }

    /**
     * #implements of OnClick Listener
     *
     * @param v click on view
     */
    @Override
    public void onClick(View v) {

    }
}
