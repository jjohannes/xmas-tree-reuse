package com.santasoft.xmastree;

import android.content.Context;
import android.widget.ImageView;
import com.santasoft.xmastree.ornaments.R;

public class Ornaments extends ImageView {

    public Ornaments(Context context) {
        super(context);

        setImageResource(R.drawable.ornaments);
    }
}