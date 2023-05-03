-- NOTE: PlanetScale was used to host this database. PlanetScale does not support Foreign Keys or Primary Keys

CREATE TABLE Users (
	user_id INT NOT NULL UNIQUE,
	username VARCHAR(60) NOT NULL UNIQUE,
	pass VARCHAR(60),
	email VARCHAR(60) NOT NULL UNIQUE,
	created_at DATE,
	updated_at DATE
);

CREATE TABLE User_Roles (
	user_role_id INT NOT NULL UNIQUE,
	user_id INT NOT NULL UNIQUE,
	role_id INT NOT NULL UNIQUE
);

CREATE TABLE Roles (
	role_id INT NOT NULL UNIQUE,
	role_name ENUM ('Admin',
		'User') NOT NULL
);
