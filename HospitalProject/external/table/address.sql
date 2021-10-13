CREATE SEQUENCE ADDRESS_ID_SEQ INCREMENT 1 START 1 CACHE 1;
CREATE TABLE ADDRESS
(
    ID           BIGINT                      NOT NULL DEFAULT NEXTVAL('ADDRESS_ID_SEQ'),
    CREATED_DATE TIMESTAMP WITHOUT TIME ZONE NOT NULL,

    COUNTRY      CHARACTER VARYING(100)      NOT NULL,
    CITY         CHARACTER VARYING(100)      NOT NULL,
    DISTRICT     CHARACTER VARYING(100)      NOT NULL,
    STREET       CHARACTER VARYING(100)      NOT NULL,
    ZIP          CHARACTER VARYING(100)      NULL,

    CONSTRAINT PK_ADDRESS PRIMARY KEY (ID)
);
insert into address (created_date, country, city, district, street, zip)
values (localtimestamp, 'Türkiye', 'İstanbul', 'Levent', 'Uzun Sk.', '1231231');

insert into address (created_date, country, city, district, street, zip)
values (localtimestamp, 'Türkiye', 'Samsun', 'Merkez', 'Cumhuriyet Sk.', '55122');
