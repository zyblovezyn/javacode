//enum命名规则 项目名称+Family+Enum
class FamilyEnum {
    public static enum Order {
        STORE("store"),//库存
        SALESVOLUME("salesVolume"); // 销量

        private final String orderName;

        Order(String orderName) {
            this.orderName = orderName;
        }

        @Override
        public String toString() {
            return orderName;
        }
    }

    public static enum MyColor {
        BLUE("蓝色", 1),
        RED("红色", 2);

        private String ColorName;
        private Integer ColorCode;

        MyColor() {
        }

        MyColor(String colorName, Integer colorCode) {
            ColorName = colorName;
            ColorCode = colorCode;
        }

        public String getColorName() {
            return ColorName;
        }

        public void setColorName(String colorName) {
            ColorName = colorName;
        }

        public Integer getColorCode() {
            return ColorCode;
        }

        public void setColorCode(Integer colorCode) {
            ColorCode = colorCode;
        }

        @Override
        public String toString() {
            return "MyColor{" +
                    "ColorName='" + ColorName + '\'' +
                    ", ColorCode=" + ColorCode +
                    '}';
        }
    }
public static enum PaymentModeEnum {

    REMITTANCE(1,"汇款");

    Integer code;
    String value;

     PaymentModeEnum(Integer code , String value){
        this.code=code;
        this.value=value;

    }
    public static Integer getCodeByValue(String value) {
        if (null == value || value.length() <= 0) {
            return null;
        }
        for (PaymentModeEnum modeEnum : PaymentModeEnum.values()) {
            if (modeEnum.getDesc().equals(value)) {
                return modeEnum.getCode();
            }
        }
        return null;
    }
    public static String getValueBycode(Integereger code) {
        if (null == code) {
            return StringUtils.EMPTY;
        }

        for (PaymentModeEnum status : values()) {
            if (status.getCode() == code) {
                return status.getvalue();
            }
        }

        return StringUtils.EMPTY;
    }
    public Integer getCode() {
        return code;
    }

    public String getvalue() {
        return value;
    }
}
    // 角色
    public static enum Role {
        SYSTEM("系统管理员", 0),
        ADMIN("管理员", 1),
        COMMON("普通用户", 2),
        ROLEA("普通用户", 2),
        ROLEB("普通用户", 2);


        private String RoleName;
        private Integer RoleCode;

        Role() {
        }

        Role(String roleName, Integer roleCode) {
            RoleName = roleName;
            RoleCode = roleCode;
        }

        public String getRoleName() {
            return RoleName;
        }

        public Integer getRoleCode() {
            return RoleCode;
        }

        @Override
        public String toString() {
            return "Role{" +
                    "RoleName='" + RoleName + '\'' +
                    ", RoleCode=" + RoleCode +
                    '}';
        }
    }
}

public class Test {
    public static void main(String[] args) {
        // 使用
        System.out.println(FamilyEnum.MyColor.RED.getColorCode() + " " + FamilyEnum.MyColor.RED.getColorName());
        System.out.println();
        // 遍历
        for (FamilyEnum.MyColor myColor : FamilyEnum.MyColor.values()) {
            System.out.println(myColor.getColorCode() + " " + myColor.getColorName());
        }
        //初始化
        FamilyEnum.MyColor myColor = FamilyEnum.MyColor.valueOf("RED");
        System.out.println(myColor);

        /**
         * EnumSet用于保存枚举项的集合，在枚举项本身并不互斥的情况下特别有用。例如，一个应用系统通常会有多种角色，而某些人在系统中可能承担不止一种角色。如果这些角色是通过枚举定义的，则此时EnumSet将可以将多种角色保存在一起，标识特定用户承担的全部角色。
         *
         * EnumSet扩展于AbstractSet，它除了拥了普通Set所拥有的方法外，主要是增加了一系列可产生EnumSet实例的方法(noneOf、allOf、copyOf、complementOf、of、range等)。
         * 原文链接：https://blog.csdn.net/ishallwin/article/details/9440251
         */
        EnumSet<FamilyEnum.Role> enumSet = EnumSet.of(FamilyEnum.Role.ROLEA, FamilyEnum.Role.ROLEB);
        for (FamilyEnum.Role role : enumSet) {
            System.out.println(role);
        }

        EnumMap<FamilyEnum.Role, String> em = new EnumMap<FamilyEnum.Role, String>(FamilyEnum.Role.class);
        em.put(FamilyEnum.Role.SYSTEM, "系统管理员");
        em.put(FamilyEnum.Role.ROLEA, "角色A");
        System.out.println(em.size());
        System.out.println(em.get(FamilyEnum.Role.SYSTEM));

    }
}
