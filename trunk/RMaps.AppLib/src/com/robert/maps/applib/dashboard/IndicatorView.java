package com.robert.maps.applib.dashboard;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.robert.maps.applib.R;

public class IndicatorView extends RelativeLayout {
	private String mIndicatorTag;

	public IndicatorView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
	}

	public IndicatorView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public IndicatorView(Context context) {
		super(context);
	}

	@Override
	protected void onLayout(boolean changed, int l, int t, int r, int b) {
		super.onLayout(changed, l, t, r, b);
	}
	
	public void setIndicatorTag(String tag) {
		mIndicatorTag = tag;
	}

	public void updateIndicator(IndicatorManager indicatorManager) {
		if(indicatorManager.getIndicators().containsKey(mIndicatorTag)) {
			if(mIndicatorTag.equalsIgnoreCase(Indicator.GPSELEV) 
					|| mIndicatorTag.equalsIgnoreCase(Indicator.GPSACCURACY)
					|| mIndicatorTag.equalsIgnoreCase(Indicator.GPSSPEED)
					) {
				final String[] val = (String[]) indicatorManager.getIndicators().get(mIndicatorTag);
				((TextView)findViewById(R.id.data_value)).setText(val[0]);
				((TextView)findViewById(R.id.data_unit)).setText(val[1]);
			} else {
				((TextView)findViewById(R.id.data_value)).setText(indicatorManager.getIndicators().get(mIndicatorTag).toString());
			}
		}
	}
}