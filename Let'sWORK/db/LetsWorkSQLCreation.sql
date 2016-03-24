/* 
DROP TABLE public.comment;
DROP TABLE public.activity;
DROP TABLE public.category;
DROP TABLE public.goal;
DROP TABLE public.diary;
DROP TABLE public.notification;
DROP TABLE public.seller;
DROP TABLE public.customer;
DROP TABLE public.person;
DROP TABLE public.admin;
DROP TABLE public."user";
*/

-- Table: public."user"

CREATE TABLE public."user"
(
  id bigint NOT NULL,
  username character varying NOT NULL,
  password character varying NOT NULL,
  CONSTRAINT user_pk PRIMARY KEY (id),
  CONSTRAINT username_unique UNIQUE (username)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public."user"
  OWNER TO "LetsWorkAdmin";

-- Table: public.category

CREATE TABLE public.category
(
  id bigint NOT NULL,
  name character varying NOT NULL,
  description character varying,
  "categoryFatherId" bigint,
  CONSTRAINT category_pk PRIMARY KEY (id),
  CONSTRAINT "category_fk_categoryFatherId" FOREIGN KEY ("categoryFatherId")
      REFERENCES public.category (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.category
  OWNER TO "LetsWorkAdmin";

-- Table: public.offer
(
  id bigint NOT NULL,
  CONSTRAINT offer_pk PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.offer
  OWNER TO "LetsWorkAdmin";

-- Table: public.brand
(
  name character varying NOT NULL,
  CONSTRAINT brand_pk PRIMARY KEY (name)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.brand
  OWNER TO "LetsWorkAdmin";

-- Table: public.ressource

CREATE TABLE public.ressource
(
  code bigint NOT NULL,
  label character varying NOT NULL,
  description character varying,
  CONSTRAINT ressource_pk PRIMARY KEY (code)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.ressource
  OWNER TO "LetsWorkAdmin";

-- Table: public.person

CREATE TABLE public.person
(
  "userId" bigint NOT NULL,
  "firstName" character varying NOT NULL,
  "lastName" character varying NOT NULL,
  street character varying NOT NULL,
  "postalCode" character varying NOT NULL,
  city character varying NOT NULL,
  phone character varying NOT NULL,
  email character varying NOT NULL,
  CONSTRAINT person_pk PRIMARY KEY ("userId"),
  CONSTRAINT person_fk_user FOREIGN KEY ("userId")
      REFERENCES public."user" (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT email_unique UNIQUE (email)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.person
  OWNER TO "LetsWorkAdmin";

-- Table: public.admin

CREATE TABLE public.admin
(
  "userId" bigint NOT NULL,
  CONSTRAINT admin_pk PRIMARY KEY ("userId"),
  CONSTRAINT admin_fk_user FOREIGN KEY ("userId")
      REFERENCES public."user" (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.admin
  OWNER TO "LetsWorkAdmin";

-- Table: public.notification

CREATE TABLE public.notification
(
  id bigint NOT NULL,
  "senderUserId" bigint NOT NULL,
  "receiverUserId" bigint NOT NULL,
  "timestamp" timestamp without time zone NOT NULL,
  title character varying NOT NULL,
  description character varying NOT NULL,
  CONSTRAINT notification_pk PRIMARY KEY (id),
  CONSTRAINT "notification_fk_receiverUserId" FOREIGN KEY ("receiverUserId")
      REFERENCES public."user" (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT "notification_fk_senderUserId" FOREIGN KEY ("senderUserId")
      REFERENCES public."user" (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.notification
  OWNER TO "LetsWorkAdmin";

-- Table: public.service

CREATE TABLE public.service
(
  "ressourceCode" bigint NOT NULL,
  CONSTRAINT service_pk PRIMARY KEY ("ressourceCode"),
  CONSTRAINT service_fk_ressource FOREIGN KEY ("ressourceCode")
      REFERENCES public."ressource" (code) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.service
  OWNER TO "LetsWorkAdmin";

-- Table: public.product

CREATE TABLE public.product
(
  "ressourceCode" bigint NOT NULL,
  "brandName" character varying NOT NULL,
  CONSTRAINT product_pk PRIMARY KEY ("ressourceCode"),
  CONSTRAINT product_fk_ressource FOREIGN KEY ("ressourceCode")
      REFERENCES public."ressource" (code) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT product_fk_brand FOREIGN KEY ("brandName")
      REFERENCES public."brand" (name) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.product
  OWNER TO "LetsWorkAdmin";

-- Table: public.categoryRessource

CREATE TABLE public.categoryRessource
(
  "categoryId" bigint NOT NULL,
  "ressourceCode" bigint NOT NULL,
  CONSTRAINT categoryRessource_pk PRIMARY KEY ("categoryId", "ressourceCode"),
  CONSTRAINT categoryRessource_fk_category FOREIGN KEY ("categoryId")
      REFERENCES public."category" (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT categoryRessource_fk_ressource FOREIGN KEY ("ressourceCode")
      REFERENCES public."ressource" (code) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.categoryRessource
  OWNER TO "LetsWorkAdmin";

-- Table: public.customer

CREATE TABLE public.customer
(
  "personId" bigint NOT NULL,
  CONSTRAINT customer_pk PRIMARY KEY ("personId"),
  CONSTRAINT "customer_fk_personId" FOREIGN KEY ("personId")
      REFERENCES public.person ("userId") MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.customer
  OWNER TO "LetsWorkAdmin";

-- Table: public.seller

CREATE TABLE public.seller
(
  "personId" bigint NOT NULL,
  siret character varying NOT NULL,
  url character varying NOT NULL,
  "categroyId" bigint NOT NULL,
  CONSTRAINT seller_id PRIMARY KEY ("personId"),
  CONSTRAINT "seller_fk_personId" FOREIGN KEY ("personId")
      REFERENCES public.person ("userId") MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT "customer_fk_categoryId" FOREIGN KEY ("categoryId")
      REFERENCES public.category ("id") MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.seller
  OWNER TO "LetsWorkAdmin";

-- Table: public.diary

CREATE TABLE public.diary
(
  id bigint NOT NULL,
  name character varying NOT NULL,
  "isPublic" boolean NOT NULL,
  "customerId" bigint NOT NULL,
  CONSTRAINT diary_pk PRIMARY KEY (id),
  CONSTRAINT "diary_fk_customerId" FOREIGN KEY ("customerId")
      REFERENCES public.customer ("personId") MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT "name_customerId_unique" UNIQUE (name, "customerId")
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.diary
  OWNER TO "LetsWorkAdmin";

-- Table: public.goal

CREATE TABLE public.goal
(
  id bigint NOT NULL,
  name character varying NOT NULL,
  description bit varying,
  deadline date,
  "customerId" bigint NOT NULL,
  CONSTRAINT goal_fk PRIMARY KEY (id),
  CONSTRAINT "goal_fk_customerId" FOREIGN KEY ("customerId")
      REFERENCES public.customer ("personId") MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.goal
  OWNER TO "LetsWorkAdmin";

-- Table: public.serviceoffer

CREATE TABLE public.serviceoffer
(
  "offerId" bigint NOT NULL,
  price character varying NOT NULL,
  "serviceRessourceId" bit varying,
  "serviceSellerId" bigint NOT NULL,
  CONSTRAINT serviceoffer_fk PRIMARY KEY ("offerId"),
  CONSTRAINT "serviceoffer_fk_ressourceId" FOREIGN KEY ("serviceRessourceId")
      REFERENCES public.ressource ("ressourceId") MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT "serviceoffer_fk_sellerId" FOREIGN KEY ("serviceSellerId")
      REFERENCES public.seller ("personId") MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.serviceoffer
  OWNER TO "LetsWorkAdmin";

-- Table: public.productoffer

CREATE TABLE public.productoffer
(
  "offerId" bigint NOT NULL,
  price character varying NOT NULL,
  amount character varying NOT NULL,
  "productRessourceId" bit varying,
  "productSellerId" bigint NOT NULL,
  CONSTRAINT productoffer_fk PRIMARY KEY ("offerId"),
  CONSTRAINT "productoffer_fk_ressourceId" FOREIGN KEY ("productRessourceId")
      REFERENCES public.ressource ("ressourceId") MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT "productoffer_fk_sellerId" FOREIGN KEY ("productSellerId")
      REFERENCES public.product ("personId") MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.productoffer
  OWNER TO "LetsWorkAdmin";

-- Table: public.order

CREATE TABLE public.order
(
  id bigint NOT NULL,
  date date,
  totalprice character varying NOT NULL,
  "customerId" bit varying,
  CONSTRAINT order_fk PRIMARY KEY (id),
  CONSTRAINT "order_fk_customerId" FOREIGN KEY ("customerId")
      REFERENCES public.customer ("personId") MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.order
  OWNER TO "LetsWorkAdmin";

-- Table: public.basketline

CREATE TABLE public.basketline
(
  id bigint NOT NULL,
  amount character varying NOT NULL,
  "offerId" character varying NOT NULL,
  "customerId" bit varying,
  CONSTRAINT basketline_fk PRIMARY KEY (id),
  CONSTRAINT "basketline_fk_offerId" FOREIGN KEY ("offerId")
      REFERENCES public.offer ("id") MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT "basketline_fk_customerId" FOREIGN KEY ("customerId")
      REFERENCES public.customer ("personId") MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.basketline
  OWNER TO "LetsWorkAdmin";

-- Table: public.activity

CREATE TABLE public.activity
(
  id bigint NOT NULL,
  name character varying NOT NULL,
  date date,
  "position" integer,
  "isPublic" boolean NOT NULL DEFAULT true,
  "diaryId" bigint NOT NULL,
  "categoryId" bigint NOT NULL,
  "goalId" bigint,
  CONSTRAINT activity_pk PRIMARY KEY (id),
  CONSTRAINT "activity_fk_categoryId" FOREIGN KEY ("categoryId")
      REFERENCES public.category (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT "activity_fk_diaryId" FOREIGN KEY ("diaryId")
      REFERENCES public.diary (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT "activity_fk_goalId" FOREIGN KEY ("goalId")
      REFERENCES public.goal (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.activity
  OWNER TO "LetsWorkAdmin";

-- Table: public.orderline

CREATE TABLE public.orderline
(
  id bigint NOT NULL,
  amount character varying NOT NULL,
  price bigint NOT NULL,
  "sellerId" character varying,
  "orderId" character varying,
  "ressourceCode" bigint,

  CONSTRAINT orderline_pk PRIMARY KEY (id),
  CONSTRAINT "orderline_fk_categoryId" FOREIGN KEY ("sellerId")
      REFERENCES public.seller (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT "orderline_fk_orderId" FOREIGN KEY ("orderId")
      REFERENCES public.order (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT "orderline_fk_ressourceCode" FOREIGN KEY ("goalId")
      REFERENCES public.ressource (Code) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.orderline
  OWNER TO "LetsWorkAdmin";

-- Table: public.comment

CREATE TABLE public.comment
(
  id bigint NOT NULL,
  "userId" bigint NOT NULL,
  "activityId" bigint NOT NULL,
  message character varying NOT NULL,
  "timestamp" timestamp without time zone NOT NULL,
  CONSTRAINT comment_pk PRIMARY KEY (id),
  CONSTRAINT "comment_fk_activityId" FOREIGN KEY ("activityId")
      REFERENCES public.activity (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT "comment_fk_userId" FOREIGN KEY ("userId")
      REFERENCES public."user" (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.comment
  OWNER TO "LetsWorkAdmin";