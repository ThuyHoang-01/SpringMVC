package vn.edu.iuh.fit.backend.enums;

public enum ProductStatusEnum {

    ACTIVE(1),//đang kinh doanh
    IN_ACTIVE(0), //tam ngung
    TERMINATED(-1); //khong ban nua
    private int value;

     ProductStatusEnum(int value) {
        this.value = value;
    }

     int getValue() {
        return value;
    }
}
