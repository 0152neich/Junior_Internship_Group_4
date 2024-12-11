package views;

import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.sql.*;
import javax.swing.*;
import javax.swing.GroupLayout.Alignment;

import model.Role;
import model.User;
import javax.swing.LayoutStyle.ComponentPlacement;

import controller.Authentic;
import controller.impl.AuthenticImpl;

public class LoginView extends javax.swing.JFrame {

	private Authentic authentic = new AuthenticImpl();

	public LoginView() {
		initComponents();
		this.setLocationRelativeTo(null); // background center
		setIconImage(Toolkit.getDefaultToolkit().getImage(LoginView.class.getResource("/icons/ypp.png")));
		setTitle("Login");
	}

	private boolean isEmpty() {
		if (txtUsername.getText().isEmpty()) {
			JOptionPane.showMessageDialog(this, "Tên người dùng không được bỏ trống", "Cảnh báo", 2);
			return false;
		}
		if (String.valueOf(jPasswordField1.getPassword()).isEmpty()) {
			JOptionPane.showMessageDialog(this, "Mật khẩu không được bỏ trống", "Cảnh báo", 2);
			return false;
		}
		return true;
	}

	private void initComponents() {

		jPanel1 = new javax.swing.JPanel();
		jLabel2 = new javax.swing.JLabel();
		jLabel1 = new javax.swing.JLabel();
		jLabel3 = new javax.swing.JLabel();
		jPanel2 = new javax.swing.JPanel();
		lblCaption = new javax.swing.JLabel();
		lblUsername = new javax.swing.JLabel();
		txtUsername = new javax.swing.JTextField();
		lblPassword = new javax.swing.JLabel();
		btnLogin = new javax.swing.JButton();
		jPasswordField1 = new javax.swing.JPasswordField();
		jLabel9 = new javax.swing.JLabel();
		lblSignUp = new javax.swing.JLabel();
		lblHideEye1 = new javax.swing.JLabel();
		lblVisibleEye1 = new javax.swing.JLabel();
		jLabel5 = new javax.swing.JLabel();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setIconImages(null);
		setResizable(false);

		jPanel1.setBackground(new Color(224, 255, 255));

		jLabel2.setIcon(new ImageIcon(LoginView.class.getResource("/icons/ypp.png"))); // NOI18N

		jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 48)); // NOI18N
		jLabel1.setText("WELCOME TO");

		jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 48)); // NOI18N
		jLabel3.setText("YP");

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
		jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup()
						.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
								.addGroup(jPanel1Layout.createSequentialGroup().addGap(33).addComponent(jLabel2,
										GroupLayout.PREFERRED_SIZE, 350, GroupLayout.PREFERRED_SIZE))
								.addGroup(jPanel1Layout.createSequentialGroup().addGap(56).addComponent(jLabel1))
								.addGroup(jPanel1Layout.createSequentialGroup().addGap(195).addComponent(jLabel3)))
						.addContainerGap(63, Short.MAX_VALUE)));
		jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(Alignment.TRAILING)
				.addGroup(jPanel1Layout.createSequentialGroup().addContainerGap(62, Short.MAX_VALUE)
						.addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, 285, GroupLayout.PREFERRED_SIZE).addGap(18)
						.addComponent(jLabel1).addGap(45).addComponent(jLabel3).addGap(160)));
		jPanel1.setLayout(jPanel1Layout);

		jPanel2.setBackground(new Color(255, 255, 240));

		lblCaption.setFont(new java.awt.Font("Times New Roman", 1, 48)); // NOI18N
		lblCaption.setText("Đăng nhập");

		lblUsername.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
		lblUsername.setText("Tên người dùng");

		txtUsername.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
		txtUsername.setHorizontalAlignment(javax.swing.JTextField.LEFT);

		lblPassword.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
		lblPassword.setText("Mật khẩu");

		btnLogin.setBackground(new java.awt.Color(0, 153, 255));
		btnLogin.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
		btnLogin.setForeground(new Color(0, 0, 0));
		btnLogin.setText("Đăng nhập");
		btnLogin.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				try {
					btnLoginActionPerformed(evt);
				} catch (HeadlessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

		jPasswordField1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N

		jLabel9.setBackground(new java.awt.Color(255, 204, 102));
		jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
		jLabel9.setForeground(new java.awt.Color(0, 102, 102));
		jLabel9.setText("Bạn chưa có tài khoản?");

		lblSignUp.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
		lblSignUp.setForeground(new java.awt.Color(0, 153, 153));
		lblSignUp.setText("Đăng ký");
		lblSignUp.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				lblSignUpMouseClicked(evt);
			}
		});

		lblHideEye1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/hide.png"))); // NOI18N
		lblHideEye1.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				lblHideEye1MouseClicked(evt);
			}
		});

		lblVisibleEye1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/visible.png"))); // NOI18N
		lblVisibleEye1.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				lblVisibleEye1MouseClicked(evt);
			}
		});

		jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/user.png")));

		javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
		jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(Alignment.TRAILING).addGroup(jPanel2Layout
				.createSequentialGroup().addContainerGap(68, Short.MAX_VALUE)
				.addGroup(jPanel2Layout.createParallelGroup(Alignment.LEADING)
						.addGroup(jPanel2Layout.createSequentialGroup().addGap(1)
								.addComponent(
										jPasswordField1, GroupLayout.PREFERRED_SIZE, 403, GroupLayout.PREFERRED_SIZE)
								.addGap(18)
								.addGroup(jPanel2Layout.createParallelGroup(Alignment.LEADING)
										.addComponent(lblVisibleEye1, GroupLayout.PREFERRED_SIZE, 60,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(lblHideEye1, GroupLayout.PREFERRED_SIZE, 60,
												GroupLayout.PREFERRED_SIZE)))
						.addComponent(lblPassword)
						.addGroup(jPanel2Layout.createSequentialGroup()
								.addGroup(jPanel2Layout.createParallelGroup(Alignment.LEADING).addComponent(lblUsername)
										.addComponent(txtUsername, GroupLayout.PREFERRED_SIZE, 403,
												GroupLayout.PREFERRED_SIZE))
								.addGap(21).addComponent(jLabel5))
						.addGroup(jPanel2Layout.createSequentialGroup().addGap(109).addComponent(btnLogin,
								GroupLayout.PREFERRED_SIZE, 220, GroupLayout.PREFERRED_SIZE)))
				.addGap(29))
				.addGroup(Alignment.LEADING,
						jPanel2Layout.createSequentialGroup().addGap(177).addComponent(lblCaption).addContainerGap(178,
								Short.MAX_VALUE))
				.addGroup(Alignment.LEADING, jPanel2Layout.createSequentialGroup().addGap(134).addComponent(jLabel9)
						.addGap(33).addComponent(lblSignUp).addContainerGap(162, Short.MAX_VALUE)));
		jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(Alignment.LEADING)
				.addGroup(jPanel2Layout.createSequentialGroup().addGap(62).addComponent(lblCaption).addGap(48)
						.addComponent(lblUsername).addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(jPanel2Layout.createParallelGroup(Alignment.LEADING).addComponent(jLabel5)
								.addComponent(txtUsername, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE))
						.addGap(43).addComponent(lblPassword).addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(jPanel2Layout.createParallelGroup(Alignment.TRAILING)
								.addGroup(jPanel2Layout.createSequentialGroup()
										.addComponent(jPasswordField1, GroupLayout.PREFERRED_SIZE, 50,
												GroupLayout.PREFERRED_SIZE)
										.addGap(28))
								.addGroup(jPanel2Layout.createSequentialGroup()
										.addGroup(jPanel2Layout.createParallelGroup(Alignment.LEADING)
												.addComponent(lblVisibleEye1).addComponent(lblHideEye1))
										.addGap(38)))
						.addGap(23).addComponent(btnLogin, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
						.addGap(34).addGroup(jPanel2Layout.createParallelGroup(Alignment.BASELINE).addComponent(jLabel9)
								.addComponent(lblSignUp))
						.addContainerGap(133, Short.MAX_VALUE)));
		jPanel2.setLayout(jPanel2Layout);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
						layout.createSequentialGroup().addGap(0, 457, Short.MAX_VALUE).addComponent(
								jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.PREFERRED_SIZE))
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(layout.createSequentialGroup().addGap(0, 0, Short.MAX_VALUE)
								.addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(575, 575, 575))));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
						Short.MAX_VALUE)
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(layout.createSequentialGroup().addGap(0, 0, Short.MAX_VALUE).addComponent(jPanel1,
								javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.PREFERRED_SIZE))));

		pack();
	}// </editor-fold>//GEN-END:initComponents

	private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) throws HeadlessException, SQLException {// GEN-FIRST:event_btnLoginActionPerformed
		// TODO add your handling code here:
		if (isEmpty()) {
			String username = txtUsername.getText();
			String password = String.valueOf(jPasswordField1.getPassword());
			User user = new User();
			if (authentic.login(username, password, user)) {
				JOptionPane.showMessageDialog(this, "Đăng nhập thành công");
				this.dispose();
				if (user.getRole().equals(Role.ADMIN)) {
					new ProductManagerView().setVisible(true);
				} else {
					new ProductManagerView().setVisible(true);
				}
			} else {
				JOptionPane.showMessageDialog(this, "Tên người dùng hoặc mật khẩu không đúng. Vui lòng nhập lại", "Lỗi",
						JOptionPane.ERROR_MESSAGE);
			}
		}
	}// GEN-LAST:event_btnLoginActionPerformed

	private void lblSignUpMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_lblSignUpMouseClicked
//		new SignUp().setVisible(true);
		this.dispose();
	}

	private void lblHideEye1MouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_lblHideEye1MouseClicked
		jPasswordField1.setEchoChar((char) 0);
		lblHideEye1.setVisible(false);
		lblVisibleEye1.setVisible(true);
	}

	private void lblVisibleEye1MouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_lblVisibleEye1MouseClicked
		jPasswordField1.setEchoChar('*');
		lblHideEye1.setVisible(true);
		lblVisibleEye1.setVisible(false);
	}

	public static void main(String args[]) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new LoginView().setVisible(true);
			}
		});
	}

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JButton btnLogin;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JLabel jLabel9;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JPanel jPanel2;
	private javax.swing.JPasswordField jPasswordField1;
	private javax.swing.JLabel lblCaption;
	private javax.swing.JLabel lblHideEye1;
	private javax.swing.JLabel lblPassword;
	private javax.swing.JLabel lblSignUp;
	private javax.swing.JLabel lblUsername;
	private javax.swing.JLabel lblVisibleEye1;
	private javax.swing.JTextField txtUsername;
	// End of variables declaration//GEN-END:variables
}
