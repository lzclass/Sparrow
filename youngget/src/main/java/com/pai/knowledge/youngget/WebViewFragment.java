package com.pai.knowledge.youngget;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.orhanobut.logger.Logger;

/**
 * @author liuzhao by 2019/1/23  14:16
 * @description 加载WebView的页面
 */
public class WebViewFragment extends Fragment {

    WebView mWebView;
    View mView;
    public WebViewFragment() {
        Logger.d("WebViewFragment()-构造函数");
    }

    public static WebViewFragment newInstance() {
        Logger.d("newInstance()");
        WebViewFragment fragment = new WebViewFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Logger.d("onCreate()");
        if (getArguments() != null) {

        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Logger.d("onCreateView()");
        mView = inflater.inflate(R.layout.fragment_web_view, container, false);
        WebView mWebView = mView.findViewById(R.id.wv_common);
        WebSettings settings = mWebView.getSettings();
        settings.setJavaScriptEnabled(true);
        mWebView.loadUrl("http://www.runoob.com/cplusplus/cpp-tutorial.html");
        return mView;
    }


    @Override
    public void onDetach() {
        super.onDetach();
        Logger.d("life", "onDetach()");
    }

}
