package com.xplores.inventory;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class ItemListFragment extends Fragment {

    /**
     * Layout Widgets Binding
     */
    @BindView(R.id.recyclerview_item) RecyclerView rvList;

    /**
     * Data Members
     */
    private ItemRecyclerView mAdapter;
    private List<Item> mList =new ArrayList<>();
    private final String TAG = this.getClass().getSimpleName();

    public ItemListFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_item, container, false);
        // Init  ButterKnife to bind with view objects
        ButterKnife.bind(this,view);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        // Init Array
        mList.add(new Item("Item 1","3"));
        mList.add(new Item("Item 2","5"));
        mList.add(new Item("Item 3","6"));
        mList.add(new Item("Item 4","2"));
        mList.add(new Item("Item 5","4"));
        // Set adapter with the Recyclerview
        mAdapter = new ItemRecyclerView(getContext(), mList, getFragmentManager());
        // Set RecyclerView LayoutManager
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        rvList.setLayoutManager(mLayoutManager);
        // Set RecyclerView adapter
        rvList.setAdapter(mAdapter);
        rvList.setHasFixedSize(false);
        // Notify data changed to update record in view
        mAdapter.notifyDataSetChanged();
    }

}
