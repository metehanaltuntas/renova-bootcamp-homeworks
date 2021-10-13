CREATE SEQUENCE POLYCLINIC_ID_SEQ INCREMENT 1 START 1 CACHE 1;
CREATE TABLE POLYCLINIC
(
    ID           BIGINT                      NOT NULL DEFAULT NEXTVAL('POLYCLINIC_ID_SEQ'),
    CREATED_DATE TIMESTAMP WITHOUT TIME ZONE NOT NULL,

    NAME         CHARACTER VARYING(100)      NOT NULL,
    BED_CAPACITY INT                         NOT NULL,
    STATUS_ENUM  statusenum                  NOT NULL,
    HOSPITAL_ID  BIGINT                      NOT NULL,

    CONSTRAINT PK_POLYCLINIC PRIMARY KEY (ID),
    CONSTRAINT FK_HOSPITAL_POLYCLINIC FOREIGN KEY (HOSPITAL_ID) REFERENCES HOSPITAL (ID)
);
CREATE UNIQUE INDEX UX_POLYCLINIC_HOSPITAL_NAME ON POLYCLINIC (HOSPITAL_ID, LOWER(NAME));

insert into polyclinic (created_date, name, bed_capacity, status_enum, hospital_id)
values (localtimestamp, 'Kulak Burun Boğaz', 5, 'ACTIVE', 1);

insert into polyclinic (created_date, name, bed_capacity, status_enum, hospital_id)
values (localtimestamp, 'Dahiliye', 10, 'PASSIVE', 2);