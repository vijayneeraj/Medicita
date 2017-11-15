package com.medicitadocter.utils;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.view.KeyEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.Toast;

import com.medicitadocter.R;
import com.medicitadocter.handler.NavigationHandler;

/**
 * Created by linux on 27/6/17.
 */

public class Utils {

    /*It makes Dashboard Toolbar Visibilty "VISIBLE" and BackPress th fragment on Dashboard*/
    public static void customBackPressForFragment(View v, final NavigationHandler handler, final FragmentActivity activity) {
        v.setFocusableInTouchMode(true);
        v.requestFocus();
        v.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event)
            {
                if (event.getAction() == KeyEvent.ACTION_DOWN)
                {
                    if (keyCode == KeyEvent.KEYCODE_BACK)
                    {
                        handler.toolbarVisibility(false);
                        activity.onBackPressed();
                        return true;
                    }
                }
                return false;
            }
        });
    }

    /*BackPress for Child fragment*/
    public static void customBackPressForChildFragment(View v, final NavigationHandler handler, final FragmentActivity activity) {
        v.setFocusableInTouchMode(true);
        v.requestFocus();
        v.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event)
            {
                if (event.getAction() == KeyEvent.ACTION_DOWN)
                {
                    if (keyCode == KeyEvent.KEYCODE_BACK)
                    {
                        activity.onBackPressed();
                        return true;
                    }
                }
                return false;
            }
        });
    }

    public static void toggle_contents(Context ctx, View v, ImageView minus)
    {
        if(ctx.equals(null) || v.equals(null) || minus.equals(null)) {
            Toast.makeText(ctx,"Layout Not Available",Toast.LENGTH_SHORT).show();
        }
        else
        {
            if (v.isShown()) {
                v.setVisibility(v.isShown() ? View.GONE : View.VISIBLE);
                minus.setBackground(ctx.getResources().getDrawable(R.drawable.add_white));
            } else {
                slide_down(ctx, v);
                v.setVisibility(v.isShown() ? View.GONE : View.VISIBLE);
                minus.setBackground(ctx.getResources().getDrawable(R.drawable.minus_white));
            }
        }
    }

    public static void toggle_contents_arrow(Context ctx, View v, ImageView minus)
    {
        if(ctx.equals(null) || v.equals(null) || minus.equals(null)) {
            Toast.makeText(ctx,"Layout Not Available",Toast.LENGTH_SHORT).show();
        }
        else
        {
            if (v.isShown()) {
                v.setVisibility(v.isShown() ? View.GONE : View.VISIBLE);
                minus.setBackground(ctx.getResources().getDrawable(R.mipmap.up_arrow_white));
            } else {
                slide_down(ctx, v);
                v.setVisibility(v.isShown() ? View.GONE : View.VISIBLE);
                minus.setBackground(ctx.getResources().getDrawable(R.mipmap.down_arrow_white));
            }
        }
    }

    public static void slide_down(Context ctx,View v){
        Animation a = AnimationUtils.loadAnimation(ctx, R.anim.slide_down);
        if(a != null)
        {
            a.reset();
            if(v != null)
            {
                v.clearAnimation();
                v.startAnimation(a);
            }
        }
    }

}
