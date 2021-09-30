package com.application.myapp.slice;

import com.application.myapp.ResourceTable;
import com.application.myapp.utils.AnimationUtils;
import ohos.aafwk.ability.AbilitySlice;
import ohos.aafwk.content.Intent;
import ohos.agp.colors.RgbPalette;
import ohos.agp.components.Button;
import ohos.agp.components.Component;
import ohos.agp.components.Image;
import ohos.agp.components.Text;
import ohos.agp.components.element.ShapeElement;
import ohos.hiviewdfx.HiLog;
import ohos.hiviewdfx.HiLogLabel;

public class MainAbilitySlice extends AbilitySlice {
    private Image appLogo;
    private Button login;
    private Button signup;
    private Text tempText;
    @Override
    public void onStart(Intent intent) {
        super.onStart(intent);
        super.setUIContent(ResourceTable.Layout_ability_main);
        HiLog.debug(new HiLogLabel(0,0,"MainAbilitySlice"), "SAMUEL onStart");
        initViews();
        setListeners();
    }

    public void initViews() {
        HiLog.debug(new HiLogLabel(0,0,"MainAbilitySlice"), "SAMUEL initViews");

        appLogo = (Image) findComponentById(ResourceTable.Id_image);
        login = (Button) findComponentById(ResourceTable.Id_login);
        signup = (Button) findComponentById(ResourceTable.Id_signup);
        appLogo.setPixelMap(ResourceTable.Media_my_app);
        appLogo.setScaleMode(Image.ScaleMode.STRETCH);
        tempText = (Text) findComponentById(ResourceTable.Id_tempText);
        ShapeElement sp = new ShapeElement();
        sp.setShape(ShapeElement.RECTANGLE);
        sp.setCornerRadius(50);
        sp.setRgbColor(RgbPalette.GRAY);
        tempText.setTextSize(40);
        tempText.setBackground(sp);

    }

    private void setListeners() {
        appLogo.setClickedListener(component -> AnimationUtils.setAppLogoAnimation(appLogo));
        login.setClickedListener(component -> handleLogin());
        signup.setClickedListener(component -> present(new SignUpAbilitySlice(), new Intent()));
        appLogo.setBindStateChangedListener(new Component.BindStateChangedListener() {
            @Override
            public void onComponentBoundToWindow(Component component) {
                HiLog.debug(new HiLogLabel(0,0,"MainAbilitySlice"), "SAMUEL setListeners onComponentBoundToWindow");
                AnimationUtils.setAppLogoAnimation(appLogo);
            }

            @Override
            public void onComponentUnboundFromWindow(Component component) {

            }
        });
    }

    private void handleLogin() {
        present(new LoginAbilitySlice(), new Intent());
        /*CommonDialog commonDialog = new CommonDialog(getContext());
        //commonDialog.setText("Hello world").show();
        commonDialog.set*/
    }

    @Override
    public void onActive() {
        super.onActive();
    }

    @Override
    public void onForeground(Intent intent) {
        super.onForeground(intent);
    }
}
