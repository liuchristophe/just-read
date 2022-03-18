CREATE TABLE jr_author
(
	idAuthor BIGINT PRIMARY KEY NOT NULL,
	strFirstname VARCHAR(50),
	strLastname VARCHAR(50),
	strUrlWiki VARCHAR(255)
)	

CREATE TABLE jr_book
(
    idBook BIGINT PRIMARY KEY NOT NULL,
    strBookName VARCHAR(50),
    strSynopsis VARCHAR(1500),
    strUrlImage VARCHAR(255),
    idAuthor BIGINT,
	FOREIGN KEY(idAuthor) REFERENCES jr_author(idAuthor)	
)

CREATE TABLE jr_category
(
	idCategory TINYINT PRIMARY KEY NOT NULL,
	strCategoryName VARCHAR(50)
)

CREATE TABLE jr_book_category
(
	idCategory TINYINT NOT NULL,
	idBook BIGINT NOT NULL,
	PRIMARY KEY(idBook, idCategory),
	FOREIGN KEY (idBook) REFERENCES jr_book(idBook),
	FOREIGN KEY (idCategory) REFERENCES jr_category(idCategory)	
)

CREATE TABLE jr_publisher
(
	idPublisher INT PRIMARY KEY NOT NULL,
	strPublisherName VARCHAR(50) NOT NULL
)
CREATE TABLE jr_edition
(
	idEdition BIGINT PRIMARY KEY NOT NULL,
	idBook BIGINT NOT NULL,
	idPublisher INT NOT NULL,
	strYear SMALLINT,
	strISBN VARCHAR(25),
	FOREIGN KEY (idBook) REFERENCES jr_book(idBook),
	FOREIGN KEY (idPublisher) REFERENCES jr_publisher(idPublisher)	
)

CREATE TABLE jr_address
(
	idAddress BIGINT PRIMARY KEY NOT NULL,
	strAddress1 VARCHAR(120) NOT NULL,
	strAddress2 VARCHAR(120),
	strAddress3 VARCHAR(120),
	strCity VARCHAR(100) NOT NULL,
	strCountry VARCHAR(25) NOT NULL,
	strPostalCode VARCHAR(16) NOT NULL
)

CREATE TABLE jr_user
(
	idUser BIGINT PRIMARY KEY NOT NULL,
	strFirstname VARCHAR(50) NOT NULL,
	strLastname VARCHAR(50) NOT NULL,
	strPassword VARCHAR(200) NOT NULL,
	strEmail VARCHAR(200) UNIQUE NOT NULL,
	strPhone VARCHAR(20),
	strLogin VARCHAR(30) UNIQUE NOT NULL,
	idAddress BIGINT,
	FOREIGN KEY (idAddress) REFERENCES jr_address(idAddress)	
)

CREATE TABLE jr_library
(
	idLibrary INT PRIMARY KEY NOT NULL,
	idAddress BIGINT NOT NULL,
	FOREIGN KEY (idAddress) REFERENCES jr_address(idAddress)
)

CREATE TABLE jr_role
(
	idRole TINYINT PRIMARY KEY NOT NULL,
	strRoleName VARCHAR(25) NOT NULL,
)

CREATE TABLE jr_user_library_role
(
	idRole TINYINT NOT NULL,
	idLibrary INT NOT NULL,
	idUser BIGINT NOT NULL,
	PRIMARY KEY(idUser, idLibrary, idRole),
	FOREIGN KEY (idRole) REFERENCES jr_role(idRole),
	FOREIGN KEY (idLibrary) REFERENCES jr_library(idLibrary),	
	FOREIGN KEY (idUser) REFERENCES jr_user(idUser)	
)

CREATE TABLE jr_library_stock
(
	idEdition BIGINT NOT NULL,
	idLibrary INT NOT NULL,
	intQuantity INT DEFAULT 0,
	strUnitPrice VARCHAR(20),
	PRIMARY KEY (idEdition,idLibrary),
	FOREIGN KEY (idLibrary) REFERENCES jr_library(idLibrary),	
	FOREIGN KEY (idEdition) REFERENCES jr_edition(idEdition)
)

CREATE TABLE jr_order
(
	idOrder BIGINT PRIMARY KEY NOT NULL,
	idLibrary INT NOT NULL,
	idUser BIGINT NOT NULL,
	strDate DATE,
	intTva TINYINT,
	intDiscount TINYINT,
	intTotalPrice INT,
	FOREIGN KEY (idLibrary) REFERENCES jr_library(idLibrary),	
	FOREIGN KEY (idUser) REFERENCES jr_user(idUser)	
)

CREATE TABLE jr_order_item
(
	idEdition BIGINT NOT NULL,
	idOrder BIGINT NOT NULL,
	intQuantity INT NOT NULL,
	strUnitPrice VARCHAR(20),
	PRIMARY KEY (idEdition, idOrder),
	FOREIGN KEY (idEdition) REFERENCES jr_edition(idEdition),
	FOREIGN KEY (idOrder) REFERENCES jr_order(idOrder)
)
