package ru.khasang.rgbcircles;

import android.view.View;
import android.widget.ImageButton;

import java.util.ArrayList;
import java.util.Timer;

/**
 * Created by Igor on 22.1.15.
 * Change by Victor on 23.11.15.
 */
public class GameManager {
    public static final int MAX_CIRCLES = 10;
    private MainCircle mainCircle;
    private ArrayList<EnemyCircle> circles;
    public CanvasView canvasView;
    private static int width;
    private static int height;
    private NavigationPanel navigationPanel;
    private ImageButton mStartButton, mCancelButton;
    private Timer mTimer;
//    private MyTimerTask mMyTimerTask;

    public GameManager(CanvasView canvasView, int w, int h) {

        this.canvasView = canvasView;
        width = w;
        height = h;
        initMainCircle();
        initEnemyCircles();
//        navigationPanel = new NavigationPanel(this);

//        mStartButton = (ImageButton) canvasView.getActivity().findViewById(R.id.imageButtonPlay);
//        mCancelButton = (ImageButton) this.canvasView.findViewById(R.id.imageButtonPause);


//        mCancelButton.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View v) {
//                if (mTimer != null) {
//                    mTimer.cancel();
//                    mTimer = null;
//                }
//                gameEnd("YOU stop!");
//            }
//        });
    }


    private void initEnemyCircles() {
        SimpleCircle mainCircleArea = mainCircle.getCircleArea();
        circles = new ArrayList<EnemyCircle>();
        for (int i = 0; i < MAX_CIRCLES; i++) {
            EnemyCircle circle;
            do {
                circle = EnemyCircle.getRandomCircle();
            } while (circle.isIntersect(mainCircleArea));
            circles.add(circle);
        }
        calculateAndSetCirclesColor();
    }

    private void calculateAndSetCirclesColor() {
        for (EnemyCircle circle : circles) {
            circle.setEnemyOrFoodColorDependsOn(mainCircle);
        }
    }

    public static int getWidth() {
        return width;
    }

    public static int getHeight() {
        return height;
    }

    private void initMainCircle() {
        mainCircle = new MainCircle(width / 2, height / 2);
    }

    public void onDraw() {
        canvasView.drawCircle(mainCircle);
        for (EnemyCircle circle : circles) {
            canvasView.drawCircle(circle);
        }
    }

    public void onTouchEvent(int x, int y) {
        mainCircle.moveMainCircleWhenTouchAt(x, y);
        moveCircles();
    }

    private void checkCollision() {
        SimpleCircle circleForDel = null;
        for (EnemyCircle circle : circles) {
            if (mainCircle.isIntersect(circle)) {
                if (circle.isSmallerThan(mainCircle)) {
                    mainCircle.growRadius(circle);
                    circleForDel = circle;
                    calculateAndSetCirclesColor();
                    break;
                } else {
                    gameEnd("YOU LOSE!");
                    return;
                }
            }
        }
        if (circleForDel != null) {
            circles.remove(circleForDel);
        }
        if (circles.isEmpty()) {
            gameEnd("YOU WIN!");
        }
    }

    private void gameEnd(String text) {
        canvasView.showMessage(text);
        mainCircle.initRadius();
        initEnemyCircles();
        canvasView.redraw();
    }

    public void moveCircles() {
        checkCollision();
        for (EnemyCircle circle : circles) {
            circle.moveOneStep();
        }
    }
}
