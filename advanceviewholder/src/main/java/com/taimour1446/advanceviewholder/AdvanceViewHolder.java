package com.taimour1446.advanceviewholder;

import android.graphics.Color;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;
import android.view.View;

import com.taimour1446.advanceviewholder.interfaces.AdvanceRecyclerViewItem;

/**
 * Created by Taimour Awais Khan on 18/11/2017.
 * Base class to be extended by all ViewHolder to use some Generic functionality
 */

public class AdvanceViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener, AdvanceRecyclerViewItem.OnItemClickListener, AdvanceRecyclerViewItem.OnItemLongClickListener {
    /**
     * Data Members
     */
    public View layout;
    private AdvanceRecyclerViewItem.OnItemClickListener mOnItemClickListener;
    private AdvanceRecyclerViewItem.OnItemLongClickListener mOnItemLongClickListener;

    /**
     * Constructor
     *
     * @param v contains current view
     */
    public AdvanceViewHolder(View v) {
        super(v);
        this.layout = v;
        // Bind recyclerViewItem click listener
        this.layout.setOnClickListener(this);
        this.layout.setOnLongClickListener(this);
        enableSelectedIndicator(Color.parseColor("#c5ccd2"));
    }

    public void setOnItemClickListener(AdvanceRecyclerViewItem.OnItemClickListener onItemClickListener) {
        this.mOnItemClickListener = onItemClickListener;
    }

    public void setOnItemLongClickListener(AdvanceRecyclerViewItem.OnItemLongClickListener onItemLongClickListener) {
        this.mOnItemLongClickListener = onItemLongClickListener;
    }

    public void enableSelectedIndicator(final int rowColor) {
        if (itemView == null)
            return;
        itemView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    layout.setBackgroundColor(rowColor);
                }
                if (event.getAction() == MotionEvent.ACTION_UP || event.getAction() == MotionEvent.ACTION_CANCEL) {
                    layout.setBackgroundColor(Color.TRANSPARENT);
                }
                return false;
            }
        });
    }

    public void disableSelectedIndicator() {
        if (itemView == null)
            return;
        itemView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return false;
            }
        });
    }

    @Override
    public void onClick(View v) {
        System.out.println("OnClick");
        onItemClick(getAdapterPosition(), v);
    }

    @Override
    public boolean onLongClick(View v) {
        System.out.println("onLongClick");
        return onItemLongClick(getAdapterPosition(), v);
    }

    @Override
    public void onItemClick(int position, View view) {
        if (this.mOnItemClickListener != null)
            this.mOnItemClickListener.onItemClick(position, view);

    }

    @Override
    public boolean onItemLongClick(int position, View view) {
        if (this.mOnItemLongClickListener != null)
            return this.mOnItemLongClickListener.onItemLongClick(position, view);
        return true;
    }
}
