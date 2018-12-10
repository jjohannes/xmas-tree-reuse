package com.null8fuffzehn.app;

import android.os.Bundle;
import android.app.Activity;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;

public class AndroidApp extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FrameLayout layout = new FrameLayout(this);
        setContentView(layout);

        com.santasoft.xmastree.Tree.compose(layout);

        Button button = new Button(this);
        button.setText("LEND MONEY");
        layout.addView(button, new FrameLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT, Gravity.TOP));

    }

}
