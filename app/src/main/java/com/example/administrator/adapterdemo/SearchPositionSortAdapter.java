package com.example.administrator.adapterdemo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;



import java.util.List;

/**
 * 居住地界面adapter
 * Created  2017/2/14 0014.
 */
public class SearchPositionSortAdapter extends RecyclerView.Adapter<ExampleViewHolder> {

    public static final int TYPE_TITLE = 0;
    public static final int TYPE_CITY = 1;

    private SparseArray<SelectBean> mSparseArray;

    private final Context context;

    private List<String> cityTitle;// 城市拼音字母数据
    private List<List<String>> cityNames;

    public SearchPositionSortAdapter(Context context, List<String> cityTitle, List<List<String>> map) {
        this.context = context;
        this.cityTitle = cityTitle;
        cityNames = map;
        mSparseArray = new SparseArray<>();
    }

    private SparseArray getCurrentChooseItem() {
        return mSparseArray;
    }

    @Override
    public ExampleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        switch (viewType) {
            case TYPE_TITLE:
                return new CityTitleHolder(R.layout.item_choose_location_title, parent, viewType, 100);

            case TYPE_CITY:
                return new CityNameHolder(R.layout.item_choose_location_cityname, parent, viewType);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(ExampleViewHolder holder, int position) {
        if (holder instanceof CityNameHolder) {
            holder.refreshData(cityNames.get(position / 2), position);
        } else if (holder instanceof CityTitleHolder) {
            holder.refreshData(cityTitle.get(position / 2), position);
        }
    }

    @Override
    public int getItemCount() {
        return cityTitle.size() * 2;
    }

    @Override
    public int getItemViewType(int position) {
        if (position % 2 == 0) {
            return TYPE_TITLE;
        } else {
            return TYPE_CITY;
        }
    }

//    ===================ViewHolder======================

    /**
     * GridView形状的RecyclerView
     */
    class CityNameHolder extends ExampleViewHolder<List<String>> {
        RecyclerView revCityname;

        private List<String> data;

        public CityNameHolder(int viewId, ViewGroup parent, int viewType) {
            super(viewId, parent, viewType);
            this.revCityname = (RecyclerView) itemView.findViewById(R.id.rev_cityname);
        }


        @Override
        public void refreshData(List<String> data, int position) {
            super.refreshData(data, position);
            this.data = data;
            revCityname.setLayoutManager(new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL));
            //  某一行的id
            GridAdapter gridAdapter = new GridAdapter(position);
            revCityname.setAdapter(gridAdapter);
        }

        private class GridAdapter extends RecyclerView.Adapter<ExampleViewHolder> {
            // 这一行的 id
            private int CurrenIndex;

            public GridAdapter(int Currentpos) {
                super();
                this.CurrenIndex = Currentpos;
            }

            @Override
            public ExampleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                final CityTitleHolder cityTitleHolder = new CityTitleHolder(R.layout.item_gridview_cityname, parent, viewType, CurrenIndex);
                cityTitleHolder.title.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // 拿到当前的 对象
                        SelectBean mSelectbean = new SelectBean(cityTitleHolder.getAdapterPosition(), cityTitleHolder.title.getText().toString());
                        // 没有选中的
                        if (mSparseArray.get(CurrenIndex) == null) {
                            mSparseArray.put(CurrenIndex, mSelectbean);
                        } else {      // 有选中的
                            if (mSparseArray.get(CurrenIndex).equals(mSelectbean)) {
                                mSparseArray.remove(CurrenIndex);
                            } else {
                                mSparseArray.remove(CurrenIndex);
                                mSparseArray.put(CurrenIndex, mSelectbean);
                            }
                        }
                        // 点击完首先当前界面
                        notifyDataSetChanged();
                    }
                });
                return cityTitleHolder;
            }

            @Override
            public void onBindViewHolder(ExampleViewHolder holder, int position) {
                holder.refreshData(data.get(position), position);
            }

            @Override
            public int getItemCount() {
                return data.size();
            }
        }
    }

    /**
     * 普通条目hodler
     */
    private class CityTitleHolder extends ExampleViewHolder<String> {
        //        当前行的index ;
        private int CurrentIndex;
        private TextView title;

        public CityTitleHolder(int viewId, ViewGroup parent, int viewType, int posIndex) {
            super(viewId, parent, viewType);
            title = (TextView) itemView.findViewById(R.id.title);
            CurrentIndex = posIndex;
//            ViewGroup.LayoutParams layoutParams = title.getLayoutParams();
//            layoutParams.width = layoutParams.height = DisplayUtil.getScreenWidth(context) / 3;
//            title.setLayoutParams(layoutParams);
        }

        //if (mSparseArray.get(CurrentIndex).getCurrentPos() == position && mSparseArray.get(CurrentIndex).getCurrentData().equals(data))
        @Override
        public void refreshData(String data, int position) {
            super.refreshData(data, position);
            if (CurrentIndex % 2 == 1) {
                if (mSparseArray.get(CurrentIndex) != null && mSparseArray.get(CurrentIndex).equals(new SelectBean(position, data))) {
                    title.setTextColor(context.getResources().getColor(R.color.app_focus));
                    title.setBackgroundResource(R.drawable.shape_gridview_item_select);
                } else {
                    title.setTextColor(context.getResources().getColor(R.color.text_color2));
                    title.setBackgroundResource(R.drawable.shape_gridview_item);
                }
               /* if (mSparseArray.get(CurrentIndex) == null) {
                    title.setTextColor(context.getResources().getColor(R.color.text_color2));
                    title.setBackgroundResource(R.drawable.shape_gridview_item);
                } else {

                }*/

            }
            title.setText(data);
//            mSparseArray.
        }
    }

}
