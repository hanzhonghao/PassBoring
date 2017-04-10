package com.exercise.passboring.utils;

import android.content.Context;
import android.os.Bundle;

import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.exercise.passboring.api.NewsUtils;
import com.exercise.passboring.api.bean.NewsInfo;

/**
 * 项目名称：PassBoring
 * 类描述：Bannner的帮助类
 * 创建人：小豪
 * 创建时间：2017/3/23 9:49
 * 修改人：小豪
 * 修改时间：2017/3/23 9:49
 * 修改备注：
 */

public class SliderHelper {

    private static final String SLIDER_KEY = "sliderKey";

    private SliderHelper() {
        throw new RuntimeException("SliderHelper cannot be initialized!");
    }

    /**
     * 初始化广告滑动器
     */
    public static void initAdSlider(final Context context, SliderLayout sliderLayout, NewsInfo newsBean) {
        for (final NewsInfo.AdData adData : newsBean.getAds()) {
            TextSliderView textSliderView = new TextSliderView(context);
            //initialize a SlideLayout
            textSliderView.description(adData.getTitle())
                    .image(adData.getImgsrc())
                    .empty(DefIconFactory.provideIcon())
                    .setScaleType(BaseSliderView.ScaleType.CenterCrop)
                    .setOnSliderClickListener(new BaseSliderView.OnSliderClickListener() {
                        @Override
                        public void onSliderClick(BaseSliderView slider) {
                            if (slider.getBundle() != null) {
                                NewsInfo.AdData adDate = slider.getBundle().getParcelable(SLIDER_KEY);
                                if (adData != null) {
                                    if (NewsUtils.isNewsPhotoSet(adData.getTag())) {
//                                        PhotoSetActivity.launch(context,adData.getUrl());
                                    } else if (NewsUtils.isNewsSpecial(adData.getTag())) {
//                                        SpecialActivity.launch(context,adData.getUrl());
                                    } else {
//                                        NewsArticleActivity.launch(context, adData.getUrl());
                                    }
                                }
                            }
                        }
                    });

            //add your extra information
            textSliderView.bundle(new Bundle());
            textSliderView.getBundle().putParcelable(SLIDER_KEY, adData);
            sliderLayout.addSlider(textSliderView);
        }
        sliderLayout.setPresetIndicator(SliderLayout.PresetIndicators.Right_Bottom);
        sliderLayout.setPresetTransformer(SliderLayout.Transformer.Accordion);
        sliderLayout.setCustomAnimation(new DescriptionAnimation());
        sliderLayout.setDuration(4000);
    }
}
