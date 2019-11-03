package com.hyper.uidemo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;

import com.hyper.uidemo.fragment.ViewPagerAddressBookFragment;
import com.hyper.uidemo.fragment.ViewPagerChatFragment;
import com.hyper.uidemo.fragment.ViewPagerDiscoveryFragment;
import com.hyper.uidemo.fragment.ViewPagerFragmentAdapter;
import com.hyper.uidemo.fragment.ViewPagerMeFragment;

import java.util.ArrayList;

public class ViewPagerMenuActivity extends FragmentActivity implements OnClickListener, OnPageChangeListener {
  private ArrayList<TextView> tv_menus;
  private ArrayList<ImageView> imgv_menus;
  private ViewPager mViewPager;

  private ArrayList<Fragment> mFragments;
  private ViewPagerFragmentAdapter mMainMenuAdapter;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.viewpager_menu_activity);

    initView();
    initData();
    initEvent();
  }

  private void initView() {
    tv_menus = new ArrayList<TextView>();
    tv_menus.add((TextView) findViewById(R.id.menuChatText));
    tv_menus.add((TextView) findViewById(R.id.menuAddressbookText));
    tv_menus.add((TextView) findViewById(R.id.menuDiscoveryText));
    tv_menus.add((TextView) findViewById(R.id.meMenuText));
    imgv_menus = new ArrayList<ImageView>();
    imgv_menus.add((ImageView) findViewById(R.id.menuChatImage));
    imgv_menus.add((ImageView) findViewById(R.id.menuAddressbookImage));
    imgv_menus.add((ImageView) findViewById(R.id.menuDiscoveryImage));
    imgv_menus.add((ImageView) findViewById(R.id.meMenuImage));
    mViewPager = (ViewPager) findViewById(R.id.viewPagerMenu);
  }

  private void initData() {
    mFragments = new ArrayList<Fragment>();
    mFragments.add(new ViewPagerChatFragment());
    mFragments.add(new ViewPagerAddressBookFragment());
    mFragments.add(new ViewPagerDiscoveryFragment());
    mFragments.add(new ViewPagerMeFragment());
    mMainMenuAdapter = new ViewPagerFragmentAdapter(getSupportFragmentManager(), mFragments);
    setMenuSelector(0);
  }

  private void initEvent() {
    mViewPager.setAdapter(mMainMenuAdapter);
    mViewPager.setOnPageChangeListener(this);
    findViewById(R.id.menuChat).setOnClickListener(this);
    findViewById(R.id.menuAddressbook).setOnClickListener(this);
    findViewById(R.id.menuDiscovery).setOnClickListener(this);
    findViewById(R.id.menuMe).setOnClickListener(this);
  }

  @Override
  public void onClick(View v) {
    switch (v.getId()) {
      case R.id.menuChat:
        setMenuSelector(0);
        break;
      case R.id.menuAddressbook:
        setMenuSelector(1);
        break;
      case R.id.menuDiscovery:
        setMenuSelector(2);
        break;
      case R.id.menuMe:
        setMenuSelector(3);
        break;

    }
  }

  private void setMenuSelector(int index) {
    reSetSelected();
    tv_menus.get(index).setSelected(true);
    imgv_menus.get(index).setSelected(true);
    mViewPager.setCurrentItem(index);
  }

  private void reSetSelected() {
    for (int i = 0; i < tv_menus.size(); i++) {
      tv_menus.get(i).setSelected(false);
      imgv_menus.get(i).setSelected(false);
    }
  }

  @Override
  public void onPageScrollStateChanged(int arg0) {

  }

  @Override
  public void onPageScrolled(int arg0, float arg1, int arg2) {

  }

  @Override
  public void onPageSelected(int arg0) {
    setMenuSelector(arg0);
  }
}
