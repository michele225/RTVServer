
CREATE TABLE "mappa" (
   id serial NOT NULL,
   "nome" varchar(20),
   cities jsonb NOT NULL,
   PRIMARY KEY(id)
);

