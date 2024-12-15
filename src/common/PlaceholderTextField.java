package common;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class PlaceholderTextField extends JTextField implements FocusListener {

    private String placeholder;
    private boolean isPlaceholderActive;

    public PlaceholderTextField(String placeholder) {
        super(placeholder);
        this.placeholder = placeholder;
        this.isPlaceholderActive = true;
        setForeground(Color.GRAY);
        addFocusListener(this);
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (isPlaceholderActive) {
                    setText("");
                    setForeground(Color.BLACK);
                    isPlaceholderActive = false;
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                if (getText().isEmpty()) {
                    setText(placeholder);
                    setForeground(Color.GRAY);
                    isPlaceholderActive = true;
                } else if (!isPlaceholderActive) {
                    setForeground(Color.BLACK);
                }
            }
        });
    }

    @Override
    public void focusGained(FocusEvent e) {
        if (isPlaceholderActive) {
            setForeground(Color.GRAY);
        }
    }

    @Override
    public void focusLost(FocusEvent e) {
        if (getText().isEmpty()) {
            setText(placeholder);
            setForeground(Color.GRAY);
            isPlaceholderActive = true;
        }
    }

    @Override
    public String getText() {
        return isPlaceholderActive ? "" : super.getText();
    }
}