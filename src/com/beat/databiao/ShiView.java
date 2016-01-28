package com.beat.databiao;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;
public class ShiView extends View {
	int[] temp = new int[7];
	int[] temps = new int[7];
	String[] dayTime = new String[7];
	private Context context;
	private Canvas canvass;
	private Paint paint;
	private Paint paints;
	public ShiView(Context context, int[] temp, int[] temps, String[] dayTime) {
		super(context);
		this.temp = temp;
		this.temps = temps;
		this.dayTime = dayTime;
		this.context = context;
	}
	public ShiView(Context context) {
		super(context);
	}
	public ShiView(Context context, AttributeSet attrs) {
		super(context, attrs);
		
	}
	
	@SuppressLint("DrawAllocation")
	@Override
	protected void onDraw(Canvas canvas) {
		// TODO Auto-generated method stub
		super.onDraw(canvas);
		canvass = canvas;
		paint = new Paint(); 
		paints = new Paint(); 
		/* 去锯齿 */ 
		paint.setAntiAlias(true); 
		paints.setAntiAlias(true); 
		
		//纵坐标
		paint.reset();
		paint.setColor(Color.WHITE);
		paint.setStyle(Paint.Style.FILL); 
		paint.setStrokeWidth(2); 
		paint.setTextSize(20); 
		//横坐标
		for(int i=0;i<7;i++){
			canvas.drawText(dayTime[i], i*200+100, 590, paint);
		}
		//折线
		paint.reset();
		paint.setColor(Color.WHITE);
		paint.setStyle(Paint.Style.STROKE); 
		paint.setStrokeWidth(2); 
		paints.reset();
		paints.setColor(Color.RED);
		paints.setTextSize(25);
		paints.setStyle(Paint.Style.STROKE); 
		paints.setStrokeWidth(2); 
		Path path = new Path(); 
		Path paths = new Path(); 
		path.moveTo(115,  560-temp[0]*16);
		paths.moveTo(115,  560-temps[0]*16);
		for(int i=1;i<7;i++){
			path.lineTo(i*200+115,  560-temp[i]*16);
			paths.lineTo(i*200+115,  560-temps[i]*16);
		}
		canvas.drawPath(path, paint); 
		canvas.drawPath(paths, paint); 
		paint.reset();
		paint.setColor(Color.WHITE); 
		// 设置样式-填充 
		paint.setStyle(Style.FILL); 
		// 绘图 // 从资源文件中生成位图 
		for(int i=0;i<7;i++){
			int tempy = (int)temp[i];
			int tempsy = (int)temps[i];
			if((tempy - tempsy) < 4 && (tempy - tempsy) > 0){
				canvas.drawText(temp[i]+"", i*200+105, 540-temp[i]*(float)16, paints);
				canvas.drawText(temps[i]+"", i*200+105, 595-temps[i]*(float)16, paints);
			}else if((tempy - tempsy) > -4 && (tempy - tempsy) < 4 && (tempy - tempsy) < 0){
				canvas.drawText(temp[i]+"", i*200+105, 595-temp[i]*(float)16, paints);
				canvas.drawText(temps[i]+"", i*200+105, 540-temps[i]*(float)16, paints);
			}else{
				canvas.drawText(temp[i]+"", i*200+105, 540-temp[i]*(float)16, paints);
				canvas.drawText(temps[i]+"", i*200+105, 540-temps[i]*(float)16, paints);
			}
			canvas.drawCircle(i*200+115, 560-temp[i]*(float)16, 12, paint);
			canvas.drawCircle(i*200+115, 560-temps[i]*(float)16, 12, paint);
		}
	}
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		  float x = event.getX();   
          float y = event.getY();   
          for(int i=0;i<7;i++){
        	  float tempx = i*200+115;
        	  float tempys = 560-temps[i]*(float)16;
        	  float tempy = 560-temp[i]*(float)16;
        	  if(x >= (tempx-15)  && x <= (tempx+15) && y <= tempys+15 && y >= tempys-15){
        		  canvass.drawCircle(i*200+115, 560-temps[i]*(float)16, 12, paint);
        		  Toast.makeText(context,temps[i]+"", Toast.LENGTH_SHORT).show();
        		  break;
        	  }
        	  if(x >= (tempx-15)  && x <= (tempx+15) && y <= tempy+15 && y >= tempy-15){
        		  Toast.makeText(context,temp[i]+"", Toast.LENGTH_SHORT).show();
        		  break;
        	  }
          }
          return super.onTouchEvent(event);
	}
}
