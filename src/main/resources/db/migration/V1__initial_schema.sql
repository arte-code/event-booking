create table "user"
(
    id         bigint generated always as identity primary key,
    name       text        not null,

    created_at timestamptz not null default now(),
    updated_at timestamptz not null default now()
);

create table event
(
    id           bigint generated always as identity primary key,

    name         text        not null,
    description  text        not null,
    organiser_id bigint      not null references "user" (id) on DELETE restrict,

    country      text        not null,
    city         text        not null,
    address      text        not null,

    start_date   timestamptz not null,
    end_date     timestamptz not null,

    created_at   timestamptz not null default now(),
    updated_at   timestamptz not null default now(),

    constraint event_time_order check ( end_date > start_date )

);

create index idx_event_organiser_id on event (organiser_id);

create table section
(
    id          bigint generated always as identity primary key,
    name        text        not null,
    description text,
    seats_count smallint    not null check ( seats_count > 0 ),

    event_id    bigint      not null references event (id) on DELETE CASCADE,

    created_at  timestamptz not null default now(),
    updated_at  timestamptz not null default now()
);

create index idx_section_event_id on section (event_id);

create table seat
(
    id         bigint generated always as identity primary key,
    name       text        not null,
    type       varchar(32) not null check (type in ('REGULAR', 'VIP')),

    section_id bigint      not null references section (id) on DELETE CASCADE,
    status     varchar(32) not null check (status in ('AVAILABLE', 'RESERVED', 'BOOKED')),


    created_at timestamptz not null default now(),
    updated_at timestamptz not null default now()

);

create index idx_seat_status_section_id on seat (status, section_id);
