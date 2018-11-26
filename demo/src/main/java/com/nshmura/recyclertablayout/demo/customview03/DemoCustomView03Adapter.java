package com.nshmura.recyclertablayout.demo.customview03;

import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.text.SpannableString;
import android.text.style.StyleSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.nshmura.recyclertablayout.RecyclerTabLayout;
import com.nshmura.recyclertablayout.demo.ColorItem;
import com.nshmura.recyclertablayout.demo.R;

import java.util.List;

/**
 * *
 * *
 * Project_Name:RecyclerTabLayout
 *
 * @author zhangxc
 * @date 2018/11/26 9:14 AM
 * *
 */
public class DemoCustomView03Adapter extends RecyclerTabLayout.Adapter<DemoCustomView03Adapter.ViewHolder> {

    //    private DemoColorPagerAdapter mAdapater;

    //    public DemoCustomView03Adapter(ViewPager viewPager) {
    //        super(viewPager);
    //        mAdapater = (DemoColorPagerAdapter) mViewPager.getAdapter();
    //    }
    private RecyclerTabLayout mRecyclerTabLayout;
    private List<ColorItem> mItems;


    public DemoCustomView03Adapter(RecyclerTabLayout recyclerTabLayout, List<ColorItem> items) {
        mRecyclerTabLayout = recyclerTabLayout;
        mItems = items;
    }

    @Override
    public DemoCustomView03Adapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_custom_view01_tab, parent, false);
        return new DemoCustomView03Adapter.ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(DemoCustomView03Adapter.ViewHolder holder, final int position) {
        ColorItem colorItem = mItems.get(position);
        holder.title.setText(colorItem.name);


        SpannableString name = new SpannableString(colorItem.name);
        if (position == getCurrentIndicatorPosition()) {
            name.setSpan(new StyleSpan(Typeface.BOLD), 0, name.length(), 0);
            holder.wrapper.setBackgroundResource(R.drawable.bg_tag_stroke_green_solid_white);
            holder.color.setVisibility(View.VISIBLE);
            holder.color.setBackgroundColor(colorItem.color);
        } else {
            holder.wrapper.setBackgroundResource(R.drawable.bg_tag_stroke_green_solid_gray);
            holder.color.setVisibility(View.GONE);
        }
        holder.title.setText(name);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mRecyclerTabLayout.setCurrentItem(position, true);
            }
        });

    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public LinearLayout wrapper;
        public View color;
        public TextView title;

        public ViewHolder(View itemView) {
            super(itemView);
            wrapper = itemView.findViewById(R.id.item_wrapper);
            title = itemView.findViewById(R.id.title);
            color = itemView.findViewById(R.id.color);

        }
    }
}
