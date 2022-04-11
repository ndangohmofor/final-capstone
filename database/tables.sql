BEGIN;

-- CREATE statements go here
DROP TABLE IF EXISTS user_profile, machine, equipment_log, gym_checkin, workout_class,app_user,workout_user;

CREATE TABLE app_user (
                          id SERIAL PRIMARY KEY,
                          user_name varchar(32) NOT NULL UNIQUE,
                          password varchar(32) NOT NULL,
                          role varchar(32),
                          salt varchar(255) NOT NULL
);

CREATE TABLE user_profile (
                          id SERIAL PRIMARY KEY,
                          first_name varchar(50) NOT NULL,
                          last_name varchar(50) NOT NULL,
                          email varchar(100) NOT NULL,
                          photo varchar(250),
                          goal varchar(250),
                          user_id int
);

alter table user_profile alter column photo type bytea using photo::bytea;


CREATE TABLE machine (
    id SERIAL PRIMARY KEY,
    machine_name varchar(50) NOT NULL,
    machine_type varchar(50) NOT NULL,
    machine_reference varchar(250),
    total_usage integer
);

CREATE TABLE equipment_log (
  id SERIAL PRIMARY KEY,
  duration int NOT NULL,
  date timestamp NOT NULL,
  reps int,
  weight int,
  user_id int,
  machine_id int
);

CREATE TABLE gym_checkin (
    id SERIAL PRIMARY KEY ,
    check_in timestamp not null,
    check_out timestamp,
    is_checked_in boolean not null,
    user_id int
);

CREATE TABLE workout_class (
    id SERIAL PRIMARY KEY,
    class_name varchar(100) not null,
    date timestamp not null,
    instructor varchar(100),
    description text,
    duration_in_minutes int
);

create table workout_user
(
    workout_id integer not null
        constraint workout_user_workout_class__fk
            references workout_class,
    user_id integer not null
        constraint workout_user_app_user__fk
            references app_user,
    constraint workout_user_pk
        primary key (workout_id, user_id)
);


INSERT INTO machine(machine_name, machine_type, machine_reference) values ('treadmill','cardio', 'treadmill.png');
INSERT INTO machine(machine_name, machine_type, machine_reference) values ('stationary bike','cardio', 'stationarybike.png');
INSERT INTO machine(machine_name, machine_type, machine_reference) values ('row machine','cardio', 'rowingmachine.png' );
INSERT INTO machine(machine_name, machine_type, machine_reference) values ('elliptical','cardio', 'eliptical.png');
INSERT INTO machine(machine_name, machine_type, machine_reference) values ('stairmaster','cardio', 'stairmaster.png');
INSERT INTO machine(machine_name, machine_type, machine_reference) values ('leg press','weights', 'legpress.png');
INSERT INTO machine(machine_name, machine_type, machine_reference) values ('chest press','weights', 'benchpress.png');
INSERT INTO machine(machine_name, machine_type, machine_reference) values ('smith','weights', 'smith.png');
INSERT INTO machine(machine_name, machine_type, machine_reference) values ('leg curl','weights', 'legcurl.png');
INSERT INTO machine(machine_name, machine_type, machine_reference) values ('bench press','weights', 'benchpress.png');

INSERT INTO workout_class (id, class_name, date, instructor, description, duration_in_minutes) VALUES (2, 'Pilates', '2022-04-16 13:45:00.000000', 'Ivo M.', 'Pilates is commonly compared for it’s similarities to Yoga. While Yoga focuses on strength and flexibility through long held, swift-moving postures and “grounding” positions to help you feel centered and balanced, Pilates brings a ....', 120);
INSERT INTO workout_class (id, class_name, date, instructor, description, duration_in_minutes) VALUES (5, 'Cycling', '2022-04-18 12:15:00.000000', 'Nirali P.', 'A Cycling class is great cardio workout that relies on a fitness center cycling machine, usually in a room designated for this type of fitness class. Often times, the class includes fast-paced upbeat tracks to help build the ...', 45);
INSERT INTO workout_class (id, class_name, date, instructor, description, duration_in_minutes) VALUES (4, 'HIIT', '2022-04-23 20:00:00.000000', 'John C.', 'HIIT stands for High-Intensity Interval Training, and is an exercise strategy that alternates short periods of intense exercise movements, followed by less intense, but still active “recovery” periods. The goal with a HIIT class is ...', 90);
INSERT INTO workout_class (id, class_name, date, instructor, description, duration_in_minutes) VALUES (3, 'Circuit Training', '2022-04-18 14:30:00.000000', 'William B.', 'Circuit Training classes are typically an interval-style, fast paced, shorter routine that does exactly as its name implies – a series of exercises that complete a circuit. Normally in this class setting, you complete ...', 60);
INSERT INTO workout_class (id, class_name, date, instructor, description, duration_in_minutes) VALUES (1, 'Yoga', '2022-04-17 10:30:00.000000', 'Yvette J.', 'Yoga is our most commonly requested group fitness class, and most people are already familiar with the concept of it. This type of exercise has nearly a dozen variations of its own, with the most popular styles including Hot Yoga, ...', 90);

ALTER TABLE user_profile ADD CONSTRAINT FK_userprofile_user_id foreign key (user_id) references app_user (id);
ALTER TABLE equipment_log ADD CONSTRAINT FK_equipment_log_user_id foreign key (user_id) references app_user (id);
ALTER TABLE equipment_log ADD CONSTRAINT FK_equipment_log_machine_id foreign key (machine_id) references machine (id);
ALTER TABLE gym_checkin ADD CONSTRAINT FK_gym_checkin_user_id foreign key (user_id) references app_user (id);

COMMIT;