package com.example.aanchalsingh.roposo_stories_task.Utils;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.ImageView;

/**
 * Created by Ritika on 13-06-2016.
 */
class CustomAllroundedImageView extends ImageView {

    public CustomAllroundedImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CustomAllroundedImageView(Context context) {
        super(context);
        init();
    }

    private final RectF roundRect = new RectF();
    private float rectRadius = 5;
    private final Paint maskPaint = new Paint();
    private final Paint zonePaint = new Paint();

    private void init() {
        maskPaint.setAntiAlias(true);
        maskPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        zonePaint.setAntiAlias(true);
        zonePaint.setColor(Color.WHITE);
        float density = getResources().getDisplayMetrics().density;
        rectRadius = rectRadius * density;
    }

    public void setRectAdius(float adius) {
        rectRadius = adius;
        invalidate();
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        int w = getWidth();
        int h = getHeight();

        roundRect.set(0, 0, w, h);
    }

    @Override
    public void draw(Canvas canvas) {
        canvas.saveLayer(roundRect, zonePaint, Canvas.ALL_SAVE_FLAG);
        canvas.drawRoundRect(roundRect, rectRadius, rectRadius, zonePaint);
        canvas.saveLayer(roundRect, maskPaint, Canvas.ALL_SAVE_FLAG);
        super.draw(canvas);
        canvas.restore();
    }
}
