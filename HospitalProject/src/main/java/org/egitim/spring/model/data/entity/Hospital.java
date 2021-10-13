package org.egitim.spring.model.data.entity;

import org.egitim.spring.model.data.base.BaseEntity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "HOSPITAL")
public class Hospital extends BaseEntity {

    private static final long serialVersionUID = 2550358746442196480L;

    @Column(name = "NAME", length = 100, nullable = false)
    private String name;

    @Column(name = "PATIENT_ROOM_COUNT", nullable = false)
    private int patientRoomCount;

    @Column(name = "BED_CAPACITY", nullable = false)
    private int bedCapacity;

    @Column(name = "PATIENT_CAPACITY", nullable = false)
    private int patientCapacity;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ADDRESS_ID", nullable = false, foreignKey = @ForeignKey(name = "FK_HOSPITAL_ADDRESS"))
    private Address address;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "HOSPITAL_ID", nullable = false, foreignKey = @ForeignKey(name = "FK_HOSPITAL_POLYCLINIC"))
    private Set<Polyclinic> polyclinics;

    @Column(name = "PHONE_NUMBER", unique = true)
    private String phoneNumber;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPatientRoomCount() {
        return patientRoomCount;
    }

    public void setPatientRoomCount(int patientRoomCount) {
        this.patientRoomCount = patientRoomCount;
    }

    public int getBedCapacity() {
        return bedCapacity;
    }

    public void setBedCapacity(int bedCapacity) {
        this.bedCapacity = bedCapacity;
    }

    public int getPatientCapacity() {
        return patientCapacity;
    }

    public void setPatientCapacity(int patientCapacity) {
        this.patientCapacity = patientCapacity;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Set<Polyclinic> getPolyclinics() {
        return polyclinics;
    }

    public void setPolyclinics(Set<Polyclinic> polyclinics) {
        this.polyclinics = polyclinics;
    }

    @Override
    public String toString() {
        return "- Hospital{" +
                "name='" + name + '\'' +
                ", patientRoomCount=" + patientRoomCount +
                ", bedCapacity=" + bedCapacity +
                ", patientCapacity=" + patientCapacity +
                ", address=" + address +
                ", polyclinics=" + polyclinics +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
