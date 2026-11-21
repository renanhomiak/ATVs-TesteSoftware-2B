# Testes de Integração com Spring Boot

Projeto com Java 17, Maven, Spring Boot, JPA, banco H2, JUnit 5 e MockMvc.

## Como rodar

```bash
mvn test
```

## Testes feitos

| Caso | Classe | O que o teste faz |
|---|---|---|
| CT01 | ProdutoServiceIntegrationTest | Cadastra um Teclado de 150,0, confere o ID e busca no repositório |
| CT02 | ProdutoServiceIntegrationTest | Tenta cadastrar com nome em branco, recebe erro e a contagem não muda |
| CT03 | ProdutoServiceIntegrationTest | Cadastra um Mouse de 80,0, muda para 95,0 e confere no repositório |
| CT04 | ProdutoControllerIntegrationTest | Faz POST /produtos e confere status 200, ID, nome e preço |
| CT05 | ProdutoControllerIntegrationTest | Faz POST, pega o ID e faz GET /produtos/{id} |

## Resultado

![Resultado do mvn test](docs/resultado-mvn-test.png)

## Como os testes ficam isolados

Todas as classes usam `@Transactional`. Antes de cada teste o Spring abre uma
transação, e no final ele desfaz tudo (rollback). Assim, o que um teste salva
não aparece no próximo.

## Respostas das perguntas

**Por que usar `findById()` no repositório e não só olhar o que o service devolveu?**
O service devolve o objeto que ele mesmo criou. Buscar no repositório mostra que
o dado foi mesmo salvo e que dá para ler ele de volta com os valores certos.

**O que o `@Transactional` faz no fim de cada teste?**
Desfaz tudo o que o teste gravou no banco.

**Quais partes do sistema o MockMvc testa?**
Controller, Service, Repository, JPA e o banco H2, além da conversão de JSON.

**Por que o MockMvc não precisa de servidor?**
Ele simula a requisição HTTP dentro da própria aplicação, sem abrir porta nem
usar rede.

**Qual a diferença para um teste unitário do controller com mocks?**
No teste unitário, Service e Repository são trocados por objetos falsos e só o
controller é testado. Aqui nada é falso, então o teste confere se todas as
camadas funcionam juntas.
