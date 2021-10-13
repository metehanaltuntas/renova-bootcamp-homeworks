package org.egitim.spring.model.data.entity;

import org.egitim.spring.model.data.base.BaseEntity;
import org.egitim.spring.model.data.enums.StatusEnum;

import javax.persistence.*;

@Entity
@Table(name = "POLYCLINIC")
public class Polyclinic extends BaseEntity {

    private static final long serialVersionUID = 4792329230253876302L;

    @Column(name = "NAME", length = 100, nullable = false)
    private String name;

    @Column(name = "BED_CAPACITY", nullable = false)
    private int bedCapacity;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "STATUS_ENUM", nullable = false, length = 7)
    private StatusEnum statusEnum = StatusEnum.ACTIVE;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBedCapacity() {
        return bedCapacity;
    }

    public void setBedCapacity(int bedCapacity) {
        this.bedCapacity = bedCapacity;
    }

    public StatusEnum getStatusEnum() {
        return statusEnum;
    }

    public void setStatusEnum(StatusEnum statusEnum) {
        this.statusEnum = statusEnum;
    }

    @Override
    public String toString() {
        return "- Polyclinic{" +
                "name='" + name + '\'' +
                ", bedCapacity=" + bedCapacity +
                ", statusEnum=" + statusEnum +
                '}';
    }
}
