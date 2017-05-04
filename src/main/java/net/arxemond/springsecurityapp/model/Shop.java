package net.arxemond.springsecurityapp.model;

import java.util.List;
import java.util.Map;

public class Shop
{

    private String name;

    private String
        staffUserName_0[],
        staffUserName_1[],
        staffUserName_2[];

    private List<Map<Long, String>> staffUserName_3;
    private Map<Long, String> staffUserName_4;
    private Map<Long, Map<Long, String>> staffUserName_5;
    private Map<Long, List<String>> staffUserName_6;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
////////////////////
    public String[] getStaffUserName_0() {
        return staffUserName_0;
    }

    public void setStaffUserName_0(String[] staffName_0) {
        this.staffUserName_0 = staffName_0;
    }

    public String[] getStaffUserName_1() {
        return staffUserName_1;
    }

    public void setStaffUserName_1(String[] staffUserName_1) {
        this.staffUserName_1 = staffUserName_1;
    }

    public String[] getStaffUserName_2() {
        return staffUserName_2;
    }

    public void setStaffUserName_2(String[] staffUserName_2) {
        this.staffUserName_2 = staffUserName_2;
    }

    public List<Map<Long, String>> getStaffUserName_3() {
        return staffUserName_3;
    }

    public void setStaffUserName_3(List<Map<Long, String>> staffUserName_3) {
        this.staffUserName_3 = staffUserName_3;
    }

    public Map<Long, String> getStaffUserName_4() {
        return staffUserName_4;
    }

    public void setStaffUserName_4(Map<Long, String> staffUserName_4) {
        this.staffUserName_4 = staffUserName_4;
    }

    public Map<Long, Map<Long, String>> getStaffUserName_5() {
        return staffUserName_5;
    }

    public void setStaffUserName_5(Map<Long, Map<Long, String>> staffUserName_5) {
        this.staffUserName_5 = staffUserName_5;
    }

    public Map<Long, List<String>> getStaffUserName_6() {
        return staffUserName_6;
    }

    public void setStaffUserName_6(Map<Long, List<String>> staffUserName_6) {
        this.staffUserName_6 = staffUserName_6;
    }

    public Shop() {
    }

}
