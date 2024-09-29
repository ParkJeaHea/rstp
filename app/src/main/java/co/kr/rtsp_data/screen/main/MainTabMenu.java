package co.kr.rtsp_data.screen.main;


import androidx.annotation.IdRes;

import co.kr.rtsp_data.R;

public enum MainTabMenu {
    PRODUCT(R.id.menu_product),
    CAMERA(R.id.menu_camera),
    SETTING(R.id.menu_setting),
    USER(R.id.menu_user);

    @IdRes
    private final int menuId;

    MainTabMenu(@IdRes int menuId) {
        this.menuId = menuId;
    }

    @IdRes
    public int getMenuId() {
        return menuId;
    }
}