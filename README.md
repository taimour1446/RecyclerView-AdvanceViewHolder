# RecyclerView-AdvanceViewHolder
RecyclerView AdvanceViewHolder library for Android Applications to easily give you OnItemClickListener and OnItemLongClickListener 


# Download

Add the dependency to your add module `build.gradle` file:

```
dependencies {
    compile 'com.github.taimour1446:RecyclerView-AdvanceViewHolder:v1.0'
}

```
# Usage
Follow these steps to use this library

In your RecyclerView.Adapter class,
Change 
````java
RecyclerView.Adapter<ViewHolder> to RecyclerView.Adapter<AdvanceViewHolder>
````
Change your onCreateViewHolder method
````java

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
        //holder.enableSelectedIndicator(R.color.colorAccent);
        return holder;
    }
````

Change your onBindViewHolder method
````java
    @Override
    public void onBindViewHolder(AdvanceViewHolder holder, int position) {
        // Get current object from list
        final Item item = mList.get(position);
        // Assign values to fields
        txtItemTitle.setText(item.getTitle());
        txtItemQuantity.setText(item.getQuantity());
    }
````

Finally implement  **AdvanceRecyclerViewItem.OnItemLongClickListener** and **AdvanceRecyclerViewItem.OnItemClickListener** in your **RecyclerView.Adapter<AdvanceViewHolder>** class


See sample code for [ItemRecyclerView](https://github.com/taimour1446/RecyclerView-AdvanceViewHolder/blob/master/app/src/main/java/com/xplores/inventory/ItemRecyclerView.java) for better understanding

# License
```
Copyright 2016 Mayowa Adegeye

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
