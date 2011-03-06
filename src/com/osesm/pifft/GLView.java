package com.osesm.pifft;

import android.content.Context;
import android.opengl.GLSurfaceView;

public class GLView extends GLSurfaceView {

  private final GLRenderer renderer;

  GLView(Context context) {
    super(context);
    
    renderer = new GLRenderer(context);
    setRenderer(renderer);
  }
  
}
