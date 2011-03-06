package com.osesm.pifft;

import android.app.ListFragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class GalleryFragment extends ListFragment implements OnTouchListener {

  private static final String TAG = "GalleryFragment";
  
  @Override
  public void onActivityCreated(Bundle savedInstanceState) {
    super.onActivityCreated(savedInstanceState);

    String[] countries = getResources().getStringArray(R.array.countries_array);
    setListAdapter(new ArrayAdapter<String>(getActivity(), R.layout.list_item, countries));

    getView().setOnTouchListener(this);

  }

  public boolean onTouch(View v, MotionEvent event) {

    dumpEvent(event);

    return false;
  }

  private void dumpEvent(MotionEvent event) {
    String names[] = { "DOWN", "UP", "MOVE", "CANCEL", "OUTSIDE", "POINTER_DOWN", "POINTER_UP", "7?", "8?", "9?" };
    StringBuilder sb = new StringBuilder();
    int action = event.getAction();
    int actionCode = action & MotionEvent.ACTION_MASK;
    sb.append("event ACTION_").append(names[actionCode]);
    if (actionCode == MotionEvent.ACTION_POINTER_DOWN || actionCode == MotionEvent.ACTION_POINTER_UP) {
      sb.append("(pid ").append(action >> MotionEvent.ACTION_POINTER_ID_SHIFT);
      sb.append(")");
    }
    sb.append("[");
    for (int i = 0; i < event.getPointerCount(); i++) {
      sb.append("#").append(i);
      sb.append("(pid ").append(event.getPointerId(i));
      sb.append(")=").append((int) event.getX(i));
      sb.append(",").append((int) event.getY(i));
      if (i + 1 < event.getPointerCount())
        sb.append(";");
    }
    sb.append("]");
    Log.d(TAG, sb.toString());
  }

}
