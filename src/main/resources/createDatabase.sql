drop table Owner;
drop table Vehicle;

CREATE table if not EXISTS Owner (
  firstname VARCHAR(10) not null,
  lastname VARCHAR(10) not null,
  email VALUE(20) not null PRIMARY KEY,
  password VARCHAR(20) not null
)

CREATE table if not EXISTS Vehicle (
  plate VARCHAR(6) not null PRIMARY KEY,
  model VARCHAR(10) not null,
  make VARCHAR(10) not null,
  manufactureDate DATE,
  fuelType VARCHAR(8),
  vin VARCHAR(17),
  firstRegistrationYear int,
  odometer int,
  wofExpiryDate DATE
)