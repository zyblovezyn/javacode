package tk.mybatis.simple.model;

import lombok.Data;

/**
 * @author zyb
 * @title: Employee
 * @projectName code-java12
 * @description: TODO
 * @date 2019/8/11 0011 20:58
 */
@Data
public class Employee {
    private Integer id;
    private String lastName;
    private String gender;
    private String email;
}
