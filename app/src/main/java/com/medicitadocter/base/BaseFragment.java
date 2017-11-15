package com.medicitadocter.base;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;

import com.medicitadocter.handler.NavigationHandler;


/**
 * Created by linux on 26/6/17.
 */

public abstract class BaseFragment extends Fragment implements View.OnClickListener,
        CompoundButton.OnCheckedChangeListener {

    protected View view;
    protected NavigationHandler handler;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(getLayoutResourceView(), container, false);
        handler = (BaseActivity) getActivity();
        findView();
        init();
        return view;
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

    protected View getFragmentView() {
        return view;
    }

    protected NavigationHandler getHandler() {
        return handler;
    }

    protected View findViewByIds(int reSourceId) {
        return view.findViewById(reSourceId);
    }

    /**
     * Call Next Activity using Intent with {@link BaseActivity#finish()}
     *
     * @param aClass next activity
     */
    protected void StartActivityWithFinish(Class aClass) {
        startActivity(new Intent(getContext(), aClass));
        getActivity().finish();
    }

    /**
     * Call Next Activity using Intent
     *
     * @param aClass next activity
     */
    protected void StartActivity(Class aClass) {
        startActivity(new Intent(getContext(), aClass));
    }

    protected void setFragments(int resourceView, Fragment fragment, boolean backStackFlag) {
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        if (backStackFlag)
            transaction.addToBackStack(fragment.getClass().getSimpleName());
        transaction.replace(resourceView, fragment);
        transaction.commit();
    }


    @Override
    public void onClick(View v) {

    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

    }

}
