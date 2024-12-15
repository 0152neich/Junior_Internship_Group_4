package common;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class PlaceholderPassword extends JPasswordField implements FocusListener {

	private String placeholder;
	private boolean isPlaceholderActive;

	public PlaceholderPassword(String placeholder) {
		super(placeholder);
		this.placeholder = placeholder;
		this.isPlaceholderActive = true;
		setEchoChar((char) 0);
		setForeground(Color.GRAY);
		addFocusListener(this);
		addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (isPlaceholderActive) {
					setText("");
					setEchoChar('\u25cf');
					setForeground(Color.BLACK);
					isPlaceholderActive = false;
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {
				if (getPassword().length == 0) {
					setText(placeholder);
					setEchoChar((char) 0);
					setForeground(Color.GRAY);
					isPlaceholderActive = true;
				} else if (!isPlaceholderActive) {
					setEchoChar('\u25cf');
					setForeground(Color.BLACK);
				}
			}
		});
	}

	@Override
	public void focusGained(FocusEvent e) {
		if (isPlaceholderActive) {
			setEchoChar((char) 0);
			setForeground(Color.GRAY);
		}
	}

	@Override
	public void focusLost(FocusEvent e) {
		if (getPassword().length == 0) {
			setText(placeholder);
			setEchoChar((char) 0);
			setForeground(Color.GRAY);
			isPlaceholderActive = true;
		}
	}

	@Override
	public char[] getPassword() {
		return isPlaceholderActive ? new char[0] : super.getPassword();
	}
}