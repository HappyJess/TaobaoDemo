package name.iiii.taobaodemo;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;

import java.util.ArrayList;

public class HomeFragment extends Fragment {
    private View mview;
    private SliderLayout sliderShow;
    //private PagerIndicator custom_indicator;
    ArrayList<View> viewContainter = new ArrayList<View>();
    ArrayList<String> titleContainer = new ArrayList<String>();
    public String TAG = "tag";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mview = inflater.inflate(R.layout.fragment_home, container, false);
        initViews();
        initEvents();
        return mview;
    }


    private void initViews() {
        sliderShow = (SliderLayout) mview.findViewById(R.id.slider);
        //custom_indicator = (PagerIndicator) mview.findViewById(R.id.custom_indicator);
    }

    private void initEvents() {
        TextSliderView textSliderView1 = new TextSliderView(this.getActivity());
        textSliderView1
                .description("第一屏")
                .image("http://pic.58pic.com/58pic/16/34/57/33X58PIC4up_1024.jpg")
                .setOnSliderClickListener(new BaseSliderView.OnSliderClickListener() {
                    @Override
                    public void onSliderClick(BaseSliderView slider) {
                        Toast.makeText(HomeFragment.this.getActivity(), "第一屏", Toast.LENGTH_SHORT).show();
                    }
                });

        TextSliderView textSliderView2 = new TextSliderView(this.getActivity());
        textSliderView2
                .description("第二屏")
                .image("http://pic.58pic.com/58pic/12/60/40/49W58PICgrS.jpg")
                .setOnSliderClickListener(new BaseSliderView.OnSliderClickListener() {
                    @Override
                    public void onSliderClick(BaseSliderView slider) {
                        Toast.makeText(HomeFragment.this.getActivity(), "第二屏", Toast.LENGTH_SHORT).show();
                    }
                });

        TextSliderView textSliderView3 = new TextSliderView(this.getActivity());
        textSliderView3
                .description("第三屏")
                .image("http://images.boomsbeat.com/data/images/full/19640/game-of-thrones-season-4-jpg.jpg")
                .setOnSliderClickListener(new BaseSliderView.OnSliderClickListener() {
                    @Override
                    public void onSliderClick(BaseSliderView slider) {
                        Toast.makeText(HomeFragment.this.getActivity(), "第三屏", Toast.LENGTH_SHORT).show();
                    }
                });

        sliderShow.addSlider(textSliderView1);
        sliderShow.addSlider(textSliderView2);
        sliderShow.addSlider(textSliderView3);

        //sliderShow.setCustomIndicator(custom_indicator);
        sliderShow.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
        sliderShow.setCustomAnimation(new test.DescriptionAnimation());
        sliderShow.setPresetTransformer(SliderLayout.Transformer.Default);
        sliderShow.setDuration(3000);


    }

    @Override
    public void onStop() {
        sliderShow.stopAutoCycle();
        super.onStop();
    }
}
