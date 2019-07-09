package bean;

/**
 * @author Administrator
 * @title: UserAddress
 * @projectName user-service-provide
 * @description: TODO
 * @date 2019/7/9 000922:02
 */

public class UserAddress implements java.io.Serializable{
    private String address;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "UserAddress{" +
                "address='" + address + '\'' +
                '}';
    }
}
