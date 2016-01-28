package com.beat.databiao;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;
import android.os.Bundle;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ActionBar.LayoutParams;
import android.content.Context;
@SuppressLint("NewApi")
public class MainActivity extends Activity {
	@ViewInject(R.id.scrollview)
	private HorizontalScrollView hsv;
	@ViewInject(R.id.lay)
	private LinearLayout lay;
	@ViewInject(R.id.lays)
	private LinearLayout lays;
	private Context context;
	private static int[] temp = {3,16,7,25,18,12,30};
	private static int[] temps = {3,14,4,32,14,14,0};
	private static String[] time = {"星期一","星期二","星期三","星期四","星期五","星期六","星期日"};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ViewUtils.inject(this);
		context = this;
		initDate();
	}
	private void initDate() {
		ShiView ssvv = new ShiView(context,temp,temps,time);
		LayoutParams lpp = new LayoutParams(1500, 600);
		ssvv.setLayoutParams(lpp);
		lay.addView(ssvv);
		ShiViews ssvvs = new ShiViews(context);
		LayoutParams lpps = new LayoutParams(1500, 600);
		ssvvs.setLayoutParams(lpps);
		lays.addView(ssvvs);
	}
	
}
