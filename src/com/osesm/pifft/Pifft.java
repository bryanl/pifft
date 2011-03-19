package com.osesm.pifft;

import android.os.Bundle;
import android.view.View;

import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.surfaceview.FillResolutionStrategy;

public class Pifft extends AndroidApplication {

	private View pifftCanvas;

  @Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	
		FillResolutionStrategy strategy = new FillResolutionStrategy();
		
		pifftCanvas = initializeForView(new PifftCanvas(), false, strategy, 500);
		
		setContentView(R.layout.main);
	}

    public View getGdxView() {
      return pifftCanvas;
    }
	
	
}
