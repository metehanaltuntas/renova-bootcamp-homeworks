package org.egitim.spring.model.data.entity;

import org.egitim.spring.model.data.base.BaseEntity;

import javax.persistence.*;

@Entity
@Table(name = "ADDRESS")
public class Address extends BaseEntity {

    private static final long serialVersionUID = -4602350318508994141L;

    @Column(name = "COUNTRY", length = 100, nullable = false)
    private String country;

    @Column(name = "CITY", length = 100, nullable = false)
    private String city;

    @Column(name = "DISTRICT", length = 100, nullable = false)
    private String district;

    @Column(name = "STREET", length = 100, nullable = false)
    private String street;

    @Column(name = "ZIP", length = 100)
    private String zip;

    @OneToOne(mappedBy = "address", fetch = FetchType.LAZY)
    private Hospital hospital;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    @Override
    public String toString() {
        return "- Address{" +
                "country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", district='" + district + '\'' +
                ", street='" + street + '\'' +
                ", zip='" + zip + '\'' +
                '}';
    }
}
