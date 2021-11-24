create table resume
(
    uuid            char(36) PRIMARY KEY NOT NULL,
    full_name       text
);

create table contact
(   id              SERIAL PRIMARY KEY,
    type            TEXT NOT NULL,
    value           TEXT NOT NULL,
    resume_uuid     CHAR(36) NOT null,
    constraint contact_resume_uuid_fk FOREIGN KEY (resume_uuid)
        REFERENCES resume (uuid_)
            on delete cascade
);

create unique index contact_uuid_type_index
    on contact (resume_uuid, type);

create table sections
(   id              serial constraint sections_pk primary key,
    resume_uuid     char(36) not null
    constraint sections_resume_uuid_fk
        references resume
            on delete cascade,
    type            text     not null,
    content         text     not null
);

create unique index sections_resume_uuid_type_uindex
    on sections (resume_uuid, type);