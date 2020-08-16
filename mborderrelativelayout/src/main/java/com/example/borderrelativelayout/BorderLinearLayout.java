package com.example.borderrelativelayout;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

public class BorderLinearLayout extends LinearLayout {
    /**
     * 画笔
     */
    private Paint mPaint;
    /**
     * 边框颜色
     */
    private int mPaintColor;
    /**
     * 边框粗细
     */
    private float mBorderStrokeWidth;
    /**
     * 底边边线左边断开距离
     */
    private int mBorderBottomLeftBreakSize;
    /**
     * 底边边线右边断开距离
     */
    private int mBorderBottomRightBreakSize;
    /**
     * 是否需要上边框
     */
    private boolean isNeedTopBorder;
    /**
     * 是否需要左右边框
     */
    private boolean isNeedLeftAndRightBorder;

    /**
     * 是否需要右邊框
     */
    private boolean isNeedLeftBorder;

    /**
     * 是否需要右邊框
     */
    private boolean isNeedRightBorder;
    /**
     * 是否需要下边框
     */
    private boolean isNeedBottomBorder;
    /**
     * 是否需要中間邊框
     */
    private boolean isNeedCenterBorder;
    /**
     * 是否需要四分之一邊框
     */
    private boolean isNeedFirstQuarterBorder;
    /**
     * 是否需四分之四邊框
     */
    private boolean isNeedFourQuarterBorder;



    public BorderLinearLayout(Context context) {
        super(context);
    }

    public BorderLinearLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public BorderLinearLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public BorderLinearLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.BorderLinearLayout);
        mPaintColor = ta.getColor(R.styleable.BorderLinearLayout_borderColor, Color.GRAY);
        mBorderStrokeWidth = ta.getFloat(R.styleable.BorderLinearLayout_borderStrokeWidth, 2.0f);
        mBorderBottomLeftBreakSize = ta.getDimensionPixelSize(R.styleable.BorderLinearLayout_borderBottomLeftBreakSize, 0);
        mBorderBottomRightBreakSize = ta.getDimensionPixelSize(R.styleable.BorderLinearLayout_borderBottomRightBreakSize, 0);
        isNeedTopBorder = ta.getBoolean(R.styleable.BorderLinearLayout_needTopBorder, true);
        isNeedLeftAndRightBorder = ta.getBoolean(R.styleable.BorderLinearLayout_needLeftAndRigtBorder, false);
        isNeedBottomBorder = ta.getBoolean(R.styleable.BorderLinearLayout_needBottomBorder, true);
        isNeedLeftBorder = ta.getBoolean(R.styleable.BorderLinearLayout_needLeftBorder, false);
        isNeedRightBorder = ta.getBoolean(R.styleable.BorderLinearLayout_needRightBorder, false);
        isNeedCenterBorder = ta.getBoolean(R.styleable.BorderLinearLayout_needCenterBorder,false);
        isNeedFirstQuarterBorder = ta.getBoolean(R.styleable.BorderLinearLayout_needFirstQuarterBorder,false);
        isNeedFourQuarterBorder = ta.getBoolean(R.styleable.BorderLinearLayout_needFourQuarterBorder,false);
        ta.recycle();
        init();
    }


    private void init() {
        mPaint = new Paint();
        mPaint.setColor(mPaintColor);
        mPaint.setAntiAlias(true);
        mPaint.setStrokeWidth(mBorderStrokeWidth);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        //  画4个边
        if (isNeedTopBorder) {
            canvas.drawLine(0, 0, this.getWidth(), 0, mPaint);
        }
        if (isNeedBottomBorder) {
            canvas.drawLine(mBorderBottomLeftBreakSize, this.getHeight(), this.getWidth() - mBorderBottomRightBreakSize, this.getHeight(), mPaint);
        }
        if (isNeedLeftAndRightBorder) {
            canvas.drawLine(0, 0, 0, this.getHeight(), mPaint);
            canvas.drawLine(this.getWidth(), 0, this.getWidth(), this.getHeight(), mPaint);
        }
        if (isNeedLeftBorder) {
            Log.v("hank", "isNeedLeftBorder:");
            canvas.drawLine(0, 0, 0, this.getHeight(), mPaint);
        }
        if (isNeedRightBorder) {
            Log.v("hank", "isNeedRightBorder:");
            canvas.drawLine(this.getWidth(), 0, this.getWidth(), this.getHeight(), mPaint);
        }
        if(isNeedCenterBorder){
            canvas.drawLine(this.getWidth()/2,0,this.getWidth()/2,this.getHeight(),mPaint);
            Log.v("hank", "isNeedCenterBorder:");
        }
        if(isNeedFirstQuarterBorder){
            canvas.drawLine(this.getWidth()/4,0,this.getWidth()/4,this.getHeight(),mPaint);
            Log.v("hank", "isNeedFirstQuarterBorder:");
        }
        if(isNeedFourQuarterBorder){
            canvas.drawLine(this.getWidth()/3,0,this.getWidth()/3,this.getHeight(),mPaint);
            Log.v("hank", "isNeedFourQuarterBorder:");
        }



    }


    private void setRoundRect(Canvas canvas) {
        int width = getWidth();
        int height = getHeight();

        mPaint.setColor(Color.BLUE);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(5);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            canvas.drawRoundRect(2.5f, 2.5f, width - 2.5f, height - 2.5f, 100, 100, mPaint);
        }
    }

    /**
     * 设置边框颜色
     *
     * @param color
     */
    public void setBorderColor(int color) {
        mPaint.setColor(color);
        invalidate();
    }

    /**
     * 设置边框宽度
     *
     * @param size
     */
    public void setBorderStrokeWidth(float size) {
        mPaint.setStrokeWidth(size);
        invalidate();
    }


    /**
     * 设置是否需要顶部边框
     *
     * @param needtopborder
     */
    public void setNeedTopBorder(boolean needtopborder) {
        isNeedTopBorder = needtopborder;
        invalidate();
    }

    /**
     * 设置是否需要底部边框
     *
     * @param needbottomborder
     */
    public void setNeedBottomBorder(boolean needbottomborder) {
        isNeedBottomBorder = needbottomborder;
        invalidate();
    }
}
