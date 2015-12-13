package com.hammad.zipper.lock;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView;

public class ZipperActivity extends Activity {
	
	/*Here is nine images in arrey
	 *  you can add 10 wih name s1 
	 *  and open case 9 that is in 
	 *  comment in set image function*/
	private ImageView zipImageView;
	private final int[] IMAGE_UNZIP = { R.drawable.s2,
			R.drawable.s3, R.drawable.s4, R.drawable.s5, R.drawable.s6,
			R.drawable.s7, R.drawable.s8, R.drawable.s9, R.drawable.s10 };
	private int frameNumber = 0;
	private boolean isDownFromStart = false;
	private int mScreenHeight;
	private int mScreenWidth;
	private int mStartWidthRange;
	private int mEndWidthRange;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_zip);
		zipImageView = (ImageView)findViewById(R.id.zipImageView);
		  zipImageView.setBackgroundResource(IMAGE_UNZIP[0]);
		  new Handler(new Handler.Callback() {

		   public boolean handleMessage(Message paramMessage) {
		    zipImageView.setBackgroundResource(IMAGE_UNZIP[paramMessage.arg1]);
		    frameNumber = paramMessage.arg1;
		    return false;
		   }
		  });
		  zipImageView.setOnTouchListener(new OnTouchListener() {

		   @SuppressLint("ClickableViewAccessibility")
		   @Override
		   public boolean onTouch(View v, MotionEvent event) {
		    
		    int i = 0;

		    mScreenHeight = zipImageView.getHeight();
		    mScreenWidth = zipImageView.getWidth();

		    mStartWidthRange = (2 * (mScreenWidth / 5));
		    mEndWidthRange = (3 * (mScreenWidth / 5));

		    switch (event.getAction()) {
		    case MotionEvent.ACTION_DOWN:

		    
		     
		     if ((event.getY() < mScreenHeight /4)
		       && (event.getX() > mStartWidthRange)
		       && (event.getX() < mEndWidthRange)) {
		     
		      isDownFromStart = true;

		     } else
		      isDownFromStart = false;

		     break;
		    case MotionEvent.ACTION_MOVE:
		     
		     
		     if (isDownFromStart)

		      if ((event.getX() > mStartWidthRange)
		        && (event.getX() < mEndWidthRange)
		        && isDownFromStart) {
		       
		       i = (int) (event.getY() / (mScreenHeight /9));
		       setImage(i);
		      }

		     break;

		    case MotionEvent.ACTION_UP:
		    
		     
		     if (frameNumber >= 8) {
		      frameNumber = 0;
		      isDownFromStart = true;
		      
		     
		      
		      
		      finish();
		      
		     }

		     else {
		      frameNumber = 0;
		      setImage(0);
		      

		     }

		     break;
		    default:
		     break;
		    }
		    return true;
		   }
		  });
		  
		
		
	}
	
	/*Changing Frames of Zipper*/
    private void setImage(int paramInt) {
		switch (paramInt) {

		case 0:
			zipImageView.setBackgroundResource(IMAGE_UNZIP[0]);
			frameNumber = 1;
			
			break;
		case 1:
			zipImageView.setBackgroundResource(IMAGE_UNZIP[1]);
			frameNumber = 2;
			
			
			break;
		case 2:
			zipImageView.setBackgroundResource(IMAGE_UNZIP[2]);
			frameNumber = 3;
			
			break;
		case 3:
			zipImageView.setBackgroundResource(IMAGE_UNZIP[3]);
			frameNumber = 4;
			
			
			break;
		case 4:
			zipImageView.setBackgroundResource(IMAGE_UNZIP[4]);
			frameNumber = 5;
			
			break;

		case 5:
			zipImageView.setBackgroundResource(IMAGE_UNZIP[5]);
			frameNumber = 6;
			
			break;
		case 6:
			zipImageView.setBackgroundResource(IMAGE_UNZIP[6]);
			frameNumber = 7;
			
			
			
			break;
		case 7:
			zipImageView.setBackgroundResource(IMAGE_UNZIP[7]);
			frameNumber = 8;
			
			break;
		case 8:
			zipImageView.setBackgroundResource(IMAGE_UNZIP[8]);
			frameNumber = 9;
			break;
		/*case 9:
			zipImageView.setBackgroundResource(IMAGE_UNZIP[9]);
			frameNumber = 10;
			break;*/

		default:
			return;
		}
	}

}
