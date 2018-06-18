package com.xplores.inventory;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.taimour1446.advanceviewholder.AdvanceViewHolder;
import com.taimour1446.advanceviewholder.interfaces.AdvanceRecyclerViewItem;

import com.xplores.inventory.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class ItemRecyclerView extends RecyclerView.Adapter<AdvanceViewHolder> implements AdvanceRecyclerViewItem.OnItemLongClickListener, AdvanceRecyclerViewItem.OnItemClickListener {

    /**
     * View Object binding with ButterKnife library
     */
    @BindView(R.id.text_item_title) TextView txtItemTitle;
    @BindView(R.id.text_item_quantity) TextView txtItemQuantity;

    /**
     * Data Members
     */
    private Context mContext;
    private List<Item> mList;
    private FragmentManager mFragmentManager;



    public ItemRecyclerView(Context context, List list, FragmentManager fragmentManager){
        this.mContext = context;
        this.mList = list;
        this.mFragmentManager = fragmentManager;
    }

    @Override
    public AdvanceViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // Inflate the layout for this fragment
        View view = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.item_item ,parent, false);
        // Init  ButterKnife to bind with view objects
        ButterKnife.bind(this,view);
        // Binding BaseViewHolder
        AdvanceViewHolder holder = new AdvanceViewHolder(view);
        holder.setOnItemClickListener(this);
        holder.setOnItemLongClickListener(this);
        return holder;
    }

    @Override
    public void onBindViewHolder(AdvanceViewHolder holder, int position) {
        // Get current object from list
        final Item item = mList.get(position);
        // Assign values to fields
        txtItemTitle.setText(item.getTitle());
        txtItemQuantity.setText(item.getQuantity());
    }

    @Override
    public int getItemCount() {
        return mList == null ? 0 : mList.size();
    }

    /**
     * Custom listener invoked when an item in some specifc list is clicked
     * @param position contains the current item index in the list
     * @param view contaings the current view clicked
     */
    @Override
    public void onItemClick(int position, View view) {
        // Get current object from list
        final Item item = mList.get(position);
        Toast.makeText(mContext,"onItemClick:" + item.getTitle(), Toast.LENGTH_SHORT ).show();
    }

    /**
     * Custom listener invoked when an item in some specifc list is clicked
     * @param position contains the current item index in the list
     * @param view contaings the current view clicked
     */
    @Override
    public boolean onItemLongClick(int position, View view) {
        final Item item = mList.get(position);
        Toast.makeText(mContext,"onItemLongClick:" + item.getTitle(), Toast.LENGTH_SHORT ).show();
        return true;
    }
}
