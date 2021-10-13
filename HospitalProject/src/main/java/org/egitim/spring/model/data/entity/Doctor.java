package org.egitim.spring.model.data.entity;

import org.egitim.spring.model.data.base.BaseEntity;
import org.egitim.spring.model.data.enums.DegreeEnum;

import javax.persistence.*;

@Entity
@Table(name = "DOCTOR")
public class Doctor extends BaseEntity {

    private static final long serialVersionUID = -8425148782234413796L;

    @Column(name = "FIRST_NAME", length = 50, nullable = false)
    private String firstName;

    @Column(name = "LAST_NAME", length = 50, nullable = false)
    private String lastName;

    @Column(name = "EMAIL", length = 50, nullable = false)
    private String email;

    @Column(name = "PHONE_NUMBER", length = 50, nullable = false)
    private String phoneNumber;

    @Column(name = "BRANCH", length = 100, nullable = false)
    private String branch;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "DEGREE", nullable = false, length = 25)
    private DegreeEnum degree;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "POLYCLINIC_ID", nullable = false, foreignKey = @ForeignKey(name = "FK_POLYCLINIC_DOCTOR"))
    private Polyclinic polyclinic;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "HOSPITAL_ID", nullable = false, foreignKey = @ForeignKey(name = "FK_HOSPITAL_DOCTOR"))
    private Hospital hospital;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public DegreeEnum getDegree() {
        return degree;
    }

    public void setDegree(DegreeEnum degree) {
        this.degree = degree;
    }

    public Polyclinic getPolyclinic() {
        return polyclinic;
    }

    public void setPolyclinic(Polyclinic polyclinic) {
        this.polyclinic = polyclinic;
    }

    public Hospital getHospital() {
        return hospital;
    }

    public void setHospital(Hospital hospital) {
        this.hospital = hospital;
    }

    @Override
    public String toString() {
        return "- Doctor{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", branch='" + branch + '\'' +
                ", degree=" + degree +
                ", polyclinic=" + polyclinic +
                ", hospital=" + hospital +
                '}';
    }
}
