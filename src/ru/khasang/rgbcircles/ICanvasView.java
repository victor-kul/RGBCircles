package ru.khasang.rgbcircles;

/**
 * Created by Igor on 22.11.15.
 */
public interface ICanvasView {
    void drawCircle(SimpleCircle circle);

    void redraw();

    void showMessage(String text);
}
