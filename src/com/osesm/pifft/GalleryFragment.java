package com.osesm.pifft;

import android.app.ListFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class GalleryFragment extends ListFragment {

  @Override
  public void onActivityCreated(Bundle savedInstanceState) {
    super.onActivityCreated(savedInstanceState);
    
    String[] countries = getResources().getStringArray(R.array.countries_array);
    setListAdapter(new ArrayAdapter<String>(getActivity(), R.layout.list_item, countries));

    
  }


}
