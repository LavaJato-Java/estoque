# LavaJato Application - Microserviço Estoque

Microserviço que salva os dados do produtos no estoque. 

Ele recebe uma Request com todos os dados do produto e salva no banco de dados. 


Microserviço usando: 

. usando serviço de mensageria.

. usando Redis para Cache

. usando Padrão Saga Coreografado para conexão com os outros microserviços.

## Endpoints

### POST /produto/add

Request 
```java
{
    UUID id;
    String nome;
    String marca;
    int quantidade;
}
```

Response : void

### GET /produto/find/{id}

Response 
```java
{
      UUID id;
      String nome;
      String marca;
      int quantidade;
}
```


### GET /produto/

Response 
```java
 [
    {
      UUID id;
      String nome;
      String marca;
      int quantidade;
    },
    {
      UUID id;
      String nome;
      String marca;
      int quantidade;
    },
                   
];
```
