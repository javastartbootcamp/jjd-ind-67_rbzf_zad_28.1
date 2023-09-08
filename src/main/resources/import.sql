INSERT INTO CATEGORY (NAME, DESCRIPTION) VALUES ('gospodarstwo domowe', 'male urzadzenia do prac domowych');
INSERT INTO CATEGORY (NAME, DESCRIPTION) VALUES ('rozrywka', 'plyty, filmy, gry, itd');
INSERT INTO CATEGORY (NAME, DESCRIPTION) VALUES ('ogrod', 'sprzet do prac ogrodowych');

INSERT INTO OFFER (TITLE, DESCRIPTION, IMG_URL, PRICE) VALUES ('Mikser', 'rozdrabniacz do warzyw i owocow', 'https://czterykaty.pl/czterykaty/7,162615,25202288,nowoczesny-i-praktyczny-mikser.html', 110);
INSERT INTO OFFER (TITLE, DESCRIPTION, IMG_URL, PRICE) VALUES ('Grabie', 'podstawowe narzedzie do pielegnacji trawnika', 'https://www.obi.pl/prace-w-ziemi/grabie-wachlarzowe/p/6981401', 89);

INSERT INTO CATEGORY_OFFERS (CATEGORY_ID, OFFERS_ID) VALUES (1, 1);
INSERT INTO CATEGORY_OFFERS (CATEGORY_ID, OFFERS_ID) VALUES (3, 2);