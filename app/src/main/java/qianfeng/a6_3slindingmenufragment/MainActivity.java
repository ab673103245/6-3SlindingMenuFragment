package qianfeng.a6_3slindingmenufragment;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.jeremyfeinstein.slidingmenu.lib.app.SlidingFragmentActivity;

public class MainActivity extends SlidingFragmentActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SlidingMenu slidingMenu = getSlidingMenu();

        slidingMenu.setMode(SlidingMenu.LEFT_RIGHT);

        // 设置左边的侧滑菜单
        setBehindContentView(R.layout.left_layout);

        slidingMenu.setSecondaryMenu(R.layout.right_layout);

        slidingMenu.setBehindOffset(getResources().getDisplayMetrics().widthPixels / 3);

        FragmentManager supportFragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = supportFragmentManager.beginTransaction();
        transaction.replace(R.id.leftMenu,new LeftFragment());
        transaction.replace(R.id.rightMenu,new RightFragment());
        transaction.commit();

    }
}
