package com.theinvader360.scene2dtutorial.swiperace;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;
import static com.badlogic.gdx.scenes.scene2d.actions.Actions.*;

/**
 * 玩家汽车
 * 车其实一直没有前后移动，只是其他的参考物移动
 * 车只能上下移动
 */
public class PlayerCar extends Actor {
    private TrafficGame trafficGame;
    // 用于碰撞检测
    private Rectangle bounds = new Rectangle();
    private int lane;

    public PlayerCar(TrafficGame trafficGame) {
        this.trafficGame = trafficGame;
        setWidth(160);
        setHeight(85);
        lane = 1;
        setPosition(100, trafficGame.lane1 - getHeight()/2);
        // 设置玩家汽车为黄色
        setColor(Color.YELLOW);
    }

    @Override
    public void act(float delta){
        super.act(delta);
        /** 更新围绕汽车的正方形位置 **/
        updateBounds();
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        /** 重新设置碰撞汽车的颜色，否则PlayCar保持原来的颜色 **/
        batch.setColor(getColor().r, getColor().g, getColor().b, getColor().a);
        batch.draw(Assets.car, getX(), getY(), getWidth()/2, getHeight()/2, getWidth(), getHeight(), 1, 1, getRotation());
    }

    /** 随着游戏不断更新玩家碰撞的位置 **/
    private void updateBounds() {
        bounds.set(getX(), getY(), getWidth(), getHeight());
    }

    public void tryMoveUp() {
        if ((getActions().size == 0) && (lane != 2)) moveToLane(lane+1);
    }

    public void tryMoveDown() {
        if ((getActions().size == 0) && (lane != 0)) moveToLane(lane-1);
    }

    private void moveToLane(int lane) {
        this.lane = lane;

        /** 添加玩家移动动画，不需要使用Actions.moveTo
         *  车只能上下移动，从getX()方法可以看出
         */
        switch (lane) {
            case 0:
                addAction(moveTo(getX(), trafficGame.lane0 - getHeight()/2, 0.5f));
                break;
            case 1:
                addAction(moveTo(getX(), trafficGame.lane1 - getHeight()/2, 0.5f));
                break;
            case 2:
                addAction(moveTo(getX(), trafficGame.lane2 - getHeight()/2, 0.5f));
                break;
        }
    }

    public Rectangle getBounds() {
        return bounds;
    }
}
