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
MIT License

Copyright (c) 2018 TAIMOUR KHAN KHAN

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.

```
