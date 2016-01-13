package name.iiii.taobaodemo.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import name.iiii.taobaodemo.R;
import name.iiii.taobaodemo.adapter.HotGoodsAdapter;
import name.iiii.taobaodemo.bean.HotGoods;

public class HotFragment extends Fragment {
    private View mview;
    private TextView top_title;
    private RecyclerView mRecyclerView;
    private HotGoodsAdapter mAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mview = inflater.inflate(R.layout.fragment_hot, container, false);
        initViews();
        initEvents();
        return mview;
    }

    private void initViews() {
        top_title = (TextView) mview.findViewById(R.id.top_title);
        top_title.setText("热卖商品");
        mRecyclerView = (RecyclerView) mview.findViewById(R.id.recyclerview_hot);


    }

    private void initEvents() {
        List<HotGoods> datas = new ArrayList<>();
        HotGoods good = new HotGoods(1,
                "联想（ThinkPad）轻薄系列E550C（012CD ）15.6英寸笔记本电脑",
                3998.00, R.drawable.good_img_1);
        datas.add(good);
        good = new HotGoods(2,
                "西部数据（WD）My Passport Ultra 升级版 1TB 2.5英寸 闪耀白 移动硬盘 WDBGPU0010BWT 限量版",
                445.00, R.drawable.good_img_2);
        datas.add(good);
        good = new HotGoods(3,
                "DM WFD015 32G 苹果手机无线U盘 无线存储器 无线分享器 电脑平板iphone安卓智能WIFI迷你U盘（白色）",
                179.00, R.drawable.good_img_3);
        datas.add(good);
        good = new HotGoods(4,
                "华硕（ASUS）猛禽STRIX-GTX970-DC2OC-4GD5 1253MHz/7010MHz 4GB/256bit DDR5 PCI-E 3.0 显卡",
                2699.00, R.drawable.good_img_4);
        datas.add(good);
        good = new HotGoods(5,
                "台电（Teclast）骑士 U盘 64G USB3.0 咖啡色",
                98.90, R.drawable.good_img_5);
        datas.add(good);
        good = new HotGoods(6,
                "西部数据（WD）My Passport Ultra 升级版 1TB 2.5英寸 闪耀白 移动硬盘 WDBGPU0010BWT 限量版",
                445.00, R.drawable.good_img_2);
        datas.add(good);
        good = new HotGoods(7,
                "DM WFD015 32G 苹果手机无线U盘 无线存储器 无线分享器 电脑平板iphone安卓智能WIFI迷你U盘（白色）",
                179.00, R.drawable.good_img_3);
        datas.add(good);
        good = new HotGoods(8,
                "华硕（ASUS）猛禽STRIX-GTX970-DC2OC-4GD5 1253MHz/7010MHz 4GB/256bit DDR5 PCI-E 3.0 显卡",
                2699.00, R.drawable.good_img_4);
        datas.add(good);
        good = new HotGoods(9,
                "台电（Teclast）骑士 U盘 64G USB3.0 咖啡色",
                98.90, R.drawable.good_img_5);
        datas.add(good);
        mAdapter = new HotGoodsAdapter(datas);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this.getActivity()));

    }
}
