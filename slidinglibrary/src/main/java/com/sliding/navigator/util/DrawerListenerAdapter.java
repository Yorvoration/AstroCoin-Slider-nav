package com.sliding.navigator.util;

import android.view.View;

import androidx.drawerlayout.widget.DrawerLayout;

import com.sliding.navigator.callback.DragListener;
import com.sliding.navigator.callback.DragStateListener;

public class DrawerListenerAdapter implements DragListener, DragStateListener {

    private final DrawerLayout.DrawerListener adaptee;
    private final View drawer;

    public DrawerListenerAdapter(DrawerLayout.DrawerListener adaptee, View drawer) {
        this.adaptee = adaptee;
        this.drawer = drawer;
    }

    @Override
    public void onDrag(float progress) {
        adaptee.onDrawerSlide(drawer, progress);
    }

    @Override
    public void onDragStart() {
        adaptee.onDrawerStateChanged(DrawerLayout.STATE_DRAGGING);
    }

    @Override
    public void onDragEnd(boolean isMenuOpened) {
        if (isMenuOpened) {
            adaptee.onDrawerOpened(drawer);
        } else {
            adaptee.onDrawerClosed(drawer);
        }
        adaptee.onDrawerStateChanged(DrawerLayout.STATE_IDLE);
    }
}
