package com.example.carrene.imenuapp.Interface;

import android.support.v7.widget.RecyclerView;

/**
 * Created by carrene on 13/8/2018.
 */

public interface RecyclerItemTouchHelperListener {
    void onSwiped(RecyclerView.ViewHolder viewHolder, int direction, int position);
}
