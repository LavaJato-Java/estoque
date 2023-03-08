--CREATE DATABASE testdb;


CREATE TABLE Produto (
                         id varchar(255) NOT NULL ,
                         nome character varying(255),
                         marca character varying(255),
                         quantidadeAdicionada double,
                         primary key(id)
);            <column name="unidade_estoque" type="bigint" defaultValue="0"/>