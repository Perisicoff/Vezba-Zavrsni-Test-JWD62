INSERT INTO korisnik (id, e_mail, korisnicko_ime, lozinka, ime, prezime, uloga)
              VALUES (1,'miroslav@maildrop.cc','miroslav','$2y$12$NH2KM2BJaBl.ik90Z1YqAOjoPgSd0ns/bF.7WedMxZ54OhWQNNnh6','Miroslav','Simic','ADMIN');
INSERT INTO korisnik (id, e_mail, korisnicko_ime, lozinka, ime, prezime, uloga)
              VALUES (2,'tamara@maildrop.cc','tamara','$2y$12$DRhCpltZygkA7EZ2WeWIbewWBjLE0KYiUO.tHDUaJNMpsHxXEw9Ky','Tamara','Milosavljevic','KORISNIK');
INSERT INTO korisnik (id, e_mail, korisnicko_ime, lozinka, ime, prezime, uloga)
              VALUES (3,'petar@maildrop.cc','petar','$2y$12$i6/mU4w0HhG8RQRXHjNCa.tG2OwGSVXb0GYUnf8MZUdeadE4voHbC','Petar','Jovic','KORISNIK');

INSERT INTO kategorija (naziv) VALUES ('pas');
INSERT INTO kategorija (naziv) VALUES ('macka');
INSERT INTO kategorija (naziv) VALUES ('papagaj');

INSERT INTO ljubimac (ime, opis, pol, starost, tezina, vakcinisan, kategorija_id, udomljavanje_id) VALUES ('ime 1', 'haha', 'muski', '3', '2.1', true, 1, null);
INSERT INTO ljubimac (ime, opis, pol, starost, tezina, vakcinisan, kategorija_id, udomljavanje_id) VALUES ('ime 2', 'hahhahaa', 'zenski', '3', '2.1', false, 2, null);
INSERT INTO ljubimac (ime, opis, pol, starost, tezina, vakcinisan, kategorija_id, udomljavanje_id) VALUES ('ime 3', 'haaaha', 'muski', '3', '2.1', true, 3, null);

INSERT INTO udomljavanje (datum) VALUES ('2020-01-12');
INSERT INTO udomljavanje (datum) VALUES ('2020-01-13');
INSERT INTO udomljavanje (datum) VALUES ('2020-01-14');