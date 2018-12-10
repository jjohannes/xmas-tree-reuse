package com.santasoft.xmastree;

import android.content.Context;
import android.widget.ImageView;
import com.santasoft.xmastree.train.R;

public class Train extends ImageView {

    public Train(Context context) {
        super(context);

        setImageResource(R.drawable.train);
    }
}