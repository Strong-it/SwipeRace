package com.theinvader360.scene2dtutorial.swiperace;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import static com.badlogic.gdx.scenes.scene2d.actions.Actions.*;

/**
 * 路面图片无线循环
 */
public class InfiniteScrollBg  extends Actor {
    /**
     *  初始化路面的大小
     * @param width 宽度
     * @param height 高度
     */
    public InfiniteScrollBg(float width, float height) {
        setWidth(width);
        setHeight(height);
        setPosition(width, 0);
        addAction(forever(sequence(moveTo(0, 0, 1f /*路面移动的速度*/), moveTo(width, 0))));
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
        batch.draw(Assets.road, getX()-getWidth(), getY(), getWidth() * 2, getHeight());
    }
}
