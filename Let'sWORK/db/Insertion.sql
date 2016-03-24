INSERT INTO public."user"(id, username, password) VALUES (DEFAULT, 'admin', 'admin');
    
INSERT INTO public."user"(id, username, password) VALUES (DEFAULT, 'customer', 'customer');

INSERT INTO public."user"(id, username, password) VALUES (DEFAULT, 'seller', 'seller');

INSERT INTO public.person(id, firstName, lastName, street, postalCode, city, phone, email)
VALUES (1, 'adminFName', 'adminLName', 'Eugène Bataillon', '34000', 'Montpellier', '0403020100', 'polytech@montpellier.fr');

INSERT INTO public.person(id, firstName, lastName, street, postalCode, city, phone, email)
VALUES (2, 'customerFName', 'customerLName', 'Eugène Bataillon', '34000', 'Montpellier', '0403020101', 'polytech2@montpellier.fr');

INSERT INTO public.person(id, firstName, lastName, street, postalCode, city, phone, email)
VALUES (3, 'sellerFName', 'sellerLName', 'Eugène Bataillon', '34000', 'Montpellier', '0403020101', 'polytech3@montpellier.fr');

INSERT INTO public.admin(id) VALUES (1);

INSERT INTO public.category (id, name, description, categoryFatherId)
VALUES (DEFAULT, 'cat1', 'premiere categorie enregistree', null);

INSERT INTO public.seller(id, siret, url, categroyid) VALUES (3, 'siret', 'url', 1);

INSERT INTO public.customer(id) VALUES (2);

INSERT INTO public.offer(id) VALUES (DEFAULT);

INSERT INTO public.offer(id) VALUES (DEFAULT);

INSERT INTO public.offer(id) VALUES (DEFAULT);

INSERT INTO public.brand(name) VALUES ('brand1');

INSERT INTO public.brand(name) VALUES ('brand2');

INSERT INTO public.brand(name) VALUES ('brand3');

INSERT INTO public.ressource(code, label, description)  VALUES (DEFAULT, 'service1', 'description service1');

INSERT INTO public.ressource(code, label, description)  VALUES (DEFAULT, 'service2', 'description service2');

INSERT INTO public.ressource(code, label, description)  VALUES (DEFAULT, 'product3', 'description product3');

INSERT INTO public.service(id) VALUES (1);

INSERT INTO public.service(id) VALUES (2);

INSERT INTO public.product(id, brandName) VALUES (3, 'brand3');

INSERT INTO public.categoryRessource(categoryId, ressourceCode) VALUES (1, 1);

INSERT INTO public.categoryRessource(categoryId, ressourceCode) VALUES (1, 2);

INSERT INTO public.diary(id, name, isPublic, customerId) VALUES (DEFAULT, 'diaryCust2', TRUE, 2);

INSERT INTO public.goal(id, name, description, deadline, customerId) VALUES (DEFAULT, 'Faire du sport', 'Aller à la salle et prendre les affaires', '2016-08-10',2);

INSERT INTO public.serviceoffer(id, price, serviceRessourceId, serviceSellerId) VALUES (DEFAULT, '19', 1, 3);

INSERT INTO public.productoffer(id, price, amount, productRessourceId, productSellerId) VALUES (DEFAULT, '22', '14', 3, 3);

INSERT INTO public.order(id, date, totalprice, customerId) VALUES (DEFAULT, '2016-03-22', '23', 2);

INSERT INTO public.activity(id, name, date, position, isPublic, diaryId, categoryId, goalId) VALUES (DEFAULT, 'acti1', '2016-03-23', 2, TRUE, 1, 1, 1);

INSERT INTO public.orderline(id, amount, price, sellerId, orderId, ressourceCode) VALUES (DEFAULT, '4', 23, 3, 1, 3);

INSERT INTO public.basketline(id, amount, offerId, customerId) VALUES (DEFAULT, '4', 1, 2);