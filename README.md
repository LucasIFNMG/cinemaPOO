# cinemaPOO
Trabalho Prático da disciplina POO - 2020/01

Este projeto é um protótipo de um sistema para gerenciamento de um cinema.

Mini-mundo: Gestão de Cinema

O sistema deve gerenciar as vendas e reservas de ingresso, assim como a criação e edição de sessões. Somente clientes registrados poderão efetuar as reservas, mas os não registrados também poderão visualizar as sessões atuais e futuras. O cliente poderá escolher o assento no ato da reserva/venda, e o sistema deverá fazer esse controle lógico dos lugares disponíveis.

No caso das reservas, deverá ser feita remotamente com pagamento em cartão de crédito. O sistema deve exigir o cadastro e login do cliente para essa operação. Quando efetuada com sucesso, a reserva deve informar um código ao cliente, que deverá apresentá-lo aos funcionários juntamente com um documento na hora da sessão.

O sistema deve registrar o log das vendas, contendo informações de data/hora, quantidade e valor pago dos ingressos e vendedor associado. 

Os gerentes deverão ter acesso especial, com permissão de criação e edição das sessões. Também poderão consultar os dados financeiros, como total de vendas e comissões.


# Instruções para Compilar e Executar o programa:
1) Clone o repositório.
2) No terminal, digite o seguinte comando:

```
$ cd "diretorio/do/repositorio/cinemapoo" && javac MainCinema.java && java MainCinema
```
Ou simplesmente acesse o repositório, e, no terminal, digite:

```
$ javac MainCinema.java && java MainCinema
```
