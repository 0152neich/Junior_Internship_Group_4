package Views;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import common.PasswordVisibilityToggle;
import common.PlaceholderPassword;
import common.PlaceholderTextField;
import controller.UserManagement;
import controller.impl.UserManagementImpl;
import model.Role;
import model.User;
import common.SendMail;

public class SignUpView {

    JFrame frame;
    private PlaceholderTextField fullname;
    private PlaceholderTextField email;
    private PlaceholderTextField username;
    private PlaceholderPassword password;
    private PlaceholderPassword confirmpassword;
    private PlaceholderTextField phonenumber;
    private PlaceholderTextField otp;
    private JButton btnSignUp;
    private JLabel lblQues;
    private JButton btnLogin;
    private String generatedOtp;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                SignUpView window = new SignUpView();
                window.frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    /**
     * Create the application.
     */
    public SignUpView() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 450, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        frame.setLocationRelativeTo(null);
        JLabel lblSignUp = new JLabel("Đăng ký");
        lblSignUp.setHorizontalAlignment(SwingConstants.CENTER);
        lblSignUp.setFont(new Font("Tahoma", Font.PLAIN, 30));
        lblSignUp.setBounds(136, 27, 151, 48);
        frame.getContentPane().add(lblSignUp);

        fullname = new PlaceholderTextField("Họ tên");
        fullname.setBounds(51, 102, 324, 25);
        frame.getContentPane().add(fullname);

        email = new PlaceholderTextField("Email");
        email.setBounds(51, 154, 237, 25);
        frame.getContentPane().add(email);

        JButton btnSendOTP = new JButton("Gửi mã");
        btnSendOTP.setBounds(299, 155, 76, 23);
        frame.getContentPane().add(btnSendOTP);

        username = new PlaceholderTextField("Tên đăng nhập");
        username.setBounds(51, 206, 324, 25);
        frame.getContentPane().add(username);

        password = new PlaceholderPassword("Mật khẩu");
        password.setBounds(51, 258, 298, 25);
        frame.getContentPane().add(password);

        confirmpassword = new PlaceholderPassword("Nhập lại mật khẩu");
        confirmpassword.setBounds(51, 310, 298, 25);
        frame.getContentPane().add(confirmpassword);

        phonenumber = new PlaceholderTextField("Số điện thoại");
        phonenumber.setBounds(51, 362, 324, 25);
        frame.getContentPane().add(phonenumber);

        otp = new PlaceholderTextField("Mã OTP");
        otp.setBounds(50, 414, 237, 25);
        frame.getContentPane().add(otp);

        btnSignUp = new JButton("Đăng ký");
        btnSignUp.setFont(new Font("Tahoma", Font.PLAIN, 13));
        btnSignUp.setBounds(167, 466, 89, 23);
        frame.getContentPane().add(btnSignUp);

        lblQues = new JLabel("Bạn đã có tài khoản?");
        lblQues.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lblQues.setBounds(90, 516, 128, 14);
        frame.getContentPane().add(lblQues);

        btnLogin = new JButton("Đăng nhập");
        btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 13));
        btnLogin.setBounds(228, 512, 121, 23);
        frame.getContentPane().add(btnLogin);

        JCheckBox chckbxShowpass = new JCheckBox();
        chckbxShowpass.setBounds(355, 259, 21, 23);
        frame.getContentPane().add(chckbxShowpass);
        PasswordVisibilityToggle.attach(password, chckbxShowpass);

        JCheckBox chckbxShowConfirmpass = new JCheckBox();
        chckbxShowConfirmpass.setBounds(355, 311, 21, 23);
        frame.getContentPane().add(chckbxShowConfirmpass);
        PasswordVisibilityToggle.attach(confirmpassword, chckbxShowConfirmpass);

        // Event handlers
        btnSendOTP.addActionListener(e -> sendOtpHandler());
        btnSignUp.addActionListener(e -> signUpHandler());
        btnLogin.addActionListener(e -> navigateToLogin());
    }

    /**
     * Handle sending OTP.
     */
    private void sendOtpHandler() {
        try {
            String emailInput = email.getText();
            if (emailInput.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Email không được để trống.", "Lỗi", JOptionPane.ERROR_MESSAGE);
                return;
            }

            UserManagement userManagement = new UserManagementImpl();
            if (userManagement.checkEmailExists(emailInput)) {
                JOptionPane.showMessageDialog(frame, "Email đã được sử dụng. Vui lòng sử dụng email khác.", "Lỗi", JOptionPane.ERROR_MESSAGE);
                return;
            }

            SendMail sendMail = new SendMail();
            if (sendMail.sendOtp(emailInput)) {
                generatedOtp = sendMail.getOtp();
                JOptionPane.showMessageDialog(frame, "Mã OTP đã được gửi đến email.", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(frame, "Gửi OTP thất bại. Vui lòng thử lại.", "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(frame, "Đã xảy ra lỗi khi gửi OTP: " + ex.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Handle sign-up.
     */
    private void signUpHandler() {
        try {
            if (!isValidForm()) {
                return;
            }

            String otpInput = otp.getText();
            if (!otpInput.equals(generatedOtp)) {
                JOptionPane.showMessageDialog(frame, "Mã OTP không hợp lệ.", "Lỗi", JOptionPane.ERROR_MESSAGE);
                return;
            }

            UserManagement userManagement = new UserManagementImpl();
            User newUser = new User(fullname.getText(), email.getText(), username.getText(),
                    password.getText(), phonenumber.getText(), Role.USER);

            if (userManagement.addUser(newUser)) {
                JOptionPane.showMessageDialog(frame, "Đăng ký thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                navigateToLogin();
            } else {
                JOptionPane.showMessageDialog(frame, "Đăng ký thất bại, vui lòng thử lại.", "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(frame, "Đã xảy ra lỗi khi đăng ký: " + ex.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Validate form fields.
     */
    private boolean isValidForm() {
        if (fullname.getText().isEmpty() || email.getText().isEmpty() || username.getText().isEmpty()
                || password.getText().isEmpty() || confirmpassword.getText().isEmpty()
                || phonenumber.getText().isEmpty() || otp.getText().isEmpty()) {
            JOptionPane.showMessageDialog(frame, "Vui lòng điền đầy đủ thông tin.", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if (!email.getText()
                .matches("^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$")) {
            JOptionPane.showMessageDialog(frame, "Email không hợp lệ", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        UserManagement userManagement = new UserManagementImpl();
        if (userManagement.checkUsernameExists(username.getText())) {
            JOptionPane.showMessageDialog(frame, "Tên đăng nhập đã được sử dụng.", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if (!password.getText().equals(confirmpassword.getText())) {
            JOptionPane.showMessageDialog(frame, "Mật khẩu không khớp.", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if (!phonenumber.getText().matches("^0\\d{9}$")) {
            JOptionPane.showMessageDialog(frame, "Số điện thoại không hợp lệ.", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        return true;
    }

    /**
     * Navigate to login view.
     */
    private void navigateToLogin() {
        frame.dispose();
        LoginView login = new LoginView();
        login.setVisible(true);
    }
}