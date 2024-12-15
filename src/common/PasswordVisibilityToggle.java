package common;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PasswordVisibilityToggle {
    /**
     * Phương thức tĩnh để gắn chức năng hiện/ẩn mật khẩu vào checkbox.
     *
     * @param passwordField Trường mật khẩu cần áp dụng tính năng.
     * @param checkBox      Checkbox để bật/tắt hiển thị mật khẩu.
     */
    public static void attach(JPasswordField passwordField, JCheckBox checkBox) {
        checkBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (checkBox.isSelected()) {
                    passwordField.setEchoChar((char) 0); // Hiển thị văn bản thường
                } else {
                    passwordField.setEchoChar('*'); // Ẩn bằng ký tự '*'
                }
            }
        });
    }
}
