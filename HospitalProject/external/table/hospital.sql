CREATE SEQUENCE HOSPITAL_ID_SEQ INCREMENT 1 START 1 CACHE 1;
CREATE TABLE HOSPITAL
(
    ID                 BIGINT                      NOT NULL DEFAULT NEXTVAL('HOSPITAL_ID_SEQ'),
    CREATED_DATE       TIMESTAMP WITHOUT TIME ZONE NOT NULL,

    NAME               CHARACTER VARYING(100)      NOT NULL,
    PATIENT_ROOM_COUNT INT                         NOT NULL,
    BED_CAPACITY       INT                         NOT NULL,
    PATIENT_CAPACITY   INT                         NOT NULL,
    ADDRESS_ID         BIGINT                      NOT NULL,
    PHONE_NUMBER       CHARACTER VARYING(20)       NULL,

    CONSTRAINT PK_HOSPITAL PRIMARY KEY (ID),
    CONSTRAINT FK_HOSPITAL_ADDRESS FOREIGN KEY (ADDRESS_ID) REFERENCES ADDRESS (ID)
);
insert into hospital (created_date, name, patient_room_count, bed_capacity, patient_capacity, address_id,
                      phone_number)
values (localtimestamp, 'Medical Park', 50, 100, 100, 1, '555 5555 555');

insert into hospital (created_date, name, patient_room_count, bed_capacity, patient_capacity, address_id,
                      phone_number)
values (localtimestamp, 'Medicana', 40, 80, 80, 2, '444 444 444');