package com.medicitadocter.handler;

import android.graphics.drawable.Drawable;

/**
 * Created by linux on 28/6/17.
 */

public interface NavigationHandler {

    void setTitle(CharSequence title);

    void toolbarVisibility(Boolean value);

    void showAndHideIcons(Boolean drawer, Boolean logo, Boolean search);

    void changeMenuIcon(Drawable image);

}
