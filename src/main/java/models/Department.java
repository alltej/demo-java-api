package models;

public class Department {
    private Integer departmentId;
    private String name;

    public Integer getDepartmentId() {
        return departmentId;
    }

    public String getName() {
        return name;
    }

    public Department( Integer departmentId, String name ) {
        this.departmentId = departmentId;
        this.name = name;
    }

    public static  Department of( Integer departmentId, String name ) {
        return new Department( departmentId, name );
    }
}
