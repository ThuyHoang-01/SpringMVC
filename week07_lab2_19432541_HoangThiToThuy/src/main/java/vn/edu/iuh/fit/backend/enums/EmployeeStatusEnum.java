package vn.edu.iuh.fit.backend.enums;

public enum EmployeeStatusEnum {

    ACTIVE(1),
    IN_ACTIVE(0),
    TERMINATED(-1);
    private int value;

    EmployeeStatusEnum(int value) {
        this.value = value;
    }

    int getValue() {
        return value;
    }
}
