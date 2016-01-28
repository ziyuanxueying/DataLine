package com.beat.databiao;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;
import android.webkit.WebSettings.TextSize;
public class ShiViews extends View {
	public ShiViews(Context context) {
		super(context);
	}
	@SuppressLint("DrawAllocation")
	@Override
	protected void onDraw(Canvas canvas) {
		// TODO Auto-generated method stub
		super.onDraw(canvas);
		Paint paint = new Paint(); 
		/* 去锯齿 */ 
		paint.setAntiAlias(true); 
		/* 设置paint的颜色 */ 
		paint.setColor(Color.WHITE);
		paint.setStyle(Paint.Style.STROKE); 
		paint.setStrokeWidth(2);  
		//划线
		canvas.drawLine(0.0f, 40.0f, 1400.0f*72, 40.f, paint);
		canvas.drawLine(0.0f, 80.0f, 1400.0f*72, 80.0f, paint);
		canvas.drawLine(0.0f, 120.0f, 1400.0f*72, 120.0f, paint);
		canvas.drawLine(0.0f, 160.0f, 1400.0f*72, 160.f, paint);
		canvas.drawLine(0.0f, 200.0f, 1400.0f*72, 200.0f, paint);
		canvas.drawLine(0.0f, 240.0f, 1400.0f*72, 240.0f, paint);
		canvas.drawLine(0.0f, 280.0f, 1400.0f*72, 280.0f, paint);
		canvas.drawLine(0.0f, 320.0f, 1400.0f*72, 320.0f, paint);
		canvas.drawLine(0.0f, 360.0f, 1400.0f*72,360.0f, paint);
		canvas.drawLine(0.0f, 400.0f, 1400.0f*72,400.0f, paint);
		canvas.drawLine(0.0f, 440.0f, 1400.0f*72,440.0f, paint);
		canvas.drawLine(0.0f, 480.0f, 1400.0f*72,480.0f, paint);
		canvas.drawLine(0.0f, 520.0f, 1400.0f*72,520.0f, paint);
		canvas.drawLine(0.0f, 560.0f, 1400.0f*72,560.0f, paint);
		//纵坐标
		paint.reset();
		paint.setColor(Color.GREEN);
		paint.setStyle(Paint.Style.STROKE);
		paint.setStrokeWidth(2);
		paint.setTextSize(24);
		canvas.drawText("30", 10, 80, paint); 
		canvas.drawText("25", 10, 160, paint); 
		canvas.drawText("20", 10, 240, paint); 
		canvas.drawText("15", 10, 320, paint); 
		canvas.drawText("10", 10, 400, paint); 
		canvas.drawText("  5", 10, 480, paint); 
		canvas.drawText("  0", 10, 560, paint); 
	}
}
