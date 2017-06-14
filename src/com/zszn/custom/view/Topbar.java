package com.zszn.custom.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.zszn.server.R;

public class Topbar extends RelativeLayout{
	
	private Button leftButton,rightButton;
	private Button tvTitle;
	
	private String leftText;
	private int leftColor;
	private float leftTextSize;
	private Drawable leftBackground;
	
	
	private String rightText;
	private int rightColor;
	private float rightTextSize;
	private Drawable rightBackground;
	
	private String title;
	private int titleTextColor;
	private float titleTextSize;
	private Drawable titleBackground;
	
	private LayoutParams  leftParams, rightParams,titleParams;
	
	private topbarClickListener listener;
	
	public interface topbarClickListener{
		public void leftClick();
		public void rightClick();
//		public void titleClick();
	}
	
	public void setOnTopbarClickListener(topbarClickListener listener){
		this.listener = listener;
	}
	
	/**
	 * 重 写构造方法
	 * @param context
	 * @param attrs
	 */
	public Topbar(Context context) {
		this(context, null);
	}


	
	public Topbar(final Context context, AttributeSet attrs) {
		super(context, attrs);
		/**
		 * 获取自定义控件
		 */
		TypedArray typeArray = context.obtainStyledAttributes(attrs, R.styleable.MyTopbar);
		
		leftText = typeArray.getString(R.styleable.MyTopbar_left_titletext);
		leftColor = typeArray.getColor(R.styleable.MyTopbar_left_titleColor, 0);
		leftTextSize = typeArray.getDimension(R.styleable.MyTopbar_left_titleSize,0);
		leftBackground = typeArray.getDrawable(R.styleable.MyTopbar_left_backgroud);
		
		rightText = typeArray.getString(R.styleable.MyTopbar_right_titletext);
		rightColor = typeArray.getColor(R.styleable.MyTopbar_right_titleColor, 0);
		rightTextSize = typeArray.getDimension(R.styleable.MyTopbar_right_titleSize, 0);
		rightBackground = typeArray.getDrawable(R.styleable.MyTopbar_right_backgroud);
		
		title = typeArray.getString(R.styleable.MyTopbar_center_title);
		titleTextColor = typeArray.getColor(R.styleable.MyTopbar_center_titleColor, 0);
		titleTextSize = typeArray.getDimension(R.styleable.MyTopbar_center_titleSize, 0);
		titleBackground = typeArray.getDrawable(R.styleable.MyTopbar_center_backgroud);
		
		typeArray.recycle();
		
		//添加左侧按扭
		leftButton = new Button(context);
		leftButton.setText(leftText);
		leftButton.setTextColor(leftColor);
//		leftButton.setTextSize(leftTextSize);
		leftButton.setBackgroundDrawable(leftBackground);
		//  view中添加控件
		leftParams = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
		leftParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT,TRUE);
		addView(leftButton,leftParams);
		
	
		//添加title
		tvTitle = new Button(context);
		tvTitle.setText(title);
		tvTitle.setTextColor(titleTextColor);
//		tvTitle.setTextSize(titleTextSize);
		tvTitle.setBackgroundDrawable(titleBackground);
		tvTitle.setGravity(Gravity.CENTER);
		// view中添加控件
		titleParams = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
		titleParams.addRule(RelativeLayout.CENTER_IN_PARENT,TRUE);
		addView(tvTitle,titleParams);
		
		
		rightButton = new Button(context);
		rightButton.setText(rightText);
		rightButton.setTextColor(rightColor);
//		rightButton.setTextSize(rightTextSize);
//		rightButton.setBackground(rightBackground);
		rightButton.setBackgroundDrawable(rightBackground);
	//  view中添加控件
		rightParams = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
		rightParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT,TRUE);
		addView(rightButton,rightParams);
		
		

		
//		setBackgroundColor(0X99ccff);
		
		leftButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				listener.leftClick();
			}
		});
		
		rightButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				listener.rightClick();
			}
		});
		
	}
	
	public Topbar(Context context, AttributeSet attrs, int defStyle) {
		this(context, attrs);
	}
	
	public void setTitleText(String title_name){
		title = title_name;
		tvTitle.setText(title);
	}
	
	//是否显示
	public void setLeftIsvisable(boolean flag){
		if(flag){
			leftButton.setVisibility(View.VISIBLE);
		}else {
			leftButton.setVisibility(View.GONE);
		}
	}
	
	public void setRightIsvisable(boolean flag){
		if(flag){
			rightButton.setVisibility(View.VISIBLE);
		}else {
			rightButton.setVisibility(View.GONE);
		}
	}

}
