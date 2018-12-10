package com.santasoft.xmastree;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.view.View;
import android.widget.ImageView;
import com.santasoft.xmastree.lights.R;

public class Lights extends ImageView {

    public Lights(Context context) {
        super(context);

        setImageResource(R.drawable.lights_anim);

        setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if (getAnimationDrawable().isRunning()) {
                    getAnimationDrawable().stop();
                } else {
                    getAnimationDrawable().start();
                }
            }
        });
    }

    private AnimationDrawable getAnimationDrawable() {
        return (AnimationDrawable) getDrawable();
    }
}