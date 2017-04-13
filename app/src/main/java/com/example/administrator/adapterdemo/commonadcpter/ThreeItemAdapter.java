package com.example.administrator.adapterdemo.commonadcpter;

import android.content.Context;
import android.view.View;
import android.widget.TextView;


import com.example.administrator.adapterdemo.R;

import java.util.List;


/**
 * @data 2017/4/12 0012
 * @aurher Administrator
 */

public class ThreeItemAdapter extends MultiItemRecycleViewAdapter<ThreeItemInfo> {
    private static final int TYPE_ONE = 0;
    private static final int TYPE_TWO = 1;
    private static final int TYPE_THREE = 2;

    public ThreeItemAdapter(Context context, List<ThreeItemInfo> datas) {
        super(context, datas, new MultiItemTypeSupport<ThreeItemInfo>() {
            @Override
            public int getLayoutId(int itemType) {
                int i = 0;
                switch (itemType) {
                    case TYPE_ONE:
                        i = R.layout.item_one_threeitem;
                        break;
                    case TYPE_TWO:
                        i = R.layout.item_two_threeitem;
                        break;
                    case TYPE_THREE:
                        i = R.layout.item_three_threeitem;
                        break;
                }
                return i;
            }

            @Override
            public int getItemViewType(int position, ThreeItemInfo threeItemInfo) {
                String currentCity = threeItemInfo.getStatus();
                int i = 0;
                switch (currentCity) {
                    case "1":
                        i = TYPE_ONE;
                        break;
                    case "2":
                        i = TYPE_TWO;
                        break;
                    case "3":
                        i = TYPE_THREE;
                        break;

                }
                return i;
            }
        });
    }

    @Override
    public void convert(ViewHolderHelper helper, ThreeItemInfo threeItemInfo, int position) {
        switch (helper.getLayoutId()) {
            case R.layout.item_one_threeitem:
                bindViewOne(helper, threeItemInfo, position);
                break;
            case R.layout.item_two_threeitem:
                bindViewTwo(helper, threeItemInfo, position);
                break;
            case R.layout.item_three_threeitem:
                bindViewThree(helper, threeItemInfo, position);
                break;
        }
    }

    private void bindViewOne(ViewHolderHelper helper, final ThreeItemInfo threeItemInfo, final int position) {
        TextView tv_1 = helper.getView(R.id.tv_1);
        helper.getConvertView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (threeItemInfo.getResults() != null && threeItemInfo.getResults().size() != 0 && threeItemInfo.getIsExpading()) {
                    addAllAt(position + 1, threeItemInfo.getResults());
                    threeItemInfo.setIsExpading(false);
                } else if (threeItemInfo.getResults() != null & threeItemInfo.getResults().size() != 0 && !threeItemInfo.getIsExpading()) {
                    for (ThreeItemInfo item : threeItemInfo.getResults()) {
                        if (!item.getIsExpading()) {
                            removeAll(item.getResults());
                        }
                    }
                    removeAll(threeItemInfo.getResults());
                    threeItemInfo.setIsExpading(true);
                }
            }
        });

    }

    private void bindViewTwo(ViewHolderHelper helper, final ThreeItemInfo threeItemInfo, final int position) {
        TextView tv_2 = helper.getView(R.id.tv_2);
        helper.getConvertView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (threeItemInfo.getResults() != null && threeItemInfo.getResults().size() != 0 && threeItemInfo.getIsExpading()) {
                    addAllAt(position + 1, threeItemInfo.getResults());
                    threeItemInfo.setIsExpading(false);
                } else if (threeItemInfo.getResults() != null & threeItemInfo.getResults().size() != 0 && !threeItemInfo.getIsExpading()) {
                    removeAll(threeItemInfo.getResults());
                    threeItemInfo.setIsExpading(true);
                }
            }
        });
    }

    private void bindViewThree(ViewHolderHelper helper, ThreeItemInfo threeItemInfo, final int position) {
        TextView tv_3 = helper.getView(R.id.tv_3);
        helper.getConvertView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (onItemThreeClickListener != null) {
                    onItemThreeClickListener.ThreeOnclickListener(position);
                }
            }
        });
    }

    public interface OnItemThreeClickListener {
        void ThreeOnclickListener(int position);
    }

    private OnItemThreeClickListener onItemThreeClickListener;

    public void setOnItemThreeClickListener(OnItemThreeClickListener onItemThreeClickListener) {
        this.onItemThreeClickListener = onItemThreeClickListener;
    }
}
