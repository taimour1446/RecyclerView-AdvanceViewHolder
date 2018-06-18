package com.taimour1446.advanceviewholder.interfaces;

import android.view.View;

public class AdvanceRecyclerViewItem {


    public interface OnItemClickListener{
        /**
         * Custom listener invoked when an item in some specifc list is clicked
         * @param position contains the current item index in the list
         * @param view contaings the current view clicked
         */
        void onItemClick(int position,View view);
    }
    public interface OnItemLongClickListener{
        /** Custom listener invoked when an item in some specifc list is clicked
         * @param position contains the current item index in the list
         * @param view contaings the current view clicked
         */
        boolean onItemLongClick(int position,View view);
    }

}
