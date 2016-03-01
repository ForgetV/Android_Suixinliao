package com.tencent.qcloud.timchat.customview;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.tencent.qcloud.timchat.R;

/**
 * 标题控件
 */
public class TemplateTitle extends RelativeLayout {

    private String titleText;
    private boolean canBack;
    private String backText;
    private String moreText;
    private int moreImg;

    private TextView tvTitle;
    private TextView tvBack;


    public TemplateTitle(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.title, this);
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.TemplateTitle, 0, 0);
        try {
            titleText = ta.getString(R.styleable.TemplateTitle_titleText);
            tvTitle = (TextView) findViewById(R.id.title);
            tvTitle.setText(titleText);
            canBack = ta.getBoolean(R.styleable.TemplateTitle_canBack,false);
            LinearLayout backBtn = (LinearLayout) findViewById(R.id.title_back);
            backBtn.setVisibility(canBack?VISIBLE:INVISIBLE);
            if (canBack){
                backText = ta.getString(R.styleable.TemplateTitle_backText);
                tvBack = (TextView) findViewById(R.id.txt_back);
                tvBack.setText(backText);
            }
            moreImg = ta.getResourceId(R.styleable.TemplateTitle_moreImg, 0);
            if (moreImg != 0){
                ImageView moreImgView = (ImageView) findViewById(R.id.img_more);
                moreImgView.setImageDrawable(getContext().getResources().getDrawable(moreImg));
            }
        } finally {
            ta.recycle();
        }
    }
}