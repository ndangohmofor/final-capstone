BEGIN;

-- CREATE statements go here
DROP TABLE IF EXISTS user_profile, machine, equipment_log, gym_checkin, workout_class,app_user;

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


CREATE TABLE machine (
    id SERIAL PRIMARY KEY,
    machine_name varchar(50) NOT NULL,
    machine_type varchar(50) NOT NULL,
    machine_reference varchar(250)
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
    check_out timestamp not null,
    user_id int
);

CREATE TABLE workout_class (
    id SERIAL PRIMARY KEY,
    class_name varchar(100) not null,
    date timestamp not null,
    instructor varchar(100)
);

--INSERT INTO app_user(user_name, password, role, salt) values ('admin', 'admin1', 'admin');

INSERT INTO machine(machine_name, machine_type) values ('treadmill','cardio');
INSERT INTO machine(machine_name, machine_type) values ('stationary bike','cardio');
INSERT INTO machine(machine_name, machine_type) values ('row machine','cardio');
INSERT INTO machine(machine_name, machine_type) values ('elliptical','cardio');
INSERT INTO machine(machine_name, machine_type) values ('stairmaster','cardio');
INSERT INTO machine(machine_name, machine_type) values ('leg press','weights');
INSERT INTO machine(machine_name, machine_type) values ('chest press','weights');
INSERT INTO machine(machine_name, machine_type) values ('smith','weights');
INSERT INTO machine(machine_name, machine_type) values ('leg curl','weights');
INSERT INTO machine(machine_name, machine_type) values ('bench press','weights');


/*ALTER TABLE user_profile ADD CONSTRAINT FK_userprofile_user_id foreign key (user_id) references app_user (id);
ALTER TABLE equipment_log ADD CONSTRAINT FK_equipment_log_user_id foreign key (user_id) references app_user (id);
ALTER TABLE equipment_log ADD CONSTRAINT FK_equipment_log_machine_id foreign key (machine_id) references machine (id);
ALTER TABLE gym_checkin ADD CONSTRAINT FK_gym_checkin_user_id foreign key (user_id) references app_user (id);
*/
COMMIT;