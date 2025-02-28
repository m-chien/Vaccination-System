package phantichtkhdt.tiemchung.HealthcareCenter;

import phantichtkhdt.tiemchung.Employee.Employee;

import java.util.ArrayList;
import java.util.List;

public class HealthcareCenter {
    private String name;
    private String address;
    private String phone;
    private List<Employee> staff;

    public HealthcareCenter(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.staff = new ArrayList<>();
    }
    public void addemployee(Employee employee)
    {
        staff.add(employee);
    }

    public List<Employee> getStaff() {
        return staff;
    }

    public void setStaff(List<Employee> staff) {
        this.staff = staff;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return
                "tên: '" + name + '\'' +
                ", địa chỉ:'" + address + '\'' +
                ", điện thoại: '" + phone + '\'' +
                ", nhân viên: " + staff;
    }
}
