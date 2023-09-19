DROP TABLE IF EXISTS caroptions, cars, completions, completionsoptions, models, customers, orders CASCADE;

DROP EXTENSION IF EXISTS "uuid-ossp";
CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE Customers
(
  id UUID DEFAULT uuid_generate_v4 (),
  secondname TEXT NOT NULL,		
  firstname TEXT NOT NULL,
  middlename TEXT NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE caroptions
(
  id UUID DEFAULT uuid_generate_v4 (),
  optionname TEXT NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE completions
(
  id UUID DEFAULT uuid_generate_v4 (),
  completionname TEXT NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE completionsoptions
(
  idcopmletion UUID,
  idcaroption UUID,
  FOREIGN KEY (idcopmletion) REFERENCES completions (id),
  FOREIGN KEY (idcaroption) REFERENCES caroptions (id)
);

CREATE TABLE models 
(
	id UUID DEFAULT uuid_generate_v4 (),
	modelname TEXT NOT NULL,
  	idcopmletion UUID,
  	PRIMARY KEY (id),
  	FOREIGN KEY (idcopmletion) REFERENCES completions (id)
);

CREATE TABLE cars
(
	id UUID DEFAULT uuid_generate_v4 (),
  	vin TEXT NOT NULL,
  	idmodel UUID,
  	PRIMARY KEY (id),
  	FOREIGN KEY (idmodel) REFERENCES models (id)
);

CREATE TABLE orders
(
	id UUID DEFAULT uuid_generate_v4 (),
  	ordernumber INT NOT NULL,
  	idcustomer UUID,
  	idcar UUID,
  	PRIMARY KEY (id),
  	FOREIGN KEY (idcustomer) REFERENCES customers (id),
  	FOREIGN KEY (idcar) REFERENCES cars (id)
);