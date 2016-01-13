package name.iiii.taobaodemo.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import name.iiii.taobaodemo.R;
import name.iiii.taobaodemo.bean.HotGoods;

/**
 * 作者：李忠峰 on 2016/1/13 15:59
 * 邮箱：i@iiii.name
 */
public class HotGoodsAdapter extends RecyclerView.Adapter<HotGoodsAdapter.HotGoodsViewHolder> {
    private LayoutInflater mInflater;
    private List<HotGoods> mDatas;

    public HotGoodsAdapter(List<HotGoods> datas) {
        this.mDatas = datas;
    }

    @Override
    public HotGoodsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        mInflater = LayoutInflater.from(parent.getContext());
        return new HotGoodsViewHolder(mInflater.inflate(R.layout.hot_goods_item,parent,false));

    }

    @Override
    public void onBindViewHolder(HotGoodsViewHolder holder, int position) {
        HotGoods good = mDatas.get(position);
        holder.good_img.setImageResource(good.getCpOne());
        holder.good_desc.setText(good.getTitle());
        holder.good_price.setText(""+good.getPrice());
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    class HotGoodsViewHolder extends RecyclerView.ViewHolder {
        TextView good_desc, good_price;
        ImageView good_img;
        public HotGoodsViewHolder(View itemView) {
            super(itemView);
            good_img = (ImageView) itemView.findViewById(R.id.hot_good_item_img);
            good_desc = (TextView) itemView.findViewById(R.id.hot_good_item_desc);
            good_price = (TextView) itemView.findViewById(R.id.hot_good_item_price);
        }
    }
}
