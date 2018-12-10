package com.santasoft.xmastree;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.santasoft.xmastree.tree.R;

public class Tree extends ImageView {

    public Tree(Context context) {
        super(context);

        setImageResource(R.drawable.tree);
    }

    public static void compose(Object container) {
        ViewGroup layout = (ViewGroup) container;
        layout.addView(new Tree(layout.getContext()));

        addFromClasspath("Ornaments", layout);
        addFromClasspath("Train", layout);
        addFromClasspath("Lights", layout);
    }

    private static void addFromClasspath(String component, ViewGroup layout) {
        try {
            layout.addView((View) Class.forName("com.santasoft.xmastree." + component).getDeclaredConstructor(Context.class).newInstance(layout.getContext()));
        } catch (Exception e) {
            // component was not requested
        }
    }
}