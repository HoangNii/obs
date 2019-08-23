package com.hoangit.obt.customviews;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import com.hoangit.obt.ObUtils;
import com.hoangit.obt.R;

public class CardImageView extends CardView {

    private ImageView mImage;

    public CardImageView(@NonNull Context context) {
        super(context);
        init(context, null);
    }

    public CardImageView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public CardImageView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    public ImageView getImage() {
        return mImage;
    }

    private void init(Context context, AttributeSet attrs) {
        mImage = new ImageView(context);
        this.addView(mImage);
        TypedArray attributes = context.obtainStyledAttributes(attrs, R.styleable.CardImageView);
        try {
            int res = attributes.getResourceId(R.styleable.CardImageView_imageSrc,0);
            int background = attributes.getResourceId(R.styleable.CardImageView_imageBackground,0);
            int tint = attributes.getColor(R.styleable.CardImageView_imageTint,Color.TRANSPARENT);
            float padding = attributes.getDimension(R.styleable.CardImageView_imageContentPadding,0f);
            int pad = (int) ObUtils.convertDpToPixel(padding,context);
            mImage.setPadding(pad,pad,pad,pad);
            mImage.setImageResource(res);
            mImage.setBackgroundResource(background);
            mImage.setColorFilter(tint);
        }finally {
            attributes.recycle();
        }
    }


}
