package com.example.administrator.mycustomviewtitledemo.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.administrator.mycustomviewtitledemo.R;

/**
 * Created by Administrator on 2017/9/1.
 */

public class MyCustomView extends LinearLayout {

    private RelativeLayout container;
    private ImageView icon;
    private TextView title;
    private TypedArray typedArray;
    private int bgColor;
    private int titleColor;
    private float titleSize;
    private String titleText;
    private Drawable iconSrcDrawable;

    public MyCustomView(Context context) {
        super(context);
        initView(context, null);
    }

    public MyCustomView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView(context, attrs);
    }

    private void initView(Context context, AttributeSet attrs) {
        View inflate = inflate(context, R.layout.custom_view, this);
        container =  inflate.findViewById(R.id.container);
        icon =  inflate.findViewById(R.id.icon);
        title =  inflate.findViewById(R.id.title);
        icon.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mOnIconClickListener !=null){
                    mOnIconClickListener.OnMyActionBarIconClick(v);
                }
            }
        });

        if (attrs == null) {
            return;
        }
        initAttrs(context, attrs);
        setViewContent();
    }

    private void initAttrs(Context context, AttributeSet attrs) {
        if (attrs == null) {
            return;
        }
        typedArray = context.obtainStyledAttributes(attrs, R.styleable.MyCustomView);
        bgColor = typedArray.getColor(R.styleable.MyCustomView_custom_view_bg_color, Color.GRAY);
        titleColor = typedArray.getColor(R.styleable.MyCustomView_custom_view_title_color, Color.RED);
        titleSize = typedArray.getDimension(R.styleable.MyCustomView_custom_view_title_size, 16);
        titleText = typedArray.getString(R.styleable.MyCustomView_custom_view_text);
        iconSrcDrawable = typedArray.getDrawable(R.styleable.MyCustomView_custom_view_icon_src);
    }

    private void setViewContent() {
        container.setBackgroundColor(bgColor);
        icon.setImageDrawable(iconSrcDrawable);
        title.setText(titleText);
        title.setTextColor(titleColor);
        title.setTextSize(titleSize);
    }

    private OnIconClickListener mOnIconClickListener;

    public interface OnIconClickListener {
        void OnMyActionBarIconClick(View icon);
    }

    public void SetOnIconClickListener(OnIconClickListener onIconClickListener) {
        mOnIconClickListener = onIconClickListener;
    }
}

