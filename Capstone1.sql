CREATE DATABASE marketplace_db;
USE marketplace_db;

-- Tables for Products
CREATE TABLE home(
home_id INTEGER AUTO_INCREMENT NOT NULL,
home_name VARCHAR(255) NOT NULL,
manufacturer_id INTEGER NOT NULL,
home_price DECIMAL(5,2) NOT NULL,
home_quantity INTEGER NOT NULL,
home_rating INTEGER(1) NOT NULL,
PRIMARY KEY (home_id)
);
CREATE TABLE electronics(
electronics_id INTEGER AUTO_INCREMENT NOT NULL,
electronics_name VARCHAR(255) NOT NULL,
manufacturer_id INTEGER NOT NULL,
electronics_price DECIMAL(5,2) NOT NULL,
electronics_quantity INTEGER NOT NULL,
electronics_rating INTEGER(1) NOT NULL,
PRIMARY KEY (electronics_id)
);
CREATE TABLE apparel(
apparel_id INTEGER AUTO_INCREMENT NOT NULL,
apparel_name VARCHAR(255) NOT NULL,
manufacturer_id INTEGER NOT NULL,
apparel_price DECIMAL(5,2) NOT NULL,
apparel_quantity INTEGER NOT NULL,
apparel_rating INTEGER(1) NOT NULL,
PRIMARY KEY (apparel_id)
);
CREATE TABLE accessories(
accessories_id INTEGER AUTO_INCREMENT NOT NULL,
accessories_name VARCHAR(255) NOT NULL,
manufacturer_id INTEGER NOT NULL,
accessories_price DECIMAL(5,2) NOT NULL,
accessories_quantity INTEGER NOT NULL,
accessories_rating INTEGER(1) NOT NULL,
PRIMARY KEY (accessories_id)
);
CREATE TABLE shoes(
shoes_id INTEGER AUTO_INCREMENT NOT NULL,
shoes_name VARCHAR(255) NOT NULL,
manufacturer_id INTEGER NOT NULL,
shoes_price DECIMAL(5,2) NOT NULL,
shoes_quantity INTEGER NOT NULL,
shoes_rating INTEGER(1) NOT NULL,
PRIMARY KEY (shoes_id)
);
CREATE TABLE beauty(
beauty_id INTEGER AUTO_INCREMENT NOT NULL,
beauty_name VARCHAR(255) NOT NULL,
manufacturer_id INTEGER NOT NULL,
beauty_price DECIMAL(5,2) NOT NULL,
beauty_quantity INTEGER NOT NULL,
beauty_rating INTEGER(1) NOT NULL,
PRIMARY KEY (beauty_id)
);
CREATE TABLE garden(
garden_id INTEGER AUTO_INCREMENT NOT NULL,
garden_name VARCHAR(255) NOT NULL,
manufacturer_id INTEGER NOT NULL,
garden_price DECIMAL(5,2) NOT NULL,
garden_quantity INTEGER,
garden_rating INTEGER(1),
PRIMARY KEY (garden_id)
);

-- Tables for entities
CREATE TABLE manufacturer(
manufacturer_id INTEGER AUTO_INCREMENT NOT NULL,
manufacturer_name VARCHAR(255) NOT NULL,
manufacturer_street VARCHAR(255) NOT NULL,
manufacturer_city VARCHAR(30) NOT NULL,
manufacturer_state VARCHAR(30) NOT NULL,
manufacturer_zipcode VARCHAR(5) NOT NULL,
manufacturer_phone VARCHAR(15) NOT NULL,
manufacturer_contact VARCHAR (255) NOT NULL
PRIMARY KEY (manufacturer_id)
);
-- adding customer later
CREATE TABLE customer(
customer_id INTEGER AUTO_INCREMENT NOT NULL,
customer_name VARCHAR(255) NOT NULL,
customer_street VARCHAR(255) NOT NULL,
customer_city VARCHAR(30) NOT NULL,
customer_state VARCHAR(30) NOT NULL,
customer_zipcode VARCHAR(5) NOT NULL,
PRIMARY KEY (customer_id)
);
CREATE TABLE cart(
cart_id INTEGER AUTO_INCREMENT NOT NULL,
customer_id INTEGER,
item_type VARCHAR(20) NOT NULL,
item_id INTEGER(11) NOT NULL,
unit_price DECIMAL(2,5) NOT NULL,
quantity INTEGER(11) NOT NULL,
total_cost DECIMAL(2,5) NOT NULL);

-- Left Join Cart / Customer
SELECT * 
FROM cart 
LEFT JOIN customer ON cart.customer_id = customer.customer_id;


-- Foreign Key Manufacturer
ALTER TABLE home ADD CONSTRAINT fk_manufacturer FOREIGN KEY (manufacturer_id) REFERENCES manufacturer(manufacturer_id);
ALTER TABLE electronics ADD CONSTRAINT fk_manufacturer FOREIGN KEY (manufacturer_id) REFERENCES manufacturer(manufacturer_id);
ALTER TABLE apparel ADD CONSTRAINT fk_manufacturer FOREIGN KEY (manufacturer_id) REFERENCES manufacturer(manufacturer_id);
ALTER TABLE accessories ADD CONSTRAINT fk_manufacturer FOREIGN KEY (manufacturer_id) REFERENCES manufacturer(manufacturer_id);
ALTER TABLE shoes ADD CONSTRAINT fk_manufacturer FOREIGN KEY (manufacturer_id) REFERENCES manufacturer(manufacturer_id);
ALTER TABLE beauty ADD CONSTRAINT fk_manufacturer FOREIGN KEY (manufacturer_id) REFERENCES manufacturer(manufacturer_id);
ALTER TABLE garden ADD CONSTRAINT fk_manufacturer FOREIGN KEY (manufacturer_id) REFERENCES manufacturer(manufacturer_id);


-- Data for table (Manufacturer)
INSERT INTO manufacturer (manufacturer_id, manufacturer_name, manufacturer_street, manufacturer_city, manufacturer_state, manufacturer_zipcode, manufacturer_phone, manufacturer_contact)
VALUES ("Happy Home", "123 Main Street", "San Diego", "CA", 92027, 111-111-1111, "Amy");
INSERT INTO manufacturer (manufacturer_id, manufacturer_name, manufacturer_street, manufacturer_city, manufacturer_state, manufacturer_zipcode, manufacturer_phone, manufacturer_contact)
VALUES ("Edward's Emporium", "555 A Street", "Huntington", "NY", 11746, 222-222-2222, "Edward");
INSERT INTO manufacturer (manufacturer_id, manufacturer_name, manufacturer_street, manufacturer_city, manufacturer_state, manufacturer_zipcode, manufacturer_phone, manufacturer_contact) 
VALUES ("Bob's Bucket", "1277 West Ford Street", "Cincinnati", "OH", 41073, 333-333-3333, "Laura");
INSERT INTO manufacturer (manufacturer_id, manufacturer_name, manufacturer_street, manufacturer_city, manufacturer_state, manufacturer_zipcode, manufacturer_phone, manufacturer_contact) 
VALUES ("Everything & More", "81 East Appleton Drive", "Toledo", "OH", 43537, 444-444-4444, "Thomas");
INSERT INTO manufacturer (manufacturer_id, manufacturer_name, manufacturer_street, manufacturer_city, manufacturer_state, manufacturer_zipcode, manufacturer_phone, manufacturer_contact) 
VALUES ("Lola's Luxuries", "751 Sol Drive Suite #2", "Miami", "FL", 33101, 555-555-5555, "Eva");
INSERT INTO manufacturer (manufacturer_id, manufacturer_name, manufacturer_street, manufacturer_city, manufacturer_state, manufacturer_zipcode, manufacturer_phone, manufacturer_contact) 
VALUES ("William's Fine Wares", "1254 East Main Street Suite A", "Chesapeake", "VA", 23320, 676-676-6766, "Bob");
INSERT INTO manufacturer (manufacturer_id, manufacturer_name, manufacturer_street, manufacturer_city, manufacturer_state, manufacturer_zipcode, manufacturer_phone, manufacturer_contact) 
VALUES ("Hashtag n' bag", "72 East Rivergate", "Memphis", "TN", 37501, 777-777-7777, "Ashley");
INSERT INTO manufacturer (manufacturer_id, manufacturer_name, manufacturer_street, manufacturer_city, manufacturer_state, manufacturer_zipcode, manufacturer_phone, manufacturer_contact) 
VALUES ("Eden's Half Acre", "752 South Industry Road", "Phoenix", "AZ", 85001, 888-888-8888, "Ruth");
INSERT INTO manufacturer (manufacturer_id, manufacturer_name, manufacturer_street, manufacturer_city, manufacturer_state, manufacturer_zipcode, manufacturer_phone, manufacturer_contact) 
VALUES ("Willow", "5217 Hearld Square", "Portland", "OR", 97305, 999-999-9999, "Ariel");
INSERT INTO manufacturer (manufacturer_id, manufacturer_name, manufacturer_street, manufacturer_city, manufacturer_state, manufacturer_zipcode, manufacturer_phone, manufacturer_contact) 
VALUES ("pLAN", "3600 East Trinity Plaza", "Dallas", "TX", 75001, 123-456-7890, "Ricardo");


-- Data for table (home)
INSERT INTO home (home_id, home_name, home_price, home_quantity, home_rating)
VALUES (1,"Table for One", 199.99, 5, 4);
INSERT INTO home (home_id, home_name, home_price, home_quantity, home_rating)
VALUES (2, "King Size Bed with Walnut Trim", 599.99, 3, 5);
INSERT INTO home (home_id, home_name, home_price, home_quantity, home_rating)
VALUES (3, "Minimalist Coffee Table", 99.99, 2, 3);
INSERT INTO home (home_id, home_name, home_price, home_quantity, home_rating)
VALUES (4, "Coffee Bar", 199.99, 10, 4);
INSERT INTO home (home_id, home_name, home_price, home_quantity, home_rating)
VALUES (5, "Classic Bar Stool", 74.99, 20, 2);

-- Data for table (electronics)
INSERT INTO electronics (electronics_id, electronics_name, electronics_price, electronics_quantity, electronics_rating)
VALUES (1, "SuperSized FlatScreen 100", 999.99, 2, 5);
INSERT INTO electronics (electronics_id, electronics_name, electronics_price, electronics_quantity, electronics_rating)
VALUES (2, "GameStation 4", 499.99, 10, 4);
INSERT INTO electronics (electronics_id, electronics_name, electronics_price, electronics_quantity, electronics_rating)
VALUES (3, "YCubeY", 599.99, 7, 4);
INSERT INTO electronics (electronics_id, electronics_name, electronics_price, electronics_quantity, electronics_rating)
VALUES (4, "DreamWare", 299.99, 5, 2);
INSERT INTO electronics (electronics_id, electronics_name, electronics_price, electronics_quantity, electronics_rating)
VALUES (5, "The Beast", 2999.99, 2, 5);

-- Data for table (apparel)
INSERT INTO apparel (apparel_id, apparel_name, apparel_price, apparel_quantity, apparel_rating)
VALUES (1, "Plain White T", 14.99, 25, 2);
INSERT INTO apparel (apparel_id, apparel_name, apparel_price, apparel_quantity, apparel_rating)
VALUES (2, "Women's Black Willow Tank", 24.99, 25, 3);
INSERT INTO apparel (apparel_id, apparel_name, apparel_price, apparel_quantity, apparel_rating)
VALUES (3, "Men's Black & Gold Rugby Pullover", 14.99, 15, 4);
INSERT INTO apparel (apparel_id, apparel_name, apparel_price, apparel_quantity, apparel_rating)
VALUES (4, "Kids YCubeY Graphic T-Shirt", 9.99, 15, 4);
INSERT INTO apparel (apparel_id, apparel_name, apparel_price, apparel_quantity, apparel_rating)
VALUES (5, "A Literal Potato Sack", 74.99, 1, 1);

-- Data for table (accessories)
INSERT INTO accessories (accessories_id, accessories_name, accessories_price, accessories_quantity, accessories_rating)
VALUES (1, "Willow Bark Necklace", 14.99, 25, 3);
INSERT INTO accessories (accessories_id, accessories_name, accessories_price, accessories_quantity, accessories_rating)
VALUES (2, "Silver Chain", 99.99, 10, 5);
INSERT INTO accessories (accessories_id, accessories_name, accessories_price, accessories_quantity, accessories_rating)
VALUES (3, "Tiger's Eye Pendant", 24.99, 20, 5);
INSERT INTO accessories (accessories_id, accessories_name, accessories_price, accessories_quantity, accessories_rating)
VALUES (4, "Woven Necklace", 9.99, 25, 1);
INSERT INTO accessories (accessories_id, accessories_name, accessories_price, accessories_quantity, accessories_rating)
VALUES (5, "Pendant", 24.99, 15, 2);

-- Data for table (shoes)
INSERT INTO shoes (shoes_id, shoes_name, manufacturer_id, shoes_price, shoes_quantity, shoes_rating)
VALUES ("Red Hightops", 49.99, 20, 4);
INSERT INTO shoes (shoes_id, shoes_name, manufacturer_id, shoes_price, shoes_quantity, shoes_rating)
VALUES ("Salsa Slippers", 19.99, 15, 2);
INSERT INTO shoes (shoes_id, shoes_name, manufacturer_id, shoes_price, shoes_quantity, shoes_rating)
VALUES ("Fuzzy Wuzzy House Slippers", 19.99, 20, 5);
INSERT INTO shoes (shoes_id, shoes_name, manufacturer_id, shoes_price, shoes_quantity, shoes_rating)
VALUES ("pOW stilettos", 99.99, 20, 5);
INSERT INTO shoes (shoes_id, shoes_name, manufacturer_id, shoes_price, shoes_quantity, shoes_rating)
VALUES ("Gatsby's Dancing Shoes", 79.99, 20, 1);

-- Data for table (beauty)
INSERT INTO beauty (beauty_id, beauty_name, beauty_price, beauty_quantity, beauty_rating)
VALUES (1, "Level 4 foundation", 24.99, 20, 2);
INSERT INTO beauty (beauty_id, beauty_name, beauty_price, beauty_quantity, beauty_rating)
VALUES (2, "Glitz Eye Shadow (Ruby)", 14.99, 20, 3);
INSERT INTO beauty (beauty_id, beauty_name, beauty_price, beauty_quantity, beauty_rating)
VALUES (3, "Noire Red Lipstick", 24.99, 20, 1);
INSERT INTO beauty (beauty_id, beauty_name, beauty_price, beauty_quantity, beauty_rating)
VALUES (4, "All Day, Never Smudge, 48 hour Wear Mascara (Coal)", 9.99, 20, 1);
INSERT INTO beauty (beauty_id, beauty_name, beauty_price, beauty_quantity, beauty_rating)
VALUES (5, "Watermelon Lip Scrub", 9.99, 20, 5);

-- Data for table (garden)
INSERT INTO garden (garden_id, garden_name, garden_price, garden_quantity, garden_rating)
VALUES (1, "Bamboo Bench", 74.99, 10, 5);
INSERT INTO garden (garden_id, garden_name, garden_price, garden_quantity, garden_rating)
VALUES (2, "Jerry the Generic Garden Gnome", 14.99, 50, 5);
INSERT INTO garden (garden_id, garden_name, garden_price, garden_quantity, garden_rating)
VALUES (3, "12-pack Flower Pots (assorted sizes & colors - SPRING THEME", 24.99, 30, 4);
INSERT INTO garden (garden_id, garden_name, garden_price, garden_quantity, garden_rating)
VALUES (4, "My First Gardening Tool Kit", 19.99, 10, 3);
INSERT INTO garden (garden_id, garden_name, garden_price, garden_quantity, garden_rating)
VALUES (5, "Weedaway", 4.99, 25, 1);

-- Data for table (cart)














