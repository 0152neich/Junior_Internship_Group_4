package model;

public enum Role {
    ADMIN {
        @Override
        public String toString() {
            return "Admin";  // Tùy chỉnh để hiển thị tên thân thiện với người dùng
        }
    },
    USER {
        @Override
        public String toString() {
            return "User";  // Tùy chỉnh
        }
    };
}
