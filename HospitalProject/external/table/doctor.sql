CREATE SEQUENCE DOCTOR_ID_SEQ INCREMENT 1 START 1 CACHE 1;
CREATE TABLE DOCTOR
(
    ID            BIGINT                      NOT NULL DEFAULT NEXTVAL('DOCTOR_ID_SEQ'),
    CREATED_DATE  TIMESTAMP WITHOUT TIME ZONE NOT NULL,

    FIRST_NAME    CHARACTER VARYING(50)       NOT NULL,
    LAST_NAME     CHARACTER VARYING(50)       NOT NULL,
    EMAIL         CHARACTER VARYING(50)       NOT NULL,
    PHONE_NUMBER  CHARACTER VARYING(50)       NOT NULL,
    BRANCH        CHARACTER VARYING(100)      NOT NULL,
    DEGREE        degree                      NOT NULL,
    HOSPITAL_ID   BIGINT                      NOT NULL,
    POLYCLINIC_ID BIGINT                      NOT NULL,

    CONSTRAINT PK_DOCTOR PRIMARY KEY (ID),
    CONSTRAINT FK_HOSPITAL_DOCTOR FOREIGN KEY (HOSPITAL_ID) REFERENCES HOSPITAL (ID),
    CONSTRAINT FK_POLYCLINIC_DOCTOR FOREIGN KEY (POLYCLINIC_ID) REFERENCES POLYCLINIC (ID)
);

insert into doctor (created_date, first_name, last_name, email, phone_number, branch, degree, hospital_id,
                    polyclinic_id)
values (localtimestamp, 'Metehan', 'ALTUNTAŞ', 'metehanaltuntas@mail.com', '543 543 5433',
        'Kulak-Burun-Boğaz Hastalıkları', 'ASSISTANT_PROFESSOR', 1, 1);

insert into doctor (created_date, first_name, last_name, email, phone_number, branch, degree, hospital_id,
                    polyclinic_id)
values (localtimestamp, 'Mustafa', 'UZUN', 'mustafauzun@mail.com', '544 544 54444',
        'Çocuk Kalp ve Damar Cerrahisi', 'PROFESSOR', 2, 2);