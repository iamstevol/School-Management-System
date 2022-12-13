package org.model.model;

import org.model.enums.StaffRoles;

public class Staff extends User {

        private String staffID;
        private String qualification;
        private StaffRoles staffRoles;


    public Staff(String name, int age, String gender, String staffID, String qualification, StaffRoles staffRoles) {
        super(name, age, gender);
        this.staffID = staffID;
        this.qualification = qualification;
        this.staffRoles = staffRoles;
    }

    public String getStaffID() {
        return staffID;
    }

    public void setStaffID(String staffID) {
        this.staffID = staffID;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public StaffRoles getStaffRoles() {
        return staffRoles;
    }

    public void setStaffRoles(StaffRoles staffRoles) {
        this.staffRoles = staffRoles;
    }

    @Override
    public String toString() {
        return super.toString() +
                " staffID='" + staffID + '\'' +
                ", qualification='" + qualification + '\'' +
                ", staffRoles=" + staffRoles ;
    }
}


